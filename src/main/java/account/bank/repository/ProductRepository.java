package account.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import account.bank.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
