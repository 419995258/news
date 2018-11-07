package com.pb.news.controller;


import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.vo.Message;
import com.pb.news.services.AdminService;
import com.pb.news.services.vo.RedisService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController  //代表controller
@RequestMapping("/adminC")
@Api(value = "admin的处理")
public class AdminController {


    @Autowired
    private RedisService redisService;

    @Autowired
    private AdminService adminService;





    /**
     *
     * @Description: TODO 查询项目属性组
     * @param
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/6 14:48
     */
    @RequestMapping(value="/queryPropertyGroup",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查询项目属性组")
    //@ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string")
    /*@ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string"),
            @ApiImplicitParam(paramType = "query",name= "password" ,value = "密码",dataType = "string")
    })*/
    /*public  void userLogin(@RequestParam(value = "username" , required = false) String username,
                           @RequestParam(value = "password" , required = false) String password)*/
    public Message queryPropertyGroup(){
        Message message = new Message();
        List<PropertyGroup> propertyGroupList = adminService.selectAllPropertyGroup();
        message.setSuccess(true);
        message.setObj(propertyGroupList);
        return message;

    }


    /**
     *
     * @Description: TODO 通过属性组id查询属性
     * @param
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/6 14:51
     */
    @RequestMapping(value="/queryProperty",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查询属性")
    @ApiImplicitParam(paramType = "query",name= "groupKey" ,value = "属性组groupKey",dataType = "string")
    public Message queryProperty(@RequestParam(value = "groupKey" , required = true) String groupKey){
        Message message = new Message();
        if(StringUtils.isNoneBlank(groupKey)){

            List<Property> propertyList = adminService.selectPropertyByPropertyGroupId(groupKey);
            message.setSuccess(true);
            message.setObj(propertyList);

        }else{
            message.setMessage("groupKey不能为空");
        }
        return message;

    }

    /**
     *
     * @Description: TODO 通过属性id删除某个属性（dle_flag = 1）
     * @param
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/7 10:50
     */
    @RequestMapping(value="/delProperty",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除属性")
    @ApiImplicitParam(paramType = "query",name= "gid" ,value = "属性id",dataType = "string")
    public Message delProperty(@RequestParam(value = "gid" , required = true) String gid){
        Message message = new Message();
        if(StringUtils.isNoneBlank(gid)){

            Integer success = adminService.delPropertyById(gid);
            if(success == 1){
                message.setSuccess(true);
            }else{
                message.setMessage("删除失败");
            }

        }else{
            message.setMessage("id不能为空");
        }
        return message;

    }


    /**
     *
     * @Description: TODO 添加或修改属性
     * @param
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/7 17:39
     */
    @RequestMapping(value="/addorUpdateProperty",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加或修改属性")
    public Message addorUpdateProperty(@RequestBody Property property){
        Message message = new Message();
        message = adminService.addorUpdateProperty(property);
        return message;

    }



    /**
     *
     * @Description: TODO 删除属性组
     * @param
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/7 17:40
     */
    @RequestMapping(value="/delPropertyGroup",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除属性组")
    public Message delPropertyGroup(@RequestBody PropertyGroup PropertyGroup){
        Message message = new Message();
        message = adminService.delPropertyGroup(PropertyGroup);
        return message;

    }


    /**
     *
     * @Description: TODO 添加或修改属性组
     * @param
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/11/7 17:39
     */
    @RequestMapping(value="/addorUpdatePropertyGroup",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加或修改属性组")
    public Message addorUpdatePropertyGroup(@RequestBody PropertyGroup propertyGroup){
        Message message = new Message();
        message = adminService.addorUpdatePropertyGroup(propertyGroup);
        return message;

    }


    @RequestMapping(value="/setPropertyRedis",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "重置属性的redis缓存")
    public Message setPropertyRedis(){
        Message message = new Message();
        message = adminService.setPropertyRedis();
        return message;

    }

}
