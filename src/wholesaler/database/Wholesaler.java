package wholesaler.database;

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
			viewer.delayScreen();
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
				viewer.delayScreen();
			} else {
				viewer.displayNotEnoughFunds();
				viewer.delayScreen();
			}

			break;
		case "i":
			viewer.displayAvailableItemList();
			break;
		case "o":
			if (alreadyTraded == false) {
				dailyMarket = new Market();
				viewer.displayMarketMessage();
				viewer.renderNewOrder(dailyMarket.getDailyOrderList());
				for (Customer order : dailyMarket.getDailyOrderList()) {
					warehouse.sellItems(order, balance);
					alreadyTraded = true;
				}

			} else {
				viewer.displayAlreadyTraded();
				viewer.delayScreen();
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
		warehouse.happyCustomerCounter = warehouse.happyCustomerCounter - 5;
		if (warehouse.happyCustomerCounter < 0){
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