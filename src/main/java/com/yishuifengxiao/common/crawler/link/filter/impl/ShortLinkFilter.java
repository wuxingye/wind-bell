package com.yishuifengxiao.common.crawler.link.filter.impl;

import com.yishuifengxiao.common.crawler.domain.constant.RuleConstant;
import com.yishuifengxiao.common.crawler.link.filter.BaseLinkFilter;
import com.yishuifengxiao.common.crawler.utils.LinkUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 短链接链接过滤器<br/>
 * 处理以双斜杠开头的链接
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019/11/20
 */
public class ShortLinkFilter extends BaseLinkFilter {

    public ShortLinkFilter(BaseLinkFilter next) {
        super(next);
    }

    @Override
    public String handle(BaseLinkFilter next, String path, String url) {
        if (StringUtils.startsWith(url, RuleConstant.SHORT_ADDR_LINK)) {
            // 双斜杠开头
            // 提取出协议
            String protocol = LinkUtils.extractProtocol(path);
            return null == protocol ? null : new StringBuffer(protocol).append(":").append(url).toString();
        }
        return next.handle(path, url);
    }
}
