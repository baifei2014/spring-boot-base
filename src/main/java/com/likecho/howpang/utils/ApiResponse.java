package com.likecho.howpang.utils;

import com.alibaba.fastjson.JSONObject;

public class ApiResponse extends JSONObject {

    public static ApiResponse create(int status) {
        return (ApiResponse) new ApiResponse()
                .fluentPut("code", status)
                .fluentPut("ts", System.currentTimeMillis())
                .fluentPut("data", new JSONObject());
    }

    public static ApiResponse create(int status, Object data) {
        return (ApiResponse) new ApiResponse()
                .fluentPut("code", status)
                .fluentPut("ts", System.currentTimeMillis())
                .fluentPut("data", data);
    }

    public static ApiResponse serverError(String msg) {
        return (ApiResponse) new ApiResponse()
                .fluentPut("code", 500)
                .fluentPut("msg", msg)
                .fluentPut("ts", System.currentTimeMillis());
    }
}
