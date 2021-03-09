package com.pb.news.controller;


import com.alibaba.fastjson.JSONObject;
import com.pb.news.entity.Property;
import com.pb.news.entity.PropertyGroup;
import com.pb.news.entity.vo.Message;
import com.pb.news.services.AdminService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.servlet.ShiroRealm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * @param
     * @return
     * @throws
     * @Description: TODO 查询项目属性组
     * @author pengbin <pengbin> 2018/11/6 14:48
     */
    @RequestMapping(value = "/queryPropertyGroup", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查询项目属性组")
    //@ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string")
    /*@ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string"),
            @ApiImplicitParam(paramType = "query",name= "password" ,value = "密码",dataType = "string")
    })*/
    /*public  void userLogin(@RequestParam(value = "username" , required = false) String username,
                           @RequestParam(value = "password" , required = false) String password)*/
    public Message queryPropertyGroup() {
        Message message = new Message();
        List<PropertyGroup> propertyGroupList = adminService.selectAllPropertyGroup();
        message.setSuccess(true);
        message.setObj(propertyGroupList);
        return message;

    }


    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 通过属性组id查询属性
     * @author pengbin <pengbin> 2018/11/6 14:51
     */
    @RequestMapping(value = "/queryProperty", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查询属性")
    @ApiImplicitParam(paramType = "query", name = "groupKey", value = "属性组groupKey", dataType = "string")
    public Message queryProperty(@RequestParam(value = "groupKey", required = true) String groupKey) {
        Message message = new Message();
        if (StringUtils.isNoneBlank(groupKey)) {

            List<Property> propertyList = adminService.selectPropertyByPropertyGroupId(groupKey);
            message.setSuccess(true);
            message.setObj(propertyList);

        } else {
            message.setMessage("groupKey不能为空");
        }
        return message;

    }

    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 通过属性id删除某个属性（dle_flag = 1）
     * @author pengbin <pengbin> 2018/11/7 10:50
     */
    @RequestMapping(value = "/delProperty", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除属性")
    @ApiImplicitParam(paramType = "query", name = "gid", value = "属性id", dataType = "string")
    public Message delProperty(@RequestParam(value = "gid", required = true) String gid) {
        Message message = new Message();
        if (StringUtils.isNoneBlank(gid)) {

            Integer success = adminService.delPropertyById(gid);
            if (success == 1) {
                message.setSuccess(true);
            } else {
                message.setMessage("删除失败");
            }

        } else {
            message.setMessage("id不能为空");
        }
        return message;

    }


    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 添加或修改属性
     * @author pengbin <pengbin> 2018/11/7 17:39
     */
    @RequestMapping(value = "/addorUpdateProperty", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加或修改属性")
    public Message addorUpdateProperty(@RequestBody Property property) {
        Message message = new Message();
        message = adminService.addorUpdateProperty(property);
        return message;

    }


    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 删除属性组
     * @author pengbin <pengbin> 2018/11/7 17:40
     */
    @RequestMapping(value = "/delPropertyGroup", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除属性组")
    public Message delPropertyGroup(@RequestBody PropertyGroup PropertyGroup) {
        Message message = new Message();
        message = adminService.delPropertyGroup(PropertyGroup);
        return message;

    }


    /**
     * @param
     * @return
     * @throws
     * @Description: TODO 添加或修改属性组
     * @author pengbin <pengbin> 2018/11/7 17:39
     */
    @RequestMapping(value = "/addorUpdatePropertyGroup", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加或修改属性组")
    public Message addorUpdatePropertyGroup(@RequestBody PropertyGroup propertyGroup) {
        Message message = new Message();
        message = adminService.addorUpdatePropertyGroup(propertyGroup);
        return message;

    }


    @RequestMapping(value = "/setPropertyRedis", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "重置属性的redis缓存")
    public Message setPropertyRedis() {
        Message message = new Message();
        message = adminService.setPropertyRedis();
        return message;

    }

    @RequestMapping(value = "/testShiroP3", method = RequestMethod.POST)
    @RequiresPermissions("p3")
    @ResponseBody
    @ApiOperation(value = "测试shiro")
    public void testShiroP3() {
        System.out.println("p3");
    }

    @RequestMapping(value = "/testShiroP1", method = RequestMethod.POST)
    @RequiresPermissions("p1")
    @ResponseBody
    @ApiOperation(value = "测试shirotestShiroP1")
    public void testShiroP1() {
        System.out.println("p1");
    }


    @RequestMapping(value = "/clearShiro", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "测试clearShiro")
    public void clearShiro() {
        Subject subject = SecurityUtils.getSubject();
        RealmSecurityManager securityManager =
                (RealmSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //删除登陆人
        shiroRealm.getAuthorizationCache().remove(subject.getPrincipal());
        //删除登陆人对应的缓存
        shiroRealm.getAuthorizationCache().remove(subject.getPrincipals());
        //重新加载subject
        subject.releaseRunAs();
    }


    /**
     * 权限异常
     */
//    配置权限异常返回json，否则跳转至在shiro.xml配置的路径
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    public void authorizationException(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(SecurityUtils.getSubject().getPrincipal());
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg", "没有权限");
            out.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
