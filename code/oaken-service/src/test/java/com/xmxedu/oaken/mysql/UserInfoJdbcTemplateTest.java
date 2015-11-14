package com.xmxedu.oaken.mysql;

import com.xmxedu.oaken.dao.bll.JdbcUserInfoRepository;
import com.xmxedu.oaken.sql.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserInfoJdbcTemplateTest {

    @Autowired
    private JdbcUserInfoRepository jdbcUserInfoRepository;

    @Test
    public void getUserInfoByUserIdTest(){
        if (null == jdbcUserInfoRepository){
            throw new NullPointerException("can not initialing the jdbc reposittory~ ");
        }

        UserInfo userInfo = this.jdbcUserInfoRepository.getUserInfoByUserName("test");

        if (null == userInfo){
            throw new NullPointerException("can not get the right sql query result~");
        }

        System.out.println(userInfo.getRealName());
    }
}
