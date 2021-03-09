package com.pb.news.dao.vo;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("UserMapperExt")
public interface UserMapperExt {

    List<Map<String, Object>> selectRoleByUserId(Integer id);

    List<Map<String, Object>> selectRolePermissionByUserId(Integer id);


    List<Map<String, Object>> test();

}