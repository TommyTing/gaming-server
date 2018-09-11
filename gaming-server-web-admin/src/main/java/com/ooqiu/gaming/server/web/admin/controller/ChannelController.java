package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.service.admin.api.ChannelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2018/9/4.
 */

@RequestMapping(value = "channel")
@Controller
public class ChannelController {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private ChannelService channelService;

        /**
     * 跳转到频道列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String lis(){
        return "modules/channel/list";
    }

    /**
     * 跳转表单页面
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String from(){
        return "modules/channel/form";
    }

    /**
     * 保存频道
     * @param channel
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Channel channel){
        int result=channelService.save(channel);
        return "redirect:/channel/list";
    }
}
