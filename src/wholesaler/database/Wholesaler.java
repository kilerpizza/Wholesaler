package wholesaler.database;

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
		warehouse.addItem(ItemTypes.APPLE, 10, day);
		warehouse.addItem(ItemTypes.POTATO, 10, day);
		warehouse.addItem(ItemTypes.ONION, 10, day);
		warehouse.addItem(ItemTypes.LEEK, 10, day);
		warehouse.addItem(ItemTypes.ORANGE, 10, day);
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
		if(choice  == "s"){
			viewer.displayStockContent(warehouse.getStock());
		}
		else if(choice == "b"){
			warehouse.buyPackets(balance, day);
		}
		dailyMarket = new Market();

		// System.out.println("Hi. I'd like to buy:");
		// dailyMarket.renderNewOrder();
		// for (Customer order : dailyMarket.getDailyOrderList()) {
		// warehouse.sellItems(order, balance);
		// }
		// }
		//
		// } else if (option.equals("e")) {
		// alreadyTraded = false;
		// endTurn();
		// } else {
		// game();
		// }
	}

	public void endTurn() {
		day++;
		warehouse.happyCustomerCounter = warehouse.happyCustomerCounter - 1;
		
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