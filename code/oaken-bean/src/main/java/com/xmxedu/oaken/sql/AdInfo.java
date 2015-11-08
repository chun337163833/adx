package com.xmxedu.oaken.sql;

/**
 * 广告位信息，广告位名称和对外展示的id，数据库表中的类模型
 * @version 1.0.0
 */
public class AdInfo {
    // 广告位名称
    private String name;
    // 广告位对外展示的唯一标示id
    private String showId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }
}
