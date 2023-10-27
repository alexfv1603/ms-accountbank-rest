package account.bank.service;

import account.bank.bean.AccountRQ;
import account.bank.bean.AccountRS;
import account.bank.bean.UpdateAmountRQ;

public interface AccountService {
	
	AccountRS inserAccount(AccountRQ accountRQ);
	boolean updateAmount(UpdateAmountRQ updateAmountRQ);

}
