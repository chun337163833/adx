package com.xmxedu.oaken.dao.impl;

import com.xmxedu.oaken.dao.UserInfoRepository;
import com.xmxedu.oaken.sql.UserInfo;

/**
 * 对数据库中用户信息的名称的表提供DAO相关操作，将接口与实现进行分离
 * 目前对NameParameterJdbcTemplate是否提供一个单一的初始化过程
 */
public class JdbcUserInfoReposittory implements UserInfoRepository {

    public UserInfo getUserInfoByUserId(String userId) {
        return null;
    }
}
