package com.xmxedu.oaken.loadimpl;

import com.xmxedu.oaken.load.ILoadService;

/**
 * 定时将数据库中的数据加载到缓存中，缓存的方式采用依赖注入，数据是按照广告位为一个纬度进行组织的
 * 
 * @author xmzheng
 * @version 1.0.1
 */
public class LoadAdBasicData implements ILoadService {

  @Override
  public void loadDataAtFixedTime() {

  }
}
