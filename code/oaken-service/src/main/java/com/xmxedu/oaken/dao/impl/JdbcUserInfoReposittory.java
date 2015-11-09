package com.xmxedu.oaken.dao.impl;

import com.xmxedu.oaken.dao.UserInfoRepository;
import com.xmxedu.oaken.sql.AppInfo;
import com.xmxedu.oaken.sql.UserInfo;
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
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对数据库中用户信息的名称的表提供DAO相关操作，将接口与实现进行分离
 * 目前对NameParameterJdbcTemplate是否提供一个单一的初始化过程
 */

@Service
public class JdbcUserInfoReposittory implements UserInfoRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcAppInfoRepository.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public UserInfo getUserInfoByUserId(String userId) {

        String selectUserInfoByAppId = "SELECT" + UserInfo.ALL_COLUMN_NAME + "FROM" + UserInfo.TABLE_NAME + "where Id = :Id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("Id", userId);

        try {
            UserInfo userInfo = this.nPJT.queryForObject(selectUserInfoByAppId, namedParameters, new RowMapper<UserInfo>() {
                public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                    UserInfo userInfo = new UserInfo();

                    userInfo.setId(resultSet.getInt(UserInfo.COLUMN_ID));
                    userInfo.setNickName(resultSet.getString(UserInfo.COLUMN_NICKNAME));
                    userInfo.setPassword(resultSet.getString(UserInfo.COLUMN_PASSWORD));
                    userInfo.setRealName(resultSet.getString(UserInfo.COLUMN_REALNAME));
                    userInfo.setPhone(resultSet.getString(UserInfo.COLUMN_PHONE));
                    userInfo.setQq(resultSet.getString(UserInfo.COLUMN_QQ));
                    userInfo.setIdentityAccount(resultSet.getString(UserInfo.COLUMN_IDENTITYACCOUNT));
                    userInfo.setIdentityPicture(resultSet.getBytes(UserInfo.COLUMN_IDENTITYPICTURE));
                    userInfo.setRegisterTime(resultSet.getInt(UserInfo.COLUMN_REGISTERTIME));

                    return userInfo;
                }
            });
            return userInfo;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific user in mysql and message is: " + e.getMessage());
        }

        return null;
    }

    public UserInfo getUserInfoByUserName(String userName) {

        String selectUserInfoByAppId = "SELECT" + UserInfo.ALL_COLUMN_NAME + "FROM" + UserInfo.TABLE_NAME + "where nickName = :nickName";
        SqlParameterSource namedParameters = new MapSqlParameterSource("nickName", userName);

        try {
            UserInfo userInfo = this.nPJT.queryForObject(selectUserInfoByAppId, namedParameters, new RowMapper<UserInfo>() {
                public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                    UserInfo userInfo = new UserInfo();

                    userInfo.setId(resultSet.getInt(UserInfo.COLUMN_ID));
                    userInfo.setNickName(resultSet.getString(UserInfo.COLUMN_NICKNAME));
                    userInfo.setPassword(resultSet.getString(UserInfo.COLUMN_PASSWORD));
                    userInfo.setRealName(resultSet.getString(UserInfo.COLUMN_REALNAME));
                    userInfo.setPhone(resultSet.getString(UserInfo.COLUMN_PHONE));
                    userInfo.setQq(resultSet.getString(UserInfo.COLUMN_QQ));
                    userInfo.setIdentityAccount(resultSet.getString(UserInfo.COLUMN_IDENTITYACCOUNT));
                    userInfo.setIdentityPicture(resultSet.getBytes(UserInfo.COLUMN_IDENTITYPICTURE));
                    userInfo.setRegisterTime(resultSet.getInt(UserInfo.COLUMN_REGISTERTIME));

                    return userInfo;
                }
            });
            return userInfo;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific user in mysql and message is: " + e.getMessage());
        }

        return null;
    }
}
