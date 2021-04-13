package com.yjymh.miraiwebhook.service;

import com.yjymh.miraiwebhook.entity.FriendToken;
import com.yjymh.miraiwebhook.mapper.FriendTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendTokenServiceImpl implements FriendTokenService {

    @Autowired
    private FriendTokenMapper friendTokenMapper;

    @Override
    public FriendToken queryFriendById(Long account) {
        return friendTokenMapper.queryFriendById(account);
    }

    @Override
    public FriendToken queryFriendByToken(String token) {
        return friendTokenMapper.queryFriendByToken(token);
    }

    @Override
    public int addFriend(FriendToken friend) {
        return friendTokenMapper.addFriend(friend);
    }

    @Override
    public int updateFriend(FriendToken friend) {
        return friendTokenMapper.updateFriend(friend);
    }

    @Override
    public int deleteFriend(Long account) {
        return friendTokenMapper.deleteFriend(account);
    }
}
