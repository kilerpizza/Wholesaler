package wholesaler.database;

import java.util.ArrayList;
import java.util.List;

public class Wholesaler {
	private int day = 1;
	private Warehouse warehouse;
	private Market dailyMarket;
	private Account balance;
	private boolean alreadyTraded = false;
	private Viewer viewer;

	public Wholesaler() {

		warehouse = new Warehouse();
		balance = new Account(1000);
		viewer = new Viewer();
		while (endOfGame() == false) {
			game();
		}

	}

	public void game() {
		viewer.displayWelcome(warehouse.happyCustomerCounter, day);
		viewer.displayBalance(balance.getAccount());
		viewer.displayStockContent(warehouse.getStock());
		viewer.displayExpiredPackets(warehouse.removeExpiredPackets(day));
		viewer.displayMenu();
		String choice = viewer.getString();
		switch (choice) {
		case "s":
			viewer.displayStockContent(warehouse.getStock());
			viewer.pauseProg();
			break;
		case "b":
			viewer.displayBuyWhat();
			String buyWhat = viewer.getString();
			viewer.displayPrice(buyWhat);
			viewer.displayBuyHowMuch();
			Integer quantity = viewer.getInteger();
			if (quantity * ItemTypes.chooseItemTypes(buyWhat).getBuyingPrice() <= balance
					.getAccount()) {
				warehouse.buyPackets(balance, day, buyWhat, quantity);
				viewer.displayBuyCommited(quantity, buyWhat);
				viewer.pauseProg();
			} else {
				viewer.displayNotEnoughFunds();
				viewer.pauseProg();
			}

			break;
		case "i":
			viewer.displayAvailableItemList();
			viewer.pauseProg();
			break;
		case "o":
			if (alreadyTraded == false) {
				dailyMarket = new Market();
				viewer.displayMarketMessage();
				viewer.renderNewOrder(dailyMarket.getDailyOrderList());
				for (Customer order : dailyMarket.getDailyOrderList()) {
					List<Packet> packetsToSell = new ArrayList<Packet>();
					packetsToSell.addAll(warehouse.getStock());
					for (Packet packet : packetsToSell) {
						if (packet.getItemType() == order.getProductType()) {
							viewer.displayWeHaveIt(packet);
							warehouse.happyCustomerCounter++;

							if (packet.getQuantity() > order
									.getPurchaseQuantity()) {
								balance.addValue(packet, order);
								warehouse.amendPacketQuantity(packet,
										order.getPurchaseQuantity());
								viewer.displaySold(packet, order);

							} else if (packet.getQuantity() < order
									.getPurchaseQuantity()) {
								balance.addValue(packet, order);
								warehouse.amendOrderQuantity(packet, order);
								warehouse.getStock().remove(packet);
								viewer.displaySold(packet, order);
							} else {

								balance.addValue(packet, order);
								warehouse.getStock().remove(packet);
								viewer.displaySold(packet, order);

							}
						}

					}
					viewer.pauseProg();

					alreadyTraded = true;
				}

			} else {
				viewer.displayAlreadyTraded();
				viewer.pauseProg();
			}
			break;
		case "e":
			alreadyTraded = false;
			endTurn();
		default:

			break;

		}

	}

	public void endTurn() {
		day++;
		warehouse.happyCustomerCounter = warehouse.happyCustomerCounter - 2;
		if (warehouse.happyCustomerCounter < 0) {
			warehouse.happyCustomerCounter = 0;
		}

	}

	public boolean endOfGame() {
		return false;
	}

	public static void main(String[] args) {
		new Wholesaler();

	}

	public void alreadyTraded() {
		alreadyTraded = true;
	}

	public Integer getDay() {
		return day;
	}

}