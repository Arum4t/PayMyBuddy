package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.specific.PersonData;
import com.paymybuddy.webapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String register(final Model model){
        model.addAttribute("personData", new PersonData());
        return "register";
    }

    @PostMapping
    public String userRegistration(final @Valid  PersonData personData,
                                   final BindingResult bindingResult,
                                   final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", personData);
            return "register";
        }
        try {
            personService.register(personData);
        }catch (Exception e){
            bindingResult.rejectValue("email",
                    "personData.email",
                    "An account already exists for this email.");
            model.addAttribute("registrationForm", personData);
            return "register";
        }
        return "redirect:/login";
    }


}
