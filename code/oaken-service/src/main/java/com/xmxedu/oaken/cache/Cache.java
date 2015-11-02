package com.xmxedu.oaken.cache;

import java.util.HashMap;

import com.xmxedu.oaken.model.AdBasicData;

/**
 * 分布式的缓存，将实现分离，提高组件的可扩展性，目前采用Redis的方式进行读存
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public abstract class Cache {
  // 设置广告中媒体的数据信息
  public abstract void setAdBasicData(HashMap<String, AdBasicData> data);
  // 根据广告位来获取其对应的广告，媒体，所有者信息
  public abstract AdBasicData getAdDataByAdid(String adid);
  // 将某个广告位的数据信息加入缓存中
  public abstract void putAdDataByAdid(String adid, AdBasicData value);
  // 初始化缓存的相关配置
  public abstract void initCache();
  // 关闭缓存，释放相关资源
  public abstract void disconnectCache();
  // 获取缓存的名字
  public abstract String getCacheName();
}
