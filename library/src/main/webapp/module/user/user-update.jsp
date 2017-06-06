<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/library/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/library/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/library/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/library/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/library/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>更新用户信息 - H-ui.admin v3.0</title>
</head>
<body>
<article class="page-container">
	<form action="javascript:void(0);" method="post" class="form form-horizontal" id="form-user-update">
		<!-- 隐藏id -->
		<input type="hidden" name="id" value="${user.id }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.name }" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>专业：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.major }" id="major" name="major">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>年级：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.userClass }" id="userClass" name="userClass">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/library/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/library/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/library/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/library/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="/library/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/library/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/library/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/library/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!-- 序列化表单 -->
<script type="text/javascript" src="/library/lib/jquery.form/jquery.form.js"></script>

<!-- 自定义js -->
<script type="text/javascript" src="/library/module/user/js/user-update.js"></script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>