package com.xmxedu.oaken.biz;

import com.xmxedu.oaken.cache.LocalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 定时任务，定时的将数据库中的数据加载到Cache中
 * @version 1.0.0
 */
@Service
public class AdxListener {

    @Autowired
    private LocalCache localCache;

    public void loadSQLIntoCacheAtFixedTime(long fixedTime){
        if (fixedTime < 0)
        {
            return;
        }
    }
}
