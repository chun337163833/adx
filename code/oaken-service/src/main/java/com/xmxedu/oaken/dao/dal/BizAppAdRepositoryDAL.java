package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.BizAppAd;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 封装上层，对上层逻辑提供底层的数据执行，抽象模块
 * @version 1.0.0
 */

@Repository
public class BizAppAdRepositoryDAL {

    private final static Logger logger = LoggerFactory.getLogger(BizAppAdRepositoryDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public BizAppAd getBizAppAdByWhereClause(String where){
        if (StringUtils.isBlank(where)){
            logger.error("where clause is empty, return a shit~");
            return null;
        }

        String whereClause = "SELECT" +
    }

}
