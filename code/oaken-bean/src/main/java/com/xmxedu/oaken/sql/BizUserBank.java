package com.xmxedu.oaken.sql;

/**
 * 用户和支付银行映射表
 * @version 1.0.0
 */
public class BizUserBank {

    public final static String TABLE_NAME = " `adx`.`tb_biz_user_bank` ";
    public final static String ALL_COLUMN_NAME = " `id`,`userid`,`paymenway`,`paymentid`,`status` ";

    public final static String COLUMN_ID = "id";
    public final static String COLUMN_USER_ID = "userid";
    public final static String COLUMN_PAYMENT_WAY = "paymentway";
    public final static String COLUMN_PAYMENT_ID = "paymentid";
    public final static String COLUMN_STATUS = "status";

    //数据库自增id
    private int id;
    //用户id
    private int userId;
    //支付方式
    private int paymentWay;
    //支付id
    private int paymentId;
    //伪删除的状态
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(int paymentWay) {
        this.paymentWay = paymentWay;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
