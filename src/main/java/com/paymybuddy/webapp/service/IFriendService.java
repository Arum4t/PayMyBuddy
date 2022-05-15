package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Friend;

import java.util.List;

public interface IFriendService {
    Friend saveFriend(Friend friend);
    List<Friend> getAllFriend();
    Friend getFriendById(Integer id);
    Friend updateFriend(Friend friend, Integer id);
    void deleteFriend(Integer id);
}
