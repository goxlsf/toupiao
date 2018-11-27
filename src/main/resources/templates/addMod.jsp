<div class="modal-dialog">
    <div class="modal-content" >
        <div class="modal-header">
            投票名称:<br>
            <input type="text" name="votename" value=$!{vote.questionName} style="width:300px">
            <br>
            #foreach($vo in $vos)
            <br>选项:$!{vo.ques.OptionId}<br>
            <input type="text" name="option" value=$!{vo.ques.option} style="width:300px">
            #end
            <br>
            <br>
            <input type="radio" name="type" value="匿名投票" >匿名投票
            <input type="radio" name="type" value="非匿名投票" >非匿名投票
            <input type="text" name="qustionId" style="display:none" value=$!{vote.questionId} >
            <br>
            <input type="date" name="time" value=$!{vote.time} style="width:300px">

        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="alter()">
                提交
            </button>
        </div>
    </div>
</div>
