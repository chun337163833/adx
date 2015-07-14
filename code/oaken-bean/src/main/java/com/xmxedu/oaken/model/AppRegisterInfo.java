package com.xmxedu.oaken.model;

import com.xmxedu.oaken.sql.TbAppInThirdpartyTable;
import com.xmxedu.oaken.sql.TbBizAppRelationshipTable;
import com.xmxedu.oaken.sql.TbThirdpartyTable;

/**
 * 媒体在第三方平台的注册信息，第三方平台对媒体的审核，广告位的产生，需要与本平台进行映射 其中包括第三方平台的信息，通过广告位进行关联
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public class AppRegisterInfo {
  private TbAppInThirdpartyTable.Row appRegister = null;
  private TbThirdpartyTable.Row thirdParty = null;
  private TbBizAppRelationshipTable.Row appMap = null;

  public TbAppInThirdpartyTable.Row getAppRegister() {
    return appRegister;
  }

  public void setAppRegister(TbAppInThirdpartyTable.Row appRegister) {
    this.appRegister = appRegister;
  }

  public TbThirdpartyTable.Row getThirdParty() {
    return thirdParty;
  }

  public void setThirdParty(TbThirdpartyTable.Row thirdParty) {
    this.thirdParty = thirdParty;
  }

  public TbBizAppRelationshipTable.Row getAppMap() {
    return appMap;
  }

  public void setAppMap(TbBizAppRelationshipTable.Row appMap) {
    this.appMap = appMap;
  }
}
