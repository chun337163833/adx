package com.xmxedu.oaken.sql;

/**
 * 媒体广告位和展示类型映射表，一个广告位是banner，还是全插屏的
 * @version 1.0.0
 */
public class BizAdShowType {
    // 数据库自增id
    private int id;
    // 媒体广告位id
    private int adId;
    // 展示类型对应的id
    private int showTypeId;
    // 是否被删除
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getShowTypeId() {
        return showTypeId;
    }

    public void setShowTypeId(int showTypeId) {
        this.showTypeId = showTypeId;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
