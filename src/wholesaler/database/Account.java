package wholesaler.database;

public class Account {
	private Integer balance;

	public Account(Integer startingBalance) {
		this.balance = 0;
		balance = startingBalance;
	}

	public Integer getAccount() {
		return balance;
	}

	public void addBalance(Integer newAccount) {
		this.balance = balance + newAccount;
	}

	public void removeBalance(Integer newAccount) {
		this.balance = balance - newAccount;
	}

	public void addValue(Packet packet, Customer dailyOrder) {
		Integer netValue = dailyOrder.getPurchaseQuantity()
				- packet.getQuantity();
		if (netValue >= 0) {
			addBalance(packet.getItemType().getSellingPrice()
					* packet.getQuantity());
		} else {
			addBalance(dailyOrder.getPurchaseQuantity()
					* packet.getItemType().getSellingPrice());
		}
	}

}
