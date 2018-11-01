package com.pb.news.services;

import com.pb.news.entity.Role;
import com.pb.news.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by pb on 2018/5/22.
 */
public interface RoleService {


    List<Map<String,Object>> getRolesByUser(Integer userId);

    List<Map<String,Object>> getRolesPermissionByUser(Integer userId);
}
