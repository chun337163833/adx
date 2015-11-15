package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.BizUserApp;
import com.xmxedu.oaken.sql.BizUserBank;
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
 * 用户银行映射表
 * @version 1.0.0
 */
@Repository
public class BizUserBankDAL {

    private final static Logger logger = LoggerFactory.getLogger(BizUserBankDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public BizUserBank getBizUserBankByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name, suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty where value, suck it~");
            return null;
        }

        String whereClause = "SELECT" + BizUserBank.ALL_COLUMN_NAME + "FROM" + BizUserBank.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            final BizUserBank bizUserBank = this.nPJT.queryForObject(whereClause, source, new RowMapper<BizUserBank>() {
                public BizUserBank mapRow(ResultSet resultSet, int i) throws SQLException {
                    BizUserBank bub = new BizUserBank();

                    bub.setId(resultSet.getInt(BizUserBank.COLUMN_ID));
                    bub.setUserId(resultSet.getInt(BizUserBank.COLUMN_USER_ID));
                    bub.setPaymentWay(resultSet.getInt(BizUserBank.COLUMN_PAYMENT_WAY));
                    bub.setPaymentId(resultSet.getInt(BizUserBank.COLUMN_PAYMENT_ID));
                    bub.setStatus(resultSet.getInt(BizUserBank.COLUMN_STATUS));

                    return bub;
                }
            });
            return bizUserBank;
        }
        catch (DataAccessException e){

        }
        return null;
    }
}
