package com.xmxedu.oaken.dao.bll;

import com.xmxedu.oaken.dao.dal.AdInfoDAL;
import com.xmxedu.oaken.sql.AdInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 对数据库中的广告位提供相关的查询接口
 * @version 1.0.0
 */
@Service
public class AdInfoBLL{

    private final static Logger logger = LoggerFactory.getLogger(AdInfoBLL.class);

    @Autowired
    private AdInfoDAL adInfoDAL;

    public AdInfo getAdInfoByShowId(String showId) {

        if (StringUtils.isBlank(showId)){
            logger.error("the showId is empty,pleasse check your showId");
            return null;
        }

        AdInfo ai = this.adInfoDAL.getAdInfoByWhereClause(AdInfo.COLUMN_SHOWID,showId);
        return ai;
    }

    public AdInfo getAdInfoByName(String name) {
        if (StringUtils.isBlank(name)){
            logger.error("the name is empty,pleasse check your showId");
            return null;
        }

        AdInfo ai = this.adInfoDAL.getAdInfoByWhereClause(AdInfo.COLUMN_NAME,name);
        return ai;
    }

    public List<AdInfo> getAllAdInfo(){
        return this.adInfoDAL.getAllAdInfoByWhereClause();
    }
}
