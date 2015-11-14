package com.xmxedu.oaken.sql;

/**
 * 媒体分类映射表，一个媒体所属的分类
 * @version 1.0.0
 */
public class BizAppCategory {

    public final static String TABLE_NAME = " `adx`.`tb_biz_app_category` ";
    public final static String ALL_COLUMN_NAME = " `id`,`appid`,`categoryid`,`status` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_APP_ID = "appid";
    public final static String COLUMN_CATEGORY_ID = "categoryid";
    public final static String COLUMN_STATUS = "status";

    // 数据库自增id
    private int id;
    // 媒体id
    private int appId;
    // 分类id
    private int categoryId;
    // 伪删除
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
