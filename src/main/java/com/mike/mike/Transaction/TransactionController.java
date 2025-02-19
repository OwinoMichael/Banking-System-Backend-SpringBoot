package com.mike.mike.Transaction;

import com.mike.mike.SuccessResponse.SuccessResponse;
import com.mike.mike.Transaction.CommandHandlers.AddTransaction;
import com.mike.mike.Transaction.CommandHandlers.UpdateTransaction;
import com.mike.mike.Transaction.CommandHandlers.UpdateTransactionParameter;
import com.mike.mike.Transaction.QueryHandlers.GetAllTransactions;
import com.mike.mike.Transaction.QueryHandlers.GetTransaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final GetAllTransactions getAllTransactions;
    private final GetTransaction getTransaction;
    private final AddTransaction addTransaction;
    private final UpdateTransaction updateTransaction;

    public TransactionController(GetAllTransactions getAllTransactions, GetTransaction getTransaction, AddTransaction addTransaction, UpdateTransaction updateTransaction) {
        this.getAllTransactions = getAllTransactions;
        this.getTransaction = getTransaction;
        this.addTransaction = addTransaction;
        this.updateTransaction = updateTransaction;
    }

    @GetMapping("/")
    public ResponseEntity<List<Transaction>> getAllTransaction(){
        return getAllTransactions.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Integer id){
        return getTransaction.execute(id);
    }

    @PostMapping("/add-transactions")
    public ResponseEntity<SuccessResponse> addTransaction(@RequestBody Transaction transaction){
        return addTransaction.execute(transaction);
    }

    @PutMapping("/update-transactions/{id}")
    public ResponseEntity<SuccessResponse> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction){
        UpdateTransactionParameter update = new UpdateTransactionParameter();
        update.setId(id);
        update.setTransaction(transaction);
        return updateTransaction.execute(update);
    }


}
