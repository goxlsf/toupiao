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
            <input type="text" name="vote" style="width:300px">
            <br>
            选项A:<br>
            <input type="text" name="op" style="width:300px">
            <br>
            选项B:<br>
            <input type="text" name="op" style="width:300px">
            <br>
            选项C:<br>
            <input type="text" name="op" style="width:300px">
            <br>
            选项D:<br>
            <input type="text" name="op" style="width:300px">
            <br><br>
            <input type="radio" name="ty" value="0" >匿名投票
            <input type="radio" name="ty" value="1" >非匿名投票
            <br>
            <input type="date" name="ti" style="width:300px">
            <br>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="submit()">
                提交投票
            </button>
        </div>
    </div>
</div>
