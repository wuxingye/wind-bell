package com.yishuifengxiao.common.crawler.extractor.content;

import com.yishuifengxiao.common.crawler.domain.model.ContentItem;
import com.yishuifengxiao.common.crawler.domain.model.FieldExtractRule;
import com.yishuifengxiao.common.crawler.extractor.content.strategy.Strategy;
import com.yishuifengxiao.common.crawler.extractor.content.strategy.StrategyFactory;

import java.util.List;

/**
 * 简单内容提取器
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019-11-5
 */
public class SimpleContentExtractor extends AbstractContentExtractor {

    public SimpleContentExtractor(ContentItem contentRule) {
        super(contentRule);
    }

    @Override
    public Object extract(String input, List<FieldExtractRule> fieldExtractRules) {
        // 获取到所有的处理规则
        for (FieldExtractRule extractRule : fieldExtractRules) {
            Strategy strategy = StrategyFactory.get(extractRule.getRule());
            if (strategy == null) {
                continue;
            }
            input = strategy.extract(input, extractRule.getParam1(), extractRule.getParam2());
        }
        return input;
    }
}
