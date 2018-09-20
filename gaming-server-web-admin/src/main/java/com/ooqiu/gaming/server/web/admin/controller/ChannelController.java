package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Lists;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.server.web.admin.dto.TreeView;
import com.ooqiu.gaming.service.admin.api.ChannelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String lis(Model model) {
        //排序后的集合
        List<Channel> list = Lists.newArrayList();
        List<Channel> channels = channelService.getAll();
        for (Channel channel : channels) {
            if ("0".equals(channel.getIsParent())) {
                list.add(channel);
                for (Channel subChannel : channels) {
                    if (subChannel.getPid().longValue() == channel.getId().longValue()) {
                        list.add(subChannel);
                    }
                }

            }
        }
        model.addAttribute("channels", list);
        return "modules/channel/list";
    }

    /**
     * 跳转表单页面
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String from(Model model) {
        return "modules/channel/form";
    }

    /**
     * 保存频道
     *
     * @param channel
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Channel channel) {
        int result = channelService.save(channel);
        return "redirect:/channel/list";
    }

    /**
     * 前端树结构
     *
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree")
    public List<TreeView> treeData(String pid) {
        List<TreeView> list = new ArrayList<>();

        //处理首次查询的参数
        if (StringUtils.isBlank(pid) || "#".equals(pid)) {
            pid = "0";
        }

        List<Channel> channels = channelService.selectByPid(Long.parseLong(pid));
        TreeView treeView = null;
        for (Channel channel : channels) {
            treeView = new TreeView();
            treeView.setId(String.valueOf(channel.getId()));
            treeView.setIcon("");
            treeView.setText(channel.getName());
            treeView.setChildren("0".equals(channel.getIsParent()));
            list.add(treeView);
        }

        return list;
    }

}
