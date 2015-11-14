package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.BizAppAdDAL;
import com.xmxedu.oaken.sql.BizAppAd;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 媒体广告位映射关系表，主要提供上层的抽象模块，业务逻辑层
 * @version 1.0.0
 */

@Service
public class BizAppAdBLL {

    private final static Logger logger = LoggerFactory.getLogger(BizAppAdBLL.class);

    @Autowired
    private BizAppAdDAL bizAppAdDAL;

    public BizAppAd getBizAppAdById(int id){

        if (id < 0){
            logger.error("invalid id, the value of it: {} can not below zero",id);
            return null;
        }

        BizAppAd bizAppAd = this.bizAppAdDAL.getBizAppAdByWhereClause("id",String.valueOf(id));
        return bizAppAd;
    }

    public BizAppAd getBizAppAdByAppId(String appId){
        if (StringUtils.isBlank(appId)){
            logger.error("empty appId,suck it~");
            return null;
        }

        BizAppAd bizAppAd = this.bizAppAdDAL.getBizAppAdByWhereClause("appid",appId);
        return bizAppAd;
    }

    public BizAppAd getBizAppAdByAdId(int adId){
        if (adId < 0){
            logger.error("invalid adid, the value of it: {} can not below zero",adId);
            return null;
        }

        BizAppAd bizAppAd = this.bizAppAdDAL.getBizAppAdByWhereClause("adid",String.valueOf(adId));
        return bizAppAd;
    }

    public BizAppAd getBizAppAdByStatus(int status){
        if (!(0 == status || 1 == status)){
            logger.error("invalid status,the status must be 0 or 1 and its value is: {}",status);
            return null;
        }

        BizAppAd bizAppAd = this.bizAppAdDAL.getBizAppAdByWhereClause("status",String.valueOf(status));
        return bizAppAd;
    }
}
