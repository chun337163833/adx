package com.xmxedu.oaken.model;

import com.xmxedu.oaken.sql.*;

/**
 * 一次广告请求中所包含的所有基础信息，广告位，媒体，第三方平台
 * 
 * @author xmzheng
 * 
 */
public class AdBasicData {
  
  private AppInfo appInfo;
  private AdInfo adInfo;
  private AdType adType;
  private AppCategory appCategory;
  private AppInOtherPlatform aop;
  private AppOS appOS;
  private ThirdPlatform tp;

  public AppInfo getAppInfo() {
    return appInfo;
  }

  public void setAppInfo(AppInfo appInfo) {
    this.appInfo = appInfo;
  }

  public AdInfo getAdInfo() {
    return adInfo;
  }

  public void setAdInfo(AdInfo adInfo) {
    this.adInfo = adInfo;
  }

  public AdType getAdType() {
    return adType;
  }

  public void setAdType(AdType adType) {
    this.adType = adType;
  }

  public AppCategory getAppCategory() {
    return appCategory;
  }

  public void setAppCategory(AppCategory appCategory) {
    this.appCategory = appCategory;
  }

  public AppInOtherPlatform getAop() {
    return aop;
  }

  public void setAop(AppInOtherPlatform aop) {
    this.aop = aop;
  }

  public AppOS getAppOS() {
    return appOS;
  }

  public void setAppOS(AppOS appOS) {
    this.appOS = appOS;
  }

  public ThirdPlatform getTp() {
    return tp;
  }

  public void setTp(ThirdPlatform tp) {
    this.tp = tp;
  }
}
