package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.AppInOtherPlatform;
import org.springframework.stereotype.Service;

/**
 * 媒体再第三方平台中申请广告位时，对应的相关配置信息
 * @version 1.0.0
 */
@Service
public interface AppInOtherPlatformRepository {
    public AppInOtherPlatform getAppInOtherPlatformById(int id);
    public AppInOtherPlatform getAppInOtherPlatformByAppName(String appName);
    public AppInOtherPlatform getAppInOtherPlatformByAppId(String appId);
}
