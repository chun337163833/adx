package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.ThirdPlatform;
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

    public ThirdPlatform getThirdPlatformByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty where value,suck it~");
            return null;
        }

        String whereClause = "SELECT" + ThirdPlatform.ALL_COLUMN_NAME + "FROM" + ThirdPlatform.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            ThirdPlatform thirdPlatform = this.nPJT.queryForObject(whereClause, source, new RowMapper<ThirdPlatform>() {
                public ThirdPlatform mapRow(ResultSet resultSet, int i) throws SQLException {
                    ThirdPlatform tp = new ThirdPlatform();

                    tp.setId(resultSet.getInt(ThirdPlatform.COLUMN_ID));
                    tp.setName(resultSet.getString(ThirdPlatform.COLUMN_NAME));
                    tp.setPlatformType(resultSet.getInt(ThirdPlatform.COLUMN_PLATFORM_TYPE));
                    tp.setPlatformType(resultSet.getInt(ThirdPlatform.COLUMN_REQUEST_TYPE));
                    tp.setRequestUrl(resultSet.getString(ThirdPlatform.COLUMN_REQUEST_URL));
                    tp.setKey(resultSet.getString(ThirdPlatform.COLUMN_KEY));
                    tp.setToken(resultSet.getString(ThirdPlatform.COLUMN_TOKEN));

                    return tp;
                }
            });
            return thirdPlatform;
        }
        catch (DataAccessException e){
            logger.error("can not get specific result,and its where clause is: {} and source is: {}",whereClause,source);
        }
        return null;
    }
}
