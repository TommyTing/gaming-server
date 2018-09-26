package com.ooqiu.gaming.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.commons.utils.IdUtils;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.service.admin.api.ArticleService;
import com.ooqiu.gaming.service.admin.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 保存文章
 */

@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int save(Article article) {
        article.setId(IdUtils.genId());
        article.setCreateDate(new Date());
        article.setUpdateDate(new Date());
        return articleMapper.insert(article);
    }
}
