package com.xmxedu.oaken.sql;

/**
 * 第三方平台相关信息，请求方式，平台类型等
 */
public class ThirdPlatform {

    public final static String TABLE_NAME = " `adx`.`tb_thirdparty` ";
    public final static String ALL_COLUMN_NAME = " `id`,`name`,`requesttype`,`platformtype`,`requesturl`,`key`,`token` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_REQUEST_TYPE = "requesttype";
    public final static String COLUMN_PLATFORM_TYPE = "platformtype";
    public final static String COLUMN_REQUEST_URL = "requesturl";
    public final static String COLUMN_KEY = "key";
    public final static String COLUMN_TOKEN = "token";

    // 数据库自增id
    private int id;
    // 第三方平台名称
    private String name;
    // 第三方平台请求方式: POST GET
    private int requestType;
    // 第三方平台的平台类型，是ADN还是DSP
    private int platformType;
    // 第三方平台请求的url
    private String requestUrl;
    // 第三方平台的key，非必须
    private String key;
    // 第三方平台的token,非必须
    private String token;

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

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getPlatformType() {
        return platformType;
    }

    public void setPlatformType(int platformType) {
        this.platformType = platformType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
