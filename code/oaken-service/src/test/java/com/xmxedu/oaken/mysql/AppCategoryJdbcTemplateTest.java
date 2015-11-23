package com.xmxedu.oaken.mysql;


import com.xmxedu.oaken.sql.AppCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@BootstrapWith
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppCategoryJdbcTemplateTest {

    @Autowired
    private JdbcAppCategoryRepository jdbcAppCategoryRepository;

    @Test
    public void GetAppCategoryById(){
        AppCategory appCategory = jdbcAppCategoryRepository.getAppCategoryById(3);
        if (null == appCategory){
            return;
        }

        System.out.println(appCategory.getName());
    }
}
