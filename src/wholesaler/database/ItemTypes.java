package wholesaler.database;


public class ItemTypes {
	public static final ItemType BANANA = new ItemType("bananas", 3, 25, 60);
	public static final ItemType TOMATO = new ItemType("tomatoes", 5, 23, 50);
	public static final ItemType ORANGE = new ItemType("oranges", 6, 18, 36);
	public static final ItemType CUCUMBER = new ItemType("cucumbers", 7, 10, 19);
	public static final ItemType PEAR = new ItemType("pears", 8, 16, 31);
	public static final ItemType LEEK = new ItemType("leeks", 9, 14, 25);
	public static final ItemType ONION = new ItemType("onions", 11, 12, 18);
	public static final ItemType CABBAGE = new ItemType("cabbages", 12, 10, 15);
	public static final ItemType APPLE = new ItemType("apples", 13, 8, 11);
	public static final ItemType POTATO = new ItemType("potatoes", 15, 6, 8);
	

	public static final ItemType chooseItemTypes(String choice) {

		if (choice.equals("bananas")) {
			ItemType itemType = BANANA;
			return itemType;
		} else if (choice.equals("tomatoes")) {
			ItemType itemType = TOMATO;
			return itemType;
		} else if (choice.equals("oranges")) {
			ItemType itemType = ORANGE;
			return itemType;
		} else if (choice.equals("cucumbers")) {
			ItemType itemType = CUCUMBER;
			return itemType;
		} else if (choice.equals("pears")) {
			ItemType itemType = PEAR;
			return itemType;
		} else if (choice.equals("leeks")) {
			ItemType itemType = LEEK;
			return itemType;
		} else if (choice.equals("onions")) {
			ItemType itemType = ONION;
			return itemType;
		} else if (choice.equals("cabbages")) {
			ItemType itemType = CABBAGE;
			return itemType;
		} else if (choice.equals("apples")) {
			ItemType itemType = APPLE;
			return itemType;
		} else if (choice.equals("potatoes")) {
			ItemType itemType = POTATO;
			return itemType;
		} else {
			

			return null;

		}

	}
}
