package com.xmxedu.oaken.sql;

/**
 * 第三方平台支付信息
 * @version 1.0.0
 */
public class UserPaymentPlatform {

    public final static String TABLE_NAME = " `adx`.`tb_user_paymentplatform` ";
    public final static String ALL_COLUMN_NAME = " `id`,`paymentplatformid`,`paymentplatformaccount` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_PAYMENT_PLATFORM_ID = "paymentplatformid";
    public final static String COLUMN_PAYMENT_PLATFORM_ACCOUNT = "paymentplatformaccount";

    // 数据库自增id
    private int id;
    // 第三方平台支付id
    private int paymentPlatformId;
    // 第三方平台账号
    private String paymentPlatformAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentPlatformId() {
        return paymentPlatformId;
    }

    public void setPaymentPlatformId(int paymentPlatformId) {
        this.paymentPlatformId = paymentPlatformId;
    }

    public String getPaymentPlatformAccount() {
        return paymentPlatformAccount;
    }

    public void setPaymentPlatformAccount(String paymentPlatformAccount) {
        this.paymentPlatformAccount = paymentPlatformAccount;
    }
}
