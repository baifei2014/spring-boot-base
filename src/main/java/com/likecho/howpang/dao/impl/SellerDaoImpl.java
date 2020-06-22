package com.likecho.howpang.dao.impl;

import com.github.pagehelper.PageHelper;
import com.likecho.howpang.configuration.DruidConfig;
import com.likecho.howpang.dao.SellerDao;
import com.likecho.howpang.mapper.SellerMapper;
import com.likecho.howpang.model.Seller;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SellerDaoImpl implements SellerDao {

    SqlSessionFactory sqlSessionFactory;

    public SellerDaoImpl() throws SQLException {
        DruidConfig druidConfig = DruidConfig.getInstance();
        DataSource dataSource = druidConfig.createDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(SellerMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

//    @Resource
//    SellerMapper sellerMapper;

    @Override
    public Map getSellerList(int page, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
//            PageHelper.startPage(page, pageSize);
//            return sqlSession.selectOne("com.likecho.howpang.mapper.SellerMapper.getSeller", 1);

            SellerMapper mapper = sqlSession.getMapper(SellerMapper.class);
            return mapper.getSeller(1);
        } finally {
            sqlSession.close();
        }
//        PageHelper.startPage(page, pageSize);
//        return sellerMapper.getSellerList();
    }
}
