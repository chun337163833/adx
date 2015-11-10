package com.xmxedu.oaken.dao.impl;

import com.xmxedu.oaken.dao.AdTypeRepository;
import com.xmxedu.oaken.sql.AdInfo;
import com.xmxedu.oaken.sql.AdType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对数据库中广告类型的表提供DAO相关操作，将接口与实现进行分离
 * @version 1.0.0
 */
public class JdbcAdTypeRepository implements AdTypeRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcAdTypeRepository.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AdType getAdTypeById(int id) {
        String selectAdTypeById = "SELECT" + AdType.ALL_COLUMN_NAME + "FROM" + AdInfo.TABLE_NAME + "where id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);

        try {
            AdType adType = this.nPJT.queryForObject(selectAdTypeById, namedParameters, new RowMapper<AdType>() {
                public AdType mapRow(ResultSet resultSet, int i) throws SQLException {
                    AdType at = new AdType();
                    at.setId(resultSet.getInt(AdType.COLUMN_ID));
                    at.setType(resultSet.getString(AdType.COLUMN_TYPE));
                    return at;
                }
            });
            return adType;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result,and its exception is:" + e.getMessage());
        }

        return null;
    }
}
