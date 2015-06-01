package com.xmxedu.oaken.cache;

import com.xmxedu.oaken.model.AdBasicData;

/**
 * 分布式的缓存，将实现分离，提高组件的可扩展性，目前采用Redis的方式进行读存
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public abstract class Cache {
  protected abstract AdBasicData getAdDataByAdid(String adid);

  protected abstract void setAdDataByAdid(String adid, AdBasicData value);

  protected abstract void initCache();

  protected abstract void disconnectCache();
}
