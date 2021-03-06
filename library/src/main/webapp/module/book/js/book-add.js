$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-book-add").validate({
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
				url : "/library/book/addBook.do",
				type : "post",
				dataType : "json",
				data : $('#form-book-add').serialize(),
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
					layer.alert('图书已存在!', {
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
