package account.bank.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Account {
	
	@DBRef
	private Client client;
	@DBRef
	private Product product;
	private String numberAccount;
	private double balance;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getNumberAccount() {
		return numberAccount;
	}
	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
