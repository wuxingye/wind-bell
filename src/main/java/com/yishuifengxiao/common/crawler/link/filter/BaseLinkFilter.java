package com.yishuifengxiao.common.crawler.link.filter;

import org.apache.commons.lang3.StringUtils;

import com.yishuifengxiao.common.crawler.link.filter.impl.NothingLinkFilter;

/**
 * 抽象链接过滤器
 * 
 * @author yishui
 * @version 1.0.0
 * @date 2019/11/20
 */
public abstract class BaseLinkFilter {
	/**
	 * 下一个处理器
	 */
	private BaseLinkFilter next;

	/**
	 * 处理链接
	 * 
	 * @param path 当前正在解析的网页的地址
	 * @param url  当前网页中提取出来的需要处理的网页地址
	 * @return
	 */
	public String handle(String path, String url) {
		if (!StringUtils.isNoneBlank(path, url)) {
			return null;
		}
		return this.handle(null != next ? next : new NothingLinkFilter(null), path, url);
	}
    /**
     * 执行链接处理操作
     * @param next 下一个过滤器
     * @param path 当前正在解析的网页的地址
     * @param url 当前网页中提取出来的需要处理的网页地址
     * @return
     */
	protected abstract String handle(BaseLinkFilter next, String path, String url);

	public BaseLinkFilter(BaseLinkFilter next) {
		this.next = next;
	}

}
