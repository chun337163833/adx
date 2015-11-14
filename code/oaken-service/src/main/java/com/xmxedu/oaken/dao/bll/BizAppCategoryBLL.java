package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.BizAppCategoryDAL;
import com.xmxedu.oaken.sql.BizAppCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 媒体分类的映射关系操作表，业务逻辑层
 * @version 1.0.0
 */
@Service
public class BizAppCategoryBLL {
    private final static Logger logger = LoggerFactory.getLogger(BizAppCategoryBLL.class);

    @Autowired
    private BizAppCategoryDAL bizAppCategoryDAL;

    public BizAppCategory getBizAppCategoryById(int id){
        if (id < 0){
            logger.error("invalid id, id value : {} can not below zero", id);
            return null;
        }

        BizAppCategory bizAppCategory = this.bizAppCategoryDAL.getBizAppCategoryByWhereClause("id",String.valueOf(id));
        return bizAppCategory;
    }

    public BizAppCategory getBizAppCategoryByAppId(int appId){
        if (appId < 0){
            logger.error("invalid appid, appId value: {} can not below zero",appId);
            return null;
        }

        BizAppCategory bizAppCategory = this.bizAppCategoryDAL.getBizAppCategoryByWhereClause("appid",String.valueOf(appId));
        return bizAppCategory;
    }

    public BizAppCategory getBizAppCategoryByCategoryId(int categoryId){
        if (categoryId < 0){
            logger.error("invalid categoryId, categoryId value: {}",categoryId);
            return null;
        }

        BizAppCategory bizAppCategory = this.bizAppCategoryDAL.getBizAppCategoryByWhereClause("categoryid",String.valueOf(categoryId));
        return bizAppCategory;
    }
}
