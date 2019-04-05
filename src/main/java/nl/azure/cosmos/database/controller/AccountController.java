package nl.azure.cosmos.database.controller;

import nl.azure.cosmos.database.model.Account;
import nl.azure.cosmos.database.service.AccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAll")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/get/{id}")
    public Account getOneAccount(@PathVariable ObjectId id) {
        return accountService.getOneAccount(id);
    }

    @PostMapping("/post/{accountNumber}")
    public void postOneAccount(@PathVariable String accountNumber) {
        accountService.postAccount(accountNumber);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllAccounts() {
        accountService.deleteAllAccounts();
    }
}
