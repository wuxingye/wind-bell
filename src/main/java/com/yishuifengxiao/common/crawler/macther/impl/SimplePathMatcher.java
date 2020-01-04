package com.yishuifengxiao.common.crawler.macther.impl;

import com.yishuifengxiao.common.crawler.domain.constant.RuleConstant;
import com.yishuifengxiao.common.crawler.macther.PathMatcher;
import com.yishuifengxiao.common.crawler.utils.RegexFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * 简单路径匹配器
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月20日
 */
public class SimplePathMatcher implements PathMatcher {

    @Override
    public boolean match(String pattern, String url) {
        if (!StringUtils.isNoneBlank(pattern, url)) {
            return false;
        }
        if (StringUtils.equalsAnyIgnoreCase(pattern, RuleConstant.ANT_MATCH_ALL, RuleConstant.REGEX_MATCH_ALL)) {
            return true;
        }
        // 判断当前网页是否符合内容提取页的提取提取规则
        if (RegexFactory.match(pattern, url)) {
            return true;
        }
        return false;
    }
}
