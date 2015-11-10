package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.AdType;

/**
 * 对广告位的类型提供数据库的DAO操作
 * @version 1.0.0
 */
public interface AdTypeRepository {
    public AdType getAdTypeById(int id);
}
