package com.mike.mike.Account;

import com.mike.mike.Account.CommandHandlers.AddAccount;
import com.mike.mike.Account.CommandHandlers.UpdateAccount;
import com.mike.mike.Account.CommandHandlers.UpdateAccountParameter;
import com.mike.mike.Account.QueryHandlers.GetAccount;
import com.mike.mike.Account.QueryHandlers.GetAllAccounts;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final GetAllAccounts getAllAccounts;
    private final GetAccount getAccount;
    private final AddAccount addAccount;
    private final UpdateAccount updateAccount;

    public AccountController(GetAllAccounts getAllAccounts, GetAccount getAccount, AddAccount addAccount, UpdateAccount updateAccount) {
        this.getAllAccounts = getAllAccounts;
        this.getAccount = getAccount;
        this.addAccount = addAccount;
        this.updateAccount = updateAccount;
    }

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return getAllAccounts.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Integer id){
        return getAccount.execute(id);
    }

    @PostMapping("/add-accounts")
    public ResponseEntity<SuccessResponse> addAccount(@RequestBody Account account){
        return addAccount.execute(account);
    }


    @PutMapping("/update-accounts/{id}")
    public ResponseEntity<SuccessResponse> updateAccount(@PathVariable Integer id, @RequestBody Account account){
        UpdateAccountParameter update = new UpdateAccountParameter();
        update.setId(id);
        update.setAccount(account);

        return updateAccount.execute(update);

    }



}
