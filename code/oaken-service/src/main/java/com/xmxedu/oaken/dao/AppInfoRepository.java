package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.model.AppInfo;

/**
 * Provid operations of AppInfo DAO in mysql
 * @version 1.0.0
 */
public interface AppInfoRepository {
    public AppInfo getAppInfoByAppId(String appId);
    public AppInfo getAppInfoByAppName(String appName);
}