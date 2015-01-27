package wholesaler.mvc.database;

public class ProductPriceType {
	private Integer id;
	private String name;

	public ProductPriceType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
