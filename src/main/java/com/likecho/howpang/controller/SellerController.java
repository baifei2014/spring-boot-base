package com.likecho.howpang.controller;

import com.likecho.howpang.service.SellerService;
import com.likecho.howpang.utils.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/seller")
public class SellerController {

    @Resource
    private SellerService sellerService;

    @GetMapping("/list")
    public ApiResponse getSellerList() {
        Map sellerList = sellerService.getSellerList();

        return ApiResponse.create(200, sellerList);
    }
}
