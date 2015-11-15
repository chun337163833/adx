package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.BizUserAppDAL;
import com.xmxedu.oaken.sql.BizUserApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户媒体映射表
 * @version 1.0.0
 */
@Service
public class BizUserAppBLL {
    private final static Logger logger = LoggerFactory.getLogger(BizUserAppBLL.class);

    @Autowired
    private BizUserAppDAL bizUserAppDAL;

    public BizUserApp getBizUserAppById(int id){
        if (id < 0){
            logger.error("invalid id, its value: {} is below zero!");
            return null;
        }

        BizUserApp bizUserApp = this.bizUserAppDAL.getBizUserAppByWhereClause(BizUserApp.COLUMN_ID,String.valueOf(id));
        return bizUserApp;
    }

    public BizUserApp getBizUserAppByUserId(int userId){
        if (userId < 0){
            logger.error("invalid userid, its value: {} is below zero!",userId);
            return null;
        }

        BizUserApp bizUserApp = this.bizUserAppDAL.getBizUserAppByWhereClause(BizUserApp.COLUMN_USER_ID,String.valueOf(userId));
        return bizUserApp;
    }

    public BizUserApp getBizUserAppByAppId(int appId){
        if (appId < 0){
            logger.error("invalid appid, its value: {} is below zero!",appId);
            return null;
        }

        BizUserApp bizUserApp = this.bizUserAppDAL.getBizUserAppByWhereClause(BizUserApp.COLUMN_APP_ID,String.valueOf(appId));
        return bizUserApp;
    }
}
