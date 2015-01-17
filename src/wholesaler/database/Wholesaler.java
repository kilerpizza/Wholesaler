package wholesaler.database;

public class Wholesaler {
	private int day = 1;
	private Warehouse warehouse;
	private Market dailyMarket;
	private Account balance;
	private boolean alreadyTraded = false;

	public Wholesaler() {

		warehouse = new Warehouse();
		balance = new Account(1000);
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
		
		System.out.println();
		System.out.println("Welcome. It's day " + day + ".");
		System.out.println("HCC: " + warehouse.happyCustomerCounter);
		System.out.println("Account as of beggining of the day: "
				+ balance.getAccount() + " GBP.");
		System.out.println();
		System.out.println("Stock content as of beginning of day:");
		warehouse.renderStockContentByItemType();

		System.out.println();
		System.out.println("Expired packets that has been removed:");
		warehouse.renderList(warehouse.removeExpiredPackets(day));
		System.out.println();
		System.out.println("What would You like to do?");
		System.out.println("(s) See Your stock by packets purchased?");
		System.out.println("(b) Buy packets? ");
		System.out.println("(i) See available items list? ");
		System.out.println("(o) Open warehouse for day's business? ");
		System.out.println("(e) End turn? ");
		String option = warehouse.getString();
		if (option.equals("s")) {
			warehouse.renderList(warehouse.getStock());
			delayScreen();
		} else if (option.equals("b")) {
			warehouse.buyPackets(balance, day);

			delayScreen();
			game();
		} else if (option.equals("i")) {
			listOfItemTypes();
			delayScreen();
		} else if (option.equals("o")) {
			if (alreadyTraded) {
				System.out.println("You've already traded today.");
				delayScreen();
				game();
			} else {
				alreadyTraded();
				
				dailyMarket = new Market();
				System.out.println("Hi. I'd like to buy:");
				dailyMarket.renderNewOrder();
				for (Customer order : dailyMarket.getDailyOrderList()) {
					warehouse.sellItems(order, balance);
				}
			}

		} else if (option.equals("e")) {
			alreadyTraded = false;
			endTurn();
		} else {
			game();
		}
	}

	public void endTurn() {
		day++;
		warehouse.happyCustomerCounter = warehouse.happyCustomerCounter - 1;
		delayScreen();
	}

	private void delayScreen() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
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

	public void listOfItemTypes() {
		System.out
				.println("Item Type:     expiry:    purchase price:   selling price:");
		System.out.println("bananas        3          25                60");
		System.out.println("tomatoes       5          23                50");
		System.out.println("oranges        6          18                36");
		System.out.println("cucumbers      7          10                19");
		System.out.println("pears          8          16                31");
		System.out.println("leeks          9          14                25");
		System.out.println("onions        11          12                18");
		System.out.println("cabbages      12          10                15");
		System.out.println("apples        13           8                11");
		System.out.println("potatoes      15           6                 8");

	}
}