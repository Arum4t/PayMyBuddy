package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.model.specific.TransactionData;
import com.paymybuddy.webapp.service.PersonService;
import com.paymybuddy.webapp.service.TransactionService;
import com.paymybuddy.webapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PersonService personService;

    @Autowired
    private WalletService walletService;

    // Read All transactions
    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransactions();
    }
    // Read transactions by id
    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionByWalletId (@PathVariable("id") Integer id_transaction){
        return new ResponseEntity<Transaction>(transactionService.getTransactionById(id_transaction), HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions/pay", method = RequestMethod.POST)
    private String sendMoney(@RequestParam String contactEmail, Float amount, Principal principal){
        transactionService.sendMoneyToConnection(contactEmail, amount, principal);
        return "redirect:/transactions/";
    }

    // test liste de transaction
    @GetMapping("/test_transaction")
    public String userTransaction(Model model, Principal principal){
        Integer personId = personService.getPersonIdByEmail(principal.getName());
        Integer walletId = walletService.getWalletByPersonId(personId).getIdWallet();
        List<Transaction> userTransactions = transactionService.userTransaction(walletId);
        model.addAttribute("userTransaction", userTransactions);
        return "test";
    }
}
