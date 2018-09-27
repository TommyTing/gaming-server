package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.server.web.admin.dto.DataTable;
import com.ooqiu.gaming.service.admin.api.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章管理
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private ArticleService articleService;

    /**
     * 跳转文章列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "modules/article/list";
    }

    /**
     * 跳转文章表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "modules/article/form";
    }

    /**
     * 保存文章
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Article article){
        int result=articleService.save(article);
        return "redirect:/article/list";
    }

    /**
     * 分页查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "data")
    public DataTable<Article> data(HttpServletRequest request){

//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String name=parameterNames.nextElement();
//            String value=request.getParameter(name);
//            System.out.println("name:"+name+"       value:"+value);
//        }

        String strPage=request.getParameter("datatable[pagination][page]");
        String strPageSize=request.getParameter("datatable[pagination][perpage]");

        int page=1;
        int pageSize=10;

        if (!StringUtils.isBlank(strPage)){
            page=Integer.parseInt(strPage);
        }
        if (!StringUtils.isBlank(strPageSize)){
            pageSize=Integer.parseInt(strPageSize);
        }

        PageInfo<Article> pageInfo = articleService.page(page, pageSize);
        return new DataTable<Article>(pageInfo);
    }
}
