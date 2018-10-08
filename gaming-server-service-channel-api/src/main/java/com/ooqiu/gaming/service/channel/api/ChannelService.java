package com.ooqiu.gaming.service.channel.api;

import com.ooqiu.gaming.server.domain.Channel;

import java.util.List;

/**
 * 频道接口
 */
public interface ChannelService {
    /**
     * 查询全部频道
     *
     * @return
     */
    public List<Channel> selectAll();
}
