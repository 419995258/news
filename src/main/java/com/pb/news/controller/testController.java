package com.pb.news.controller;


import com.alibaba.fastjson.JSONObject;
import com.pb.news.annotation.RequestJson;
import com.pb.news.dao.NewsMapper;
import com.pb.news.entity.News;
import com.pb.news.entity.vo.Message;
import com.pb.news.services.vo.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  //代表controller
@RequestMapping("/testC")
public class testController {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private RedisService redisService;


    @PostMapping("/index")
    public Message index() {
        Message message = new Message();
       /* Student student = new Student();
        student.setName("a");
        student.setAge(11);
        studentMapper.insertSelective(student);
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andAgeIsNull();
        List<Student> list = studentMapper.selectByExample(studentExample);
        message.setSuccess(true);
        message.setMessage(String.valueOf(list.size()));*/
        News news = new News();
        news.setHref("1");
        newsMapper.insertSelective(news);

        return message;
    }

    @RequestMapping("/get")
    public String get(){

        return  "1";
    }

    @RequestMapping(value = "/getAjax", method = RequestMethod.POST)
    @ResponseBody
    public void getAjax(@RequestBody News news, @RequestParam(value = "a", required = false) String a) {
        System.out.println("ok");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestParam(value = "name", required = false) String name, String pwd) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("ok");
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ResponseBody
    public void login2(@RequestBody JSONObject jsonObject) {
        System.out.println("ok");
    }

    @RequestMapping(value = "/login3", method = RequestMethod.POST)
    public void login3(@RequestJson(value = "name") String name, @RequestJson(value = "pwd") String pwd) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("ok");
    }

    @RequestMapping(value = "/testRedis", method = RequestMethod.POST)
    @ResponseBody
    public void testRedis() {
        String testRedis = "testRedis";
        Integer testRedis2 = 2;
        redisService.setStr("testRedis", testRedis);
        System.out.println(redisService.getStr(testRedis));
        redisService.setObj(testRedis2, testRedis2);
        System.out.println(redisService.getObj(testRedis2));
    }


}
