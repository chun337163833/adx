package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.AppOS;

/**
 * 媒体的操作系统，其所属的值有限，一般为android，iOS，winphone
 * @version 1.0.0
 */
public interface AppOSRepository {
    public AppOS getAppOSById(int id);
    public AppOS getAppOSByType(String type);
}
