package com.xmxedu.oaken.mysql;

import com.xmxedu.oaken.dao.impl.JdbcAppInfoRepository;
import com.xmxedu.oaken.model.AppInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTest {

    @Autowired
    private JdbcAppInfoRepository jdbcAppInfoRepository;

    @Test
    public void mainTest(){
        if (null == jdbcAppInfoRepository){
            throw new NullPointerException();
        }

        AppInfo appInfo = jdbcAppInfoRepository.getAppInfoByAppId("");
    }

}
