package com.ooqiu.gaming.service.search.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.service.search.api.SearchService;
import com.ooqiu.gaming.service.search.domain.SearchResult;

import java.util.List;

@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_SEARCH)
public class SearchServiceImpl implements SearchService {
    @Override
    public List<SearchResult> search(String query, int page, int row) {
        return null;
    }
}
