package com.yjymh.miraiwebhook.service;

import com.yjymh.miraiwebhook.entity.FriendToken;

public interface FriendTokenService {

    FriendToken queryFriendById(Long account);

    FriendToken queryFriendByToken(String token);

    int addFriend(FriendToken friend);

    int updateFriend(FriendToken friend);

    int deleteFriend(Long account);

}
