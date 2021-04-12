package com.yjymh.miraiwebhook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupToken {
    private Long group;
    private Long account;
    private String token;
    private boolean status;
    private Date update_time;
    private Date create_time;
}
