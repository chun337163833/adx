package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.AppOS;
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
 * 媒体操作系统类型DAO操作
 * @version 1.0.0
 */
@Repository
public class AppOSDAL {
    private final static Logger logger = LoggerFactory.getLogger(AppOSDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AppOS getAppOsByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty values,suck it~");
            return null;
        }

        String whereClause = "SELECT" + AppOS.ALL_COLUMN_NAME + "FROM" + AppOS.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource namedParameters = new MapSqlParameterSource(whereName,whereValue);

        try {
            AppOS appOS = this.nPJT.queryForObject(whereClause, namedParameters, new RowMapper<AppOS>() {
                public AppOS mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppOS ao = new AppOS();

                    ao.setId(resultSet.getInt(AppOS.COLUMN_ID));
                    ao.setType(resultSet.getString(AppOS.COLUMN_TYPE));

                    return ao;
                }
            });
            return appOS;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result of sql query clause: {} and mapParameter: {}", whereClause,namedParameters.toString());
        }

        return null;
    }
}
