package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.AppOSRepository;
import com.xmxedu.oaken.sql.AppOS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 媒体操作系统的DAO操作
 * @version 1.0.0
  */
public class JdbcAppOSRepository implements AppOSRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcAppOSRepository.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;


    public AppOS getAppOSById(int id) {
        if (id < 0){
            logger.error("invalid id~");
            return null;
        }

        String selectAppOSById = "SELECT" + AppOS.ALL_COLUMN_NAME + "FROM" + AppOS.TABLE_NAME + "where id = :id";
        SqlParameterSource source = new MapSqlParameterSource("id",id);

        try {
            final AppOS appOS = this.nPJT.queryForObject(selectAppOSById, source, new RowMapper<AppOS>() {
                public AppOS mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppOS ao = new AppOS();
                    ao.setId(resultSet.getInt(AppOS.COLUMN_ID));
                    ao.setType(resultSet.getString(AppOS.COLUMN_TYPE));
                    return ao;
                }
            });
            return appOS;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result and its id: {},its exception: {}",id,e.getMessage());
        }

        return null;
    }

    public AppOS getAppOSByType(String type) {
        if (StringUtils.isBlank(type)){
            logger.error("invalid type~");
            return null;
        }

        String selectAppOSById = "SELECT" + AppOS.ALL_COLUMN_NAME + "FROM" + AppOS.TABLE_NAME + "where type = :type";
        SqlParameterSource source = new MapSqlParameterSource("type",type);

        try {
            final AppOS appOS = this.nPJT.queryForObject(selectAppOSById, source, new RowMapper<AppOS>() {
                public AppOS mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppOS ao = new AppOS();
                    ao.setId(resultSet.getInt(AppOS.COLUMN_ID));
                    ao.setType(resultSet.getString(AppOS.COLUMN_TYPE));
                    return ao;
                }
            });
            return appOS;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result and its type: {},its exception: {}",type,e.getMessage());
        }

        return null;
    }
}
