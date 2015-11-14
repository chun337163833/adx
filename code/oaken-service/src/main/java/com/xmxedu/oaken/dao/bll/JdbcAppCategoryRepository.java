package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.AppCategoryRepository;
import com.xmxedu.oaken.sql.AppCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 媒体分类的DAO操作
 * @version 1.0.0
 */
@Service
public class JdbcAppCategoryRepository implements AppCategoryRepository {

    private final static Logger logger = LoggerFactory.getLogger(JdbcAppCategoryRepository.class);

    @Autowired
    @Qualifier("bNPJdbcTemplate")
    private NamedParameterJdbcTemplate nPJT;

    public AppCategory getAppCategoryById(int id) {

        if (id < 0){
            logger.error("invalid id in AppCategory");
            return null;
        }

        String selectAppCategoryById = "SELECT" + AppCategory.ALL_COLUMN_NAME + "FROM" + AppCategory.TABLE_NAME + "where id = :id";
        SqlParameterSource namedParameter = new MapSqlParameterSource("id",id);

        try {
            AppCategory appCategory = this.nPJT.queryForObject(selectAppCategoryById, namedParameter, new RowMapper<AppCategory>() {
                public AppCategory mapRow(ResultSet resultSet, int i) throws SQLException {
                    AppCategory ac = new AppCategory();

                    ac.setId(resultSet.getInt(AppCategory.COLUMN_ID));
                    ac.setName(resultSet.getString(AppCategory.COLUMN_NAME));

                    return ac;
                }
            });
            return appCategory;
        }
        catch (DataAccessException e){
            logger.error("can not get the specific result and its exception is: " + e.getMessage());
        }
        return null;
    }
}
