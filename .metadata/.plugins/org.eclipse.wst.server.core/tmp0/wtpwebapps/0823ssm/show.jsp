<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>model</title>
<style type="text/css">
	body{
		background-color: silver;
	}
	table{
		border-collapse: collapse; 
		width: 100%;
		text-align: center;
		margin: 20px auto;
		font-family: "微软雅黑";
	}
	td{
		border: 1px solid green;
		height: 30px;
	}
	caption {
		margin: 5px;
		font-size: 30px;
		font-weight: bold;
	}

</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/emp/findByCondition">
		<div>
		<h1>员工列表显示</h1>
			姓名：<input type="text" name="ename" value="${emp.ename }"/> &emsp; 
			地址：<input type="text" name="address" value="${emp.address }"/> &emsp; 
			部门编号：
			<select name="deptno" id="deptno">
				<option value="">请选择部门：</option>
				<option value="10">技术部【10】</option>
				<option value="20">销售部【20】</option>
				<option value="30">财务部【30】</option>
				<option value="40">人事部【40】</option>
			</select>
			薪水：
			<select name="sal" id="sal">
				<option value="">请选择薪水：</option>
				<option value="3000.0">3000以下</option>
				<option value="5000.0">[3000-5000)</option>
				<option value="8000.0">[5000-8000)</option>
				<option value="8001.0">8000以上</option>
			</select>
			<input type="submit" value="搜索"/>
		</div>
		<script type="text/javascript">
			document.getElementById("deptno").value="${emp.deptno}";
			document.getElementById("sal").value="${emp.sal}";
		</script>
	</form> 
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>地址</td>
				<td>薪水</td>
				<td>部门编号</td>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach  items="${emps}" var="e">
				<tr>
					<td>${e.eid}</td>
					<td>${e.eno}</td>
					<td>${e.ename}</td>
					<td>${e.age}</td>
					<td>${e.sex}</td>
					<td>${e.address}</td>
					<td>${e.sal}</td>
					<td>${e.deptno}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>