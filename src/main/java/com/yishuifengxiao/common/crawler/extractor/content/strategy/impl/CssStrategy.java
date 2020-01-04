package com.yishuifengxiao.common.crawler.extractor.content.strategy.impl;

import com.yishuifengxiao.common.crawler.domain.constant.CrawlerConstant;
import com.yishuifengxiao.common.crawler.extractor.content.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用css规则提取<br/>
 * 此规则下提取出来的数据会包含html标签
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019-11-7
 */
@Slf4j
public class CssStrategy implements Strategy {

    @Override
    public String extract(String input, String param1, String param2) {
        if (!StringUtils.isNoneBlank(input, param1)) {
            return "";
        }
        List<String> out = new ArrayList<>();
        try {
            Document document = Jsoup.parse(input);
            Elements elements = document.select(param1);
            if (elements == null) {
                return "";
            }
            elements.forEach(e -> {
                if (StringUtils.isBlank(param2)) {
                    out.add(e.outerHtml());
                } else {
                    out.add(e.attr(param2));
                }
            });
        } catch (Exception e) {
            log.info("使用【css规则】 提取 {} 时出现问题，提取参数为 param1= {} ,param2 = {},问题为 {}", input, param1, param2,
                    e.getMessage());
        }
        return String.join(CrawlerConstant.SEPARATOR, out);
    }
}
