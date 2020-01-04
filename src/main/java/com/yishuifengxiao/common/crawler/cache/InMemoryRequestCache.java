package com.yishuifengxiao.common.crawler.cache;

import java.util.HashSet;
import java.util.Set;

/**
 * 基于内存实现的资源缓存器
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月28日
 */
public class InMemoryRequestCache implements RequestCache {

    private final Set<String> cacheSet = new HashSet<>();

    @Override
    public synchronized void save(String cacheName, String value) {
        if (value != null) {
            cacheSet.add(value);
        }
    }

    @Override
    public boolean lookAndCache(String cacheName, String value) {
        boolean exist = this.exist(cacheName, value);
        this.save(cacheName, value);
        return exist;
    }

    @Override
    public Boolean exist(String cacheName, String value) {
        return this.cacheSet.contains(value);
    }

    @Override
    public synchronized void remove(String cacheName) {
        this.cacheSet.clear();
    }

    @Override
    public Long getCount(String cacheName) {
        return (long) this.cacheSet.size();
    }
}
