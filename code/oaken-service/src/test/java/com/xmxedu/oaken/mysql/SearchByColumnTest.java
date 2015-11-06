package com.xmxedu.oaken.mysql;

import com.xmxedu.oaken.dao.impl.JdbcAppInfoRepository;
import com.xmxedu.oaken.model.AppInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"applicationContext.xml"})
public class SearchByColumnTest {

    @Autowired
    private JdbcAppInfoRepository appInfoRepository;

    @Test
    public void mainTest() throws FileNotFoundException {
        if (null == appInfoRepository){
            System.out.println("null pointer exception");
            return;
        }

        AppInfo appinfo = appInfoRepository.getAppInfoByAppId("");
    }
}
