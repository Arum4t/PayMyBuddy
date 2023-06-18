package com.paymybuddy.webapp.controller;


import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;

import com.paymybuddy.webapp.service.PersonService;
import com.paymybuddy.webapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@Controller
public class WalletController {

    @Autowired
    private WalletService walletService;

}
