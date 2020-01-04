package com.yishuifengxiao.common.crawler.content;

import com.yishuifengxiao.common.crawler.domain.entity.Page;

/**
 * 内容解析器<br/>
 * 功能如下：<br/>
 * 1 解析下载的原始数据<br/>
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月26日
 */
public interface ContentExtract {

    /**
     * 从网页内容里解析出所有符合要求的数据
     *
     * @param page
     * @throws Exception
     */
    void extract(final Page page) throws Exception;
}
