<div class="modal-dialog">
    <div class="modal-content" >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
                请创建新的投票
            </h4>
        </div>
        <div class="modal-body">

            投票名称:<br>
            <input type="text" name="votename" style="width:300px">
            <br>
            选项A:<br>
            <input type="text" name="option" style="width:300px">
            <br>
            选项B:<br>
            <input type="text" name="option" style="width:300px">
            <br>
            选项C:<br>
            <input type="text" name="option" style="width:300px">
            <br>
            选项D:<br>
            <input type="text" name="option" style="width:300px">
            <br><br>
            <input type="radio" name="type" value="匿名投票" >匿名投票
            <input type="radio" name="type" value="非匿名投票" >非匿名投票
            <br>
            <input type="date" name="time" style="width:300px">
            <br>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="submit()">
                提交投票
            </button>
        </div>
    </div>
</div>
