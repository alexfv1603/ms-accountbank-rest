package account.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import account.bank.model.Account;
import account.bank.model.Client;
import account.bank.model.Product;
import account.bank.repository.AccountRepository;
import account.bank.repository.ClientRepository;
import account.bank.repository.ProductRepository;

@SpringBootTest
class MsAccountbankRestApplicationTests {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	

	@Test
	@Disabled
	void saveAccount() {
		
		try {
			Account account = new Account();
			
			Client client = new Client();
			client.setId("652a16e9bc0122501430f1fb");
			
			Product product = new Product();
			product.setId("65275dfd9a977c69c46cd561");
			
			account.setClient(client);
			account.setProduct(product);
			account.setNumberAccount("444");
			account.setBalance(2.0);
			
			accountRepository.save(account);
			System.out.println("regisro");
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	@Test
	//@Disabled
	void saveAccounClient() {
		
		try {
			
			String clientId = "65275b469a977c69c46cd557";
			String productId = "65275e7e9a977c69c46cd564";
			
			Optional<Client> clientExists = clientRepository.findById(clientId);
			
			List<Account> accounts = new ArrayList<>();
			
			if(clientExists != null) {
				if(clientExists.get().getTypeClient().equals("Personal")) {
					Optional<Product> product = productRepository.findById(productId);
					
					if(product.get().getAccountType().equals("Ahorro")
							&& product.get().getAccountType().equals("Cuenta corriente")
							&& product.get().getAccountType().equals("Plazo fijo")) {
						
						accounts = accountRepository
								.findByClientAndProduct(clientExists.get(), product.get());
						
						if(accounts.size() == 0) {
							
							accountRepository.save(acount(clientId, productId));
							System.out.println("Se registró");
						} else {
							System.out.println("El cliente ya cuenta con una cuenta de " + product.get().getAccountType());
						}
						
					} else if(product.get().getAccountType().equals("Tarjeta de Crédito")) {
						
						accounts = accountRepository
								.findByClientAndProduct(clientExists.get(), product.get());
						
						if(accounts.size() == 0) {
							accountRepository.save(acount(clientId, productId));
							System.out.println("Se registró");
						} else {
							System.out.println("Solo se puede tener una Tarjeta de Crédito");
						}
					} else {
						System.out.println("El cliente personal solo puede tener una cuenta de Ahorro, cuenta corriente o cuenta a plazo fijo");
					}
				} else if(clientExists.get().getTypeClient().equals("Empresarial")) {
					
					Optional<Product> product = productRepository.findById(productId);
					
					if(!product.get().getAccountType().equals("Ahorro")
							&& !product.get().getAccountType().equals("Plazo fijo")) {
						
						if(product.get().getAccountType().equals("Cuenta corriente")) {
							
							accountRepository.save(acount(clientId, productId));
							System.out.println("Se registró");
							
						} else {
							accounts = accountRepository
									.findByClientAndProduct(clientExists.get(), product.get());
							
							if(accounts.size() == 0) {
								accountRepository.save(acount(clientId, productId));
								System.out.println("Se registró");
							} else {
								System.out.println("Solo se permite tener una cuenta - " + product.get().getAccountType());
							}
						}
					} else {
						System.out.println("El cliente empresarial no puede tener una cuenta de ahorros o de plazo fijo");
					}
				}
			} else {
				System.out.println("No existe cliente");
			}
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	private Account acount(String clientId, String productId) {
		Account account = new Account();
		
		Client client = new Client();
		client.setId(clientId);
		
		Product prod = new Product();
		prod.setId(productId);
		
		account.setClient(client);
		account.setProduct(prod);
		account.setNumberAccount("555");
		account.setBalance(250.5);
		
		return account;
	}
}
