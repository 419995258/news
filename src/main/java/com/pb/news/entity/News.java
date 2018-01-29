package com.pb.news.entity;

import java.io.Serializable;

public class News implements Serializable {
    private static final long serialVersionUID = 1435515995276255188L;

    private Integer id;

    private String title;

    private String href;

    private String source;

    private String creTime;

    private Integer order;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getsource() {
        return source;
    }

    public void setsource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime == null ? null : creTime.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}