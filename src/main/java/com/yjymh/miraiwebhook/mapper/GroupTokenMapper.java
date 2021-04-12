package com.yjymh.miraiwebhook.mapper;

import com.yjymh.miraiwebhook.entity.GroupToken;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GroupTokenMapper {
    @Select("select * from group where account = ${id}")
    GroupToken queryGroupById(long id);

    @Select("select * from group where token = '${token}'")
    GroupToken queryGroupByToken(String token);

    @Insert("")
    int addGroup(GroupToken group);

    @Update("")
    int updateGroup(GroupToken group);

    @Delete("")
    int deleteGroup(Long id);
}
