package com.mike.mike.Account.CommandHandlers;

import com.mike.mike.Account.Account;

public class UpdateAccountParameter {

    private Integer id;
    private Account account;

    public UpdateAccountParameter() {
    }

    public UpdateAccountParameter(Integer id, Account account) {
        this.id = id;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
