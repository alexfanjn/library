var dataTableParam = {};
$(function() {//jq
	initDataTable();
	$("#search").click(function(){
		dataTableParam = $("#query").toJson();
		table.fnDraw(true);
	});
})

/* 商品-添加 */
function product_add(title, url, w, h) {
	layer_show(title, url, w, h);
}

/* 商品-详情*/
function product_detail(data) {
	layer_show("商品详情", Global.contextPath + "/CommonController/showProduct.do?type=desc&id=" + data, "", 510);
}

/* 商品-修改*/
function product_edit(data) {
	layer_show("修改商品", Global.contextPath + "/CommonController/showProduct.do?id=" + data, "", 510);
}

/* 上传-图片 */
function picture_update(data) {
	layer_show("上传图片", Global.contextPath + "/CommonController/showPicture.do?id=" + data, 800, 280);
}

/* 商品-下架 */
function product_stop(product_id) {
	layer.confirm('确认要下架吗？',function(index) {
		$.ajax({
			"type" : 'post',
			"url" : Global.contextPath + '/product/updateStatus.do',
			"dataType" : "json",
			"data" : {
				"id" : product_id,
				"status" : "000"
			},
			"success" : function(data) {
				if (data.code == '001') {
					table.fnDraw(false);// 刷新表格数据false为当前页数，true为刷新到第一页
					layer.msg('成功下架!', {
						icon : 1,
						time : 1000
					});
				} else {
					layer.msg('操作失败!', {
						icon : 1,
						time : 1000
					});
				}
			},
		});
	});
}

/* 商品-上架 */
function product_start(product_id) {
	layer.confirm('确认要上架吗？',function(index) {
		$.ajax({
			"type" : 'post',
			"url" : Global.contextPath + '/product/updateStatus.do',
			"dataType" : "json",
			"data" : {
				"id" : product_id,
				"status" : "001"
			},
			"success" : function(data) {
				if (data.code == '001') {
					table.fnDraw(false);// 刷新表格数据false为当前页数，true为刷新到第一页
					layer.msg('成功上架!', {
						icon : 1,
						time : 1000
					});
				} else {
					layer.msg('操作失败!', {
						icon : 1,
						time : 1000
					});
				}
			}
		});
	});
}

/* 删除 */
function del(id) {
	layer.confirm('确认要删除吗？', function(index) {
		$.ajax({
			"type" : 'get',
			"url" : Global.contextPath + '/product/deleteProduct.do',
			"dataType" : "json",
			"data" : {
				"ids" : id
			},
			"success" : function(data) {
				// console.log(data);
				if (data.code == '001') {
					table.fnDraw(false);// 刷新表格数据false为当前页数，true为刷新到第一页
					layer.msg('已删除!', {
						icon : 1,
						time : 1000
					});
				} else {
					layer.msg('操作失败!', {
						icon : 1,
						time : 1000
					});
				}
			},
			error : function(){
				layer.alert('某商品与某订单有关联!', {
					icon : 2,
					shade : 0.5,
					time : 3000
				});
			}
		});
	});
}

/* 批量删除 */
function datasDelete() {
	var obj = $("input[name^='checkbox_']:checked");
	if (obj.length == 0) {
		layer.msg('请最少选择一条记录！', {
			icon : 1,
			time : 1000
		});
		return;
	}
	var values = [];
	for (var i = 0; i < obj.length; i++) {
		// console.log(obj[i]);
		values.push(obj[i].value);
	}
	var ids = values.join(",");
	$.ajax({
		"type" : 'get',
		"url" : Global.contextPath + '/product/deleteProduct.do',
		"dataType" : "json",
		"data" : {
			"ids" : ids
		},
		"success" : function(data) {
			// console.log(data);
			if (data.code == '001') {
				table.fnDraw(false);// 刷新表格数据false为当前页数，true为刷新到第一页
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			} else {
				layer.msg('操作失败!', {
					icon : 1,
					time : 1000
				});
			}
		},
		error : function(){
			layer.alert('某商品与某订单有关联!', {
				icon : 2,
				shade : 0.5,
				time : 3000
			});
		}
	});
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
		// 另一种为two_button //
		// 是datatables默认
		"bServerSide" : true,// 服务端传分页table参数
		"aoColumns" : [// 表格数据填充
				{
					"mDataProp" : "u_id",
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
					"mDataProp" : "u_bookName",
					"sClass" : "text-c",
				}, {
					"mDataProp" : "u_location",
					"sClass" : "text-c",
				}, {
					"mDataProp" : "u_isBorrow",
					"sClass" : "text-c",
				}, {
					"mDataProp" : "u_createTime",
					"sClass" : "text-c",
				}

		],
		"columnDefs" : [// 后加载填充自定义列内容
		{
			"targets" : [ 5 ],
			"data" : "id",
			"sClass" : "text-c",
			"mRender" : function(data, type, full) {
				var html = '';
				// 编辑商品-按钮
				html += '<a style="text-decoration: none" onClick="product_edit(\''
						+ data
						+ '\')" href="javascript:;" title="编辑">';
				html += '<i class="Hui-iconfont">&#xe6df;</i></a>';
				return html;
			}
		}

		],
		/*sAjaxSource在这里没用到*/
		"sAjaxSource" : Global.contextPath
				+ '/DataTableController/getData.do',
		"fnServerData" : function(sSource, aoData, fnCallback) {
			$.dataTableService("com.jintao.DataTableDao.getProductListForPage", aoData, dataTableParam, fnCallback);
		}
	});
}

jQuery.dataTableService = function(statement, aoData, param, fnCallback) {
	var params = {};
	if (param != null) {
		params = $.extend(params, param);
	}
	$.ajax({
		"type" : 'post',
		"url" : Global.contextPath
				+ '/DataTableController/getListForPage.do',
		"dataType" : "json",
		"data" : {
			aoData : JSON.stringify(aoData),
			param : JSON.stringify(params),
			statement : statement
		},
		"success" : function(resp) {
			fnCallback(resp);
		}
	});
}