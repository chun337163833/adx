package com.xmxedu.oaken.sql;

import org.springframework.context.annotation.Bean;

/**
 * 广告位形式，分横幅，全插屏，视频，语音等
 * @version 1.0.0
 */
public class AdType {

    public final static String TABLE_NAME = " `adx`.`tb_ad_type` ";
    public final static String ALL_COLUMN_NAME = " `id`,`type` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_TYPE = "type";

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
