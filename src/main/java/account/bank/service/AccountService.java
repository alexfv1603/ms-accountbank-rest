package account.bank.service;

import account.bank.bean.AccountRQ;
import account.bank.bean.AccountRS;
import account.bank.bean.UpdateAmountRQ;
import account.bank.bean.UpdateAmountRS;

public interface AccountService {
	
	AccountRS insertAccount(AccountRQ accountRQ);
	UpdateAmountRS updateAmount(UpdateAmountRQ updateAmountRQ);

}
