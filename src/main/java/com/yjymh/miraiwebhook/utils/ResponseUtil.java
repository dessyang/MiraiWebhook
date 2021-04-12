package com.yjymh.miraiwebhook.utils;

import com.alibaba.fastjson.JSON;
import com.yjymh.miraiwebhook.entity.Response;


public class ResponseUtil {
    // 设置返回数据
    public static String setSuccessResponse(int code, String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return JSON.toJSONString(response);
    }

    public static String setSuccessResponse(String msg){
        return setSuccessResponse(0, msg);
    }

    public static String setFailResponse(int code, String msg) {
        return setSuccessResponse(code, msg);
    }

    public static String setFailResponse(String msg) {
        return setSuccessResponse(500, msg);
    }
}
