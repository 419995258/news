package com.pb.news.controller;


import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.vo.Message;
import com.pb.news.services.AdminService;
import com.pb.news.services.vo.RedisService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiImplicitParam(paramType = "query",name= "id" ,value = "属性组id",dataType = "string")
    public Message queryProperty(@RequestParam(value = "id" , required = true) String id){
        Message message = new Message();
        if(StringUtils.isNoneBlank(id)){

            List<Property> propertyList = adminService.selectPropertyByPropertyGroupId(id);
            message.setSuccess(true);
            message.setObj(propertyList);

        }else{
            message.setMessage("id不能为空");
        }
        return message;

    }

}
