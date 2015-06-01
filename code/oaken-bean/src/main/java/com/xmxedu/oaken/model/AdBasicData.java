package com.xmxedu.oaken.model;

import com.xmxedu.oaken.sql.TbAdInfoTable;

/**
 * 一次广告请求中所包含的所有基础信息，广告位，媒体，第三方平台
 * 
 * @author xmzheng
 * 
 */
public class AdBasicData {
  public TbAdInfoTable.Row adInfo = null;
  public AppRegisterInfo registerInfo = null;
  public AppInfo appInfo = null;
}
