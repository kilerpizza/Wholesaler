package wholesaler.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warehouse {
	private List<Packet> stock;
	public Integer happyCustomerCounter = 50;

	public Warehouse() {
		@SuppressWarnings("unused")
		Integer happyCustomerCounter;
		stock = new ArrayList<Packet>();

	}

	public List<Packet> getStock() {
		return stock;
	}

	public void sellItems(Customer dailyOrder, Account account) {

		List<Packet> packetsToSell = new ArrayList<Packet>();
		packetsToSell.addAll(getStock());
		for (Packet packet : packetsToSell) {
			if (packet.getItemType() == dailyOrder.getProductType()) {
				System.out.println("We have " + packet.getPacketName() + ".");
				happyCustomerCounter++;

				if (packet.getQuantity() > dailyOrder.getPurchaseQuantity()) {
					account.addValue(packet, dailyOrder);
					amendPacketQuantity(packet,
							dailyOrder.getPurchaseQuantity());
					System.out.println("You've just sold "
							+ dailyOrder.getPurchaseQuantity() + " "
							+ packet.getPacketName() + " for "
							+ packet.getItemType().getSellingPrice()
							* dailyOrder.getPurchaseQuantity() + " GBP.");

				} else if (packet.getQuantity() < dailyOrder
						.getPurchaseQuantity()) {
					System.out.println("You've just sold "
							+ packet.getQuantity() + " "
							+ packet.getPacketName() + " for "
							+ packet.getQuantity()
							* packet.getItemType().getSellingPrice() + " GBP.");
					account.addValue(packet, dailyOrder);
					amendOrderQuantity(packet, dailyOrder);
					stock.remove(packet);

				} else {
					System.out.println("You've just sold "
							+ packet.getQuantity() + " "
							+ packet.getPacketName() + " for "
							+ packet.getQuantity()
							* packet.getItemType().getSellingPrice() + " GBP.");
					account.addValue(packet, dailyOrder);
					stock.remove(packet);

				}
			}

		}
	}

	public Integer getInteger() {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		Integer quantity = userInput.nextInt();
		return quantity;

	}

	 public void buyPackets(Account balance, int day) {
	 System.out.println("What would You like to buy?");
	 String choice = getString();
	 System.out.println("How much You'd like to buy?");
	 System.out.println("Price is "
	 + ItemTypes.chooseItemTypes(choice).getBuyingPrice()
	 + " GBP per unit.");
	 Integer quantity = getInteger();
	 if (quantity * ItemTypes.chooseItemTypes(choice).getBuyingPrice() <=
	 balance
	 .getAccount()) {
	 addItem(ItemTypes.chooseItemTypes(choice), quantity, day);
	 balance.removeBalance(quantity
	 * ItemTypes.chooseItemTypes(choice).getBuyingPrice());
	 System.out
	 .println("You've bought " + quantity + " " + choice + ".");
	
	 } else {
	 System.out.println("You don't have enough money.");
	 
	 }
	
	 }

	private void amendOrderQuantity(Packet packet, Customer dailyOrder) {
		Integer amendedOrderQuantity = dailyOrder.getPurchaseQuantity()
				- packet.getQuantity();
		dailyOrder.setPurchaseQuantity(amendedOrderQuantity);
	}

	public void amendPacketQuantity(Packet packet, Integer orderQuantity) {
		Integer amendedPacketQuantity = packet.getQuantity() - orderQuantity;
		packet.setQuantity(amendedPacketQuantity);
	}

	public void renderStockContentByItemType() {
		for (ItemType itemType : getEveryTypeOfItemTypesInStock()) {
			System.out.println(itemType.getName() + ": "
					+ getTotalQuantityByItemType(itemType));
		}
	}

	public void addItem(ItemType itemType, Integer quantity, Integer purchase) {
		Packet packet = new Packet(itemType, quantity, purchase);
		stock.add(packet);
	}

	public List<Packet> getPacketListByItemType(ItemType itemType) {
		List<Packet> specificItems = new ArrayList<Packet>();
		List<Packet> packetsToCheck = new ArrayList<Packet>();
		packetsToCheck.addAll(getStock());
		for (Packet packetToExamine : packetsToCheck) {
			if (packetToExamine.getItemType().equals(itemType)) {
				specificItems.add(packetToExamine);

			}

		}
		return specificItems;

	}

	public Integer getTotalQuantityByItemType(ItemType itemType) {
		Integer sum = 0;
		for (Packet packet : getPacketListByItemType(itemType)) {
			sum = sum + packet.getQuantity();
		}
		return sum;

	}

	public List<ItemType> getEveryTypeOfItemTypesInStock() {
		List<ItemType> result = new ArrayList<ItemType>();
		for (Packet packet : stock) {
			if (!result.contains(packet.getItemType())) {
				result.add(packet.getItemType());
			}
		}
		return result;

	}

	public List<Packet> removeExpiredPackets(Integer day) {
		List<Packet> expiredPackets = new ArrayList<Packet>();
		List<Packet> packetsToCheck = new ArrayList<Packet>();
		packetsToCheck.addAll(getStock());
		for (Packet packetToSmell : packetsToCheck) {
			if (packetToSmell.isExpired(day)) {
				stock.remove(packetToSmell);
				expiredPackets.add(packetToSmell);
			}
		}
		return expiredPackets;
	}

}