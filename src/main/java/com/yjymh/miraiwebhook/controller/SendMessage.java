package com.yjymh.miraiwebhook.controller;

import com.yjymh.miraiwebhook.entity.FriendToken;
import com.yjymh.miraiwebhook.robot.PennyBot;
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


    @RequestMapping(value = "/sendfriend")
    public String sendFriendMessage(@RequestParam Map<String, Object> map){
        try {
            Bot bot = PennyBot.getBot();

            String token = (String) map.get("token");
            String msg = (String) map.get("msg");

            FriendToken friendToken = friendTokenService.queryFriendByToken(token);
            if(msg!=null && token!=null) {
                if (friendToken != null) {
                    Long id = friendToken.getAccount();
                    if (id != null) {
                        bot.getFriend(id).sendMessage(msg);
                        return ResponseUtil.setSuccessResponse("发送成功");
                    }
                }
            }

            return ResponseUtil.setSuccessResponse("token错误");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.setFailResponse("错误");
        }
    }

    @RequestMapping(value = "/sendgroup")
    public String sendGroupMessage(@RequestParam Map<String, Object> map) {
        return null;
    }
}
