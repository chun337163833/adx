package com.xmxedu.oaken.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmxedu.oaken.model.AdBasicData;

/**
 * 加载数据到本地缓存
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public class LocalCache extends Cache {

  private final static Logger logger = LoggerFactory.getLogger(LocalCache.class);
  private final static String name = "local cache";

  @Override
  protected AdBasicData getAdDataByAdid(String adid) {
    return null;
  }

  @Override
  protected void setAdDataByAdid(String adid, AdBasicData value) {

  }

  @Override
  protected void initCache() {
    logger.info("Cache name is {}", name);
  }

  @Override
  protected void disconnectCache() {

  }

}
