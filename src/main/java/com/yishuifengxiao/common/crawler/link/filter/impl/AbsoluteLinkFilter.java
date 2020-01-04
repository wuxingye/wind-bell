package com.yishuifengxiao.common.crawler.link.filter.impl;

import com.yishuifengxiao.common.crawler.domain.constant.RuleConstant;
import com.yishuifengxiao.common.crawler.link.filter.BaseLinkFilter;
import com.yishuifengxiao.common.crawler.utils.LinkUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 绝对地址链接过滤器<br/>
 * 处理绝对地址链接
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019/11/20
 */
public class AbsoluteLinkFilter extends BaseLinkFilter {

    public AbsoluteLinkFilter(BaseLinkFilter next) {
        super(next);
    }

    @Override
    public String handle(BaseLinkFilter next, String path, String url) {
        if (StringUtils.startsWith(url, RuleConstant.ABSOLUTE_ADDR_LINK)) {
            // 绝对地址
            // 保证地址的形式为 / 开头，而不是//开头
            //提取出协议和域名
            String protocolAndHost = LinkUtils.extractProtocolAndHost(path);
            return null == protocolAndHost ? null : new StringBuffer(protocolAndHost).append(url).toString();
        }
        return next.handle(path, url);
    }
}
