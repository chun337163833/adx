package com.xmxedu.oaken.dao.dal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 第三方平台的DAO相关操作表
 * @version 1.0.0
 */
@Repository
public class ThirdPartyDAL {
    private final static Logger logger = LoggerFactory.getLogger(ThirdPartyDAL.class);

    // 非继承,主要是将数据源脱离于上层，采用组合的方式
    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    
}
