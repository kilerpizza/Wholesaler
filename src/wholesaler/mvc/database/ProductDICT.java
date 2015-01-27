package wholesaler.mvc.database;

import java.util.Arrays;
import java.util.List;

public class ProductDICT {
	public static final Product BANANA = new Product(1, "bananas", 3);
	public static final Product TOMATO = new Product(2, "tomatoes", 5);
	public static final Product ORANGE = new Product(3, "oranges", 6);
	public static final Product CUCUMBER = new Product(4, "cucumbers", 7);
	public static final Product PEAR = new Product(5, "pears", 8);
	public static final Product LEEK = new Product(6, "leeks", 9);
	public static final Product ONION = new Product(7, "onions", 11);
	public static final Product CABBAGE = new Product(8, "cabbages", 12);
	public static final Product APPLE = new Product(9, "apples", 13);
	public static final Product POTATO = new Product(10, "potatoes", 15);

	public static final List<Product> ALL = Arrays.asList(BANANA, TOMATO,
			ORANGE, CUCUMBER, PEAR, LEEK, ONION, CABBAGE, APPLE, POTATO);
}
