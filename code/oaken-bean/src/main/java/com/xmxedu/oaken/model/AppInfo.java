package com.xmxedu.oaken.model;

import com.xmxedu.oaken.sql.TbAppCategoryTable;
import com.xmxedu.oaken.sql.TbAppInfoTable;
import com.xmxedu.oaken.sql.TbUserTable;

/**
 * 媒体信息，包括所属用户和分类，此类需要经过数据库加载后进行使用
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public class AppInfo {
  private TbUserTable.Row user = null;
  private TbAppInfoTable.Row app = null;
  private TbAppCategoryTable.Row appCategory = null;

  public TbUserTable.Row getUser() {
    return user;
  }

  public void setUser(TbUserTable.Row user) {
    this.user = user;
  }

  public TbAppCategoryTable.Row getAppCategory() {
    return appCategory;
  }

  public void setAppCategory(TbAppCategoryTable.Row appCategory) {
    this.appCategory = appCategory;
  }

  public TbAppInfoTable.Row getApp() {
    return app;
  }

  public void setApp(TbAppInfoTable.Row app) {
    this.app = app;
  }
}
