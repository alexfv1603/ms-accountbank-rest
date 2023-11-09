package account.bank.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAmountRQ {
	
	private String numberAccount;
	private String numberAccountDestination;
	private String transaction;
	private double amount;
	
}
