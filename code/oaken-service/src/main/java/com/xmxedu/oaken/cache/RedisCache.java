package com.xmxedu.oaken.cache;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmxedu.oaken.model.AdBasicData;

/**
 * Redis 来做分布式缓存，调用的时候必须初始化
 * @author xmzheng
 * @version 1.0.1
 */
public class RedisCache extends Cache {
  
  private final static Logger logger = LoggerFactory.getLogger(RedisCache.class);

  @Override
  public AdBasicData getAdDataByAdid(String adid) {
    return null;
  }

  @Override
  public void putAdDataByAdid(String adid, AdBasicData value) {

  }

  @Override
  public void initCache() {
    
  }

  @Override
  public void disconnectCache() {

  }

  @Override
  public String getCacheName() {
    return "Redis Cache";
  }

  @Override
  public void setAdBasicData(HashMap<String, AdBasicData> data) {
    // TODO Auto-generated method stub
    
  }
}
