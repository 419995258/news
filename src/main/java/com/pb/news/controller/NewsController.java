package com.pb.news.controller;


import com.alibaba.fastjson.JSONObject;
import com.pb.news.annotation.RequestJson;
import com.pb.news.config.JedisConfig;
import com.pb.news.entity.News;
import com.pb.news.entity.vo.Message;
import com.pb.news.entity.vo.ResultVo;
import com.pb.news.services.NewsService;
import com.pb.news.services.vo.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController  //代表controller
@RequestMapping("/newsC")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private JedisConfig jedisConfig;


    /**
     * 保存上传文件
     * @Description: TODO
     * @param    
     * @return 
     * @throws
     * @author pengbin <pengbin>
     * 2018/5/30 15:40
     */
    @ResponseBody
    @RequestMapping(value = "/uploadTemp", method = RequestMethod.POST)
    public Map<String, Object> uploadTemp(@RequestParam(value = "imgs") MultipartFile[] file) throws Exception {
        Map dataMap = new HashMap();
        // Integer orgId = (Integer) session.getAttribute("currentOrgId");
        Message m = newsService.saveTempFiles(file);

        dataMap.put("success", m.getSuccess());
        if (m.getSuccess()) {
            dataMap.put("fileId", m.getResult().get("fileId"));
            dataMap.put("fileUrl", m.getResult().get("fileUrl"));
        }
        return dataMap;
    }


    @RequestMapping("/index")
    public Message index(){
        Message message = new Message();
        System.out.println(jedisConfig);
       /* Student student = new Student();
        student.setName("a");
        student.setAge(11);
        studentMapper.insertSelective(student);
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andAgeIsNull();
        List<Student> list = studentMapper.selectByExample(studentExample);
        message.setSuccess(true);
        message.setMessage(String.valueOf(list.size()));*/
        return message;
    }

    /*@RequestMapping("/get")
    public Student getStudent(Integer id){
        Student student = new Student();
        student = studentMapper.selectByPrimaryKey(id);

        return  student;
    }*/

    @RequestMapping(value="/getAjax",method = RequestMethod.POST)
    @ResponseBody
    public void getAjax(@RequestBody News news, @RequestParam(value = "a",required = false) String a){
        System.out.println("ok");
    }




    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public  void login(@RequestParam(value = "name" , required = false) String name,String pwd){
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("ok");
    }

    @RequestMapping(value="/login2",method = RequestMethod.POST)
    @ResponseBody
    public  void login2(@RequestBody JSONObject jsonObject){
        System.out.println("ok");
    }

    @RequestMapping(value="/login3",method = RequestMethod.POST)
    public  void login3(@RequestJson(value = "name") String name,@RequestJson(value = "pwd") String pwd){
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("ok");
    }

    @RequestMapping(value="/testRedis",method = RequestMethod.POST)
    @ResponseBody
    public  void testRedis(){
        String testRedis = "testRedis";
        Integer testRedis2 = 2;
        redisService.setStr("testRedis",testRedis);
        System.out.println(redisService.getStr(testRedis));
        redisService.setObj(testRedis2,testRedis2);
        System.out.println(redisService.getObj(testRedis2));
    }


    /**
     * 查询数据
     * @Description: TODO
     * @param    
     * @return 
     * @throws
     * @author pengbin <pengbin>
     * 2018/5/30 16:19
     */
    @RequestMapping(value="/getNews",method = RequestMethod.POST)
    public ResultVo getNews(@RequestBody JSONObject json) throws Exception{
        System.out.println(json);
        System.out.println(json.get("a"));

        ResultVo resultVo = new ResultVo();
        resultVo.setPageSize(json.get("pageSize")+"");
        resultVo.setPageNum(json.get("pageNum")+"");
        resultVo.setOther(json.get("query"));
        resultVo = newsService.queryNews(resultVo);

        return resultVo;
    }


    /**
     * 新增数据
     * @Description: TODO
     * @param    
     * @return 
     * @throws
     * @author pengbin <pengbin>
     * 2018/5/30 16:19
     */
    @RequestMapping(value="/saveNews",method = RequestMethod.POST)
    public Message saveNews(@RequestBody News news) throws Exception{

        Message message = new Message();
        message = newsService.saveNews(news);
        return message;
    }


    /**
     * 删除数据
     * @Description: TODO
     * @param    
     * @return 
     * @throws
     * @author pengbin <pengbin>
     * 2018/5/30 16:19
     */
    @RequestMapping(value="/delNews",method = RequestMethod.POST)
    public Message delNews(@RequestBody News news) throws Exception{

        Message message = new Message();
        message = newsService.delNews(news);
        return message;
    }


}
