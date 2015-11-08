package com.xmxedu.oaken.sql;

/**
 * 银行或者第三方支付平台的支付信息，因为是线下的支付确认后发送即可
 * @version 1.0.0
 */
public class PaymentPlatform {
    //数据库自增id
    private int id;
    // 支付平台名称，支付宝，银行卡
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
