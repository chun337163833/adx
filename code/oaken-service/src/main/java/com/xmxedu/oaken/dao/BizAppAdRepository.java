package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.BizAppAd;

/**
 * 媒体广告位映射关系表
 * @version 1.0.0
 */
public interface BizAppAdRepository {
    public BizAppAd getBizAppAdById(int id);
    public BizAppAd getBizAppAdByAppId(int appId);
    public BizAppAd getBizAppAdByAdId(int adid);
    public BizAppAd getBizAppAdByStatus(int status);
}
