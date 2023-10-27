package account.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import account.bank.model.Client;

public interface ClientRepository extends MongoRepository<Client, String>{

	
}
