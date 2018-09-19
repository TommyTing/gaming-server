package com.ooqiu.gaming.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.commons.utils.IdUtils;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.service.admin.api.ChannelService;
import com.ooqiu.gaming.service.admin.mapper.ChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 频道接口实现
 * Created by admin on 2018/8/29.
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public List<Channel> getAll() {
        return channelMapper.selectAll();
    }

    @Override
    public Channel getById(Long id) {
        return null;
    }

    @Override
    public int save(Channel channel) {
        channel.setId(IdUtils.genId());
        channel.setIsParent("1");//默认不是
        channel.setCreateDate(new Date());
        channel.setUpdateDate(new Date());

        //判断是否父级频道
        if (channel.getPid() == null || channel.getPid() == 0L) {
            channel.setIsParent("0");
            channel.setPid(0L);
        }

        return channelMapper.insert(channel);
    }

    @Override
    public List<Channel> selectByPid(Long pid) {
        Example example = new Example(Channel.class);
        example.createCriteria().andEqualTo("pid", pid);
        return channelMapper.selectByExample(example);
    }
}
