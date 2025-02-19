package com.mike.mike.Transaction.CommandHandlers;

import com.mike.mike.Command;
import com.mike.mike.SuccessResponse.SuccessResponse;
import com.mike.mike.Transaction.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransaction implements Command<UpdateTransactionParameter, SuccessResponse> {

    private final TransactionRepository transactionRepository;

    public UpdateTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(UpdateTransactionParameter entity) {
        return null;
    }
}
