package com.yjymh.miraiwebhook.entity;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendToken {
    private Long account;
    private String token;
    private boolean status;
    private Date update_time;
    private Date create_time;
}
