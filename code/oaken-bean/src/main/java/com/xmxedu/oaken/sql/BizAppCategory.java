package com.xmxedu.oaken.sql;

/**
 * 媒体分类映射表，一个媒体所属的分类
 * @version 1.0.0
 */
public class BizAppCategory {
    // 数据库自增id
    private int id;
    // 媒体id
    private int appId;
    // 分类id
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
