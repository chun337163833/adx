package com.xmxedu.oaken.sql;

/**
 * 媒体所属的系统:android,iOS,winphone
 * @version 1.0.0
 */
public class AppOS {
    // 数据库自增id
    private int id;
    // 媒体系统
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
