package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.AppInOtherPlatform;
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
 * 媒体在第三方平台的相关注册信息，包括广告位，token等
 * @version 1.0.0
 */
@Repository
public class AppInOtherPlatformDAL {

    private final static Logger logger = LoggerFactory.getLogger(AppInOtherPlatformDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AppInOtherPlatform getAppInOtherPlatformByWhereClause(String whereName,String whereValues){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValues)){
            logger.error("empty values,suck it~");
            return null;
        }

        String whereClause = "SELECT" + AppInOtherPlatform.ALL_COLUMN_NAME + "FROM" + AppInOtherPlatform.TABLE_NAME + "where " + whereName +" = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValues);

        try {
            AppInOtherPlatform aip = this.nPJT.queryForObject(whereClause, source, new RowMapper<AppInOtherPlatform>() {
                public AppInOtherPlatform mapRow(ResultSet resultSet, int i) throws SQLException {

                    AppInOtherPlatform aio = new AppInOtherPlatform();
                    aio.setId(resultSet.getInt(AppInOtherPlatform.COLUMN_ID));
                    aio.setAppName(resultSet.getString(AppInOtherPlatform.COLUMN_APP_NAME));
                    aio.setThirdPlatformId(resultSet.getInt(AppInOtherPlatform.COLUMN_PLATFORM_ID));
                    aio.setAppId(resultSet.getInt(AppInOtherPlatform.COLUMN_APP_ID));
                    aio.setAdId(resultSet.getInt(AppInOtherPlatform.COLUMN_AD_ID));
                    aio.setShowType(resultSet.getInt(AppInOtherPlatform.COLUMN_SHOW_TYPE));
                    aio.setIncomeType(resultSet.getInt(AppInOtherPlatform.COLUMN_INCOME_TYPE));
                    return aio;
                }
            });
            return aip;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result of sql query clause: {} and mapParameter: {}", whereClause,source.toString());
        }
        return null;
    }
}
