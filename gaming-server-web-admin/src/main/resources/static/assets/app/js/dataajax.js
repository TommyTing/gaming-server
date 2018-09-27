var DataAjax = function () {
    var handlerInitAjaxTable = function () {
        var datatable = $('.m_datatable').mDatatable({
            translate: {
                records: {
                    processing: '数据加载中，请稍后...',
                    noRecords: '没有查询到记录'
                },
                toolbar: {
                    pagination: {
                        items: {
                            default: {
                                first: '首页',
                                prev: '上一页',
                                next: '下一页',
                                last: '尾页',
                                more: '更多',
                                input: '页码',
                                select: '选择笔数'
                            },
                            info: '显示第 {{start}} - {{end}} 条，共 {{total}} 条记录'
                        }
                    }
                }
            },
            // 定义数据源
            data: {
                type: 'remote',
                source: {
                    read: {
                        method: 'POST',
                        url: '/article/data',
                        map: function (raw) {
                            var dataSet = raw;
                            if (typeof raw.data !== 'undefined') {
                                dataSet = raw.data;
                            }
                            return dataSet;
                        }
                    }
                },
                pageSize: 10,
                serverPaging: true,
                serverFiltering: true,
                serverSorting: true,
            },
            pagination: true,

            toolbar: {
                // toolbar items
                items: {
                    // pagination
                    pagination: {
                        // page size select
                        pageSizeSelect: [2, 20, 30, 50, 100],
                    }
                }
            },

            columns: [{
                field: 'title',
                title: '文章标题',
                sortable: false,
                selector: false,
                textAlign: 'center',
            },{
                field: 'url',
                title: '链接地址',
                sortable: false,
                selector: false,
                textAlign: 'center',
            }]

        });


    };

    return {
        initAjaxTable: function () {
            handlerInitAjaxTable();
        }
    }

}();