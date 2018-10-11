package com.ooqiu.gaming.service.search.domain;

import java.io.Serializable;

/**
 * 自定义搜索结果集
 */
public class SearchResult implements Serializable {
    private long id;
    private String article_title;
    private String getArticle_url;
    private String getArticle_source;
    private String getArticle_introduction;
    private String getArticle_cover;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getGetArticle_url() {
        return getArticle_url;
    }

    public void setGetArticle_url(String getArticle_url) {
        this.getArticle_url = getArticle_url;
    }

    public String getGetArticle_source() {
        return getArticle_source;
    }

    public void setGetArticle_source(String getArticle_source) {
        this.getArticle_source = getArticle_source;
    }

    public String getGetArticle_introduction() {
        return getArticle_introduction;
    }

    public void setGetArticle_introduction(String getArticle_introduction) {
        this.getArticle_introduction = getArticle_introduction;
    }

    public String getGetArticle_cover() {
        return getArticle_cover;
    }

    public void setGetArticle_cover(String getArticle_cover) {
        this.getArticle_cover = getArticle_cover;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "id=" + id +
                ", article_title='" + article_title + '\'' +
                ", getArticle_url='" + getArticle_url + '\'' +
                ", getArticle_source='" + getArticle_source + '\'' +
                ", getArticle_introduction='" + getArticle_introduction + '\'' +
                ", getArticle_cover='" + getArticle_cover + '\'' +
                '}';
    }
}
