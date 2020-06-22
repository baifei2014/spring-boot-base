package com.likecho.howpang.dao;

import com.likecho.howpang.model.Seller;

import java.util.List;
import java.util.Map;

public interface SellerDao {
    Map getSellerList(int page, int pageSize);
}
