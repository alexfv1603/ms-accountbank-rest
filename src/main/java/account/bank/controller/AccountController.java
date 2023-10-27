package account.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import account.bank.bean.AccountRQ;
import account.bank.bean.AccountRS;
import account.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<AccountRS> insertAccount(@RequestBody AccountRQ accountRQ) {
		AccountRS accountRS = accountService.inserAccount(accountRQ);
		return new ResponseEntity<>(accountRS, HttpStatus.OK);
	}

}