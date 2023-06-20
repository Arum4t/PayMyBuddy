package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.service.PersonService;
import com.paymybuddy.webapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.security.Security;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private WalletService walletService;

    @GetMapping("/profiles")
    public String currentPersonProfile(Model model, Principal principal){
        Person person = personService.getPersonByEmail(principal.getName());
        Integer personId = personService.getPersonIdByEmail(principal.getName());
        Wallet wallet = walletService.getWalletById(personId);
        model.addAttribute("profile", person);
        model.addAttribute("profileWallet", wallet);
        return "profile";
    }
    @RequestMapping(value = "/persons/email", method = RequestMethod.POST)
    private String updateUserEmail(@RequestParam String newEmail, Principal principal){
        Integer userId = personService.getPersonIdByEmail(principal.getName());
        personService.updateEmailUser(newEmail, userId);
        return "redirect:/logout";
    }
    @RequestMapping(value ="/persons/password", method = RequestMethod.POST)
    public String updateUserPassword(@RequestParam String newPassword, Principal principal){
        Integer userId = personService.getPersonIdByEmail(principal.getName());
        personService.updatePasswordUser(newPassword, userId);
        return "redirect:/logout";
    }
}
