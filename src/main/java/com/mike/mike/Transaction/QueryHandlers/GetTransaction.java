package com.mike.mike.Transaction.QueryHandlers;

import com.mike.mike.Query;
import com.mike.mike.Transaction.Transaction;
import com.mike.mike.Transaction.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetTransaction implements Query<Integer, Transaction> {

    private final TransactionRepository transactionRepository;

    public GetTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<Transaction> execute(Integer input) {
        return null;
    }
}
