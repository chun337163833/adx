package com.xmxedu.oaken.biz;

import com.xmxedu.oaken.sql.AdInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据库中根据广告位id进行数据业务收集的工具类,根据最小粒度广告来映射整个数据
 * 将数据库中的数据进行收集，并提供一个完整广告位的广告请求数据
 * @author xmzheng
 * @version 1.0.1
 */
@Service
public class AdBasicDataCollect {
  private final static Logger logger = LoggerFactory.getLogger(AdBasicDataCollect.class);

  @Autowired
  private Adinfo

  public AdInfo getAdInfoByShowId(String showId){
      if (StringUtils.isBlank(showId)){
          logger.error("empty showid from Ad Basic Data Collect");
          return null;
      }


  }
}
