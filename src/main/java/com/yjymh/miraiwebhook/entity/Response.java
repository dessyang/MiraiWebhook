package com.yjymh.miraiwebhook.entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int code;
    private String msg;
}
