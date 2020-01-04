package com.yishuifengxiao.common.crawler.pool;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ThreadFactory;

/**
 * 线程工厂
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月28日
 */
public class SimpleThreadFactory implements ThreadFactory {

    private String name;

    public SimpleThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(this.name + ":" + RandomUtils.nextInt());
        return thread;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
