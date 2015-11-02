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
  public abstract void setAdBasicData(HashMap<String, AdBasicData> data);
  public abstract AdBasicData getAdDataByAdid(String adid);

  public abstract void putAdDataByAdid(String adid, AdBasicData value);

  public abstract void initCache();

  public abstract void disconnectCache();
  
  public abstract String getCacheName();
}
