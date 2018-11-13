package com.pb.news.controller;


import com.alibaba.fastjson.JSONObject;
import com.pb.news.entity.User;
import com.pb.news.entity.vo.Message;
import com.pb.news.services.RoleService;
import com.pb.news.services.UserService;
import com.pb.news.services.vo.RedisService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController  //代表controller
@RequestMapping("/userC")
@Api(value = "用户的处理")
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisService redisService;




    @RequestMapping(value="/userLoginShiro",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户进行shiro登录")
    //@ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string"),
            @ApiImplicitParam(paramType = "query",name= "password" ,value = "密码",dataType = "string")
    })
    /*public  void userLogin(@RequestParam(value = "username" , required = false) String username,
                           @RequestParam(value = "password" , required = false) String password)*/
    public  void userLoginShiro(@RequestBody JSONObject json){
        System.out.println("ok");
        User user = new User();
        user.setUsername(json.getString("username"));
        user.setPassword(json.getString("password"));
        List<User> userList = new ArrayList<>();
        userList = userService.getUserList(user);
        if(userList.size() == 1){
            user = userList.get(0);
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // Boolean rememberMe = true;   //是否记住
        token.setRememberMe(true);

        try {
            subject.login(token);
            Object name = SecurityUtils.getSubject().getPrincipals();
            System.out.println(name);

            if(subject.hasRole("admin")){
                System.out.println("11111");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
//            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
        }





    }



    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户进行登录")
    //@ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string"),
            @ApiImplicitParam(paramType = "query",name= "password" ,value = "密码",dataType = "string")
    })
    /*public  void userLogin(@RequestParam(value = "username" , required = false) String username,
                           @RequestParam(value = "password" , required = false) String password)*/
    public Message userLogin(@RequestBody JSONObject json,HttpServletRequest request){
        Message message = new Message();

        User user = new User();
        user.setUsername(json.getString("username"));
        user.setPassword(json.getString("password"));
        List<User> userList = new ArrayList<>();
        userList = userService.getUserList(user);
        if(userList.size() == 1){
            user = userList.get(0);
            message.setSuccess(true);
            message.setMessage("登录成功");

            //保存session
            String token = UUID.randomUUID().toString();
            request.getSession().setAttribute(token,user);
            request.getSession().setAttribute("username",user.getUsername());
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            message.setResult(map);


            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken shiroToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            // Boolean rememberMe = true;   //是否记住
            shiroToken.setRememberMe(true);

            try {
                subject.login(shiroToken);
               // Object name = SecurityUtils.getSubject().getPrincipals();
               // System.out.println(name);
                // 获取role,并且存储session
                List<Map<String,Object>> roleList = new ArrayList<>();
                roleList = roleService.getRolesByUser(user.getId());
                request.getSession().setAttribute("roleList",roleList);

            } catch (AuthenticationException e) {
                e.printStackTrace();
//            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
            }

        }else{
            message.setMessage("账号或密码错误！");
        }



        return message;

    }


    @RequestMapping(value="/validateUserLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证用户登录")
    @ApiImplicitParam(paramType = "query",name= "token" ,value = "token",dataType = "string")
    public Message validateUserLogin(@RequestParam(value = "token" , required = true)String token,HttpServletRequest request){
        Message message = new Message();
        if(!"first".equals(token)){
            Object user = request.getSession().getAttribute(token);
            if(user != null){
                message.setSuccess(true);
            }else{
                message.setSuccess(false);
            }
        }else{
            message.setSuccess(true);
        }

        return message;

    }



}
