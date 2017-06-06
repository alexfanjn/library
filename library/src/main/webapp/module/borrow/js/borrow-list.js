var dataTableParam = {};
$(function() {// jq
	initDataTable();
})

/* 图书-添加 */
function borrow_add(title, url, w, h) {
	layer_show(title, url, w, h);
}

function initDataTable() {
	table = $('.table-sort').dataTable({
		"bPaginate" : true,// 分页按钮
		"bFilter" : false,// 搜索栏
		"bLengthChange" : true,// 每行显示记录数
		"iDisplayLength" : 10,// 每页显示行数
		"bProcessing" : true,
		"bSort" : false,// 排序
		"sPaginationType" : "full_numbers", // 分页，一共两种样式
		"bServerSide" : true,// 服务端传分页table参数
		"aoColumns" : [// 表格数据填充
				{
					"mDataProp" : "b.b_id",//??????????????????
					"sClass" : "text-c",
					"mRender" : function(data, type, full) {
						var html = '<input type="checkbox" value="'
								+ data
								+ '" title="'
								+ data
								+ '" id="checkbox_'
								+ data
								+ '" name="checkbox_'
								+ data
								+ '" />';
						return html;
					}
				}, {
					"mDataProp" : "u.u_name",
					"sClass" : "text-c",
				}, {
					"mDataProp" : "u.u_major",
					"sClass" : "text-c",
				}, {
					"mDataProp" : "u.u_userClass",
					"sClass" : "text-c",
				},{
					"mDataProp" : "b.b_bookName",
					"sClass" : "text-c",
				}, {
					"mDataProp" : "b.b_location",
					"sClass" : "text-c",
				}, {
					"mDataProp" : "b1.b_outDate",
					"sClass" : "text-c",
				},

		],
		"columnDefs" : [// 后加载填充自定义列内容
		{
			"targets" : [ 7 ],
			"data" : "u_id",  //?????????????????????????????
			"sClass" : "text-c",
			"mRender" : function(data, type, full) {
				var html = '';
				// 编辑用户-按钮
				html += '<a style="text-decoration: none" onClick="users_edit(\''
						+ data
						+ '\')" href="javascript:void(0);" title="还书">';
				html += '<i class="Hui-iconfont">&#xe6df;</i></a>';
				return html;
			}
		}

		],
		/*sAjaxSource在这里没用到*/
		"sAjaxSource" : '/library/DataTableController/getData.do',
		"fnServerData" : function(sSource, aoData, fnCallback) {
			$.dataTableService("cn.fang.dao.DataTableDao.getBorrowListForPage", aoData, dataTableParam, fnCallback);
		}
	});
}

jQuery.dataTableService = function(statement, aoData, param, fnCallback) {
	var params = {};
	if (param != null) {
		params = $.extend(params, param);
	}
	$.ajax({// 发送ajax请求
		"type" : 'post',
		"url" : '/library/DataTableController/getListForPage.do',
		"dataType" : "json",
		"data" : {
			aoData : JSON.stringify(aoData),
			param : JSON.stringify(params),
			statement : statement
		},
		"success" : function(resp) {
			fnCallback(resp);
		},
		"error" : function(){
			
		}
	});
}