package com.xmxedu.oaken.sql;

/**
 * 媒体广告映射表，一个媒体下的所有广告位信息
 * @version 1.0.0
 */
public class BizAppAd {
    //数据库自增id
    private int id;
    //媒体对应的id；
    private int appId;
    //广告位对应的Id
    private int adId;
    //状态信息，是否被删除
    private int status;

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

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
