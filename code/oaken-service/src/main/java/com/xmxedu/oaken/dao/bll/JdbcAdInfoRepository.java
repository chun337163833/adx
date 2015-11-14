package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.AdInfoRepository;
import com.xmxedu.oaken.sql.AdInfo;
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
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对数据库中的广告位提供相关的查询接口
 * @version 1.0.0
 */
@Service
public class JdbcAdInfoRepository implements AdInfoRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcAdInfoRepository.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AdInfo getAdInfoByShowId(String showId) {

        if (StringUtils.isBlank(showId)){
            logger.error("the showId is empty,pleasse check your showId");
            return null;
        }

        String selectAdInfoByShowId = "SELECT" + AdInfo.ALL_COLUMN_NAME + "FROM" + AdInfo.TABLE_NAME + "where showid = :showid";
        SqlParameterSource namedParameters = new MapSqlParameterSource("showid",showId);

        try {
            AdInfo adInfo = this.nPJT.queryForObject(selectAdInfoByShowId, namedParameters, new RowMapper<AdInfo>() {
                public AdInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                    AdInfo ai = new AdInfo();

                    ai.setId(resultSet.getInt(AdInfo.COLUMN_ID));
                    ai.setName(resultSet.getString(AdInfo.COLUMN_NAME));
                    ai.setShowId(resultSet.getString(AdInfo.COLUMN_SHOWID));

                    return ai;
                }
            });
            return adInfo;
        }
        catch (DataAccessException e){
            logger.error("can not get specific result~ and its exceptions is: " + e.getMessage());
        }

        return null;
    }

    public AdInfo getAdInfoByName(String name) {
        return null;
    }
}
