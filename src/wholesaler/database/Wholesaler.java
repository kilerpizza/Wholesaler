package wholesaler.database;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Wholesaler {
	private JTextField howMuch;
	private String nme;
	private String nm;
	private JButton button;
	private Integer amount;
	public int day = 1;
	private Warehouse warehouse;
	private Market dailyMarket;
	private Account balance;
	private boolean alreadyTraded = false;
	private GUI gui;

	public Wholesaler() {

		warehouse = new Warehouse();
		balance = new Account(1000);
		gui = new GUI();

		game();

	}

	public class BuyWhat implements ActionListener {
		public void actionPerformed(ActionEvent ch) {

			gui.getContentPane().removeAll();
			gui.getContentPane().revalidate();
			gui.getContentPane().setLayout(new GridLayout(1, 3));
			howMuch = new JTextField(5);
			Font font1 = new Font("SansSerif", Font.BOLD, 40);
			howMuch.setFont(font1);
			howMuch.setHorizontalAlignment(JTextField.CENTER);
			gui.getContentPane().add(howMuch);
			JButton buy = new JButton("Buy");
			gui.getContentPane().add(buy);
			String actionCommand = ((JButton) ch.getSource())
					.getActionCommand();
			JTextField choice = new JTextField(actionCommand);
			choice.setFont(font1);
			gui.getContentPane().add(choice);
			nm = actionCommand;
			BuyCommit by = new BuyCommit();
			buy.addActionListener(by);

		}
	}

	public class BuyCommit implements ActionListener {
		public void actionPerformed(ActionEvent by) {

			try {
				amount = Integer.valueOf(howMuch.getText());
				if (amount > 0) {
					if (amount * ItemTypes.chooseItemTypes(nm).getBuyingPrice() <= balance
							.getAccount()) {
						warehouse.buyPackets(balance, day, nm, amount);
						gui.getContentPane().removeAll();
						gui.getContentPane().revalidate();
						gui.getContentPane().repaint();
						gui.getContentPane().setLayout(new FlowLayout());
						game();
					} else {
						gui.displayNotEnoughFunds();
						continueButton();

					}

				} else if (amount == 0) {
					gui.getContentPane().removeAll();
					gui.getContentPane().revalidate();
					gui.getContentPane().repaint();
					gui.getContentPane().setLayout(new FlowLayout());
					continueButton();
				}
			} catch (Exception ex) {
				gui.getContentPane().removeAll();
				gui.getContentPane().revalidate();
				gui.getContentPane().repaint();
				gui.getContentPane().setLayout(new FlowLayout());
				JLabel label = new JLabel("This is not a number!");
				gui.getContentPane().add(label);
				continueButton();
			}
		}
	}

	public class ContinueButton implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			gui.getContentPane().removeAll();
			gui.getContentPane().revalidate();
			gui.getContentPane().repaint();
			gui.getContentPane().setLayout(new FlowLayout());
			game();

		}
	}

	public class Choice implements ActionListener {

		public void actionPerformed(ActionEvent choice) {
			String actionComm = ((JButton) choice.getSource())
					.getActionCommand();
			switch (actionComm) {
			case "Buy Items":
				gui.getContentPane().removeAll();
				gui.getContentPane().revalidate();
				gui.getContentPane().repaint();
				gui.getContentPane().setLayout(new GridLayout(2, 2));

				for (Integer i = 0; i < 10; i++) {
					String buttonName = ItemTypes.allItems(i).getName();
					button = new JButton(buttonName + " price: "
							+ ItemTypes.allItems(i).getBuyingPrice());
					gui.getContentPane().add(button);
					button.setActionCommand(buttonName);

					BuyWhat ch = new BuyWhat();
					button.addActionListener(ch);

				}

				break;
			case "Open Warehouse":
				if (alreadyTraded == false) {
					dailyMarket = new Market();
					gui.displayMarketMessage();
					gui.renderNewOrder(dailyMarket.getDailyOrderList());
					for (Customer order : dailyMarket.getDailyOrderList()) {
						List<Packet> packetsToSell = new ArrayList<Packet>();
						packetsToSell.addAll(warehouse.getStock());
						for (Packet packet : packetsToSell) {
							if (packet.getItemType() == order.getProductType()) {
								gui.displayWeHaveIt(packet);
								warehouse.happyCustomerCounter++;
								if (packet.getQuantity() > order
										.getPurchaseQuantity()) {
									balance.addValue(packet, order);
									warehouse.amendPacketQuantity(packet,
											order.getPurchaseQuantity());
									gui.displaySold(packet, order);
								} else if (packet.getQuantity() < order
										.getPurchaseQuantity()) {
									balance.addValue(packet, order);
									warehouse.amendOrderQuantity(packet, order);
									warehouse.getStock().remove(packet);
									gui.displaySold(packet, order);
								} else {

									balance.addValue(packet, order);
									warehouse.getStock().remove(packet);
									gui.displaySold(packet, order);

								}
							}

						}

					}
					continueButton();
					alreadyTraded = true;
				} else {
					gui.displayAlreadyTraded();
					continueButton();
				}

				break;
			case "End Turn":
				gui.getContentPane().removeAll();
				gui.getContentPane().revalidate();
				gui.getContentPane().repaint();
				gui.getContentPane().setLayout(new FlowLayout());
				endTurn();

				break;

			}
		}
	}

	public void continueButton() {
		JButton button = new JButton("Press to continue.");
		gui.getContentPane().add(button);
		ContinueButton b = new ContinueButton();
		button.addActionListener(b);

	}

	public void game() {

		gui.topInfo(warehouse.happyCustomerCounter, day, balance.getAccount());
		gui.displayExpiredPackets(warehouse.removeExpiredPackets(day));
		stockContent();

		menuButtons();

	}

	public void endTurn() {
		alreadyTraded = false;
		day++;
		warehouse.happyCustomerCounter = warehouse.happyCustomerCounter - 2;

		if (warehouse.happyCustomerCounter < 0) {
			warehouse.happyCustomerCounter = 0;
		}
		game();
	}

	public void stockContent() {
		JLabel label = new JLabel("Your current stock:");
		gui.getContentPane().add(label);
		for (ItemType itemType : warehouse.getEveryTypeOfItemTypesInStock()) {
			gui.stockLabel(itemType.getName() + ": "
					+ warehouse.getTotalQuantityByItemType(itemType));

		}
	}

	public static void main(String[] args) {
		new Wholesaler();

	}

	public Integer getDay() {
		return day;
	}

	public void menuButtons() {

		int nmr = 0;

		for (int i = 0; i < 3; i++) {
			nmr++;
			switch (nmr) {
			case 1:
				nme = "Buy Items";
				break;
			case 2:
				nme = "Open Warehouse";
				break;
			case 3:
				nme = "End Turn";
				break;
			}

			button = new JButton(nme);
			gui.getContentPane().add(button);
			button.setActionCommand(nme);
			Choice choice = new Choice();
			button.addActionListener(choice);
		}
	}

	// public String getString() {
	// @SuppressWarnings("resource")
	// Scanner userInput = new Scanner(System.in);
	// String choice = userInput.next();
	// return choice;
	//
	// }
	//
	// public Integer getInteger() {
	// @SuppressWarnings("resource")
	// Scanner userInput = new Scanner(System.in);
	// Integer quantity = userInput.nextInt();
	// return quantity;
	//
	// }

}