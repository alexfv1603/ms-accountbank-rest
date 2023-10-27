package account.bank.service;

import account.bank.bean.AccountRQ;
import account.bank.bean.AccountRS;

public interface AccountService {
	
	AccountRS inserAccount(AccountRQ accountRQ);

}
