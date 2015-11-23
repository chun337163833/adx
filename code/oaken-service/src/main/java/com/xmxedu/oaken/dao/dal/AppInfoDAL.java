package com.xmxedu.oaken.dao.dal;

import com.xmxedu.oaken.sql.AppCategory;
import com.xmxedu.oaken.sql.AppInfo;
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
 * 对数据库中媒体信息的名称的表提供DAO相关操作，将接口与实现进行分离
 *
 * @version 1.0.1
 */
@Repository
public class AppInfoDAL {
    private final static Logger logger = LoggerFactory.getLogger(AppInfoDAL.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AppInfo getAppInfoByWhereClause(String whereName,String whereValue){
        if (StringUtils.isBlank(whereName)){
            logger.error("empty where name,suck it~");
            return null;
        }

        if (StringUtils.isBlank(whereValue)){
            logger.error("empty values,suck it~");
            return null;
        }

        String whereClause = "SELECT" + AppInfo.ALL_COLUMN_NAME + "FROM" + AppInfo.TABLE_NAME + "where " + whereName + " = :" + whereName;
        SqlParameterSource namedParameters = new MapSqlParameterSource(whereName,whereValue);

        try {
            AppInfo appInfo = this.nPJT.queryForObject(whereClause, namedParameters, new RowMapper<AppInfo>() {
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
            logger.error("can not get the specific result,and its exception is:" + e.getMessage());
            logger.error("its whereClause is: {} and its parameters is: {}",whereClause,namedParameters.toString());
        }

        return null;
    }
}
