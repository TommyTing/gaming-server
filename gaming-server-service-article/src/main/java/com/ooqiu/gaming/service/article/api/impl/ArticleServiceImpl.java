package com.ooqiu.gaming.service.article.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.service.article.api.ArticleService;
import com.ooqiu.gaming.service.article.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

/**
 * 文章接口
 */

@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ARTICLE)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> selectAll(int pageNum, int pageSize) {
        Example example=new Example(Article.class);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Article> pageInfo=new PageInfo<>(articleMapper.selectByExample(example));
        return pageInfo;
    }

    @Override
    public PageInfo<Article> selectByChannelId(int pageNum, int pageSize, long channelId) {
        Example example=new Example(Article.class);
        example.createCriteria().andEqualTo("channelId",channelId);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Article> pageInfo=new PageInfo<>(articleMapper.selectByExample(example));
        return pageInfo;
    }

    @Override
    public PageInfo<Article> selectBtType(int pageNum, int pageSize, String type) {
        Example example=new Example(Article.class);
        example.createCriteria().andEqualTo("type",type);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Article> pageInfo=new PageInfo<>(articleMapper.selectByExample(example));
        return pageInfo;
    }
}
