package com.yjymh.miraiwebhook.service;

import com.yjymh.miraiwebhook.entity.GroupToken;

public interface GroupTokenService {

    GroupToken queryGroupById(long account);

    GroupToken queryGroupByToken(String token);

    int addGroup(GroupToken group);

    int updateGroup(GroupToken group);

    int deleteGroup(Long account);

}
