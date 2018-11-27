function TableTest() {
    $('#mytable').bootstrapTable({
        method: 'post',
        url: "/index",//请求路径
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
                questionName: $('#search_name').val(),
            };
            return temp;
        },
        columns: [{
            title: '投票名称',
            field: 'questionName',
            sortable: true
        }, {
            title: '类别',
            field: 'type',
            formatter: formatSex,//对返回的数据进行处理再显示

        }, {
            title: '截止时间',
            field: 'time',
            formatter: function (value, row, index) {
                return changeDateFormat(value)
            }

        }, {
            title: '投票数量',
            field: 'count',
        }, {
            title: '操作',
            field: 'questionId',
            formatter: operation,//对资源进行操作
        }]
    });
}
function TableTest1() {
    $('#mytable1').bootstrapTable({
        method: 'post',
        url: "/index1",//请求路径
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        striped: true, //是否显示行间隔色
        pageNumber: 1, //初始化加载第一页
        pagination: true,//是否分页
        sidePagination: 'client',//server:服务器端分页|client：前端分页
        pageSize: 10,//单页记录数
        pageList: [5, 10, 20, 30],//可选择单页记录数
        showRefresh: true,//刷新按钮
        queryParams: function (params) {//上传服务器的参数
            var temp1 = {
                questionName: $('#search_name1').val(),
            };
            return temp1;
        },
        columns: [{
            title: '投票名称',
            field: 'questionName',
            sortable: true
        }, {
            title: '类别',
            field: 'type',
            formatter: formatSex1,//对返回的数据进行处理再显示
        }, {
            title: '截止时间',
            field: 'time',
            formatter: function (value, row, index) {
                return changeDateFormat(value)
            }
        }, {
            title: '投票数量',
            field: 'count',

        }, {
            title: '操作',
            field: 'questionId',
            formatter: operation1,//对资源进行操作
        }]
    });
}

$(function(){
    TableTest();
    TableTest1();  //初始化载入表格
    $('#search_btn').on('click',function() {
        $('#mytable').bootstrapTable('refresh', {
            url : '/index'
        });
    })
    $('#search_btn1').on('click',function() {
        $('#mytable1').bootstrapTable('refresh', {
            url : '/index1'
        });
    })



});
//value代表该列的值，row代表当前对象
function formatSex(value, row, index) {
    return value == 1 ? "匿名投票" : "非匿名投票";
    //或者 return row.sex == 1 ? "男" : "女";
}
function formatSex1(value, row, index) {
    return value == 1 ? "匿名投票" : "非匿名投票";
    //或者 return row.sex == 1 ? "男" : "女";
}
function operation(value, row, index) {
    var questionId = row.questionId;

    var htm = "<button id=\"vote\" data-toggle=\"modal\" data-remote=\"retire/add/dead\" style='float:left' type='button' class=\"btn btn-primary\"  onclick='Test(\"" + questionId + "\")'>修改</button><button id=\"vote\" data-toggle=\"modal\" data-remote=\"retire/add/dead\" style='float: right' type='button' class=\"btn btn-primary\"  onclick='Delete(\"" + questionId + "\")'>删除</button>"
    return htm;
}
function alter() {
    var votename = document.getElementsByName("votename")[0].value;
    var option = new Array();
    var i=0;
    $("[name=option]").each(function (){
        option[i]=$(this).val();
        i++;
    });
    var date = document.getElementsByName("time")[0].value;
    var radio = document.getElementsByName("type");
    var id = document.getElementsByName("qustionId")[0].value;
    for (i=0; i<radio.length; i++) {
        if (radio[i].checked) {
            var type = radio[i].value;
        }
    }

    var url = "option/vote/alter?votename="+votename+"&&type="+type+"&&time="+date+"&&option="+option+"&&questionId="+id;
    $('#vote').load(url);
    $('#deadMod').modal('hide');
    $('#mytable').bootstrapTable('refresh', {
        url : '/index'
    });
    $('#mytable1').bootstrapTable('refresh', {
        url : '/index1'
    });
}
function submit() {
    var votename = document.getElementsByName("vote")[0].value;
    var option = new Array();
    var i=0;
    $("[name=op]").each(function (){
        option[i]=$(this).val();
        i++;
    });
    var date = document.getElementsByName("ti")[0].value;
    var radio = document.getElementsByName("ty");
    for (i=0; i<radio.length; i++) {
        if (radio[i].checked) {
            var type = radio[i].value;
        }
    }
    var url = "option/vote?votename="+votename+"&&type="+type+"&&time="+date+"&&option="+option;
    $('#vote').load(url);
    $('#deadAdd').modal('hide');
    $('#mytable').bootstrapTable('refresh', {
        url : '/index'
    });
    $('#mytable1').bootstrapTable('refresh', {
        url : '/index1'
    });
}
function AddVote() {
    var url = "vote/add";
    //将id为deadAdd的页面元素作为模态框激活
    $('#vote').modal();
    //从url加载数据到模态框
    $('#deadAdd').load(url);
    $("#deadAdd").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");

        $(this).find(".modal-content").children().remove();
    });
    
}
function Delete(questionId) {
    var url = "option/delete?questionId="+questionId;
    $('#vote').load(url);
    $('#mytable').bootstrapTable('refresh', {
        url : '/index'
    });
    $('#mytable1').bootstrapTable('refresh', {
        url : '/index1'
    });
}
function Test(questionId) {

    //获取url的值
    var url = "vote/mod?questionId="+questionId;
    //将id为deadAdd的页面元素作为模态框激活
    $('#deadMod').modal();
    //从url加载数据到模态框
    $('#deadMod').load(url);
    $("#deadMod").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");

        $(this).find(".modal-content").children().remove();
    });
}
function operation1(value, row, index) {
    var questionId = row.questionId;
    var htm = "<button id=\"vote\" data-toggle=\"modal\" data-remote=\"retire/add/dead\" style='float:left' type='button' class=\"btn btn-primary\"  onclick='Mod(\"" + questionId + "\")'>修改</button><button id=\"vote\" data-toggle=\"modal\" data-remote=\"retire/add/dead\" style='float: right' type='button' class=\"btn btn-primary\"  onclick='Delete(\"" + questionId + "\")'>删除</button>"
    return htm;
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
