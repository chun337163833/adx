package com.xmxedu.oaken.dao.dal;

import com.google.common.collect.Lists;
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
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 广告位相关信息DAO操作函数
 * @version 1.0.0
 */
@Repository
public class AdInfoDAL {

    private final static Logger logger = LoggerFactory.getLogger(AdInfoDAL.class);

    // 非继承,主要是将数据源脱离于上层
    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AdInfo getAdInfoByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("whereName clause is empty, return a shit~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("whereValue clause is empty, return a shit for u~");
            return null;
        }

        String whereClause = "SELECT" + AdInfo.ALL_COLUMN_NAME + "FROM" + AdInfo.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource source = new MapSqlParameterSource(whereName,whereValue);

        try {
            AdInfo adInfo = this.nPJT.queryForObject(whereClause, source, new RowMapper<AdInfo>() {
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
            logger.error("can not get the specific result of sql query clause: {} and mapParameter: {}", whereClause,source.toString());
        }
        return null;
    }

    public List<AdInfo> getAllAdInfoByWhereClause(){


        String whereClause = "SELECT" + AdInfo.ALL_COLUMN_NAME + "FROM" + AdInfo.TABLE_NAME + "where id > :id";
        SqlParameterSource source = new MapSqlParameterSource("id","0");

        try {
            List<Map<String,Object>> queryResult = this.nPJT.queryForList(whereClause,source);
            List<AdInfo> result = Lists.newArrayList();

            for (Map<String,Object> map : queryResult){
                AdInfo ai = new AdInfo();

                ai.setId((Integer)map.get(AdInfo.COLUMN_ID));
                ai.setName((String) map.get(AdInfo.COLUMN_NAME));
                ai.setShowId((String)map.get(AdInfo.COLUMN_SHOWID));
            }

            return result;
        }
        catch (DataAccessException e){

        }

        return null;
    }
}
