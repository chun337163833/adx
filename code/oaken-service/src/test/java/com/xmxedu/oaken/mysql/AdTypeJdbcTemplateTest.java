package com.xmxedu.oaken.mysql;


import com.xmxedu.oaken.dao.impl.JdbcAdTypeRepository;
import com.xmxedu.oaken.sql.AdType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@BootstrapWith
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdTypeJdbcTemplateTest {
    @Autowired
    private JdbcAdTypeRepository jdbcAdTypeRepository;

    @Test
    public void GetAdTypeByIdTest(){
        if (null == jdbcAdTypeRepository){
            throw new NullPointerException("jdbcAdTypeRepository is not initilization~");
        }

        AdType adType = jdbcAdTypeRepository.getAdTypeById(1);

        if (null == adType){
            throw new NullPointerException("Can not find specific result");
        }

        System.out.println(adType.getType());
    }
}
