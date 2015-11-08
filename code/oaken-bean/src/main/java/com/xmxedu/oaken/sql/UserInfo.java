package com.xmxedu.oaken.sql;

/**
 * 用户相关信息，媒体用户的所有者的相关信息
 * @version 1.0.0
 */
public class UserInfo {
    // 数据库自增id
    private int id;
    // 用户昵称
    private String nickName;
    // 用户密码
    private String password;
    // 状态
    private int status;
    // 真实名称
    private String realName;
    // 电话号码
    private String phone;
    // QQ号码
    private String qq;
    // 身份证号码
    private String identityAccount;
    // 身份证正反面图片
    private byte[] identityPicture;
    // 注册时间
    private long registerTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getIdentityAccount() {
        return identityAccount;
    }

    public void setIdentityAccount(String identityAccount) {
        this.identityAccount = identityAccount;
    }

    public byte[] getIdentityPicture() {
        return identityPicture;
    }

    public void setIdentityPicture(byte[] identityPicture) {
        this.identityPicture = identityPicture;
    }

    public long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(long registerTime) {
        this.registerTime = registerTime;
    }
}
