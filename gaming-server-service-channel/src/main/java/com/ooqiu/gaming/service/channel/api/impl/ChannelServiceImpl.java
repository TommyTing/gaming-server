package com.ooqiu.gaming.service.channel.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.service.channel.api.ChannelService;
import com.ooqiu.gaming.service.channel.mapper.ChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_CHANNEL)
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public List<Channel> selectAll() {
        return channelMapper.selectAll();
    }
}
