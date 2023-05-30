$(function(){
	list();
});
function list(){
	$.post("emp/findAllp",function(data){
		$("#tbody").empty();
		$(data).each(function(){
			var td1 = "<td>"+this.eid+"</td>";
			var td2 = "<td>"+this.ename+"</td>";
			var td3 = "<td>"+this.sex+"</td>";
			var td4 = "<td>"+this.address+"</td>";
			var td5 = "<td>"+this.tel+"</td>";
			var td6 = "<td>"+this.card+"</td>";
			var td7 = '<td><a href="javascript:;" id="delBtn" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span> delete</a>&emsp;<a href="javascript:;" id="updateBtn" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-pencil"></span> update</a></td>';
			$("<tr></tr>").append(td1).append(td2).append(td3).append(td4).append(td5).append(td6).append(td7).appendTo("#tbody");
		});
	},"json")
}
// 静态的元素只能使用普通的事件绑定 动态生成的元素只能使用事件委托的方式绑定
$("table").on("click","#delBtn",function(){
	// 获取当前节点的父节点td的父节点tr的第一个td的内容
	var eid = $(this).parent().parent().find("td:eq(0)").text();
	var ename = $(this).parent().parent().find("td:eq(1)").text();
	var boo = confirm("你确定要删除"+ename+"吗？");
	if(boo){
		$.post("/emp/del",{"eid":eid},function(data){
			if(data=="ok"){
				list();
			}else{
				alert("删除失败！");
			}
		});
	};
})

// 添加元素
$("#addBtn").on("click",function(){
	//清空模态框
	$("form").get(0).reset();
	$("#empEditModal").modal("show");
});
// 修改元素
$("table").on("click","#updateBtn",function(){
	$("form").get(0).reset();
	// 回显
	var eid = $(this).parent().parent().find("td:eq(0)").text();
	var ename = $(this).parent().parent().find("td:eq(1)").text();
	var sex = $(this).parent().parent().find("td:eq(2)").text();
	var address = $(this).parent().parent().find("td:eq(3)").text();
	var tel = $(this).parent().parent().find("td:eq(4)").text();
	var card = $(this).parent().parent().find("td:eq(5)").text();
	$("#eid_edit_input").val(eid);
	$("#ename_edit_input").val(ename);
	$("#sex1_edit_input,sex2_edit_input").val([sex]);
	$("#address_edit_input").val(address);
	$("#tel_edit_input").val(tel);
	$("#card_edit_input").val(card);
	$("#empEditModal").modal("show");
});
$("#emp_edit_btn").on("click",function(){
	var d = $("form").serialize();
	//1.发送异步请求 2.获取参数
	$.post("emp/save",d,function(data){
		if(data=="ok"){
			list();
		}else{
			alert("操作失败！");
		}
		// 关闭模态框
		$("empEditModal").modal("hide");
	});
});
