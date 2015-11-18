package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.PaymentPlatform;
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
 * 第三方支付平台相关DAO操作表
 * 其实，大部分的代码逻辑是一样的，可以采用Freemaker这样的组件进行代码生成的工作
 * @version 1.0.0
 */
@Repository
public class PaymentPlatformDAL {

    private final static Logger logger = LoggerFactory.getLogger(PaymentPlatformDAL.class);

    // 非继承,主要是将数据源脱离于上层，采用组合的方式
    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public PaymentPlatform getPaymentPlatformByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty whereName,Suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty whereValue,suck it~");
            return null;
        }

        String whereClause = "SELECT" + PaymentPlatform.ALL_COLUMN_NAME + "FROM" + PaymentPlatform.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            PaymentPlatform paymentPlatform = this.nPJT.queryForObject(whereClause, source, new RowMapper<PaymentPlatform>() {
                public PaymentPlatform mapRow(ResultSet resultSet, int i) throws SQLException {
                    PaymentPlatform pp = new PaymentPlatform();

                    pp.setId(resultSet.getInt(PaymentPlatform.COLUMN_ID));
                    pp.setName(resultSet.getString(PaymentPlatform.COLUMN_PAYMENT_PLATFORM_NAME));

                    return null;
                }
            });
            return paymentPlatform;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result of it,its sql: {} and its map source: {}",whereClause,source.toString());
        }
        return null;
    }
}
