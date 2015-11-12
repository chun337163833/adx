package com.xmxedu.oaken.sql;

/**
 * 媒体分类信息，一个媒体所属的分类，类似于体育竞技，理财投资，社交美食
 * @version 1.0.0
 */
public class AppCategory {

    public final static String TABLE_NAME = " `adx`.`tb_app_category` ";
    public final static String ALL_COLUMN_NAME = " `id`,`name` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_NAME = "name";

    //数据库自增id
    private int id;
    //媒体分类名称
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
