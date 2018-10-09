package com.ooqiu.gaming.server.api.controller.v1;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ooqiu.gaming.server.api.dto.BaseResult;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.service.channel.api.ChannelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 频道接口
 */
@RestController
@RequestMapping(value = "${rest.path.api.v1}/channel")
public class ChannelControllerV1 {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_CHANNEL)
    private ChannelService channelService;

    @ApiOperation(value = "获取频道列表",notes = "获取全部频道列表")
    @RequestMapping(value = "data", method = RequestMethod.GET)
    public BaseResult data() {
        return BaseResult.success(channelService.selectAll());
    }
}
