$(function () {
    $('.skin-minimal input').iCheck({
        checkboxClass: 'icheckbox-blue',
        radioClass: 'iradio-blue',
        increaseArea: '20%'
    });

    $("#form-admin-loan-edit").validate({
        rules:{
            name:{
                required:true,
                remote: {
                    url: "/admin/loan/isExist",
                    type: "get",
                    data: {
                        name: function () {
                            return $("#loanName").val();
                        },
                        id:$("#rid").val()
                    }
                }
            },
            perms:{
                required:true
            }
        },
        messages : {
            name : {
                remote: "该借款人已经存在！"
            }
        },
        onkeyup:false,
        focusCleanup:true,
        success:"valid",
        submitHandler:function(form){
            $(form).ajaxSubmit({
                type: 'PUT',
                url: "/admin/loan/"+$("#rid").val(),
                dataType:"json",
                success: function(data){
                    if(data.status == "success"){
                        succeedMessage(data.message);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.location.reload();
                        parent.layer.close(index);
                    }else {
                        errorMessage(data.message);
                    }
                }
            });
            return false; // 非常重要，如果是false，则表明是不跳转，在本页上处理，也就是ajax，如果是非false，则传统的form跳转。
        }
    });
});