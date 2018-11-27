#parse("userheader.jsp")
<style>.modal-backdrop{z-index:0;}</style>
<div id="main">
    #if ($admin)
    <h1 align="center">欢迎您，管理员$!{admin.name}</h1>
    #else
    <h1 align="center">管理员,请先登录</h1>
    #end
    <div class="container" id="daily">
        <div id="sorti">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px;width: auto">用户名：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="Name" id="search_name" style="width: 200px"/>
                    </div>

                    <div class="col-sm-1 col-sm-offset-4">
                        <button class="btn btn-primary" id="search_btn" style="text-align: right">查询</button>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <table id="mytable" ></table>
                </div>
            </div>


        </div>

    </div>
</div>
<div class="modal" id="userAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</div>

#if ($pop)
<script>
    window.loginpop = $!{pop};
</script>
#end
#parse("footer.jsp")