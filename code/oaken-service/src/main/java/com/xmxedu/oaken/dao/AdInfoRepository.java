package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.AdInfo;

/**
 * 对广告位的信息提供数据库的DAO操作
 * @version 1.0.0
 */
public interface AdInfoRepository {
    public AdInfo getAdInfoByShowId(String showID);
    public AdInfo getAdInfoByName(String name);
}
