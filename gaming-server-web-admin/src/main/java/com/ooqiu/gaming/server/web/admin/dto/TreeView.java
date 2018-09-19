package com.ooqiu.gaming.server.web.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 前端树控件
 */
@Data
public class TreeView implements Serializable {
    private String id;
    private String icon;
    private String text;
    private boolean children;
}
