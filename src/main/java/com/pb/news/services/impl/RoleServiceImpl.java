package com.pb.news.services.impl;

import com.pb.news.dao.RoleMapper;
import com.pb.news.dao.vo.UserMapperExt;
import com.pb.news.services.RoleService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.util.Basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pb on 2018/5/22.
 */

@Service
public class RoleServiceImpl extends Basic implements RoleService {


    @Autowired
    private UserMapperExt userMapperExt;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RedisService redisService;


    @Override
    public List<Map<String,Object>> getRolesByUser(Integer userId) {
        List<Map<String,Object>> roleList = userMapperExt.selectRoleByUserId(userId);
        return roleList;
    }

    @Override
    public List<Map<String, Object>> getRolesPermissionByUser(Integer userId) {
        List<Map<String,Object>> permissionList = userMapperExt.selectRolePermissionByUserId(userId);
        return permissionList;
    }
}
