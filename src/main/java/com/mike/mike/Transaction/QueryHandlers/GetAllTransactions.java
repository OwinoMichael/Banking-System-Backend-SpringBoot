package com.mike.mike.Transaction.QueryHandlers;

import com.mike.mike.Query;
import com.mike.mike.Transaction.Transaction;
import com.mike.mike.Transaction.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTransactions implements Query<Void, List<Transaction>> {

    private final TransactionRepository transactionRepository;

    public GetAllTransactions(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<List<Transaction>> execute(Void input) {
        List<Transaction> transactions = transactionRepository.findAll();

        return ResponseEntity.ok(transactions);
    }
}
