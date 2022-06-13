package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.service.PersonService;
import com.paymybuddy.webapp.service.TransactionService;
import com.paymybuddy.webapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TemplateController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private PersonService personService;

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/login")
    public String getLoginView(){
        return "login";
    }
    @GetMapping("/home")
    public String getHomeView(){
        return "home";
    }

    @GetMapping("/profiles")
    public String currentPersonProfile(Model model, Principal principal){
        Person person = personService.getPersonByEmail(principal.getName());
        Integer personId = person.getId();
        Wallet wallet = walletService.getWalletById(personId);
        model.addAttribute("profile", person);
        model.addAttribute("profileWallet", wallet);
        return "profile";
    }
    @GetMapping("/transfers")
    public String currentPersonTransactions(Model model, Principal principal){
        Person person = personService.getPersonByEmail(principal.getName());
        List<Wallet> wallets = walletService.getAllWallet();
        List<Wallet> walletList = new ArrayList<>();
        for (Wallet wallet: wallets){
            if(wallet.getPerson().getEmail().equals(person.getEmail())){
                List<Transaction> transaction = transactionService.getTransactionByWalletId(wallet.getId());
                model.addAttribute("transactions", transaction);
                return "transfer";
            }
        }
        return null;
    }


}
