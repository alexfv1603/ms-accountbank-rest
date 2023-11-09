package account.bank.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAmountRS {
	
	private boolean status;
	private String message;
	private String accountId = "";

}
