$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-borrow-add").validate({
		rules:{

		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			
			$.ajax({
				url : "/library/borrow/addBorrow.do",
				type : "post",
				dataType : "json",
				data : $('#form-borrow-add').serialize(),
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
					if (data == '301') {
						layer.alert('用户不存在，借书失败', {
							icon : 1,
							shade : 0.5,
							time : 3000
						});
						return;
					}
					if (data == '302') {
						layer.alert('书籍id不存在，借书失败', {
							icon : 1,
							shade : 0.5,
							time : 3000
						});
						return;
					}
					if (data == '303') {
						layer.alert('此书已借出，借书失败', {
							icon : 1,
							shade : 0.5,
							time : 3000
						});
						return;
					}
					layer.alert('系统错误!', {
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
