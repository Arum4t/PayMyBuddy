package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transactions/pay", method = RequestMethod.POST)
    private String sendMoney(@RequestParam String contactEmail, @RequestParam Float amount, @RequestParam String description, Principal principal){
        transactionService.sendMoneyToConnection(contactEmail,principal.getName(), amount, description);
        return "redirect:/transfers/";
    }
}
