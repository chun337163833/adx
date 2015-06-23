package com.xmxedu.oaken.cache;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

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

  private AtomicReference<HashMap<String, AdBasicData>> atomicReference =
      new AtomicReference<HashMap<String, AdBasicData>>(null);

  public void setAdBasicData(HashMap<String, AdBasicData> data) {
    atomicReference.set(data);
    this.data = atomicReference.getAndSet(data);
  }

  @Override
  protected AdBasicData getAdDataByAdid(String adid) {
    if (data.containsKey(adid)) {
      return data.get(adid);
    }
    logger.warn("Cannot get ad Data by adid of {} in {} .", adid, LocalCache.name);
    return null;
  }

  @Override
  protected void putAdDataByAdid(String adid, AdBasicData value) {
    if (Strings.isNullOrEmpty(adid)) {
      logger.warn("The parameters of adid is null!");
      return;
    }
    if (null == value) {
      logger.warn("Cannot set a key with nullable value in {}", LocalCache.name);
      return;
    }
    data.put(adid, value);
  }

  @Override
  protected void initCache() {
    logger.info("Cache name is {}", name);
    if (this.data.isEmpty()) {
      logger.warn("{} u must collect the data and inovke its fuction of 'setAdBasicData' first",
          LocalCache.class.getCanonicalName());
      return;
    } else {
      logger.info("{} initialize the Cache correctlly, and its size is {}",
          LocalCache.class.getCanonicalName(), this.data.size());
    }

  }

  @Override
  protected void disconnectCache() {

  }

}
