package com.xmxedu.oaken.dao;

import com.xmxedu.oaken.sql.BizAdShowType;

/**
 * 广告位对应的展示类型，映射关系表
 * @version 1.0.0
 */
public interface BizAdShowTypeRepository {
    public BizAdShowType getBizAdShowTypeById(int id);
    public BizAdShowType getBizAdShowTypeByAdId(int adId);
    public BizAdShowType getBizAdShowTypeByShowTypeId(int showTypeId);
}