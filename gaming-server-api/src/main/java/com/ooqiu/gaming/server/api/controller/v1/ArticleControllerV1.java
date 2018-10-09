package com.ooqiu.gaming.server.api.controller.v1;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.api.dto.BaseResult;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.service.article.api.ArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章接口
 */
@RestController
@RequestMapping(value = "${rest.path.api.v1}/article")
public class ArticleControllerV1 {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ARTICLE)
    private ArticleService articleService;

    /**
     * 获取文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "获取文章列表", notes = "分页查询文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int",
                    paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "int",
                    paramType = "path")
    })
    @RequestMapping(value = "data/list/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult data(@PathVariable(required = true) int pageNum, @PathVariable(required =
            true) int pageSize) {
        PageInfo<Article> pageInfo = articleService.selectAll(pageNum, pageSize);
        return BaseResult.success(pageInfo.getList());
    }

    @ApiOperation(value = "获取文章列表", notes = "根据频道 ID 获取文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "channelId", value = "频道 ID", required = true, dataType =
                    "long",
                    paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int",
                    paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "int",
                    paramType = "path")
    })
    @RequestMapping(value = "data/channel/{channelId}/{pageNum}/{pageSize}", method =
            RequestMethod.GET)
    public BaseResult data(@PathVariable(required = true) int pageNum,
                           @PathVariable(required = true) int pageSize,
                           @PathVariable(required = true) long channelId) {
        PageInfo<Article> pageInfo = articleService.selectByChannelId(pageNum, pageSize, channelId);
        return BaseResult.success(pageInfo.getList());
    }

    @ApiOperation(value = "获取文章列表", notes = "根据文章类型获取文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "文章类型: 1/文章，2/视频", required = true, dataType =
                    "String",
                    paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int",
                    paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "int",
                    paramType = "path")
    })
    @RequestMapping(value = "data/type/{type}/{pageNum}/{pageSize}", method =
            RequestMethod.GET)
    public BaseResult data(@PathVariable(required = true) int pageNum,
                           @PathVariable(required = true) int pageSize,
                           @PathVariable(required = true) String type) {
        PageInfo<Article> pageInfo = articleService.selectBtType(pageNum, pageSize, type);
        return BaseResult.success(pageInfo.getList());
    }

}
