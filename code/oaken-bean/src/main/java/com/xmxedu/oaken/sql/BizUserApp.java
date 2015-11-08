package com.xmxedu.oaken.sql;

/**
 * 媒体和用户之间的映射表
 * @version 1.0.0
 */
public class BizUserApp {
    // 数据库自增id
    private int id;
    // 用户id
    private int userId;
    // 媒体id
    private int appId;
    // 状态
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
