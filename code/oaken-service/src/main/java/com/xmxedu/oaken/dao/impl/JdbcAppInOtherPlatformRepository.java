package com.xmxedu.oaken.dao.impl;

import com.xmxedu.oaken.dao.AppInOtherPlatformRepository;
import com.xmxedu.oaken.sql.AppInOtherPlatform;
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
 * 媒体再第三方平台的相关属性配置信息，该表的操作是用来记录第三方平台的媒体信息
 */
@Service
public class JdbcAppInOtherPlatformRepository implements AppInOtherPlatformRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcAppInOtherPlatformRepository.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AppInOtherPlatform getAppInOtherPlatformById(int id) {
        String selectAIOById = "SELECT" + AppInOtherPlatform.ALL_COLUMN_NAME + "FROM" + AppInOtherPlatform.TABLE_NAME + "where id = :id";
        SqlParameterSource namedParametered = new MapSqlParameterSource("id",id);
        try {
            AppInOtherPlatform appInOtherPlatform = this.nPJT.queryForObject(selectAIOById, namedParametered, new RowMapper<AppInOtherPlatform>() {
                public AppInOtherPlatform mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppInOtherPlatform aio = new AppInOtherPlatform();
                    aio.setId(resultSet.getInt(AppInOtherPlatform.COLUMN_ID));
                    aio.setAppName(resultSet.getString(AppInOtherPlatform.COLUMN_APP_NAME));
                    aio.setThirdPlatformId(resultSet.getInt(AppInOtherPlatform.COLUMN_PLATFORM_ID));
                    aio.setAppId(resultSet.getInt(AppInOtherPlatform.COLUMN_APP_ID));
                    aio.setAdId(resultSet.getInt(AppInOtherPlatform.COLUMN_AD_ID));
                    aio.setShowType(resultSet.getInt(AppInOtherPlatform.COLUMN_SHOW_TYPE));
                    aio.setIncomeType(resultSet.getInt(AppInOtherPlatform.COLUMN_INCOME_TYPE));
                    return aio;
                }
            });
            return appInOtherPlatform;
        }
        catch (DataAccessException e){
            logger.error("can not get specifici result with id = {}, its error is: ", id, e.getMessage());
        }

        return null;
    }

    public AppInOtherPlatform getAppInOtherPlatformByAppName(String appName) {
        String selectAIOById = "SELECT" + AppInOtherPlatform.ALL_COLUMN_NAME + "FROM" + AppInOtherPlatform.TABLE_NAME + "where appname = :appname";
        SqlParameterSource namedParametered = new MapSqlParameterSource("appname",appName);
        try {
            AppInOtherPlatform appInOtherPlatform = this.nPJT.queryForObject(selectAIOById, namedParametered, new RowMapper<AppInOtherPlatform>() {
                public AppInOtherPlatform mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppInOtherPlatform aio = new AppInOtherPlatform();
                    aio.setId(resultSet.getInt(AppInOtherPlatform.COLUMN_ID));
                    aio.setAppName(resultSet.getString(AppInOtherPlatform.COLUMN_APP_NAME));
                    aio.setThirdPlatformId(resultSet.getInt(AppInOtherPlatform.COLUMN_PLATFORM_ID));
                    aio.setAppId(resultSet.getInt(AppInOtherPlatform.COLUMN_APP_ID));
                    aio.setAdId(resultSet.getInt(AppInOtherPlatform.COLUMN_AD_ID));
                    aio.setShowType(resultSet.getInt(AppInOtherPlatform.COLUMN_SHOW_TYPE));
                    aio.setIncomeType(resultSet.getInt(AppInOtherPlatform.COLUMN_INCOME_TYPE));
                    return aio;
                }
            });
            return appInOtherPlatform;
        }
        catch (DataAccessException e){
            logger.error("can not get specifici result with appname = {}, its error is: ", appName, e.getMessage());
        }

        return null;
    }

    public AppInOtherPlatform getAppInOtherPlatformByAppId(String appId) {

        String selectAIOById = "SELECT" + AppInOtherPlatform.ALL_COLUMN_NAME + "FROM" + AppInOtherPlatform.TABLE_NAME + "where appid = :appid";
        SqlParameterSource namedParametered = new MapSqlParameterSource("appid",appId);
        try {
            AppInOtherPlatform appInOtherPlatform = this.nPJT.queryForObject(selectAIOById, namedParametered, new RowMapper<AppInOtherPlatform>() {
                public AppInOtherPlatform mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppInOtherPlatform aio = new AppInOtherPlatform();
                    aio.setId(resultSet.getInt(AppInOtherPlatform.COLUMN_ID));
                    aio.setAppName(resultSet.getString(AppInOtherPlatform.COLUMN_APP_NAME));
                    aio.setThirdPlatformId(resultSet.getInt(AppInOtherPlatform.COLUMN_PLATFORM_ID));
                    aio.setAppId(resultSet.getInt(AppInOtherPlatform.COLUMN_APP_ID));
                    aio.setAdId(resultSet.getInt(AppInOtherPlatform.COLUMN_AD_ID));
                    aio.setShowType(resultSet.getInt(AppInOtherPlatform.COLUMN_SHOW_TYPE));
                    aio.setIncomeType(resultSet.getInt(AppInOtherPlatform.COLUMN_INCOME_TYPE));
                    return aio;
                }
            });
            return appInOtherPlatform;
        }
        catch (DataAccessException e){
            logger.error("can not get specifici result with appid = {}, its error is: ", appId, e.getMessage());
        }

        return null;
    }
}
