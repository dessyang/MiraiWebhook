package com.yjymh.miraiwebhook.robot;

import com.yjymh.miraiwebhook.event.MessageEvents;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PennyBot implements ApplicationRunner {

    private static final String deviceInfo = "deviceInfo.json";

    private static Bot bot;

    @Autowired
    private MessageEvents messageEvents;

    @Value("${bot.account}")
    private long botAccount;
    @Value("${bot.pwd}")
    private String botPwd;
    @Value("${bot.device:pad}")
    private String device;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        startBot();
    }

    // bot启动方法
    public void startBot(){
        bot = BotFactory.INSTANCE.newBot(botAccount,botPwd, new BotConfiguration() {{
            fileBasedDeviceInfo(deviceInfo);
            setProtocol(setDevice(device));
        }});

        bot.login();

        bot.getEventChannel().registerListenerHost(messageEvents);

        new Thread(() -> {
            bot.join();
        }).start();
    }

    // 获取bot实例
    public static Bot getBot(){
        return bot;
    }

    // 设置登录设备
    private MiraiProtocol setDevice(String device) {
        switch (device) {
            case "phone":
            case "手机":
                return MiraiProtocol.ANDROID_PHONE;
            case "watch":
            case "手表":
                return MiraiProtocol.ANDROID_WATCH;
            default:
                return MiraiProtocol.ANDROID_PAD;
        }
    }

}
