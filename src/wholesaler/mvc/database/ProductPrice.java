package wholesaler.mvc.database;

import java.math.BigDecimal;

public class ProductPrice {
	private final Integer productId;
	private final Integer priceTypeId;
	private final BigDecimal price;

	public ProductPrice(Integer productId, Integer priceTypeId, BigDecimal price) {
		this.productId = productId;
		this.priceTypeId = priceTypeId;
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getPriceTypeId() {
		return priceTypeId;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
