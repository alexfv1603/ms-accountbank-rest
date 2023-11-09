package account.bank.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRQ {
	
	private String clientId;
	private String productId;
	private String numberAccount;
	private double amount;

}
