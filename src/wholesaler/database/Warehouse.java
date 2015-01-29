package wholesaler.database;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	private List<Packet> stock;
	public Integer happyCustomerCounter = 5;

	public Warehouse() {
		@SuppressWarnings("unused")
		Integer happyCustomerCounter;
		stock = new ArrayList<Packet>();

	}

	public List<Packet> getStock() {
		return stock;
	}

	public void buyPackets(Account balance, int day, String buyWhat,
			int quantity) {

		addItem(ItemTypes.chooseItemTypes(buyWhat), quantity, day);
		balance.removeBalance(quantity
				* ItemTypes.chooseItemTypes(buyWhat).getBuyingPrice());

	}

	public void amendOrderQuantity(Packet packet, Customer dailyOrder) {
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