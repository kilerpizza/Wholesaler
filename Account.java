package wholesaler.database;

public class Account {
	private Integer balance;

	public Account(Integer startingBalance) {
	this.balance = 0;
	balance = startingBalance;
	}

//	private void createAccount() {
//		Account balance = new Account(0);
//	
//
//	}

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
		} else if (netValue < 0) {
			addBalance(dailyOrder.getPurchaseQuantity()
					* packet.getItemType().getSellingPrice());
		}
	}

}
