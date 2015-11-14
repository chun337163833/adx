package com.xmxedu.oaken.mysql;

import com.xmxedu.oaken.dao.bll.JdbcAdInfoRepository;
import com.xmxedu.oaken.sql.AdInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@BootstrapWith
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdInfoJdbcTemplateTest {
    @Autowired
    private JdbcAdInfoRepository jdbcAdInfoRepository;

    @Test
    public void GetAdInfoByShowIdTest(){
        if (null == jdbcAdInfoRepository){
            throw new NullPointerException("initiling the jdbc adinfo repository encounter an nullpointer exception~");
        }

        String showId = "288498d041da486c82b12dd74921f66f";
        AdInfo adInfo = this.jdbcAdInfoRepository.getAdInfoByShowId(showId);

        if (null == adInfo){
            throw new NullPointerException("can not get the specific result of key: " + showId);
        }

        System.out.println(adInfo.getName());
    }
}
