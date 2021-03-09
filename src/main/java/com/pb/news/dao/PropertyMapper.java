package com.pb.news.dao;

import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PropertyMapper {
    long countByExample(PropertyExample example);

    int deleteByExample(PropertyExample example);

    int deleteByPrimaryKey(String gid);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(String gid);

    int updateByExampleSelective(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByExample(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}