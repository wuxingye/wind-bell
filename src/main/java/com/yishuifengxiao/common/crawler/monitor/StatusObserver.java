package com.yishuifengxiao.common.crawler.monitor;

import com.yishuifengxiao.common.crawler.Task;
import com.yishuifengxiao.common.crawler.domain.eunm.Status;

/**
 * 风铃虫状态观察者<br/>
 * 监控风铃虫状态的变化
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月28日
 */
public interface StatusObserver {

    /**
     * 任务的状态发生了变化
     *
     * @param task   任务
     * @param status 变化之后的状态
     */
    void update(final Task task, final Status status);
}
