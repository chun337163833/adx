package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.AdType;
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
 * 广告位类型的相关数据库操作DAO
 * @version 1.0.0
 */
@Repository
public class AdTypeDAL {
    private final static Logger logger = LoggerFactory.getLogger(AdTypeDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AdType getAdTypeByWhereClause(String whereName,String whereValue) {

        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty values,suck it~");
            return null;
        }

        String whereClause = "SELECT" + AdType.ALL_COLUMN_NAME + "FROM" + AdType.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource namedParameters = new MapSqlParameterSource(whereName,whereValue);

        try {
            AdType adType = this.nPJT.queryForObject(whereClause, namedParameters, new RowMapper<AdType>() {
                public AdType mapRow(ResultSet resultSet, int i) throws SQLException {
                    AdType at = new AdType();
                    at.setId(resultSet.getInt(AdType.COLUMN_ID));
                    at.setType(resultSet.getString(AdType.COLUMN_TYPE));
                    return at;
                }
            });
            return adType;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result,and its exception is:" + e.getMessage());
            logger.error("its whereClause is: {} and its parameters is: {}",whereClause,namedParameters.toString());
        }

        return null;
    }
}
