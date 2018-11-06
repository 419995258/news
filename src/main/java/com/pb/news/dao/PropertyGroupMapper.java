package com.pb.news.dao;

import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.PropertyGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyGroupMapper {
    long countByExample(PropertyGroupExample example);

    int deleteByExample(PropertyGroupExample example);

    int deleteByPrimaryKey(String gid);

    int insert(PropertyGroup record);

    int insertSelective(PropertyGroup record);

    List<PropertyGroup> selectByExample(PropertyGroupExample example);

    PropertyGroup selectByPrimaryKey(String gid);

    int updateByExampleSelective(@Param("record") PropertyGroup record, @Param("example") PropertyGroupExample example);

    int updateByExample(@Param("record") PropertyGroup record, @Param("example") PropertyGroupExample example);

    int updateByPrimaryKeySelective(PropertyGroup record);

    int updateByPrimaryKey(PropertyGroup record);
}