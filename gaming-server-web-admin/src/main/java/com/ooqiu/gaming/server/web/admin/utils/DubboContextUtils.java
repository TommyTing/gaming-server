package com.ooqiu.gaming.server.web.admin.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.service.admin.api.DictService;
import org.springframework.stereotype.Component;

/**
 * Dubbo 上下文
 */

@Component
public class DubboContextUtils {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private DictService dictService;

    public DictService getDictService() {
        return dictService;
    }
}
