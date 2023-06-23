package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

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
