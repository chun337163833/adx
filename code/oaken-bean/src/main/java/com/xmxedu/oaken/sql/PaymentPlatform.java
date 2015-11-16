package com.xmxedu.oaken.sql;

/**
 * 银行或者第三方支付平台的支付信息，因为是线下的支付确认后发送即可
 * @version 1.0.0
 */
public class PaymentPlatform {

    public final static String TABLE_NAME = " `adx`.`tb_paymentplatform` ";
    public final static String ALL_COLUMN_NAME = " `id`,`paymentplatformname` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_PAYMENT_PLATFORM_NAME = "paymentplatformname";

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
