package com.xmxedu.oaken.biz;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmxedu.oaken.model.AdBasicData;
import com.xmxedu.oaken.model.AppInfo;
import com.xmxedu.oaken.sql.TbAdInfoTable;
import com.xmxedu.oaken.sql.TbAdTypeTable;
import com.xmxedu.oaken.sql.TbAppInfoTable;
import com.xmxedu.oaken.sql.TbBizAdShowtypeTable;
import com.xmxedu.oaken.sql.TbBizAppAdTable;

/**
 * 数据库中根据广告位id进行数据业务收集的工具类,根据最小粒度广告来映射整个数据
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public class AdBasicDataCollect {
  private final static Logger logger = LoggerFactory.getLogger(AdBasicDataCollect.class);

  public AdBasicData generate(TbAdInfoTable.Row row) {
    if (null == row) {
      return null;
    }

    AdBasicData data = new AdBasicData();

    // get showtype by adSlotId
    TbAdTypeTable.Row adType = getAdType(row.getID());
    data.setAdType(adType);
    
    // get appinfo by adSlotId
    AppInfo appInfo = getAppInfo(row.getID());
    data.setAppInfo(appInfo);

    return data;
  }

  private TbAdTypeTable.Row getAdType(int adSlotId) {
    if (adSlotId < 1) {
      return null;
    }

    TbAdTypeTable.Row row = null;
    try {
      TbBizAdShowtypeTable.Row biz =
          TbBizAdShowtypeTable
              .getRow(TbBizAdShowtypeTable.adidColumnName, String.valueOf(adSlotId));
      if (null == biz) {
        logger.error("Cannot get show type with given adSlotId of {} in {}", adSlotId,
            TbBizAdShowtypeTable.tableName);
        return null;
      }

      int showTypeId = biz.getShowtypeid();
      if (showTypeId < 1) {
        logger.error("Cannot find show type id in {}", TbBizAdShowtypeTable.tableName);
        return null;
      }

      row = TbAdTypeTable.getRow(TbAdTypeTable.idColumnName, String.valueOf(showTypeId));

    } catch (SQLException e) {
      logger.error("Get show type id in {} encounter an sql exception",TbBizAdShowtypeTable.tableName);
      logger.error(ExceptionUtils.getMessage(e));
    }
    return row;
  }
  
  private AppInfo getAppInfo(int adSlotId){
    if(adSlotId < 1){
      return null;
    }
    
    AppInfo appInfo = new AppInfo();
    try{
      TbBizAppAdTable.Row biz = TbBizAppAdTable.getRow(TbBizAppAdTable.adidColumnName, String.valueOf(adSlotId));
      if(null == biz){
        logger.error("Cannot find app id in {}",TbBizAppAdTable.tableName);
        return null;
      }
      
      TbAppInfoTable.Row row = TbAppInfoTable.getRow(TbAppInfoTable.idColumnName, String.valueOf(biz.getAppid()));
      // 设置app
      appInfo.setApp(row);
    }
    catch(SQLException e){
      logger.error("Get app id in {} encounter an sql exception",TbBizAppAdTable.tableName);
      logger.error(ExceptionUtils.getMessage(e));
    }
    return appInfo;
  }
}
