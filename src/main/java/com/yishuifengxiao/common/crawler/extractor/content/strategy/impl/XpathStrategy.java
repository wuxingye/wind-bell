package com.yishuifengxiao.common.crawler.extractor.content.strategy.impl;

import com.yishuifengxiao.common.crawler.domain.constant.CrawlerConstant;
import com.yishuifengxiao.common.crawler.extractor.content.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import us.codecraft.xsoup.Xsoup;

import java.util.List;

/**
 * XPATH提取
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019-11-7
 */
@Slf4j
public class XpathStrategy implements Strategy {

    @Override
    public String extract(String input, String param1, String param2) {
        if (!StringUtils.isNoneBlank(input, param1)) {
            return "";
        }
        try {
            List<String> list = Xsoup.compile(param1).evaluate(Jsoup.parse(input)).list();
            return String.join(CrawlerConstant.SEPARATOR, list);
        } catch (Exception e) {
            log.info("使用【XPATH规则】 提取 {} 时出现问题，提取参数为 param1= {} ,param2 = {},问题为 {}", input, param1, param2, e.getMessage());
        }
        return "";
    }
}
