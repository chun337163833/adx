package com.xmxedu.oaken.sql;

/**
 * 广告位形式，分横幅，全插屏，视频，语音等
 * @version 1.0.0
 */
public class AdType {
    // 数据库自增的id
    private int id;
    // 广告类型名称
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
