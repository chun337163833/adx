package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.BizAppCategory;
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
 * 媒体APP功能分类，提供一个appId下对应的categoryId
 * @version 1.0.0
 */

@Repository
public class BizAppCategoryDAL {
    private final static Logger logger = LoggerFactory.getLogger(BizAppCategoryDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public BizAppCategory getBizAppCategoryByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty whereName,check your query clause~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty whereValue,check your query clause~");
        }

        String whereClause = "SELECT" + BizAppCategory.ALL_COLUMN_NAME + "FROM" + BizAppCategory.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            BizAppCategory bizAppCategory = this.nPJT.queryForObject(whereClause, source, new RowMapper<BizAppCategory>() {
                public BizAppCategory mapRow(ResultSet resultSet, int i) throws SQLException {
                    BizAppCategory bac = new BizAppCategory();

                    bac.setId(resultSet.getInt(BizAppCategory.COLUMN_ID));
                    bac.setAppId(resultSet.getInt(BizAppCategory.COLUMN_APP_ID));
                    bac.setCategoryId(resultSet.getInt(BizAppCategory.COLUMN_CATEGORY_ID));
                    bac.setStatus(resultSet.getInt(BizAppCategory.COLUMN_STATUS));

                    return bac;
                }
            });
            return bizAppCategory;
        }
        catch (DataAccessException e){

        }
        return null;
    }
}
