package com.xmxedu.oaken.cache;

import java.util.HashMap;

import com.xmxedu.oaken.model.AdBasicData;

/**
 * 分布式的缓存，将实现分离，提高组件的可扩展性，目前采用Redis的方式进行读存
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public interface Cache {
  // put into data by a hash map
  public void setAdBasicData(HashMap<String, AdBasicData> data);

  // get a ad basic data by a ad id
  public AdBasicData getAdDataByAdid(String adid);

  // put a ad basic data with a ad id key
  public void putAdDataByAdid(String adid, AdBasicData value);

  // initialize the cache if you have extra operation
  public void initCache();

  // disconnect a cache when u do not using it
  public void disconnectCache();

  // get the same of your cache name,such as localCache,redisCache
  public String getCacheName();
}
