package com.ooqiu.gaming.server.web.admin.dto;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DataTable<T> implements Serializable {

    private Meta meta;
    private List<T> data;

    public DataTable(PageInfo pageInfo){
        meta=new Meta(pageInfo.getPageNum(),pageInfo.getPages(),pageInfo.getPageSize(),
                pageInfo.getTotal());

        //获取分页后的数据
        data=pageInfo.getList();
    }

    @Data
    class Meta{
        private int page;
        private int pages;
        private int perpage;
        private Long total;
        private String sort;
        private String field;

        public Meta() {}

        public Meta(int page, int pages, int perpage, Long total) {
            this.page = page;
            this.pages = pages;
            this.perpage = perpage;
            this.total = total;
        }
    }
}
