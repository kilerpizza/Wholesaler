package wholesaler.database;

public class ItemType {
	private String name;
	private Integer expiry;
	private Integer buyingPrice;
	private Integer sellingPrice;

	public ItemType(String name, Integer expiry, Integer buyingPrice,
			Integer sellingPrice) {
		this.name = name;
		this.expiry = expiry;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
	}

	public Integer getBuyingPrice() {
		return buyingPrice;
	}

	public Integer getSellingPrice() {
		return sellingPrice;
	}

	public String getName() {
		return name;
	}

	public void renderItemType() {
		System.out.println("Item type: " + name + ", quantity: ");
	}

	public Integer getExpiry() {
		return expiry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemType other = (ItemType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
