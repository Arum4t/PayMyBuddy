package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.service.PersonService;
import com.paymybuddy.webapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    // Create
    @PostMapping("/wallets/create")
    public ResponseEntity<Wallet> saveWallet(@RequestBody Wallet wallet){
        return new ResponseEntity<Wallet>(walletService.saveWallet(wallet), HttpStatus.CREATED);
    }
    // Read All Wallet
    @GetMapping("/wallets")
    public List<Wallet> getAllWallet(){
        return walletService.getAllWallet();
    }
    // Read Wallet by id
    @GetMapping("/wallets/{id}")
    public ResponseEntity<Wallet> getWalletById (@PathVariable("id") Integer id_wallet){
        return new ResponseEntity<Wallet>(walletService.getWalletById(id_wallet), HttpStatus.OK);
    }
    // Update Wallet
    @PutMapping("/wallets/{id}")
    public ResponseEntity<Wallet> updatePerson(@PathVariable("id") Integer id_wallet,@RequestBody Wallet wallet){
        return new ResponseEntity<Wallet>(walletService.updateWallet(wallet, id_wallet), HttpStatus.OK);
    }
    // Delete Wallet
    @DeleteMapping("/wallets/{id}")
    public ResponseEntity<String> deleteWallet(@PathVariable("id") Integer id_wallet){
        //Delete Person from DB
        walletService.deleteWallet(id_wallet);
        return new ResponseEntity<String>("Wallet deleted successfully!.", HttpStatus.OK);
    }
}
