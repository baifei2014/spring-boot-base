package com.likecho.howpang.mapper;

import com.likecho.howpang.model.Seller;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SellerMapper {
//    @Select("SELECT name, pic_url, update_time FROM seller WHERE id = #{id}")
//    @Results(value = {
//            @Result(column = "name", property = "name"),
//            @Result(column = "pic_url", property = "picUrl"),
//            @Result(column = "update_time", property = "updateTime")
//    })
    Map getSeller(@Param("id") int id);
}
