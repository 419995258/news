package com.pb.news.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "com.pb.news.entity.Permission")
public class Permission implements Serializable {
    /* */
    @ApiModelProperty(value = "")
    private Integer id;

    /* 权限名*/
    @ApiModelProperty(value = "权限名")
    private String name;

    /* 权限地址*/
    @ApiModelProperty(value = "权限地址")
    private String url;

    /* 描述*/
    @ApiModelProperty(value = "描述")
    private String desc;

    /* 创建人*/
    @ApiModelProperty(value = "创建人")
    private String creUser;

    /* 创建时间*/
    @ApiModelProperty(value = "创建时间")
    private String creTime;

    /* 修改人*/
    @ApiModelProperty(value = "修改人")
    private String modUser;

    /* 修改时间*/
    @ApiModelProperty(value = "修改时间")
    private String modTime;

    /* 是否删除：1：删除*/
    @ApiModelProperty(value = "是否删除：1：删除")
    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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