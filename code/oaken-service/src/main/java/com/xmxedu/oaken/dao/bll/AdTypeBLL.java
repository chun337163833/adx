package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.AdTypeRepository;
import com.xmxedu.oaken.dao.dal.AdTypeDAL;
import com.xmxedu.oaken.sql.AdType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对数据库中广告类型的表提供DAO相关操作，将接口与实现进行分离
 * @version 1.0.0
 */
@Service
public class AdTypeBLL {

    private final static Logger logger = LoggerFactory.getLogger(AdTypeBLL.class);

    @Autowired
    private AdTypeDAL adTypeDAL;

    public AdType getAdTypeById(int id) {
        if (id < 0){
            logger.error("invalid id, its value can not below zero~");
            return null;
        }
        AdType adType = this.adTypeDAL.getAdTypeByWhereClause(AdType.COLUMN_ID,String.valueOf(id));
        return adType;
    }
}
