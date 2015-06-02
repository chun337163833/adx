package com.xmxedu.oaken.cache;

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
  protected AdBasicData getAdDataByAdid(String adid) {
    return null;
  }

  @Override
  protected void putAdDataByAdid(String adid, AdBasicData value) {

  }

  @Override
  protected void initCache() {
    
  }

  @Override
  protected void disconnectCache() {

  }
}
