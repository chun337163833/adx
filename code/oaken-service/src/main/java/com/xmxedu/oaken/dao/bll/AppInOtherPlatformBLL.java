package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.AppInOtherPlatformDAL;
import com.xmxedu.oaken.sql.AppInOtherPlatform;
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
 * 媒体再第三方平台的相关属性配置信息，该表的操作是用来记录第三方平台的媒体信息
 */
@Service
public class AppInOtherPlatformBLL {

    private final static Logger logger = LoggerFactory.getLogger(AppInOtherPlatformBLL.class);

    @Autowired
    private AppInOtherPlatformDAL appInOtherPlatformDAL;

    public AppInOtherPlatform getAppInOtherPlatformById(int id) {

        if (id < 0){
            logger.error("invalid id~");
            return null;
        }

        AppInOtherPlatform aio = this.appInOtherPlatformDAL.getAppInOtherPlatformByWhereClause(AppInOtherPlatform.COLUMN_ID,String.valueOf(id));
        return aio;
    }

    public AppInOtherPlatform getAppInOtherPlatformByAppName(String appName) {
        if (StringUtils.isBlank(appName)){
            logger.error("invalid appname~");
            return null;
        }
        AppInOtherPlatform aio = this.appInOtherPlatformDAL.getAppInOtherPlatformByWhereClause(AppInOtherPlatform.COLUMN_APP_NAME,appName);
        return aio;
    }

    public AppInOtherPlatform getAppInOtherPlatformByAppId(String appId) {

        if (StringUtils.isBlank(appId)){
            logger.error("invalid appid~");
            return null;
        }
        AppInOtherPlatform aio = this.appInOtherPlatformDAL.getAppInOtherPlatformByWhereClause(AppInOtherPlatform.COLUMN_APP_ID,appId);
        return aio;
    }
}
