package com.byk.visit.boke.entity;

import java.util.Date;

public class Visiter {
    private String id;

    private String visiterIp;

    private Date createTime;

    private Integer delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisiterIp() {
        return visiterIp;
    }

    public void setVisiterIp(String visiterIp) {
        this.visiterIp = visiterIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}