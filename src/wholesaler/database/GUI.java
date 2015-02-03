package wholesaler.database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import wholesaler.database.Wholesaler.BuyCommit;

public class GUI extends JFrame {
	private JPanel content;
	public JPanel stock;
	public JPanel removedStock;
	private boolean endPressed;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean getEndPressed() {
		return endPressed;
	}

	public void setEndPressed(boolean endPressed) {
		this.endPressed = endPressed;
	}

	public GUI() {

		content = new JPanel();
		setContentPane(content);
		setTitle("Wholesaler by K.Groszyk & B. Ko³akowski");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void stockLabel(String string) {
		JLabel stockLabel = new JLabel(string);

		getContentPane().add(stockLabel);

	}

	public void displayNotEnoughFunds() {
		JLabel notEnoughFunds = new JLabel("Not enough funds.");
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(notEnoughFunds);
	}

	public void displayMarketMessage() {
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().setLayout(new FlowLayout());
		JLabel label = new JLabel("Hi. I'd like to buy:");
		getContentPane().add(label);

	}

	public void renderNewOrder(List<Customer> dailyOrderList) {
		for (Customer order : dailyOrderList) {
			JLabel label = new JLabel(order.getProductType() + ": "
					+ order.getPurchaseQuantity());
			getContentPane().add(label);

		}
	}

	public void displayExpiredPackets(List<Packet> expiredPackets) {
		if (expiredPackets.size() > 0) {
			JLabel label = new JLabel("Expired packets that has been removed: ");
			getContentPane().add(label);
		}
		for (Packet packet : expiredPackets) {
			JLabel label2 = new JLabel(packet.getPacketName() + ": "
					+ packet.getQuantity() + ". ");
			getContentPane().add(label2);

		}

	}

	public void displayWeHaveIt(Packet packet) {

		JLabel label = new JLabel("We have " + packet.getPacketName() + ".");
		getContentPane().add(label);

	}

	public void displaySold(Packet packet, Customer order) {
		Integer quantity = 0;
		if (packet.getQuantity() >= order.getPurchaseQuantity()) {
			quantity = order.getPurchaseQuantity();
		} else {
			quantity = packet.getQuantity();

		}

		JLabel label = new JLabel("You've just sold " + quantity + " "
				+ packet.getPacketName() + " for "
				+ packet.getItemType().getSellingPrice() * quantity + " GBP.");
		getContentPane().add(label);

	}

	public void displayAlreadyTraded() {
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().setLayout(new FlowLayout());
		JLabel label = new JLabel("You've already traded today.");
		getContentPane().add(label);
	}

	public void topInfo(Integer hcc, Integer day, Integer balance) {
		JLabel label = new JLabel("Welcome. It's day " + day + ". HCC: " + hcc
				+ ". Account balance: " + balance + ".");

		getContentPane().add(label);
	}

}
