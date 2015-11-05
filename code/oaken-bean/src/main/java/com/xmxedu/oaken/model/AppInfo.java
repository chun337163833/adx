package com.xmxedu.oaken.model;


/**
 * 媒体信息，包括所属用户和分类，此类需要经过数据库加载后进行使用
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public class AppInfo {
    //  自增id
    private int id;

    // app的名称
    private String name;

    // app的对外展示的id
    private String showId;

    // 外键对应媒体的操作系统Android，iOS
    private int osTypeId;

    // 外键对应媒体的具体分类，如理财投资，角色游戏
    private int categoryId;

    // app对应的包名称,如com.hdcp.shipu
    private String pkgn;

    // app的简介说明，这个媒体是干嘛的
    private String note;

    // app的具体上传包
    private byte[] content;

    // app的审核状态
    private int status;

    // app的审核信息，不符合的因素
    private String checkInfo;

    // app的创建时间
    private long createTime;

    // app的审核时间
    private long checkTime;

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

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public int getOsTypeId() {
        return osTypeId;
    }

    public void setOsTypeId(int osTypeId) {
        this.osTypeId = osTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPkgn() {
        return pkgn;
    }

    public void setPkgn(String pkgn) {
        this.pkgn = pkgn;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(String checkInfo) {
        this.checkInfo = checkInfo;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(long checkTime) {
        this.checkTime = checkTime;
    }
}
