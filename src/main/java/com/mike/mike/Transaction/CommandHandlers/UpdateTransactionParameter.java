package com.mike.mike.Transaction.CommandHandlers;

import com.mike.mike.Transaction.Transaction;

public class UpdateTransactionParameter {

    private Integer id;
    private Transaction transaction;

    public UpdateTransactionParameter() {
    }

    public UpdateTransactionParameter(Integer id, Transaction transaction) {
        this.id = id;
        this.transaction = transaction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
