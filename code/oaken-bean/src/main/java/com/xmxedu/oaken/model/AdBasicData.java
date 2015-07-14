package com.xmxedu.oaken.model;

import com.xmxedu.oaken.sql.TbAdInfoTable;
import com.xmxedu.oaken.sql.TbAdTypeTable;

/**
 * 一次广告请求中所包含的所有基础信息，广告位，媒体，第三方平台
 * 
 * @author xmzheng
 * 
 */
public class AdBasicData {
  private TbAdInfoTable.Row adInfo = null;
  private TbAdTypeTable.Row adType = null;
  private AppRegisterInfo registerInfo = null;
  private AppInfo appInfo = null;
  public TbAdInfoTable.Row getAdInfo() {
    return adInfo;
  }
  public void setAdInfo(TbAdInfoTable.Row adInfo) {
    this.adInfo = adInfo;
  }
  public TbAdTypeTable.Row getAdType() {
    return adType;
  }
  public void setAdType(TbAdTypeTable.Row adType) {
    this.adType = adType;
  }
  public AppRegisterInfo getRegisterInfo() {
    return registerInfo;
  }
  public void setRegisterInfo(AppRegisterInfo registerInfo) {
    this.registerInfo = registerInfo;
  }
  public AppInfo getAppInfo() {
    return appInfo;
  }
  public void setAppInfo(AppInfo appInfo) {
    this.appInfo = appInfo;
  }
}
