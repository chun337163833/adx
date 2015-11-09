package com.xmxedu.oaken.dao.impl;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import com.xmxedu.oaken.dao.AppInfoRepository;
import com.xmxedu.oaken.sql.AppInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对数据库中媒体信息的名称的表提供DAO相关操作，将接口与实现进行分离
 *
 * @version 1.0.1
 */

@Service
public class JdbcAppInfoRepository implements AppInfoRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcAppInfoRepository.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AppInfo getAppInfoByAppId(String showId) {
        String selectAppInfoByAppId = "SELECT" + AppInfo.ALL_COLUMN_NAME + "FROM" + AppInfo.TABLE_NAME + "where showId = :showId";
        SqlParameterSource namedParameters = new MapSqlParameterSource("showId", showId);

        try {
            AppInfo appInfo = (AppInfo) this.nPJT.queryForObject(selectAppInfoByAppId, namedParameters, new RowMapper() {
                public AppInfo mapRow(ResultSet rs, int i) throws SQLException {
                    AppInfo ai = new AppInfo();

                    ai.setId(rs.getInt(AppInfo.COLUMN_ID));
                    ai.setName(rs.getString(AppInfo.COLUMN_NAME));
                    ai.setShowId(rs.getString(AppInfo.COLUMN_SHOWID));
                    ai.setOsTypeId(rs.getInt(AppInfo.COLUMN_OSTYPEID));
                    ai.setCategoryId(rs.getInt(AppInfo.COLUMN_CATEGORYID));
                    ai.setPkgn(rs.getString(AppInfo.COLUMN_PKGN));
                    ai.setNote(rs.getString(AppInfo.COLUMN_NOTE));
                    ai.setStatus(rs.getInt(AppInfo.COLUMN_STATUS));
                    ai.setCheckInfo(rs.getString(AppInfo.COLUMN_CHECKINFO));
                    ai.setCreateTime(rs.getLong(AppInfo.COLUMN_CREATETIME));
                    ai.setCheckTime(rs.getLong(AppInfo.COLUMN_CHECKTIME));

                    return ai;
                }
            });
            return appInfo;
        } catch (DataAccessException e) {
            logger.error("get appinfo by appid encounter an error: " + e.getMessage());
        }
        return null;
    }

    public AppInfo getAppInfoByAppName(String appName) {

        String selectAppInfoByAppName = "SELECT" + AppInfo.ALL_COLUMN_NAME + "FROM" + AppInfo.TABLE_NAME + "where name = :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource("name",appName);

        try {
            AppInfo appInfo = (AppInfo)this.nPJT.queryForObject(selectAppInfoByAppName, namedParameters, new RowMapper<AppInfo>() {
                public AppInfo mapRow(ResultSet rs, int i) throws SQLException {
                    AppInfo ai = new AppInfo();

                    ai.setId(rs.getInt(AppInfo.COLUMN_ID));
                    ai.setName(rs.getString(AppInfo.COLUMN_NAME));
                    ai.setShowId(rs.getString(AppInfo.COLUMN_SHOWID));
                    ai.setOsTypeId(rs.getInt(AppInfo.COLUMN_OSTYPEID));
                    ai.setCategoryId(rs.getInt(AppInfo.COLUMN_CATEGORYID));
                    ai.setPkgn(rs.getString(AppInfo.COLUMN_PKGN));
                    ai.setNote(rs.getString(AppInfo.COLUMN_NOTE));
                    ai.setStatus(rs.getInt(AppInfo.COLUMN_STATUS));
                    ai.setCheckInfo(rs.getString(AppInfo.COLUMN_CHECKINFO));
                    ai.setCreateTime(rs.getLong(AppInfo.COLUMN_CREATETIME));
                    ai.setCheckTime(rs.getLong(AppInfo.COLUMN_CHECKTIME));

                    return ai;
                }
            });
            return appInfo;
        }
        catch (DataAccessException e){
            logger.error("get appinfo by appName encounter an error: " + e.getMessage());
        }


        return null;
    }
}
