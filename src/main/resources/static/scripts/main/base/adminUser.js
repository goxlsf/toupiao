function TableTest() {
    $('#mytable').bootstrapTable({
        method: 'post',
        url: "/user/index",//请求路径
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        striped: true, //是否显示行间隔色
        pageNumber: 1, //初始化加载第一页
        pagination: true,//是否分页
        sidePagination: 'client',//server:服务器端分页|client：前端分页
        pageSize: 10,//单页记录数
        pageList: [5, 10, 20, 30],//可选择单页记录数
        showRefresh: true,//刷新按钮
        queryParams: function (params) {//上传服务器的参数
            var temp = {
                userName: $('#search_name').val(),
            };
            return temp;
        },
        columns: [{
            title: '用户名',
            field: 'userName',
            sortable: true
        }, {
            title: '密码',
            field: 'passWord',

        },  {
            title: '操作',
            field: 'userId',
            formatter: operation,//对资源进行操作
        }]
    });
}
$(function(){
    TableTest();
    $('#search_btn').on('click',function() {
        $('#mytable').bootstrapTable('refresh', {
            url : '/user/index'
        });
    })
});

function operation(value, row, index) {
    var userId = row.id;

    var htm = "<button id=\"vote\" data-toggle=\"modal\"  style='float:left' type='button' class=\"btn btn-primary\"  onclick='Test(\"" + userId + "\")'>修改</button><button id=\"vote\" data-toggle=\"modal\" style='float: right' type='button' class=\"btn btn-primary\"  onclick='Delete(\"" + userId + "\")'>删除</button>"
    return htm;
}
function alter() {
    var username = document.getElementsByName("username")[0].value;
    var pwd = document.getElementsByName("pwd")[0].value;
    var id = document.getElementsByName("userId")[0].value;
    var url = "user/alter?username="+votename+"&&pwd="+pwd+"&&userId="+id;
    $('#vote').load(url);
    $('#userMod').modal('hide');
    $('#mytable').bootstrapTable('refresh', {
        url : '/user/index/'
    });

}
function submit() {
    var username = document.getElementsByName("user")[0].value;
    var pwd = document.getElementsByName("pwd")[0].value;

    var url = "option/vote?votename="+votename+"&&type="+type+"&&time="+date+"&&option="+option;
    $('#vote').load(url);
    $('#deadAdd').modal('hide');
    $('#mytable').bootstrapTable('refresh', {
        url : '/user/index/'
    });
}

function Delete(userId) {
    var url = "delete?userId="+userId;
    $('#vote').load(url);
    $('#mytable').bootstrapTable('refresh', {
        url : '/user/index/'
    });
}
function Test(userId) {

    //获取url的值
    var url = "user/mod?userId="+userId;
    //将id为deadAdd的页面元素作为模态框激活
    $('#userMod').modal();
    //从url加载数据到模态框
    $('#userMod').load(url);
    $("#userMod").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");

        $(this).find(".modal-content").children().remove();
    });
}
function changeDateFormat(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
    }
}