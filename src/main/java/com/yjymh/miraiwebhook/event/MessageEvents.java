package com.yjymh.miraiwebhook.event;

import com.yjymh.miraiwebhook.entity.FriendToken;
import com.yjymh.miraiwebhook.service.FriendTokenService;
import com.yjymh.miraiwebhook.utils.MD5Util;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class MessageEvents extends SimpleListenerHost {

    @Autowired
    private FriendTokenService friendTokenService;

    // 功能很少，就没必要把command模块化
    @NotNull
    @EventHandler
    public ListeningStatus friendMessage(@NotNull FriendMessageEvent event) {
        String msg = event.getMessage().contentToString();
        Long sendId = event.getSender().getId();
        FriendToken friendToken = friendTokenService.queryFriendById(sendId);
        String newToken = MD5Util.toMD5(sendId.toString());

        Timestamp time = new Timestamp(new Date().getTime());

        if(msg.contains(".token")) {
            if (friendToken!=null) {
                // 发送token
                event.getSender().sendMessage(friendToken.getToken());
            } else {
                // 创建一个新的 token
                friendTokenService.addFriend(new FriendToken(sendId, newToken, true, time, time));
                event.getSender().sendMessage(newToken);
            }
        }
        if(msg.contains(".update")) {
            if (friendToken!=null) {
                friendTokenService.updateFriend(new FriendToken(sendId, newToken,true, time, null));
            }else {
                friendTokenService.addFriend(new FriendToken(sendId, newToken, true, time, time));
            }
            event.getSender().sendMessage(newToken);
        }
        if(msg.contains(".del")) {
            if (friendToken!=null) {
                friendTokenService.deleteFriend(sendId);
                event.getSender().sendMessage("删除成功");
            }else {
                event.getSender().sendMessage("已经删除，不要重复操作");
            }

        }

        return ListeningStatus.LISTENING;
    }

}
