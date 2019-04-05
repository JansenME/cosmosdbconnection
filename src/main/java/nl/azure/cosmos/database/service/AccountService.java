package nl.azure.cosmos.database.service;

import nl.azure.cosmos.database.model.Account;
import nl.azure.cosmos.database.repository.AccountRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getOneAccount(ObjectId id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void postAccount(final String accountNumber) {
        accountRepository.save(generateAccount(accountNumber));
    }

    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }

    private Account generateAccount(final String accountNumber) {
        return new Account(ObjectId.get(), accountNumber, generateBalance());
    }

    private String generateBalance() {
        return String.valueOf(Math.random());
    }
}
