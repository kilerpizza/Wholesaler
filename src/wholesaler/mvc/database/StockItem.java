package wholesaler.mvc.database;

import java.sql.Date;

public class StockItem {
	private Integer productId;
	private Integer quantity;
	private Date purchaseDate;

	public StockItem(Integer productId, Integer quantity, Date purchaseDate) {
		this.productId = productId;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
