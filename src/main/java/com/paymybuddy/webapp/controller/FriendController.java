package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Friend;
import com.paymybuddy.webapp.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    // Create
    @PostMapping("/friends/create")
    public ResponseEntity<Friend> saveFriend(@RequestBody Friend friend){
        return new ResponseEntity<Friend>(friendService.saveFriend(friend), HttpStatus.CREATED);
    }
    // Read All Friend
    @GetMapping("/friends")
    public List<Friend> getAllFriend(){
        return friendService.getAllFriend();
    }
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
    public ResponseEntity<String> deleteFriend(@PathVariable("id") Integer id_friend){
        //Delete Friend from DB
        friendService.deleteFriend(id_friend);
        return new ResponseEntity<String>("Friend deleted successfully!.", HttpStatus.OK);
    }
}
