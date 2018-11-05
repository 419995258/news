package com.pb.news.services.impl;

import com.pb.news.dao.PropertyGroupMapper;
import com.pb.news.dao.PropertyMapper;
import com.pb.news.dao.UserMapper;
import com.pb.news.dao.vo.UserMapperExt;
import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.User;
import com.pb.news.entity.UserExample;
import com.pb.news.services.AdminService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.util.FengYeBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.runtime.PropertyMap;

//import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pb on 2018/5/22.
 */

@Service
public class AdminServiceImpl extends FengYeBasic implements AdminService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperExt userMapperExt;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PropertyMapper propertyMapper;

    @Autowired
    private PropertyGroupMapper propertyGroupMapper;

}
