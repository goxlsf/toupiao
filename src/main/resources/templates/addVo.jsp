<div class="modal-dialog">
    <div class="modal-content" >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
                $!{vote.questionName}
            </h4>
        </div>
        <div class="modal-body">

                #foreach($vo in $vos)
                <input type="radio" name="que" value = $!{vo.ques.OptionId}>$!{vo.ques.option}<br>
                #end

                <input type="text" name="user" value=$!{user.UserName} style="display: none">
                <input type="text" name="questionId" value=$!{vote.questionId} style="display: none">

        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="vote()">
                提交
            </button>
        </div>
    </div>
</div>
