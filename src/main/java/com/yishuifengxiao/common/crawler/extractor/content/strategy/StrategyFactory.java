package com.yishuifengxiao.common.crawler.extractor.content.strategy;

import com.yishuifengxiao.common.crawler.domain.eunm.Rule;
import com.yishuifengxiao.common.crawler.extractor.content.strategy.impl.*;

/**
 * 提取策略工厂
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019-11-7
 */
public class StrategyFactory {

    /**
     * 根据规则生成内容提取器
     *
     * @param rule
     * @return
     */
    public static Strategy get(Rule rule) {
        Strategy strategy = null;
        switch (rule) {
            case ALL:
                strategy = new AllStrategy();
                break;
            case CSS:
                strategy = new CssStrategy();
                break;
            case XPATH:
                strategy = new XpathStrategy();
                break;
            case REGEX:
                strategy = new RegexStrategy();
                break;
            case REPLACE:
                strategy = new ReplaceStrategy();
                break;
            case REMOVE:
                strategy = new RemoveStrategy();
                break;
            case CONSTANT:
                strategy = new ConstantStrategy();
                break;
            case CHN:
                strategy = new ChnStrategy();
                break;
            case NUM:
                strategy = new NumStrategy();
                break;
            case EMAIL:
                strategy = new EmailStrategy();
                break;
            case TEXT:
                strategy = new CssTextStrategy();
                break;
            case DOMAIN:
                strategy = new DomainStrategy();
                break;
            case URL:
                strategy = new UrlStrategy();
                break;
            case SYSTEM:
                strategy = new SystemStrategy();
                break;
            case ARRAY:
                strategy = new ArrayStrategy();
                break;
            default:
                break;
        }
        return strategy;
    }
}
