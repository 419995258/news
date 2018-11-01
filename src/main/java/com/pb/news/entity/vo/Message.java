package com.pb.news.entity.vo;

import java.util.HashMap;
import java.util.Map;

public class Message {

    private String message;
    private Boolean success =false;
    private Map<String,Object> context;
    private Map result = new HashMap(0); //返回对象

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }


    public Map getResult() {
        return result;
    }

    public void setResult(Map result) {
        this.result = result;
    }
}
