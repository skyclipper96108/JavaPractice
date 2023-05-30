document.querySelector('#table-demo-baseCode').GM({
    gridManagerName: 'demo-baseCode',
    ajaxData: '/system/article/findPage', // 页面一加载就会自动发送异步请求
    ajaxType: 'POST',
    supportAjaxPage: true,
    supportAdjust: true,
    currentPageKey: 'localPage',
    pageSizeKey: 'pageSize',
    pageSize: 5,
    sizeData: [5,10,20],
    columnData: [
        {
            key: 'title',
            text: '文章标题',
            align: 'center'
        },{
            key: 'url',
            text: 'url地址',
            align: 'center'
        },{
            key: 'type',
            text: '文章类型',
            align: 'center',
            template: function(cell, row, index, key){
            	return cell.name;
            }
        },{
            key: 'clickCount',
            text: '点击次数',
            align: 'center'
        },{
            key: 'createDate',
            text: '创建时间',
            align: 'center'
        },{
            key: 'enable',
            text: '启用状态',
            align: 'center',
            template: function(cell, row, index, key){
            	return cell?"<span style='color:green'>启用</sapn>":"<span style='color:red'>禁用</sapn>";
            }
        },{
            key: 'id',
            text: '操作&emsp; <a href="javascript:;" id="addBtn">添加</a>',
            align: 'center',
            // cell key对应的值 row当前对象 index下标 key值
            template: function(cell, row, index, key){
            	// 将json对象转换成json的标准格式字符串
            	var jsonString = JSON.stringify(row);
            	return "<a href='javascript:;' style='color:blue' data-obj='"+jsonString+"'>修改</a>&emsp;"+
            	"<a href='javascript:;' style='color:red' data-id='"+cell+"'>删除</a>";
            }
        }
    ]
});

/* 高级查询的代码 */
$(function(){
	$("#queryButton").on("click",function(){
		// 1. 获取表单的数据
		var data =$("#queryForm").serializeObject();
		console.log(data);
		// 2. 调用gm的setQuery方法 会自动发送demo-baseCode的gm指定异步请求，并且把分页的信息和指定的参数一起传递到后台
		GridManager.setQuery('demo-baseCode', data);
	});
	
	/* 删除操作 */
	$("#table-demo-baseCode").on('click',"a[data-id]",function(){
		//this是dom对象，转成jquery对象使用data()方法获取自定义属性data-*的时候会自动转换
		var id = $(this).data("id");
		$("#delModal").modal("show");
		
		// 先取消所有时间然后再绑定
		$("#delModalButton").off();
		$("#delModalButton").on("click",function(){
			// 发送post异步请求
			$.post('/system/article/del', {"id":id}, function(data){
				console.log(data);
				// 关闭模态框
				if(data.indexOf("ok")!=-1){
					$("#delModal").modal("hide");
					//刷新表格
					GridManager.refreshGrid('demo-baseCode');
				}else{
					$("#delModal").modal("hide");
					alert("删除失败");
				}	
			});
			
		});
	});
	// 点击添加时弹出模态框
	$("#table-demo-baseCode").on('click',"#addBtn",function(){
		$("#saveForm").get(0).reset();
		//手动清空隐藏域
		$("input[type='hidden']").val("");
		// 将富文本清空
		var ue = UE.getEditor('container');
		ue.ready(function(){
			// 设置默认值
			ue.setContent('');
		});
		
		$("#saveModal").modal("show");
	});
	
	// 点击修改时弹出模态框
	$("#table-demo-baseCode").on('click',"a[data-obj]",function(){
		// 获取回显的数据
		var obj = $(this).data("obj");
		// 将富文本清空
		var ue = UE.getEditor("container");
		ue.ready(function(){
			// 设置默认值
			ue.setContent(obj.content);
		});
		$("#saveForm").setForm(obj);
		$("#saveModal").modal("show");
		
	});
	
	// 点击添加和修改的确定按钮保存数据
	$("#saveButton").on("click",function(){
		//将表单以ajax的方式进行数据提交，提交请求就是action写的内容
		$("#saveForm").ajaxSubmit({
			success:function(data){
				console.debug(data);
				if(data.indexOf("ok")!=-1){
					$("#saveModal").modal("hide");
					//刷新表格
					GridManager.refreshGrid('demo-baseCode');
				}else{
					$("#saveModal").modal("hide");
					alert("操作失败");
				};
			}
		});
	});
	
	
});