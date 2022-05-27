package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Friend;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Create
    @PostMapping("/transactions/create")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }
    // Read All transactions
    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransactions();
    }
    // Read transactions by id
    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById (@PathVariable("id") Integer id_transaction){
        return new ResponseEntity<Transaction>(transactionService.getTransactionById(id_transaction), HttpStatus.OK);
    }
    // Update transactions
    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Integer id_transaction,@RequestBody Transaction transaction){
        return new ResponseEntity<Transaction>(transactionService.updateTransaction(transaction, id_transaction), HttpStatus.OK);
    }
    // Delete transactions
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Integer id_transaction){
        transactionService.deleteTransaction(id_transaction);
        return new ResponseEntity<String>("Friend deleted successfully!.", HttpStatus.OK);
    }
}
