package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.BizAppRelationshipDAL;
import com.xmxedu.oaken.sql.BizAppRelationShip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 自家平台与第三方平台关系映射DAO操作
 * @version 1.0.0
 */
@Service
public class BizAppRelationShipBLL {

    private final static Logger logger = LoggerFactory.getLogger(BizAppRelationShipBLL.class);

    @Autowired
    private BizAppRelationshipDAL bizAppRelationshipDAL;

    public BizAppRelationShip getBizAppRelationShipById(int id){
        if (id < 0){
            logger.error("invalid id, the value of it: {} is below zero!",id);
            return null;
        }

        BizAppRelationShip bizAppRelationShip = this.bizAppRelationshipDAL.getBizAppRelationShipByWhereClause("id",String.valueOf(id));
        return bizAppRelationShip;
    }

    public BizAppRelationShip getBizAppRelationShipByOurAd(int ourAd){
        if (ourAd < 0){
            logger.error("invalid id, the value of it: {} is below zero!",ourAd);
            return null;
        }

        BizAppRelationShip bizAppRelationShip = this.bizAppRelationshipDAL.getBizAppRelationShipByWhereClause(BizAppRelationShip.COLUMN_OUR_AD,String.valueOf(ourAd));
        return bizAppRelationShip;
    }

    public BizAppRelationShip getBizAppRelationShipByThirdPartyAd(int thirdPartyAd){
        if (thirdPartyAd < 0){
            logger.error("invalid thirdpartyad, the value of thirdpartyad: {} is below zero!",thirdPartyAd);
            return null;
        }

        BizAppRelationShip bizAppRelationShip = this.bizAppRelationshipDAL.getBizAppRelationShipByWhereClause(BizAppRelationShip.COLUMN_OTHERPLATFORM_AD,String.valueOf(thirdPartyAd));
        return bizAppRelationShip;
    }
}
