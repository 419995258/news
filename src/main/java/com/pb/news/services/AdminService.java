package com.pb.news.services;

import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyGroup;

import java.util.List;

/**
 * Created by pb on 2018/5/22.
 */
public interface AdminService {

    List<PropertyGroup> selectAllPropertyGroup();

    List<Property> selectPropertyByPropertyGroupId(String id);

    Integer delPropertyById(String id);

}
