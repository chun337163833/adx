package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.UserBankDAL;
import com.xmxedu.oaken.sql.UserBank;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户银行的相关操作表结构
 * @version 1.0.0
 */
@Service
public class UserBankBLL {
    private final Logger logger = LoggerFactory.getLogger(UserBankBLL.class);

    @Autowired
    private UserBankDAL userBankDAL;

    public UserBank getUserBankById(int id){
        if (id < 0){
            logger.error("invalid id, can not below zero!");
            return null;
        }

        UserBank userBank = this.userBankDAL.getUserBankByWhereClause(UserBank.COLUMN_ID,String.valueOf(id));
        return userBank;
    }

    public UserBank getUserBankByName(String name){
        if (StringUtils.isBlank(name)){
            logger.error("empty name, suck it~");
            return null;
        }

        UserBank userBank = this.userBankDAL.getUserBankByWhereClause(UserBank.COLUMN_NAME,name);
        return userBank;
    }
}
