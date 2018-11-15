package com.pb.news.services.impl;

import com.pb.news.dao.PropertyGroupMapper;
import com.pb.news.dao.PropertyMapper;
import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyExample;
import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.PropertyGroupExample;
import com.pb.news.entity.vo.Message;
import com.pb.news.services.AdminService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.util.Basic;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@Service
public class AdminServiceImpl extends Basic implements AdminService {

    final private String PROPERTY_GROUP = "PROPERTY_GROUP";

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
    public List<Property> selectPropertyByPropertyGroupId(String groupKey) {
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.setOrderByClause(" seq_no desc");
        propertyExample.createCriteria().andDelFlagEqualTo(0).andGroupKeyEqualTo(groupKey);
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


    @Override
    public Message addorUpdateProperty(Property property) {
        Message message = new Message();
        if(property == null){
            property = new Property();
        }

        if(StringUtils.isBlank(property.getPropertyKey())){
            message.setMessage("属性key不能为空");
            return message;
        }
        if(StringUtils.isBlank(property.getPropertyValue())){
            message.setMessage("属性value不能为空");
            return message;
        }
        if(StringUtils.isBlank(property.getGroupKey())){
            message.setMessage("属性组key不能为空");
            return message;
        }

        //先判断propertyKey是否存在，来确认是添加还是修改
        if(StringUtils.isBlank(property.getGid())){
            //添加
            //先验证key不能重复
            PropertyExample propertyExample = new PropertyExample();
            propertyExample.createCriteria().andPropertyKeyEqualTo(property.getPropertyKey());
            List<Property> propertyList = propertyMapper.selectByExample(propertyExample);
            if(propertyList.size() > 0){
                message.setMessage("属性key已经重复");
                return message;
            }
            property.setGid(UUID.randomUUID().toString());
            Integer success = propertyMapper.insertSelective(property);
            if(success ==1){
                message.setSuccess(true);
            }

        }else{
            //更新
            //先验证key不能重复
            PropertyExample propertyExample = new PropertyExample();
            propertyExample.createCriteria().andPropertyKeyEqualTo(property.getPropertyKey())
                    .andGidNotEqualTo(property.getGid());
            List<Property> propertyList = propertyMapper.selectByExample(propertyExample);
            if(propertyList.size() > 0){
                message.setMessage("属性key已经重复");
                return message;
            }
            Integer success = propertyMapper.updateByPrimaryKeySelective(property);
            if(success ==1){
                message.setSuccess(true);
            }
        }
        return message;
    }

    @Override
    public Message delPropertyGroup(PropertyGroup propertyGroup) {
        Message message = new Message();
        if(StringUtils.isBlank(propertyGroup.getGid())){
            message.setMessage("gid不能为空");
            return message;
        }
        if(StringUtils.isBlank(propertyGroup.getGroupKey())){
            message.setMessage("GroupKey不能为空");
            return message;
        }

        //先判断这个属性组是否有属性，如果有，则不能删除
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.createCriteria()
                .andGroupKeyEqualTo(propertyGroup.getGroupKey()).andDelFlagEqualTo(0);
        List<Property> propertyList = propertyMapper.selectByExample(propertyExample);

        if(propertyList.size() > 0){
            message.setMessage("该group下还存在property！");
            return message;
        }

        propertyGroup.setDelFlag(1);
        Integer success = propertyGroupMapper.updateByPrimaryKeySelective(propertyGroup);
        if(success == 1){
            message.setSuccess(true);
            message.setMessage("删除成功");
        }

        return message;
    }


    @Override
    public Message addorUpdatePropertyGroup(PropertyGroup propertyGroup) {
        Message message = new Message();
        if(propertyGroup == null){
            propertyGroup = new PropertyGroup();
        }

        if(StringUtils.isBlank(propertyGroup.getGroupKey())){
            message.setMessage("属性组key不能为空");
            return message;
        }
        if(StringUtils.isBlank(propertyGroup.getGroupName())){
            message.setMessage("属性组name不能为空");
            return message;
        }


        //先判断propertyKey是否存在，来确认是添加还是修改
        if(StringUtils.isBlank(propertyGroup.getGid())){
            //添加
            //先验证key不能重复
            PropertyGroupExample propertyGroupExample = new PropertyGroupExample();
            propertyGroupExample.createCriteria().andGroupKeyEqualTo(propertyGroup.getGroupKey())
                    .andDelFlagEqualTo(0);
            List<PropertyGroup> propertyGroupList = propertyGroupMapper.selectByExample(propertyGroupExample);
            if(propertyGroupList.size() > 0){
                message.setMessage("属性组key已经重复");
                return message;
            }
            propertyGroup.setGid(UUID.randomUUID().toString());
            Integer success = propertyGroupMapper.insertSelective(propertyGroup);
            if(success ==1){
                message.setSuccess(true);
            }

        }else{
            //更新
            //先验证key不能重复
            PropertyGroupExample propertyGroupExample = new PropertyGroupExample();
            propertyGroupExample.createCriteria().andGroupKeyEqualTo(propertyGroup.getGroupKey())
                    .andGidNotEqualTo(propertyGroup.getGid()).andDelFlagEqualTo(0);
            List<PropertyGroup> propertyGroupList = propertyGroupMapper.selectByExample(propertyGroupExample);
            if(propertyGroupList.size() > 0){
                message.setMessage("属性key已经重复");
                return message;
            }
            Integer success = propertyGroupMapper.updateByPrimaryKeySelective(propertyGroup);
            if(success ==1){
                message.setSuccess(true);
            }
        }
        return message;
    }


    @Override
    public Message setPropertyRedis() {
        Message message = new Message();
        try {
            PropertyGroupExample propertyGroupExample = new PropertyGroupExample();
            propertyGroupExample.createCriteria().andDelFlagEqualTo(0);
            List<PropertyGroup> propertyGroupList = propertyGroupMapper.selectByExample(propertyGroupExample);
            if(propertyGroupList.size() > 0){
                PropertyExample propertyExample = new PropertyExample();
                propertyExample.setOrderByClause(" seq_no desc");
                PropertyExample.Criteria cr = propertyExample.createCriteria();
                List<Property> propertyList = new ArrayList<>();
                for (Iterator<PropertyGroup> iterator = propertyGroupList.iterator(); iterator.hasNext(); ) {
                    PropertyGroup propertyGroup = iterator.next();
                    cr = propertyExample.createCriteria();
                    cr.andDelFlagEqualTo(0);
                    cr.andGroupKeyEqualTo(propertyGroup.getGroupKey());
                    propertyList = propertyMapper.selectByExample(propertyExample);
                    //放置于redis
                    redisService.set(propertyGroup.getGroupKey(),propertyList);
                }
            }
            message.setSuccess(true);
            message.setMessage("正在执行！");
        } catch (Exception e) {
            e.printStackTrace();
            message.setSuccess(false);
            message.setMessage("发现错误！");
        }

        return message;
    }
}
