package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.exception.NoUserFoundException;
import com.paymybuddy.webapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts/add")
    public String getAddConnectionView(){
        return "addConnection";
    }
    @RequestMapping(value = "/contacts/addConnection", method = RequestMethod.POST)
    private String addConnection(@RequestParam(value = "email") String contactEmail, Principal principal, Model model){
        try {
            contactService.addConnection(contactEmail, principal.getName());
            return "redirect:/transfers/";
        } catch (NoUserFoundException e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "addConnection";
        }

    }
}
