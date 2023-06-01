package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.service.ContactService;
import com.paymybuddy.webapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private PersonService personService;

/*
    // Create
    @PostMapping("/friends/create")
    public ResponseEntity<Friend> saveFriend(@RequestBody Friend friend){
        return new ResponseEntity<Friend>(friendService.saveFriend(friend), HttpStatus.CREATED);
    }
    // Read All Friend
//    @GetMapping("/friends")
//    public List<Friend> getAllFriend(){
//        return friendService.getAllFriend();
//    }
    // Read Friend by id
    @GetMapping("/friends/{id}")
    public ResponseEntity<Friend> getFriendById (@PathVariable("id") Integer id_friend){
        return new ResponseEntity<Friend>(friendService.getFriendById(id_friend), HttpStatus.OK);
    }
    // Update Friend
    @PutMapping("/friends/{id}")
    public ResponseEntity<Friend> updateFriend(@PathVariable("id") Integer id_friend,@RequestBody Friend friend){
        return new ResponseEntity<Friend>(friendService.updateFriend(friend, id_friend), HttpStatus.OK);
    }
    // Delete Friend
    @DeleteMapping("/friends/{id}")
    public String deleteFriend(@PathVariable("id") Integer id_friend, Model model){
        //Delete Friend from DB
        friendService.deleteFriend(id_friend);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/friends", method = RequestMethod.POST)
    public String createFriend(Model model, @ModelAttribute Contact contactInfo) {
        Contact contact = contactService.saveContact(contactInfo);
        model.addAttribute("errorMessage", errorMessage);
        return "redirect:/contacts/";
    }*/

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String currentPersonContact(Model model, Principal principal){
        Person person = personService.getPersonByEmail(principal.getName());
        List<Contact> contacts = person.getContactList();
        model.addAttribute("contacts", contacts);
        model.addAttribute("contactInfo", new Contact());
        return "contact";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    private String addContact(Model model, @ModelAttribute String contactEmail, Principal principal) {
        contactService.addContact(contactEmail, principal);
        return "redirect:/contacts/";
    }
}
