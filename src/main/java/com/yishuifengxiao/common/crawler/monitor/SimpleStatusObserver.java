package com.yishuifengxiao.common.crawler.monitor;

import com.yishuifengxiao.common.crawler.Task;
import com.yishuifengxiao.common.crawler.domain.eunm.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认实现的风铃虫状态监视器
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月29日
 */
@Slf4j
public class SimpleStatusObserver implements StatusObserver {

    @Override
    public void update(Task task, Status status) {
        log.debug("风铃虫 {} 的状态发生变化了，变化之后的状态为 {}", task.getName(), status);
    }
}
