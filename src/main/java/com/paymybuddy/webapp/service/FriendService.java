package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Friend;
import com.paymybuddy.webapp.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService implements IFriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public List<Friend> getAllFriend() {
        return friendRepository.findAll();
    }

    @Override
    public Friend getFriendById(Integer id) {
        return friendRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Friend", "Id", id));
    }

    @Override
    public Friend updateFriend(Friend friend, Integer id) {
        //Check friend exist in DB or not
        Friend existingFriend = friendRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Friend", "Id", id));
        existingFriend.setEmail(friend.getEmail());
        // Save existing Friend to DB
        friendRepository.save(existingFriend);
        return existingFriend;
    }

    @Override
    public void deleteFriend(Integer id) {
        //Check friend exist in DB or not
        friendRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Friend", "Id", id));
        friendRepository.deleteById(id);
    }
}
