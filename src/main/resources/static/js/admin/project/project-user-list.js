//查看项目详情
function project_detail(title,url,w,h){
	layer_show(title,url,w,h);
}
//删除评论
function expert_user_comment_delete(obj,id){
	layer.confirm('确认要删除吗(删除后数据无法恢复)？',function(index){
			$.ajax({
				url:"/admin/comment/deleteUserComment?"+Math.random(),
				dataType:"json",
				type:"post",
				data:{"id":id},
				success:function(data){
					if(data.status=='success'){					
						$(obj).parents("tr").remove();
						layer.msg('已删除!',{icon:1,time:1000});
						location.reload();
					}else{
						layer.msg('删除失败',{icon:5,time:1000});
					}
				},
				error:function(){
					layer.msg('系统异常',{icon:5,time:1000});
				}
			});
		
	});
}