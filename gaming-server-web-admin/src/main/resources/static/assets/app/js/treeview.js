var TreeView=function () {
    var handlerInitTree=function () {
        $('#m_tree_1').jstree({
            "core" : {
                "themes" : {
                    "responsive": false
                }
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder"
                },
                "file" : {
                    "icon" : "fa fa-file"
                }
            },
            "plugins": ["types"]
        });

        $('#m_tree_1').bind("activate_node.jstree",function (obj,e) {
            var currentNode=e.node;
            console.log(currentNode.id);
            $("#pid").val(currentNode.id);
            $("#pidText").val(currentNode.text);
        });
    };

    return{
        init:function () {
            handlerInitTree();
        }
    }
}();

jQuery(document).ready(function () {
    TreeView.init();
});