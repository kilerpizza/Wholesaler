package wholesaler.database;

import java.util.ArrayList;
import java.util.List;

public class Market {
	@SuppressWarnings("unused")
	private Warehouse warehouse;
	private Customer order;
	private List<Customer> dailyOrderList;

	public Market() {
		Warehouse warehouse = new Warehouse();
		dailyOrderList = new ArrayList<Customer>();
		for (int i = 0; i <= (RandomGenerator
				.getRandomNumber(6 + warehouse.happyCustomerCounter)); i++) {
			Customer order = new Customer();
			this.order = order;
			dailyOrderList.add(order);

		}

	}

	public Customer getOrderFromDailyOrderList() {
		return order;
	}

	public List<Customer> getDailyOrderList() {
		return dailyOrderList;

	}

}
