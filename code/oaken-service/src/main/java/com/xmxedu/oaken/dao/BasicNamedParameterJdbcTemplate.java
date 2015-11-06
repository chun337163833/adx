package com.xmxedu.oaken.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * for sake of thread safe of JdbcTemplate, now we provide a Service
 * @version 1.0.0
 */

@Service("bNPJdbcTemplate")
public class BasicNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate{
    @Autowired
    public BasicNamedParameterJdbcTemplate(BasicDataSource basicDataSource){
        super(basicDataSource);
    }
}
