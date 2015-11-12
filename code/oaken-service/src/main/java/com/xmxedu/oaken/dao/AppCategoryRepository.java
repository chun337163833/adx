package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.AppCategory;

/**
 * 媒体分类的DAO操作接口
 * @version 1.0.0
 */
public interface AppCategoryRepository {
    public AppCategory getAppCategoryById(int id);
}
