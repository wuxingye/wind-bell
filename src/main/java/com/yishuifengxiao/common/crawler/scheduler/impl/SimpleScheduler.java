package com.yishuifengxiao.common.crawler.scheduler.impl;

import com.yishuifengxiao.common.crawler.scheduler.Scheduler;

import java.util.Collections;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 简单资源调度器
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月26日
 */
public class SimpleScheduler implements Scheduler {

    private Queue<String> queue = new ConcurrentLinkedQueue<>();

    @Override
    public synchronized void push(String... urls) {
        if (null != urls) {
            Collections.addAll(queue, urls);
        }
    }

    @Override
    public synchronized void clear() {
        this.queue.clear();
    }

    @Override
    public synchronized String poll() {
        return queue.poll();
    }

    @Override
    public String getName() {
        return UUID.randomUUID().toString();
    }
}
