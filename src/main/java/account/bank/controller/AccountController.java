package account.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import account.bank.bean.AccountRQ;
import account.bank.bean.AccountRS;
import account.bank.bean.UpdateAmountRQ;
import account.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountRS> insertAccount(@RequestBody AccountRQ accountRQ) {
		AccountRS accountRS = accountService.inserAccount(accountRQ);
		return new ResponseEntity<>(accountRS, HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateAmount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateAmount(@RequestBody UpdateAmountRQ updateAmountRQ) {
		boolean status = accountService.updateAmount(updateAmountRQ);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}