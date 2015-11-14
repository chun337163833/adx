package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.BizAppAd;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装上层，对上层逻辑提供底层的数据执行，抽象模块
 * @version 1.0.0
 */

@Repository
public class BizAppAdDAL {

    private final static Logger logger = LoggerFactory.getLogger(BizAppAdDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public BizAppAd getBizAppAdByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("whereName clause is empty, return a shit~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("whereValue clause is empty, return a shit for u~");
            return null;
        }


        String whereClause = "SELECT" + BizAppAd.ALL_COLUMN_NAME + "FROM" + BizAppAd.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            BizAppAd bizAppAd = this.nPJT.queryForObject(whereClause, source, new RowMapper<BizAppAd>() {
                public BizAppAd mapRow(ResultSet resultSet, int i) throws SQLException {
                    BizAppAd baa = new BizAppAd();

                    baa.setId(resultSet.getInt(BizAppAd.COLUMN_ID));
                    baa.setAppId(resultSet.getInt(BizAppAd.COLUMN_APP_ID));
                    baa.setAdId(resultSet.getInt(BizAppAd.COLUMN_AD_ID));
                    baa.setStatus(resultSet.getInt(BizAppAd.COLUMN_STATUS));

                    return baa;
                }
            });
            return bizAppAd;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result of sql query clause: {} and mapParameter: {}", whereClause,source.toString());
        }

        logger.info("sorry, u have get a nullable value of query~");
        return null;
    }

}
