package com.yjymh.miraiwebhook.service;

import com.yjymh.miraiwebhook.entity.FriendToken;

public interface FriendTokenService {
    FriendToken queryFriendById(Long id);

    FriendToken queryFriendByToken(String token);

    int addFriend(FriendToken friend);

    int updateFriend(FriendToken friend);

    int deleteFriend(Long id);
}
