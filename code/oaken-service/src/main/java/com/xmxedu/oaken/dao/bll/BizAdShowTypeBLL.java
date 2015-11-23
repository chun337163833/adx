package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.BizAdShowTypeDAL;
import com.xmxedu.oaken.sql.BizAdShowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 媒体广告展示类型映射表
 * @version 1.0.0
 */
@Service
public class BizAdShowTypeBLL {
    private final static Logger logger = LoggerFactory.getLogger(BizAdShowTypeBLL.class);

    @Autowired
    private BizAdShowTypeDAL bizAdShowTypeDAL;

    public BizAdShowType getBizAdShowTypeById(int id){
        if (id < 0){
            logger.error("invalid id, id cannot below zero!");
            return null;
        }

        BizAdShowType bizAdShowType = this.bizAdShowTypeDAL.getBizAdShowTypeByWhereClause(BizAdShowType.COLUMN_ID,String.valueOf(id));
        return bizAdShowType;
    }

    public BizAdShowType getBizAdShowTypeByAdId(int adId){
        if (adId < 0){
            logger.error("invalid adId, adId cannot below zero!");
            return null;
        }

        BizAdShowType bizAdShowType = this.bizAdShowTypeDAL.getBizAdShowTypeByWhereClause(BizAdShowType.COLUMN_ID,String.valueOf(adId));
        return bizAdShowType;
    }

    public BizAdShowType getBizAdShowTypeByShowTypeId(int ShowTypeId){
        if (ShowTypeId < 0){
            logger.error("invalid ShowTypeId, ShowTypeId cannot below zero!");
            return null;
        }

        BizAdShowType bizAdShowType = this.bizAdShowTypeDAL.getBizAdShowTypeByWhereClause(BizAdShowType.COLUMN_ID,String.valueOf(ShowTypeId));
        return bizAdShowType;
    }
}
