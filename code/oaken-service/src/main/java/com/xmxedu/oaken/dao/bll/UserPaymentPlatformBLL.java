package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.UserPaymentPlatformDAL;
import com.xmxedu.oaken.sql.UserPaymentPlatform;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户支付查询
 * @version 1.0.0
 */
@Service
public class UserPaymentPlatformBLL {
    private final static Logger logger = LoggerFactory.getLogger(UserPaymentPlatformBLL.class);

    @Autowired
    private UserPaymentPlatformDAL userPaymentPlatformDAL;

    public UserPaymentPlatform getUserPaymentPlatformById(int id){
        if (id < 0){
            logger.error("invalid id,suck it~");
            return null;
        }

        UserPaymentPlatform userPaymentPlatform = this.userPaymentPlatformDAL.getUserPaymentPlatformByWhereClause(UserPaymentPlatform.COLUMN_ID,String.valueOf(id));
        return userPaymentPlatform;
    }

    public UserPaymentPlatform getUserPaymentPlatformByPPId(int ppId){
        if (ppId < 0){
            logger.error("invalid payment platform by ppid");
            return null;
        }

        UserPaymentPlatform userPaymentPlatform = this.userPaymentPlatformDAL.getUserPaymentPlatformByWhereClause(UserPaymentPlatform.COLUMN_PAYMENT_PLATFORM_ID,String.valueOf(ppId));
        return null;
    }

    public UserPaymentPlatform getUserPaymentPlatformByPPAccount(String account){
        if (StringUtils.isBlank(account)){
            logger.error("empyt account,suck it");
            return null;
        }

        UserPaymentPlatform userPaymentPlatform = this.userPaymentPlatformDAL.getUserPaymentPlatformByWhereClause(UserPaymentPlatform.COLUMN_PAYMENT_PLATFORM_ACCOUNT,account);
        return userPaymentPlatform;
    }
}
