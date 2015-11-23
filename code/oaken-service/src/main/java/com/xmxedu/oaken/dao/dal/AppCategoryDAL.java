package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.AdType;
import com.xmxedu.oaken.sql.AppCategory;
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
 * 媒体分类信息表DAO，比如说教育阅读，理财投资
 * @version 1.0.0
 */
@Repository
public class AppCategoryDAL {
    private final static Logger logger = LoggerFactory.getLogger(AppCategoryDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AppCategory getAppCategoryByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty values,suck it~");
            return null;
        }

        String whereClause = "SELECT" + AppCategory.ALL_COLUMN_NAME + "FROM" + AppCategory.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource namedParameters = new MapSqlParameterSource(whereName,whereValue);

        try {
            AppCategory appCategory = this.nPJT.queryForObject(whereClause, namedParameters, new RowMapper<AppCategory>() {
                public AppCategory mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppCategory ac = new AppCategory();

                    ac.setId(resultSet.getInt(AppCategory.COLUMN_ID));
                    ac.setName(resultSet.getString(AppCategory.COLUMN_NAME));

                    return ac;
                }
            });
            return appCategory;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result,and its exception is:" + e.getMessage());
            logger.error("its whereClause is: {} and its parameters is: {}",whereClause,namedParameters.toString());
        }

        return null;
    }
}
