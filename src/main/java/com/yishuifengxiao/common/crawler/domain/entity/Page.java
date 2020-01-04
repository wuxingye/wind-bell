package com.yishuifengxiao.common.crawler.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

/**
 * 风铃虫页面对象
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月26日
 */
@Data
@Accessors(chain = true)
public class Page {

    /**
     * 风铃虫下载页面是的响应码
     */
    private int code;
    /**
     * 对应页面的请求信息
     */
    private String url;
    /**
     * 具备重定向功能的下载器在请求时重定向之后的地址
     */
    private String redirectUrl;
    /**
     * 对应的页面的原始文本
     */
    private String rawTxt;
    /**
     * 该页面里所有的超链接
     */
    private List<String> links;
    /**
     * 该页面里所有提取出来的数据
     */
    private Map<String, Object> outData = new WeakHashMap<>();
    /**
     * 是否跳过该页面的解析
     */
    private boolean isSkip;

    public Page(String url) {
        this.url = url;
    }

    /**
     * 在原来的链接地址集合里增加新的链接信息
     *
     * @param links
     * @return
     */
    public Page addLinks(List<String> links) {
        Assert.notNull(links, "目标链接集合不能为空");
        if (this.links == null) {
            this.links = new ArrayList<>();
        }
        this.links.addAll(links.parallelStream().filter(StringUtils::isNotBlank).collect(Collectors.toSet()));
        return this;
    }

    /**
     * 清空链接地址
     *
     * @return
     */
    public Page clearLinks() {
        this.links = new ArrayList<>();
        return this;
    }

    /**
     * 设置输出数据<br/>
     * 会替换原始的输出输出
     *
     * @param data
     * @return
     */
    public Page setResultItem(Map<String, Object> data) {
        Assert.notNull(data, "设置的数据不能为空");
        this.outData.clear();
        this.addResultItem(data);
        return this;
    }

    /**
     * 增加输出数据
     *
     * @param data
     * @return
     */
    public Page addResultItem(Map<String, Object> data) {
        Assert.notNull(data, "设置的数据不能为空");
        this.outData.putAll(data);
        return this;
    }

    /**
     * 增加输出数据
     *
     * @param key
     * @param value
     * @return
     */
    public Page addResultItem(String key, Object value) {
        Assert.notNull(key, "输出结果的键值不能为空");
        this.outData.put(key, value);
        return this;
    }

    public Object getResultItem(String key) {
        Assert.notNull(key, "输出结果的键值不能为空");
        return this.outData.get(key);
    }

    public boolean containResultItem(String key) {
        Assert.notNull(key, "输出结果的键值不能为空");
        return this.outData.containsKey(key);
    }
}
