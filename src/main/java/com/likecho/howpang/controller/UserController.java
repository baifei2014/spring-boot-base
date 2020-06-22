package com.likecho.howpang.controller;

import com.likecho.howpang.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Value("${aaa.bbb}")
    private String name;

    @GetMapping("/profile")
    public ApiResponse profile() {
        Map profile = new HashMap();
        List menu = new ArrayList<Map>();
        Map item;
        item = new HashMap<>();
        item.put("title", "好胖红包");
        item.put("icon", "mt-red-packet-o");
        item.put("path", "/pages/redPacket/main");
        item.put("amount", 4);
        menu.add(item);
        item = new HashMap<>();
        item.put("title", "我的地址");
        item.put("icon", "mt-my-location-o");
        item.put("path", "/pages/addressList/main");
        menu.add(item);
        item = new HashMap<>();
        item.put("title", "邀请有奖");
        item.put("icon", "mt-gift-o");
        menu.add(item);
        item = new HashMap<>();
        item.put("title", "客服中心");
        item.put("icon", "mt-customer-service-o");
        menu.add(item);
        item = new HashMap<>();
        item.put("title", "帮助和反馈");
        item.put("icon", "mt-help-o");
        item.put("path", "/pages/feedback/main");
        menu.add(item);
        item = new HashMap<>();
        item.put("title", "协议和说明");
        item.put("icon", "mt-protocol-o");
        item.put("path", "/pages/protocol/main");
        menu.add(item);
        profile.put("name", "张三");
        profile.put("phone", "15237391081");
        profile.put("menu", menu);
        return ApiResponse.create(200, profile);
    }

    @GetMapping("/info")
    public ApiResponse info() {
        Map res = new HashMap();
        res.put("name", name);

        return ApiResponse.create(200, res);
    }
}
