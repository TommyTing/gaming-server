package com.ooqiu.gaming.server.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义数据返回结构体
 */
@Data
public class BaseResult implements Serializable {

    //状态码
    private int status;

    //自当以消息
    private String msg;

    //请求的数据
    private Object data;

    public static BaseResult success(Object data){
        BaseResult result=new BaseResult();
        result.setStatus(200);
        result.setMsg("请求成功");
        result.setData(data);
        return result;
    }

    /**
     * 失败的请求
     * @param status 状态码
     * @param msg 消息
     * @return
     */
    public static BaseResult fail(int status,String msg){
        BaseResult result=new BaseResult();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }
}
