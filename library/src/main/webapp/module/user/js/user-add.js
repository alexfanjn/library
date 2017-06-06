$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-user-add").validate({
		rules:{
			bookName:{
				required:true,
				minlength:2,
				maxlength:16
			},
			// location
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			
			$.ajax({
				url : "/library/user/addUser.do",
				type : "post",
				dataType : "json",
				data : $('#form-user-add').serialize(),
				success : function(data) {
					parent.window.table.fnDraw(false);
					if (data == '200') {
						layer.alert('操作成功', {
							icon : 1,
							shade : 0.5,
							time : 3000
						});
						return;
					}
					layer.alert('用户已存在!', {
						icon : 5,
						shade : 0.5,
						time : 3000
					});
				},
				error : function() {
					layer.alert('操作失败', {
						icon : 2,
						shade : 0.5,
						time : 3000
					});
				}
			});
			return false;
			
		}
	});
});
