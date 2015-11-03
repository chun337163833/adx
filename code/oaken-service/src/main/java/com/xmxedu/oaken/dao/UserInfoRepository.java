package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.UserInfo;

/**
 * Provide operations of userinfo DAO in mysql
 * @version 1.0.0
 */
public interface UserInfoRepository {
    public UserInfo getUserInfoByUserId(String userId);
}
