package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.service.ContactService;
import com.paymybuddy.webapp.service.PersonService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contacts/addConnection", method = RequestMethod.POST)
    private String addConnection(@RequestParam(value = "email") String contactEmail, Principal principal){
        contactService.addConnection(contactEmail, principal);
        return "redirect:/transfers/";
    }
}
