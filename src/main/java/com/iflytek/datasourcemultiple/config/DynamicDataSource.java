package com.iflytek.datasourcemultiple.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yjwang46
 * 动态数据源管理器
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    {
        setLenientFallback(false);
    }

    /**
     * 返回使用的数据源 key 值
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 设置数据源
     *
     * @param db
     */
    public static void setDataSource(String db) {
        CONTEXT_HOLDER.set(db);
    }

    public static void remove() {
        CONTEXT_HOLDER.remove();
    }
}