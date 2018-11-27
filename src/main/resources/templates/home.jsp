#parse("header.jsp")
<style>.modal-backdrop{z-index:0;}</style>
    <div id="main">
        <div class="container" id="daily">
            <button id="time" type="button">按时间排序</button>
            <button id="count" type="button">按点击数排序</button>
        <div id="sorti">
            <div class="panel panel-default">
            <div class="panel-heading">
                查询条件
            </div>
            <div class="panel-body form-group" style="margin-bottom:0px;">
                <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px;width: auto">投票名称：</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="Name" id="search_name"/>
                </div>

                <div class="col-sm-1 col-sm-offset-4">
                    <button class="btn btn-primary" id="search_btn">查询</button>
                </div>
            </div>
        </div>
        <table id="mytable" class="table table-hover"></table>
        </div>

            <div id="sorco" style="display: none">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        查询条件
                    </div>
                    <div class="panel-body form-group" style="margin-bottom:0px;">
                        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px;width: auto">投票名称：</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name="Name" id="search_name1"/>
                        </div>

                        <div class="col-sm-1 col-sm-offset-4">
                            <button class="btn btn-primary" id="search_btn1">查询</button>
                        </div>
                    </div>
                </div>
                <table id="mytable1" class="table table-hover"></table>
            </div>
        </div>
    </div>
<div class="modal" id="deadAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

</div>


#if ($pop)
<script>
window.loginpop = $!{pop};
</script>

#end


#parse("footer.jsp")