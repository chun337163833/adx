package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.BizUserBankDAL;
import com.xmxedu.oaken.sql.BizUserBank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户银行映射关系表
 * @version 1.0.0
 */
@Service
public class BizUserBankBLL {

    private final static Logger logger = LoggerFactory.getLogger(BizUserBankBLL.class);

    @Autowired
    private BizUserBankDAL bizUserBankDAL;

    public BizUserBank getBizUserBankById(int id){
        if (id < 0){
            logger.error("invalid id,suck it~");
            return null;
        }

        BizUserBank bizUserBank = this.bizUserBankDAL.getBizUserBankByWhereClause(BizUserBank.COLUMN_ID,String.valueOf(id));
        return bizUserBank;
    }

    public BizUserBank getBizUserBankByUserId(int userId){
        if (userId < 0){
            logger.error("invalid user id, suck it~");
            return null;
        }

        BizUserBank bizUserBank = this.bizUserBankDAL.getBizUserBankByWhereClause(BizUserBank.COLUMN_USER_ID,String.valueOf(userId));
        return bizUserBank;
    }

    public BizUserBank getBizUserBankByPaymentWay(int paymentWay){
        if (paymentWay < 0){
            logger.error("invalid payment way, suck it~");
            return null;
        }

        BizUserBank bizUserBank = this.bizUserBankDAL.getBizUserBankByWhereClause(BizUserBank.COLUMN_PAYMENT_WAY,String.valueOf(paymentWay));
        return bizUserBank;
    }

    public BizUserBank getBizUserBankByPaymentId(int paymentId){
        if (paymentId < 0){
            logger.error("invalid payment id, suck it~");
            return null;
        }

        BizUserBank bizUserBank = this.bizUserBankDAL.getBizUserBankByWhereClause(BizUserBank.COLUMN_PAYMENT_WAY,String.valueOf(paymentId));
        return bizUserBank;
    }

    public BizUserBank getBizUserBankByStatus(int status){
        if (status < 0){
            logger.error("invalid status id, suck it~");
            return null;
        }

        BizUserBank bizUserBank = this.bizUserBankDAL.getBizUserBankByWhereClause(BizUserBank.COLUMN_PAYMENT_WAY,String.valueOf(status));
        return bizUserBank;
    }
}
