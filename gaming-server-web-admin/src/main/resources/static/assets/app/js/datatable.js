var DataTable=function () {
    var handlerInit=function () {
        var datatable = $('.m-datatable').mDatatable({
            data: {
                saveState: {cookie: false}
            },
            pagination:false//分页
            // sortable:false//排序
        });
    };

    return{
        init: function () {
            handlerInit();
        }
    }

}();

jQuery(document).ready(function () {
    DataTable.init();
});