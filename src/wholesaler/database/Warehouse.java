package wholesaler.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warehouse {
	private List<Packet> stock;
	public Integer happyCustomerCounter = 20;

	public Warehouse() {
		@SuppressWarnings("unused")
		Integer happyCustomerCounter;
		stock = new ArrayList<Packet>();

	}

	public List<Packet> getStock() {
		return stock;
	}

	public void sellItems(Customer order, Account balance) {

		List<Packet> packetsToSell = new ArrayList<Packet>();
		packetsToSell.addAll(getStock());
		for (Packet packet : packetsToSell) {
			if (packet.getItemType() == order.getProductType()) {
				System.out.println("We have " + packet.getPacketName() + ".");
				happyCustomerCounter++;

				if (packet.getQuantity() > order.getPurchaseQuantity()) {
					balance.addValue(packet, order);
					amendPacketQuantity(packet, order.getPurchaseQuantity());
					System.out.println("You've just sold "
							+ order.getPurchaseQuantity() + " "
							+ packet.getPacketName() + " for "
							+ packet.getItemType().getSellingPrice()
							* order.getPurchaseQuantity() + " GBP.");

				} else if (packet.getQuantity() < order.getPurchaseQuantity()) {
					System.out.println("You've just sold "
							+ packet.getQuantity() + " "
							+ packet.getPacketName() + " for "
							+ packet.getQuantity()
							* packet.getItemType().getSellingPrice() + " GBP.");
					balance.addValue(packet, order);
					amendOrderQuantity(packet, order);
					stock.remove(packet);

				} else {
					System.out.println("You've just sold "
							+ packet.getQuantity() + " "
							+ packet.getPacketName() + " for "
							+ packet.getQuantity()
							* packet.getItemType().getSellingPrice() + " GBP.");
					balance.addValue(packet, order);
					stock.remove(packet);

				}
			}

		}
	}

	public void buyPackets(Account balance, int day, String buyWhat,
			int quantity) {

		addItem(ItemTypes.chooseItemTypes(buyWhat), quantity, day);
		balance.removeBalance(quantity
				* ItemTypes.chooseItemTypes(buyWhat).getBuyingPrice());

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