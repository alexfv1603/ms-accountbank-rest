package account.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import account.bank.bean.AccountRQ;
import account.bank.bean.AccountRS;
import account.bank.bean.UpdateAmountRQ;
import account.bank.model.Account;
import account.bank.model.Client;
import account.bank.model.Product;
import account.bank.repository.AccountRepository;
import account.bank.repository.ClientRepository;
import account.bank.repository.ProductRepository;
import account.bank.service.AccountService;
import account.bank.validate.ValidateAccount;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public AccountRS inserAccount(AccountRQ accountRQ) {
		AccountRS accountRS = new AccountRS();
		
		boolean status = false;
		String messaje = "";
		try {

			Optional<Client> clientExists = clientRepository.findById(accountRQ.getClientId());

			List<Account> accounts = new ArrayList<>();
			
			if (clientExists != null) {
				Account account = new Account();

				Client client = new Client();
				client.setId(accountRQ.getClientId());

				Product prod = new Product();
				prod.setId(accountRQ.getProductId());

				account.setClient(client);
				account.setProduct(prod);
				account.setNumberAccount(accountRQ.getNumberAccount());
				account.setBalance(accountRQ.getAmount());
				
				if (clientExists.get().getTypeClient().equals("Personal")) {
					Optional<Product> product = productRepository.findById(accountRQ.getProductId());

					if (ValidateAccount.validateAccountPersonal(product.get())) {

						accounts = accountRepository.findByClientAndProduct(clientExists.get(), product.get());

						if (accounts.size() == 0) {

							accountRepository.save(account);
							status = true;
							messaje = "Se registró exitosamente";
						} else {
							status = false;
							messaje = "El cliente ya cuenta con una cuenta de " + product.get().getAccountType();
						}

					} else if (product.get().getAccountType().equals("Tarjeta de Crédito")) {

						accounts = accountRepository.findByClientAndProduct(clientExists.get(), product.get());

						if (accounts.size() == 0) {
							accountRepository.save(account);
							status = true;
							messaje = "Se registró exitosamente";
						} else {
							status = false;
							messaje = "Solo se puede tener una Tarjeta de Crédito";
						}
					} else {
						status = false;
						messaje = "El cliente personal solo puede tener una cuenta de Ahorro, cuenta corriente o cuenta a plazo fijo";
					}
				} else if (clientExists.get().getTypeClient().equals("Empresarial")) {

					Optional<Product> product = productRepository.findById(accountRQ.getProductId());

					if (ValidateAccount.validateAccountEmpresarial(product.get())) {

						if (product.get().getAccountType().equals("Cuenta corriente")) {

							accountRepository.save(account);
							status = true;
							messaje = "Se registró exitosamente";

						} else {
							accounts = accountRepository.findByClientAndProduct(clientExists.get(), product.get());

							if (accounts.size() == 0) {
								accountRepository.save(account);
								status = true;
								messaje = "Se registró exitosamente";
							} else {
								status = false;
								messaje = "Solo se permite tener una cuenta - " + product.get().getAccountType();
							}
						}
					} else {
						status = false;
						messaje = "El cliente empresarial no puede tener una cuenta de ahorros o de plazo fijo";
					}
				}
			} else {
				status = false;
				messaje = "No existe cliente";
			}
		} catch (Exception e) {
			status = false;
			messaje = e.getMessage();
		}
		accountRS.setStatus(status);
		accountRS.setMessage(messaje);
		return accountRS;
	}

	@Override
	public boolean updateAmount(UpdateAmountRQ updateAmountRQ) {
		try {
			Account account = accountRepository.getAccountByNumberAccount(updateAmountRQ.getNumberAccount());
			
			if(account != null) {
				double amountNew = 0.0;
				if(ValidateAccount.validateTransaction(updateAmountRQ)) {
					if(account.getBalance() > 0) {
						if(account.getBalance() >= updateAmountRQ.getAmount()) {
							amountNew = account.getBalance() - updateAmountRQ.getAmount();
							
							account.setBalance(amountNew);
						}
	 				} else {
	 					return false;
	 				}
				} else {
					amountNew = account.getBalance() + updateAmountRQ.getAmount();
					
					account.setBalance(amountNew);
				}
				accountRepository.save(account);
				return true;
			}
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
		return false;
	}

}
