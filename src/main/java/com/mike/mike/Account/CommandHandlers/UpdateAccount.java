package com.mike.mike.Account.CommandHandlers;

import com.mike.mike.Account.Account;
import com.mike.mike.Account.AccountRepository;
import com.mike.mike.Command;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccount implements Command<UpdateAccountParameter, SuccessResponse> {

    private final AccountRepository accountRepository;

    public UpdateAccount(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdateAccountParameter updateParams) {
        Account account = accountRepository.findById(updateParams.getId()).orElseThrow(() -> new ResourceNotFound("Account"));
        Account accountForm = updateParams.getAccount();
        accountForm.setAccountId(updateParams.getId());

        accountRepository.save(accountForm);

        return ResponseEntity.ok(new SuccessResponse("true", "Account Updated !"));
    }
}
