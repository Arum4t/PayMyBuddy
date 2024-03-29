package com.paymybuddy.webapp.controller;


import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;

import com.paymybuddy.webapp.service.PersonService;
import com.paymybuddy.webapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private PersonService personService;

    @GetMapping("/profiles")
    public String currentPersonProfile(Model model, Principal principal){
        Person person = personService.getPersonByEmail(principal.getName());
        Integer personId = personService.getPersonIdByEmail(principal.getName());
        Wallet wallet = walletService.getWalletById(personId);
        model.addAttribute("profile", person);
        model.addAttribute("profileWallet", wallet);
        return "profile";
    }
    @PostMapping(value="/wallet/addMoney")
    public String addMoneyToUserWallet(@RequestParam Float amount, Principal principal){
        walletService.addMoneyToWallet(principal.getName(), amount);
        return "redirect:/profiles";
    }
}
