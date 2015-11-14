package com.xmxedu.oaken.dao.helper;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * this is a wrapper of datasource of alibaba DruidDataSource,using mysql.properties file to config the mysql datasource
 * @version 1.0.0
 */

@Repository
@PropertySource("classpath:mysql.properties")
public class BasicDataSource extends DruidDataSource{
    private final static Logger logger = LoggerFactory.getLogger(BasicDataSource.class);

    private String url = "jdbc:mysql://localhost:3306/tb_book_storage?characterEncoding=utf-8";
    private String userName = "root";
    private String password = "";
    private String filters = "stat";
    private int initialSize = 5;
    private int minIdle = 1;
    private int maxActive = 100;
    private int maxWait = 60000;
    private int timeBetweenEvictionRunsMillis = 60000;
    private int minEvictableIdleTimeMillis = 30000;
    private String validationQuery = "SELECT 1";
    private boolean testWhileIdle = true;
    private boolean testOnBorrow = false;
    private boolean testOnReturn = false;
    private boolean poolPreparedStatements = true;
    private int maxPoolPreparedStatementPerConnectionSize = 50;

    @Autowired
    public BasicDataSource(Environment env) {

        url = env.getProperty("url", url);
        userName = env.getProperty("userName", userName);
        password = env.getProperty("password", password);
        filters = env.getProperty("filters", filters);
        initialSize = env.getProperty("initialSize", Integer.class, initialSize);
        minIdle = env.getProperty("minIdle", Integer.class, minIdle);
        maxActive = env.getProperty("maxActive", Integer.class, maxActive);
        maxWait = env.getProperty("maxWait", Integer.class, maxWait);
        timeBetweenEvictionRunsMillis = env.getProperty("timeBetweenEvictionRunsMillis", Integer.class,
                timeBetweenEvictionRunsMillis);
        minEvictableIdleTimeMillis =
                env.getProperty("minEvictableIdleTimeMillis", Integer.class, minEvictableIdleTimeMillis);
        validationQuery = env.getProperty("validationQuery", validationQuery);
        testWhileIdle = env.getProperty("testWhileIdle", Boolean.class, testWhileIdle);
        testOnBorrow = env.getProperty("testOnBorrow", Boolean.class, testOnBorrow);
        testOnReturn = env.getProperty("testOnReturn", Boolean.class, testOnReturn);
        poolPreparedStatements =
                env.getProperty("poolPreparedStatements", Boolean.class, poolPreparedStatements);
        maxPoolPreparedStatementPerConnectionSize =
                env.getProperty("maxPoolPreparedStatementPerConnectionSize", Integer.class,
                        maxPoolPreparedStatementPerConnectionSize);

        super.setUrl(this.url);
        super.setUsername(this.userName);
        super.setPassword(this.password);
        super.setInitialSize(this.initialSize);
        super.setMinIdle(this.minIdle);
        super.setMaxActive(this.maxActive);
        super.setMaxWait(this.maxWait);
        super.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        super.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        super.setValidationQuery(this.validationQuery);
        super.setTestWhileIdle(this.testWhileIdle);
        super.setTestOnBorrow(this.testOnBorrow);
        super.setTestOnReturn(this.testOnReturn);
        super.setPoolPreparedStatements(this.poolPreparedStatements);
        super.setMaxPoolPreparedStatementPerConnectionSize(
                this.maxPoolPreparedStatementPerConnectionSize);

        try {
            super.setFilters(this.filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
