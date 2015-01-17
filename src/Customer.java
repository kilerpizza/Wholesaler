package wholesaler.database;

public class Customer {
	private Integer purchaseQuantity;
	private ItemType product;

	public Customer() {
		createProduct();
		createPurchaseQuantity();
	}

	public void createProduct() {
		int i = RandomGenerator.getRandomNumber(100);
		if (i <= 3) {
			product = ItemTypes.BANANA;
		} else if (i <= 9) {
			product = ItemTypes.TOMATO;
		} else if (i <= 16) {
			product = ItemTypes.ORANGE;
		} else if (i <= 24) {
			product = ItemTypes.CUCUMBER;
		} else if (i <= 33) {
			product = ItemTypes.PEAR;
		} else if (i <= 44) {
			product = ItemTypes.LEEK;
		} else if (i <= 56) {
			product = ItemTypes.ONION;
		} else if (i <= 69) {
			product = ItemTypes.CABBAGE;
		} else if (i <= 81) {
			product = ItemTypes.APPLE;
		} else if (i <= 100) {
			product = ItemTypes.POTATO;
		}

	}

	public ItemType getProductType() {
		return product;
	}
	public Integer getPurchaseQuantity(){
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public void createPurchaseQuantity() {

		purchaseQuantity = RandomGenerator.getRandomNumber(10);
		if (purchaseQuantity == 0) {
			purchaseQuantity = 1;
		}

	}

	@Override
	public String toString() {
		return " " + product + " " + purchaseQuantity + " units.";
	}
}
