package com.yishuifengxiao.common.crawler.builder;

import com.yishuifengxiao.common.crawler.content.ContentExtract;
import com.yishuifengxiao.common.crawler.domain.model.ContentRule;
import com.yishuifengxiao.common.crawler.domain.model.LinkRule;
import com.yishuifengxiao.common.crawler.link.LinkExtract;

/**
 * 解析器构造者
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年12月10日
 */
public interface ExtractBuilder {

    /**
     * 构建一个链接解析器
     *
     * @param link        链接解析规则
     * @param linkExtract 自定义链接解析器，允许为空
     * @return
     */
    LinkExtract createLinkExtract(LinkRule link, LinkExtract linkExtract);

    /**
     * 构造一个内容解析器
     *
     * @param content        内容解析规则
     * @param contentExtract 自定义内容解析器，允许为空
     * @return
     */
    ContentExtract createContentExtract(ContentRule content, ContentExtract contentExtract);
}
