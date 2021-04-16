package com.yjymh.miraiwebhook.service.Impl;

import com.yjymh.miraiwebhook.entity.FriendToken;
import com.yjymh.miraiwebhook.mapper.FriendTokenMapper;
import com.yjymh.miraiwebhook.service.FriendTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendTokenServiceImpl implements FriendTokenService {

    @Autowired
    private FriendTokenMapper friendTokenMapper;

    @Override
    public FriendToken queryFriendById(Long id) {
        return friendTokenMapper.queryFriendById(id);
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
    public int deleteFriend(Long id) {
        return friendTokenMapper.deleteFriend(id);
    }
}
