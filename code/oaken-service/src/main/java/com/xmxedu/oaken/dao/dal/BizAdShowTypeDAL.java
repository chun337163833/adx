package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.AppOS;
import com.xmxedu.oaken.sql.BizAdShowType;
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
 * 媒体广告展示类型映射关系
 * @version 1.0.0
 */
@Repository
public class BizAdShowTypeDAL {
    private final static Logger logger = LoggerFactory.getLogger(BizAdShowTypeDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public BizAdShowType getBizAdShowTypeByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty values,suck it~");
            return null;
        }

        String whereClause = "SELECT" + BizAdShowType.ALL_COLUMN_NAME + "FROM" + BizAdShowType.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource namedParameters = new MapSqlParameterSource(whereName,whereValue);

        try {
            BizAdShowType bizAdShowType = this.nPJT.queryForObject(whereClause, namedParameters, new RowMapper<BizAdShowType>() {
                public BizAdShowType mapRow(ResultSet resultSet, int i) throws SQLException {
                    BizAdShowType bast = new BizAdShowType();

                    bast.setId(resultSet.getInt(BizAdShowType.COLUMN_ID));
                    bast.setAdId(resultSet.getInt(BizAdShowType.COLUMN_ADID));
                    bast.setShowTypeId(resultSet.getInt(BizAdShowType.COLUMN_SHOWTYPE_ID));
                    bast.setStatus(resultSet.getInt(BizAdShowType.COLUMN_STATUS));

                    return bast;
                }
            });
            return bizAdShowType;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result of sql query clause: {} and mapParameter: {}", whereClause,namedParameters.toString());
        }

        return null;
    }
}
