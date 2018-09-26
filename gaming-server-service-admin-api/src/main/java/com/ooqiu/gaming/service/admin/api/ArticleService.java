package com.ooqiu.gaming.service.admin.api;

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
}
