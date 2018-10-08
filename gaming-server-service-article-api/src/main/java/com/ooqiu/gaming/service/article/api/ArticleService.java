package com.ooqiu.gaming.service.article.api;

import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Article;

/**
 * 文章接口
 */
public interface ArticleService {

    /**
     * 查询全部文章
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    public PageInfo<Article> selectAll(int pageNum,int pageSize);

    /**
     * 根据频道查询文章
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param channelId 频道 Id
     * @return
     */
    public PageInfo<Article> selectByChannelId(int pageNum,int pageSize,long channelId);

    /**
     * 根据文章类别查询文章
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param type 文章类别 1：文章 2：视频
     * @return
     */
    public PageInfo<Article> selectBtType(int pageNum,int pageSize,String type);
}
