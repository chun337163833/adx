package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.AppCategoryDAL;
import com.xmxedu.oaken.sql.AppCategory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 媒体信息分类表的业务逻辑层操作
 * @version 1.0.0
 */
@Service
public class AppCategoryBLL {

    private final static Logger logger = LoggerFactory.getLogger(AppCategoryBLL.class);

    @Autowired
    private AppCategoryDAL appCategoryDAL;

    public AppCategory getAppCategoryById(int id){
        if (id < 0){
            logger.error("invalid id, id can not below zero!");
            return null;
        }

        AppCategory ac = this.appCategoryDAL.getAppCategoryByWhereClause(AppCategory.COLUMN_ID,String.valueOf(id));
        return ac;
    }

    public AppCategory getAppCategoryByName(String name){
        if (StringUtils.isBlank(name)){
            logger.error("empty name,suck it~");
            return null;
        }

        AppCategory ac = this.appCategoryDAL.getAppCategoryByWhereClause(AppCategory.COLUMN_NAME,name);
        return ac;
    }

}
