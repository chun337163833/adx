package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.UserBank;
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
 * 用户银行底层操作类
 * 其实，大部分的代码逻辑是一样的，可以采用Freemaker这样的组件进行代码生成的工作
 * @version 1.0.0
 */
@Repository
public class UserBankDAL {
    private final static Logger logger = LoggerFactory.getLogger(UserBankDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public UserBank getUserBankByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty where value,suck it~");
            return null;
        }


        String whereClause = "SELECT" + UserBank.ALL_COLUMN_NAME + "FROM" + UserBank.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            UserBank userBank = this.nPJT.queryForObject(whereClause, source, new RowMapper<UserBank>() {
                public UserBank mapRow(ResultSet resultSet, int i) throws SQLException {
                    UserBank ub = new UserBank();

                    ub.setId(resultSet.getInt(UserBank.COLUMN_ID));
                    ub.setName(resultSet.getString(UserBank.COLUMN_NAME));
                    ub.setAccount(resultSet.getString(UserBank.COLUMN_ACCOUNT));
                    ub.setAddress(resultSet.getString(UserBank.COLUMN_ADDRESS));

                    return ub;
                }
            });
            return userBank;
        }
        catch (DataAccessException e){
            logger.error("cannot get specific result of query,its where clause is: {} and source is: {}",whereClause,source.toString());
        }

        return null;
    }
}
