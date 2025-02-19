package com.mike.mike.Transaction.CommandHandlers;

import com.mike.mike.Command;
import com.mike.mike.SuccessResponse.SuccessResponse;
import com.mike.mike.Transaction.Transaction;
import com.mike.mike.Transaction.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddTransaction implements Command<Transaction, SuccessResponse> {

    private final TransactionRepository transactionRepository;

    public AddTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Transaction entity) {
        return null;
    }
}
