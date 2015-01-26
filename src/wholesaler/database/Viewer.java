package wholesaler.database;

import java.util.List;
import java.util.Scanner;

public class Viewer {

	public void displayWelcome(int hcc, int day) {
		System.out.println();
		System.out.println("Welcome. It's day " + day + ".");
		System.out.println("HCC: " + hcc);
	}

	public void displayList(List<Packet> list) {
		for (Packet packet : list) {
			System.out
					.println((packet.getItemType() + ": " + packet
							.getQuantity())
							+ ". purchased on: "
							+ packet.getPurchase());
		}
	}

	public void displayBalance(int balance) {
		System.out.println("Account as of beggining of the day: " + balance
				+ " GBP.");
		System.out.println();
	}

	public void displayStockContent(List<Packet> stock) {
		System.out.println();
		System.out.println("Stock content as of beginning of day:");
		displayList(stock);

	}

	public void displayExpiredPackets(List<Packet> expiredPackets) {
		System.out.println();
		System.out.println("Expired packets that has been removed:");
		displayList(expiredPackets);

	}

	public String getString() {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		String choice = userInput.next();
		return choice;

	}

	private void delayScreen() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

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

	public void displayMenu() {
		System.out.println();
		System.out.println("What would You like to do?");
		System.out.println("(s) See Your stock.");
		System.out.println("(b) Buy packets.");
		System.out.println("(i) See available items list.");
		System.out.println("(o) Open warehouse for day's business.");
		System.out.println("(e) End turn.");
		
			// } else if (option.equals("b")) {
			// 
			//
			// delayScreen();
			// game();
			// }
			// else if (option.equals("i")) {
			// listOfItemTypes();
			// delayScreen();
			// } else if (option.equals("o")) {
			// if (alreadyTraded) {
			// System.out.println("You've already traded today.");
			// delayScreen();
			// game();
			// } else {
			// alreadyTraded();}

		}
	}
