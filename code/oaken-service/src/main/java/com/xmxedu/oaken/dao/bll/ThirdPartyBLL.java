package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.ThirdPartyDAL;
import com.xmxedu.oaken.sql.ThirdPlatform;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 第三方平台的业务逻辑操作DAO
 * @version 1.0.0
 */
@Service
public class ThirdPartyBLL {
    private final static Logger logger = LoggerFactory.getLogger(ThirdPartyBLL.class);

    @Autowired
    private ThirdPartyDAL thirdPartyDAL;

    public ThirdPlatform getThirdPlatformById(int id){
        if (id < 0){
            logger.error("invalid id,suck it~");
            return null;
        }

        ThirdPlatform thirdPlatform = this.thirdPartyDAL.getThirdPlatformByWhereClause(ThirdPlatform.COLUMN_ID,String.valueOf(id));
        return thirdPlatform;
    }

    public ThirdPlatform getThirdPlatformByName(String name){
        if (StringUtils.isBlank(name)){
            logger.error("empty name,suck it~");
            return null;
        }

        ThirdPlatform thirdPlatform = this.thirdPartyDAL.getThirdPlatformByWhereClause(ThirdPlatform.COLUMN_NAME,name);
        return thirdPlatform;
    }
}
