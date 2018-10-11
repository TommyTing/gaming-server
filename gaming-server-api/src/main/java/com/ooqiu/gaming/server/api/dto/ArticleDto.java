package com.ooqiu.gaming.server.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ArticleDto implements Serializable {
    private long id;
    private String type;
    private String source;
    private String title;
    private String url;
    private String introduction;
    private List<String> cover;
}
