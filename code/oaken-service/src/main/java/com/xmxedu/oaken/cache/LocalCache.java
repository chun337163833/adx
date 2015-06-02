package com.xmxedu.oaken.cache;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.xmxedu.oaken.model.AdBasicData;

/**
 * 加载数据到本地缓存，读写的时候要注意同步锁的问题，采用原子引用的方式进行加载
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public class LocalCache extends Cache {

  private final static Logger logger = LoggerFactory.getLogger(LocalCache.class);
  private final static String name = "local cache";

  private HashMap<String, AdBasicData> data = Maps.newHashMap();

  @Override
  protected AdBasicData getAdDataByAdid(String adid) {
    if (data.containsKey(adid)) {
      return data.get(adid);
    }
    return null;
  }

  @Override
  protected void putAdDataByAdid(String adid, AdBasicData value) {
    if (Strings.isNullOrEmpty(adid)) {}
    if (null == value) {}
    data.put(adid, value);
  }

  @Override
  protected void initCache() {
    logger.info("Cache name is {}", name);
  }

  @Override
  protected void disconnectCache() {

  }

}
