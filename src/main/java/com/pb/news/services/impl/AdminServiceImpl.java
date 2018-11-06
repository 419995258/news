package com.pb.news.services.impl;

import com.pb.news.dao.PropertyGroupMapper;
import com.pb.news.dao.PropertyMapper;
import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyExample;
import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.PropertyGroupExample;
import com.pb.news.services.AdminService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.util.Basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl extends Basic implements AdminService {


    @Autowired
    private RedisService redisService;

    @Autowired
    private PropertyMapper propertyMapper;

    @Autowired
    private PropertyGroupMapper propertyGroupMapper;

    /**
     *
     * @Description: TODO 查询所有的属性组
     * @param
     * @return propertyGroupList
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/6 14:41
     */
    @Override
    public List<PropertyGroup> selectAllPropertyGroup() {

        PropertyGroupExample propertyGroupExample = new PropertyGroupExample();
        propertyGroupExample.setOrderByClause(" seq_no desc");
        propertyGroupExample.createCriteria().andDelFlagEqualTo(0);
        List<PropertyGroup> propertyGroupList = propertyGroupMapper.selectByExample(propertyGroupExample);

        return propertyGroupList;
    }

    /**
     *
     * @Description: TODO 查询所有的属性 通过 属性组的id
     * @param id，属性组的id
     * @return propertyList
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/6 14:45
     */
    @Override
    public List<Property> selectPropertyByPropertyGroupId(String id) {
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.setOrderByClause(" seq_no desc");
        propertyExample.createCriteria().andDelFlagEqualTo(0).andGroupKeyEqualTo(id);
        List<Property> propertyList = propertyMapper.selectByExample(propertyExample);
        return propertyList;
    }

    /**
     *
     * @Description: TODO 通过id删除某个属性
     * @param Integer
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/6 17:09
     */
    @Override
    public Integer delPropertyById(String id) {
       /* PropertyExample propertyExample = new PropertyExample();
        propertyExample.createCriteria().andDelFlagEqualTo(0).andGroupKeyEqualTo(id);*/
        Property property = new Property();
        property.setGid(id);
        property.setDelFlag(1);
        return propertyMapper.updateByPrimaryKeySelective(property);
    }
}
