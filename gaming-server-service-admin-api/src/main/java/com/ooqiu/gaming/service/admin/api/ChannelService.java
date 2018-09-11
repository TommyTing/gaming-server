package com.ooqiu.gaming.service.admin.api;

import com.ooqiu.gaming.server.domain.Channel;

import java.util.List;

/**
 * 频道接口
 * Created by admin on 2018/8/29.
 */
public interface ChannelService {

    /*
    查询所有频道
     */
    public List<Channel> getAll();

    /**
     * 根据 Id 查询频道
     *
     * @param id
     * @return
     */
    public Channel getById(Long id);

    /**
     * 保存频道
     * @param channel
     * @return
     */
    public int save(Channel channel);
}
