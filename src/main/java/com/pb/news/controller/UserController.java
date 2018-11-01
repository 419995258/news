package com.pb.news.controller;


import com.alibaba.fastjson.JSONObject;
import com.pb.news.entity.User;
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
import java.util.List;

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
    private RedisService redisService;





    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户进行shiro登录")
    //@ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string"),
            @ApiImplicitParam(paramType = "query",name= "password" ,value = "密码",dataType = "string")
    })
    /*public  void userLogin(@RequestParam(value = "username" , required = false) String username,
                           @RequestParam(value = "password" , required = false) String password)*/
    public  void userLogin(@RequestBody JSONObject json){
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



}
