package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.model.specific.TransactionData;
import com.paymybuddy.webapp.repository.ContactRepository;
import com.paymybuddy.webapp.repository.PersonRepository;
import com.paymybuddy.webapp.service.ContactService;
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
    private TransactionService transactionService;

    @Autowired
    private PersonService personService ;

    @Autowired
    private ContactService contactService;

    @Autowired
    private WalletService walletService;


    @GetMapping("/login")
    public String getLoginView(){
        return "login";
    }
    @GetMapping("/home")
    public String getHomeView(){
        return "home";
    }
    @GetMapping("/add")
    public String getAddConnectionView(){
        return "addConnection";
    }
    @GetMapping("/transfers")
    public String getTransferView(Model model, Principal principal){
        Integer personId = personService.getPersonIdByEmail(principal.getName());

        List<String> userContacts = contactService.userContact(personId);
//        List<TransactionData> userTransactions = transactionService.userTransaction(personId);

        model.addAttribute("userContactList", userContacts);
//        model.addAttribute("userTransactionList", userTransactions);
        return "transfer";
    }
}
