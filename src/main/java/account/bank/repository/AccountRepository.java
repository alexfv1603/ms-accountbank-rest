package account.bank.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import account.bank.model.Account;
import account.bank.model.Client;
import account.bank.model.Product;

public interface AccountRepository extends MongoRepository<Account, String>{
	
	List<Account> findByClientAndProduct(Client client, Product product);
	
}
