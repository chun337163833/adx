package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.UserPaymentPlatform;
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
 * 用户支付平台
 * 其实，大部分的代码逻辑是一样的，可以采用Freemaker这样的组件进行代码生成的工作
 * @version 1.0.0
 */
@Repository
public class UserPaymentPlatformDAL {
    private final static Logger logger = LoggerFactory.getLogger(UserPaymentPlatformDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public UserPaymentPlatform getUserPaymentPlatformByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty where value,suck it~");
            return null;
        }

        String whereClause = "SELECT" + UserPaymentPlatform.ALL_COLUMN_NAME + "FROM" + UserPaymentPlatform.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {

            UserPaymentPlatform upp = this.nPJT.queryForObject(whereClause, source, new RowMapper<UserPaymentPlatform>() {
                public UserPaymentPlatform mapRow(ResultSet resultSet, int i) throws SQLException {
                    UserPaymentPlatform userPaymentPlatform = new UserPaymentPlatform();

                    userPaymentPlatform.setId(resultSet.getInt(UserPaymentPlatform.COLUMN_ID));
                    userPaymentPlatform.setPaymentPlatformId(resultSet.getInt(UserPaymentPlatform.COLUMN_PAYMENT_PLATFORM_ID));
                    userPaymentPlatform.setPaymentPlatformAccount(resultSet.getString(UserPaymentPlatform.COLUMN_PAYMENT_PLATFORM_ACCOUNT));

                    return userPaymentPlatform;
                }
            });
            return upp;

        }
        catch (DataAccessException e){
            logger.error("can not get specific result of it, its where clause is: {} and its source is: {}",whereClause,source.toString());
        }

        return null;
    }

}
