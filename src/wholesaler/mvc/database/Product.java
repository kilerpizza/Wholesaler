package wholesaler.mvc.database;

public class Product {
	private final Integer id;
	private final String name;
	private final Integer expiry;

	public Product(Integer id, String name, Integer expiry) {
		this.id = id;
		this.name = name;
		this.expiry = expiry;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getExpiry() {
		return expiry;
	}

}
