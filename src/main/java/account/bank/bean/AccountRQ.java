package account.bank.bean;

public class AccountRQ {
	
	private String clientId;
	private String productId;
	private String numberAccount;
	private double amount;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getNumberAccount() {
		return numberAccount;
	}
	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
