package com.pb.news.entity;

import java.io.Serializable;

public class PropertyGroup implements Serializable {
    /* gid*/
    private String gid;

    /* 属性组编码（如：001，001001）*/
    private String groupCode;

    /* 属性组Key（如：teach.subject）*/
    private String groupKey;

    /* 属性组名称*/
    private String groupName;

    /* 父节点代码(根节点：-1)*/
    private String parCode;

    /* 排序*/
    private Integer seqNo;

    /* 创建人*/
    private String creUser;

    /* 创建时间*/
    private String creTime;

    /* 修改人*/
    private String modUser;

    /* 修改时间*/
    private String modTime;

    /* 是否删除：1：删除*/
    private Integer delFlag;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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