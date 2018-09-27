package com.ooqiu.gaming.service.admin.api;

import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Article;

/**
 * 文章管理
 */
public interface ArticleService {

    /**
     * 保存文章
     * @param article
     * @return
     */
    public int save(Article article);

    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 页大小
     * @return
     */
    public PageInfo<Article> page(int page,int pageSize);
}
