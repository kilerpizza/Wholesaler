package wholesaler.database;

public class Packet {
	private ItemType itemType;
	private Integer quantity;
	private Integer purchase;

	public Packet(ItemType itemType, Integer quantity, Integer purchase) {
		this.itemType = itemType;
		this.quantity = quantity;
		this.purchase = purchase;

	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPurchase() {
		return purchase;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public String getPacketName() {
		return itemType.getName();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public boolean isExpired(Integer day) {
		return getItemType().getExpiry() + getPurchase() <= day;
	}

	@Override
	public String toString() {
		return "" + itemType + " , quantity = " + quantity
				+ ", purchased on = " + purchase + ". ";
	}

}
