package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.BizAppRelationShip;
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
 * 本平台和第三方媒体的映射关系表，DAO
 * 其实，大部分的代码逻辑是一样的，可以采用Freemaker这样的组件进行代码生成的工作
 * @version 1.0.0
 */

@Repository
public class BizAppRelationshipDAL {
    private final static Logger logger = LoggerFactory.getLogger(BizAppRelationshipDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public BizAppRelationShip getBizAppRelationShipByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty whereName, suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty whereValue,suck it~");
            return null;
        }

        String whereClause = "SELECT" + BizAppRelationShip.ALL_COLUMN_NAME + "FROM" + BizAppRelationShip.TABLE_NAME + "where " + whereName + " =: " + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {

            BizAppRelationShip bar = this.nPJT.queryForObject(whereClause, source, new RowMapper<BizAppRelationShip>() {
                public BizAppRelationShip mapRow(ResultSet resultSet, int i) throws SQLException {
                    BizAppRelationShip bar = new BizAppRelationShip();

                    bar.setId(resultSet.getInt(BizAppRelationShip.COLUMN_ID));
                    bar.setOurAdId(resultSet.getInt(BizAppRelationShip.COLUMN_OUR_AD));
                    bar.setThirdPlatformId(resultSet.getInt(BizAppRelationShip.COLUMN_OTHERPLATFORM_AD));
                    bar.setRequestWeight(resultSet.getDouble(BizAppRelationShip.COLUMN_REQUEST_WEIGHT));

                    return bar;
                }
            });
            return bar;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result of it, its sql: {}",whereClause);
            logger.error("its source: {}",source.toString());
        }
        return null;
    }

}
