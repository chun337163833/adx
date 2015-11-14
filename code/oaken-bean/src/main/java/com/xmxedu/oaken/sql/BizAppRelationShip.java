package com.xmxedu.oaken.sql;

/**
 * 媒体本身映射，自家媒体跟第三方媒体的映射关系
 * @version 1.0.0
 */
public class BizAppRelationShip {

    public final static String TABLE_NAME = " `adx`.`tb_biz_app_relationship` ";
    public final static String ALL_COLUMN_NAME = " `id`,`ourad`,`otherplatformad`,`requestweight` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_OUR_AD = "ourad";
    public final static String COLUMN_OTHERPLATFORM_AD = "otherplatformad";
    public final static String COLUMN_REQUEST_WEIGHT = "requestweight";

    // 数据库自增id
    private int id;
    // 自家平台的媒体id
    private int ourAdId;
    // 第三方上游平台的id
    private int thirdPlatformId;
    // 第三方平台再我们在家平台的请求权重
    private double requestWeight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOurAdId() {
        return ourAdId;
    }

    public void setOurAdId(int ourAdId) {
        this.ourAdId = ourAdId;
    }

    public int getThirdPlatformId() {
        return thirdPlatformId;
    }

    public void setThirdPlatformId(int thirdPlatformId) {
        this.thirdPlatformId = thirdPlatformId;
    }

    public double getRequestWeight() {
        return requestWeight;
    }

    public void setRequestWeight(double requestWeight) {
        this.requestWeight = requestWeight;
    }
}
