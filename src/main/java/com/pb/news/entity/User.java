package com.pb.news.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.pb.news.entity.User")
public class User implements Serializable {
    /* */
    @ApiModelProperty(value="")
    private Integer id;

    /* 用户名*/
    @ApiModelProperty(value="用户名")
    private String username;

    /* 密码*/
    @ApiModelProperty(value="密码")
    private String password;

    /* 家庭住址*/
    @ApiModelProperty(value="家庭住址")
    private String address;

    /* 手机号*/
    @ApiModelProperty(value="手机号")
    private String tel;

    /* 昵称*/
    @ApiModelProperty(value="昵称")
    private String name;

    /* 注册时间*/
    @ApiModelProperty(value="注册时间")
    private Date register;

    /* 订单总金额*/
    @ApiModelProperty(value="订单总金额")
    private Integer money;

    /* 1:普通用户 2：管理员*/
    @ApiModelProperty(value="1:普通用户 2：管理员")
    private Integer type;

    /* 创建人*/
    @ApiModelProperty(value="创建人")
    private String creUser;

    /* 创建时间*/
    @ApiModelProperty(value="创建时间")
    private String creTime;

    /* 修改人*/
    @ApiModelProperty(value="修改人")
    private String modUser;

    /* 修改时间*/
    @ApiModelProperty(value="修改时间")
    private String modTime;

    /* 是否删除：1：删除*/
    @ApiModelProperty(value="是否删除：1：删除")
    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreUser() {
        return creUser;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime;
    }

    public String getModUser() {
        return modUser;
    }

    public void setModUser(String modUser) {
        this.modUser = modUser;
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}