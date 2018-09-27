package com.ooqiu.gaming.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.commons.utils.IdUtils;
import com.ooqiu.gaming.server.domain.Dict;
import com.ooqiu.gaming.service.admin.api.DictService;
import com.ooqiu.gaming.service.admin.mapper.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 字典管理
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public PageInfo<Dict> page(int pageNum, int pageSize) {
        Example example = new Example(Dict.class);
        PageHelper.startPage(pageNum == 0 ? 1 : pageNum, pageSize == 0 ? 10 : pageSize);
        PageInfo<Dict> pageInfo = new PageInfo<>(dictMapper.selectByExample(example));
        return pageInfo;
    }

    @Override
    public int save(Dict dict) {
        dict.setId(IdUtils.genId());
        dict.setCreateDate(new Date());
        dict.setUpdateDate(new Date());
        return dictMapper.insert(dict);
    }

    @Override
    public List<Dict> selectByType(String type) {
        Example example = new Example(Dict.class);
        example.createCriteria().andEqualTo("type", type);
        return dictMapper.selectByExample(example);
    }
}
