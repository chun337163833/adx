package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.AppOSDAL;
import com.xmxedu.oaken.sql.AppOS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 媒体操作系统类型
 * @version 1.0.0
 */
@Repository
public class AppOSBLL {
    private final static Logger logger = LoggerFactory.getLogger(AppOSBLL.class);

    @Autowired
    private AppOSDAL appOSDAL;

    public AppOS getAppOSById(int id){
        if (id < 0){
            logger.error("invalid id~");
            return null;
        }

        AppOS appOS = this.appOSDAL.getAppOsByWhereClause(AppOS.COLUMN_ID,String.valueOf(id));
        return appOS;
    }

    public AppOS getAppOSByType(String type){
        if (StringUtils.isBlank(type)){
            logger.error("empty type,suck it~");
            return null;
        }

        AppOS ao = this.appOSDAL.getAppOsByWhereClause(AppOS.COLUMN_TYPE,type);
        return ao;
    }
}
