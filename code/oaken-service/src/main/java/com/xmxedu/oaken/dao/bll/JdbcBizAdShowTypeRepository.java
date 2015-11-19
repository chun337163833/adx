package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.BizAdShowTypeRepository;
import com.xmxedu.oaken.sql.BizAdShowType;
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
 * 广告位展示类型映射表相关的DAO操作
 *
 * @version 1.0.0
 */
public class JdbcBizAdShowTypeRepository implements BizAdShowTypeRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcBizAdShowTypeRepository.class);

    // 抽象提取出来
    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;


    public BizAdShowType getBizAdShowTypeById(int id) {
        if (id < 0) {
            logger.error("invalid id for get biz ad showtype and its value: {}", id);
            return null;
        }

        String selectBizAdShowTypeById = "SELECT" + BizAdShowType.ALL_COLUMN_NAME + "FROM" + BizAdShowType.TABLE_NAME + "where id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);

        try {
            BizAdShowType bizAdShowType = this.nPJT.queryForObject(selectBizAdShowTypeById, parameterSource, new RowMapper<BizAdShowType>() {
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
        } catch (DataAccessException e) {
            logger.error("can not get specific result of id with: " + id);
        }

        return null;
    }

    public BizAdShowType getBizAdShowTypeByAdId(int adId) {

        if (adId < 0) {
            logger.error("invalid adId for get biz ad showtype and its value: {}", adId);
            return null;
        }

        String selectBizAdShowTypeById = "SELECT" + BizAdShowType.ALL_COLUMN_NAME + "FROM" + BizAdShowType.TABLE_NAME + "where adid = :adid";
        SqlParameterSource parameterSource = new MapSqlParameterSource("adid", adId);

        try {
            BizAdShowType bizAdShowType = this.nPJT.queryForObject(selectBizAdShowTypeById, parameterSource, new RowMapper<BizAdShowType>() {
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
        } catch (DataAccessException e) {
            logger.error("can not get specific result of adid with: " + adId);
        }

        return null;
    }

    public BizAdShowType getBizAdShowTypeByShowTypeId(int showTypeId) {
        if (showTypeId < 0) {
            logger.error("invalid adId for get biz ad showTypeId and its value: {}", showTypeId);
            return null;
        }

        String selectBizAdShowTypeById = "SELECT" + BizAdShowType.ALL_COLUMN_NAME + "FROM" + BizAdShowType.TABLE_NAME + "where showtypeid = :showtypeid";
        SqlParameterSource parameterSource = new MapSqlParameterSource("showtypeid", showTypeId);

        try {
            BizAdShowType bizAdShowType = this.nPJT.queryForObject(selectBizAdShowTypeById, parameterSource, new RowMapper<BizAdShowType>() {
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
        } catch (DataAccessException e) {
            logger.error("can not get specific result of showtypeid with: " + showTypeId);
        }

        return null;
    }
}
