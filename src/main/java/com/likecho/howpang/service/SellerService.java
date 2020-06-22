package com.likecho.howpang.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.likecho.howpang.configuration.DruidConfig;
import com.likecho.howpang.dao.SellerDao;
import com.likecho.howpang.dao.impl.SellerDaoImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerService {

    private SellerDao dao;

    private DataSource dataSource;

    public SellerService() throws SQLException {
        SellerDao dao = new SellerDaoImpl();
        this.dao = dao;
    }

    public Map getSellerList() {
//        Map result = new HashMap();
//        result.put(1, 2);
//        result.put(3, 3);
//        result.put(5, 5);
//        result.put(7, 7);
//        result.put(9, 9);

        Map result = dao.getSellerList(1, 50);

        return result;
    }
}
