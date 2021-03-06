package com.yjymh.miraiwebhook.controller;

import com.yjymh.miraiwebhook.entity.FriendToken;
import com.yjymh.miraiwebhook.entity.GroupToken;
import com.yjymh.miraiwebhook.robot.PennyBot;
import com.yjymh.miraiwebhook.service.GroupTokenService;
import com.yjymh.miraiwebhook.utils.ResponseUtil;
import com.yjymh.miraiwebhook.service.FriendTokenService;
import net.mamoe.mirai.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SendMessage {

    @Autowired
    private FriendTokenService friendTokenService;

    @Autowired
    private GroupTokenService groupTokenService;

    @RequestMapping(value = "/sendfriend")
    public String sendFriendMessage(@RequestParam("token") String token,
                                    @RequestParam("msg") String msg) {
        try {
            Bot bot = PennyBot.getBot();


            FriendToken friendToken = friendTokenService.queryFriendByToken(token);
            if (msg != null && token != null) {
                if (friendToken != null) {
                    Long id = friendToken.getAccount();
                    if (id != null) {
                        bot.getFriend(id).sendMessage(msg);
                        return ResponseUtil.setSuccessResponse("发送成功");
                    }
                }
            }

            return ResponseUtil.setSuccessResponse("token错误");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.setFailResponse("错误");
        }
    }

    @RequestMapping(value = "/sendgroup")
    public String sendGroupMessage(@RequestParam("token") String token,
                                   @RequestParam("msg") String msg) {
        try {
            Bot bot = PennyBot.getBot();

            GroupToken groupToken = groupTokenService.queryGroupByToken(token);

            if (msg != null && token != null) {
                if (groupToken != null) {
                    Long group = groupToken.getAccount();
                    if (group != null) {
                        bot.getGroup(group).sendMessage(msg);
                        return ResponseUtil.setSuccessResponse("发送成功");
                    }
                }
            }
            return ResponseUtil.setSuccessResponse("token错误");
        } catch (Exception e) {
            return ResponseUtil.setFailResponse("错误");
        }
    }
}
