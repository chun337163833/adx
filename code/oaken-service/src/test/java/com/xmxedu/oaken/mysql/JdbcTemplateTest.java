package com.xmxedu.oaken.mysql;

import com.xmxedu.oaken.dao.impl.JdbcAppInfoRepository;
import com.xmxedu.oaken.model.AppInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@BootstrapWith
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTest {

    @Autowired
    private JdbcAppInfoRepository jdbcAppInfoRepository;

    @Test
    public void GetAppInfoByAppIdTest(){
        if (null == jdbcAppInfoRepository){
            throw new NullPointerException();
        }

        AppInfo appInfo = jdbcAppInfoRepository.getAppInfoByAppId("55ed62ff");

        if (null == appInfo){
            throw new NullPointerException("Cannot find the specific result~");
        }

        System.out.println(appInfo.getName());
    }

    @Test
    public void GetAppInfoByAppNameTest(){
        if (null == jdbcAppInfoRepository){
            throw new NullPointerException("jdbc not initializating~");
        }

        AppInfo appInfo = jdbcAppInfoRepository.getAppInfoByAppName("好豆菜谱");
        if (null == appInfo){
            throw new NullPointerException("Cannot find specific result~");
        }

        System.out.println(appInfo.getCheckInfo());
    }

}
