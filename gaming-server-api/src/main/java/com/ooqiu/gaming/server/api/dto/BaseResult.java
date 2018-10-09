package com.ooqiu.gaming.server.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义数据返回结构体
 */
@Data
public class BaseResult implements Serializable {

    //状态码
    private int state;

    //自当以消息
    private String msg;

    //请求的数据
    private Object data;

    public static BaseResult success(Object data){
        BaseResult result=new BaseResult();
        result.setState(200);
        result.setMsg("请求成功");
        result.setData(data);
        return result;
    }
}
