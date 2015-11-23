package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.AppInfoDAL;
import com.xmxedu.oaken.sql.AppInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 对数据库中媒体信息的名称的表提供DAO相关操作，将接口与实现进行分离
 *
 * @version 1.0.1
 */

@Service
public class AppInfoBLL {

    private final static Logger logger = LoggerFactory.getLogger(AppInfoBLL.class);

    @Autowired
    private AppInfoDAL appInfoDAL;

    public AppInfo getAppInfoByAppId(String showId) {

        if (StringUtils.isBlank(showId)){
            logger.error("invalid showId,and its value is: " + showId);
            return null;
        }

        AppInfo appInfo = this.appInfoDAL.getAppInfoByWhereClause(AppInfo.COLUMN_SHOWID,showId);
        return appInfo;
    }

    public AppInfo getAppInfoByAppName(String appName) {

        if (StringUtils.isBlank(appName)){
            logger.error("invalid appname~");
            return null;
        }

        AppInfo appInfo = this.appInfoDAL.getAppInfoByWhereClause(AppInfo.COLUMN_NAME,appName);
        return appInfo;
    }
}
