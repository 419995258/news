package com.pb.news.services.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;


    /**
     * 根据指定key获取String
     * @param key
     * @return
     */
    public String getStr(String key){
        return valOpsStr.get(key);
    }

    /**
     * 设置Str缓存
     * @param key
     * @param val
     */
    public void setStr(String key, String val){
        valOpsStr.set(key,val);
    }

    /**
     * 删除指定key
     * @param key
     */
    public void delStr(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o){

        return valOpsObj.get(o);
        //return redisTemplate.opsForValue().get(o);
    }

    /**
     * 设置obj缓存
     * @param key
     * @param value
     */
    public void setObj(Object key, Object value){
        valOpsObj.set(key, value);
       // redisTemplate.opsForValue().set(key, value);
    }



    /**
     * 删除Obj缓存
     * @param o
     */
    public void delObj(Object o){
        redisTemplate.delete(o);
    }


    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object get(String str){

        return valOpsObj.get(str);
        //return redisTemplate.opsForValue().get(o);
    }

    /**
     * 设置obj缓存
     * @param key
     * @param value
     */
    public void set(String key, Object value){
        valOpsObj.set(key, value);
        // redisTemplate.opsForValue().set(key, value);
    }



    /**
     * 删除Obj缓存
     * @param o
     */
    public void del(String str){
        redisTemplate.delete(str);
    }

}
