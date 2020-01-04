package com.yishuifengxiao.common.crawler.pipeline;

import com.yishuifengxiao.common.crawler.domain.entity.ResultData;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认实现的信息输出器<br/>
 * 输出信息到日志
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月28日
 */
@Slf4j
public class SimplePipeline implements Pipeline {

    private final static String SEPARATOR = System.getProperty("line.separator");

    @Override
    public void recieve(ResultData resultData) {
        log.debug(SEPARATOR);
        log.info("{} request : {} , out data : {} {}", SEPARATOR, resultData.getUrl(), resultData.getAllData(),
            SEPARATOR);
    }
}
