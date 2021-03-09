package com.pb.news.services;

import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.vo.Message;

import java.util.List;

/**
 * Created by pb on 2018/5/22.
 */
public interface AdminService {

    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 查询所有的属性组
     * @author pengbin <pengbin> 2018/11/7 15:01
     */
    List<PropertyGroup> selectAllPropertyGroup();

    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 通过属性组id查询属性
     * @author pengbin <pengbin> 2018/11/7 15:01
     */
    List<Property> selectPropertyByPropertyGroupId(String groupKey);

    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 删除属性通过id
     * @author pengbin <pengbin> 2018/11/7 15:01
     */
    Integer delPropertyById(String id);

    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 添加或者更新属性
     * @author pengbin <pengbin> 2018/11/7 15:02
     */
    Message addorUpdateProperty(Property property);


    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 通过属性组id删除属性组
     * @author pengbin <pengbin> 2018/11/7 17:40
     */
    Message delPropertyGroup(PropertyGroup propertyGroup);

    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 添加或者更新属性组
     * @author pengbin <pengbin> 2018/11/7 15:02
     */
    Message addorUpdatePropertyGroup(PropertyGroup propertyGroup);


    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 重新跑property的redis缓存
     * @author pengbin <pengbin> 2018/11/7 20:16
     */
    Message setPropertyRedis();
}
