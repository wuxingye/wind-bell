package com.yishuifengxiao.common.crawler.content;

import com.yishuifengxiao.common.crawler.domain.entity.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

/**
 * 内容解析器装饰器<br/>
 * 进行内容解析前的前置操作<br/>
 * 功能如下：<br/>
 * 1. 决定是否对该网页进行内容提取<br/>
 * 2. 调用真正的内容解析器进行内容解析
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月26日
 */
@Slf4j
public abstract class BaseContentExtractDecorator implements ContentExtract {

    /**
     * 内容页url的规则，只有满足此规则的网页才会被解析
     */
    protected String contentExtractRules;
    /**
     * 风铃虫处理器，负责解析下载后的网页内容
     */
    protected ContentExtract contentExtract;

    public BaseContentExtractDecorator(String contentExtractRules, ContentExtract contentExtract) {
        this.contentExtractRules = contentExtractRules;
        this.contentExtract = contentExtract;
    }

    @Override
    public void extract(final Page page) throws Exception {
        if (null != page && HttpStatus.SC_OK == page.getCode()) {
            // 判断是否符合内容页规则
            boolean match = this.matchContentExtractRule(this.contentExtractRules, page.getUrl());
            log.debug("Whether the web page [{}] matches the content page parsing rule is {}", page.getUrl(), match);
            if (match && null != page.getRedirectUrl()) {
                // 判断重定向之后的页面是否满足内容也规则
                match = this.matchContentExtractRule(this.contentExtractRules, page.getRedirectUrl());
            }
            page.setSkip(!match);
            if (match) {
                // 开始真正的内容解析操作
                this.contentExtract.extract(page);
            }
        }
    }

    /**
     * 是否符合内容页解析规则
     *
     * @param contentExtractRules 内容页规则
     * @param url                 需要提取的目标页面的地址
     * @return
     */
    protected abstract boolean matchContentExtractRule(String contentExtractRules, String url);
}
