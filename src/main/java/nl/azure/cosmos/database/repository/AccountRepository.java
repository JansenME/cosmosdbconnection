package nl.azure.cosmos.database.repository;

import nl.azure.cosmos.database.model.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    Account findById(ObjectId id);
}
