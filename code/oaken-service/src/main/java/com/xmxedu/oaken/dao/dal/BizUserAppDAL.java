package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.BizUserApp;
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
 * 用户媒体映射关系表
 * @version 1.0.0
 */
@Repository
public class BizUserAppDAL {

    private final static Logger logger = LoggerFactory.getLogger(BizUserAppDAL.class);

    // 非继承,主要是将数据源脱离于上层
    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public BizUserApp getBizUserAppByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty wherName,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty whereValue,suck it~");
            return null;
        }

        String whereClause = "SELECT" + BizUserApp.ALL_COLUMN_NAME + "FROM" + BizUserApp.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            BizUserApp bizUserApp = this.nPJT.queryForObject(whereClause, source, new RowMapper<BizUserApp>() {
                public BizUserApp mapRow(ResultSet resultSet, int i) throws SQLException {
                    BizUserApp bua = new BizUserApp();

                    bua.setId(resultSet.getInt(BizUserApp.COLUMN_ID));
                    bua.setUserId(resultSet.getInt(BizUserApp.COLUMN_USER_ID));
                    bua.setAppId(resultSet.getInt(BizUserApp.COLUMN_APP_ID));
                    bua.setStatus(resultSet.getInt(BizUserApp.COLUMN_STATUS));

                    return bua;
                }
            });
            return bizUserApp;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result of sql: {} and mapSqlParameter: {}",whereClause,source);
        }

        return null;
    }

}
