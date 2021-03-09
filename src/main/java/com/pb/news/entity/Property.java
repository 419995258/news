package com.pb.news.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "com.pb.news.entity.Property")
public class Property implements Serializable {
    /* gid*/
    @ApiModelProperty(value = "gid")
    private String gid;

    /* 属性Key（如：teach.subject）*/
    @ApiModelProperty(value = "属性Key（如：teach.subject）")
    private String propertyKey;

    /* 属性值*/
    @ApiModelProperty(value = "属性值")
    private String propertyValue;

    /* 属性描述*/
    @ApiModelProperty(value = "属性描述")
    private String propertyDesc;

    /* 属性组*/
    @ApiModelProperty(value = "属性组")
    private String groupKey;

    /* 父节点代码(根节点：-1)*/
    @ApiModelProperty(value = "父节点代码(根节点：-1)")
    private String parCode;

    /* 排序*/
    @ApiModelProperty(value = "排序")
    private Integer seqNo;

    /* 其他属性1*/
    @ApiModelProperty(value = "其他属性1")
    private String extra1;

    /* 其他属性2*/
    @ApiModelProperty(value = "其他属性2")
    private String extra2;

    /* 其他属性3*/
    @ApiModelProperty(value = "其他属性3")
    private String extra3;

    /* 其他属性4*/
    @ApiModelProperty(value = "其他属性4")
    private String extra4;

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

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getParCode() {
        return parCode;
    }

    public void setParCode(String parCode) {
        this.parCode = parCode;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

    public String getExtra4() {
        return extra4;
    }

    public void setExtra4(String extra4) {
        this.extra4 = extra4;
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