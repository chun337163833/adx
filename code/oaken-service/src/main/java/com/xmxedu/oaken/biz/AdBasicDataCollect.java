package com.xmxedu.oaken.biz;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmxedu.oaken.model.AdBasicData;
import com.xmxedu.oaken.model.AppInfo;
import com.xmxedu.oaken.model.AppRegisterInfo;
import com.xmxedu.oaken.sql.TbAdInfoTable;
import com.xmxedu.oaken.sql.TbAdTypeTable;
import com.xmxedu.oaken.sql.TbAppCategoryTable;
import com.xmxedu.oaken.sql.TbAppInThirdpartyTable;
import com.xmxedu.oaken.sql.TbAppInfoTable;
import com.xmxedu.oaken.sql.TbBizAdShowtypeTable;
import com.xmxedu.oaken.sql.TbBizAppAdTable;
import com.xmxedu.oaken.sql.TbBizAppCategoryTable;
import com.xmxedu.oaken.sql.TbBizAppRelationshipTable;
import com.xmxedu.oaken.sql.TbBizUserAppTable;
import com.xmxedu.oaken.sql.TbThirdpartyTable;
import com.xmxedu.oaken.sql.TbUserTable;

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

    // get app register info by adSlotId

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
      logger.error("Get show type id in {} encounter an sql exception",
          TbBizAdShowtypeTable.tableName);
      logger.error(ExceptionUtils.getMessage(e));
    }
    return row;
  }

  private AppInfo getAppInfo(int adSlotId) {
    if (adSlotId < 1) {
      return null;
    }

    AppInfo appInfo = null;
    try {
      TbBizAppAdTable.Row biz =
          TbBizAppAdTable.getRow(TbBizAppAdTable.adidColumnName, String.valueOf(adSlotId));
      if (null == biz) {
        logger.error("Cannot find app id in {}", TbBizAppAdTable.tableName);
        return null;
      }

      TbAppInfoTable.Row app =
          TbAppInfoTable.getRow(TbAppInfoTable.idColumnName, String.valueOf(biz.getAppid()));
      
      if(null == app){
        logger.error("Can not get app in {}",TbAppInfoTable.tableName);
        return null;
      }
      
      appInfo = new AppInfo();
      // 设置app
      appInfo.setApp(app);
      
      TbAppCategoryTable.Row category = getAppCategory(app.getID());
      TbUserTable.Row user = getUserInfo(app.getID());


      // 设置category
      appInfo.setAppCategory(category);
      // 设置用户信息
      appInfo.setUser(user);
    } catch (SQLException e) {
      logger.error("Get app id in {} encounter an sql exception", TbBizAppAdTable.tableName);
      logger.error(ExceptionUtils.getMessage(e));
    }
    return appInfo;
  }

  private TbAppCategoryTable.Row getAppCategory(int appId) {
    if (appId < 0) {
      return null;
    }

    TbAppCategoryTable.Row row = null;
    try {
      TbBizAppCategoryTable.Row biz =
          TbBizAppCategoryTable
              .getRow(TbBizAppCategoryTable.appidColumnName, String.valueOf(appId));
      if (null == biz) {
        logger.error("Cannot find app id in {}", TbBizAppCategoryTable.tableName);
        return null;
      }
      row =
          TbAppCategoryTable.getRow(TbAppCategoryTable.idColumnName,
              String.valueOf(biz.getCategoryid()));
    } catch (SQLException e) {
      logger.error("Get app id in {} encounter an sql exception", TbBizAppCategoryTable.tableName);
      logger.error(ExceptionUtils.getMessage(e));
    }
    return row;
  }

  private TbUserTable.Row getUserInfo(int appId) {
    if (appId < 0) {
      return null;
    }
    TbUserTable.Row user = null;
    try {
      TbBizUserAppTable.Row biz =
          TbBizUserAppTable.getRow(TbBizUserAppTable.appidColumnName, String.valueOf(appId));
      if (null == biz) {
        logger.error("Cannot find app id in {}", TbBizUserAppTable.tableName);
        return null;
      }
      user = TbUserTable.getRow(TbUserTable.idColumnName, String.valueOf(biz.getUserid()));
    } catch (SQLException e) {
      logger.error("Get app id in {} encounter an sql exception", TbBizUserAppTable.tableName);
      logger.error(ExceptionUtils.getMessage(e));
    }
    return user;
  }

  private AppRegisterInfo getAppRegister(int adSlotId) {
    if (adSlotId < 0) {
      return null;
    }

    AppRegisterInfo appRegister = null;
    try {
      TbBizAppRelationshipTable.Row biz =
          TbBizAppRelationshipTable.getRow(TbBizAppRelationshipTable.ouradColumnName,
              String.valueOf(adSlotId));
      
      if(null == biz){
        logger.error("Can not find ad slot id in {}",TbBizAppRelationshipTable.tableName);
        return null;
      }
      
      appRegister = new AppRegisterInfo();
      appRegister.setAppMap(biz);
      
      TbAppInThirdpartyTable.Row appInThirdParty = TbAppInThirdpartyTable.getRow(TbAppInThirdpartyTable.idColumnName, String.valueOf(biz.getOtherplatformad()));
      if(null == appInThirdParty){
        logger.error("can not get app in third party with {}",biz.getOtherplatformad());
        return null;
      }
      
      appRegister.setAppRegister(appInThirdParty);
      TbThirdpartyTable.Row thirdParty = TbThirdpartyTable.getRow(TbThirdpartyTable.idColumnName, String.valueOf(appInThirdParty.getPlatformid()));
      appRegister.setThirdParty(thirdParty);
      
    } catch (SQLException e) {
      logger.error("generate app register encounter an sql exception");
      logger.error(ExceptionUtils.getMessage(e));
    }
    return appRegister;
  }
}
