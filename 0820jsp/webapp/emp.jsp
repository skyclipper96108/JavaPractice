<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
	<head>
		<meta charset="UTF-8">
		<title>员工管理</title>
		<link rel="stylesheet" href="/css/main.css" />
	</head>
	<body>
		<div>
			<div id="head">
				<marquee>你想一夜暴富吗？你想一夜成名吗？别做梦了，好好编程吧!!!</marquee>
				<table border="1" width="100%" cellspacing="0">
					<tr>
						<th><img alt="" src="/img/one/1.jpg"></th>
						<th><img alt="" src="/img/one/2.jpg"></th>
						<th><img alt="" src="/img/one/3.jpg"></th>
						<th><img alt="" src="/img/one/4.jpg"></th>
						<th><img alt="" src="/img/one/5.jpg"><br /> 欢迎XX登录&emsp;
							<a href="login.html">注销登录</a>
						</th>
					</tr>
				</table>
			</div>
			<div class="clfloat" id="left">
				<a href="emp.html">
					<div class="active">员工管理</div>
				</a>
				<a href="dept.html">
					<div>部门管理</div>
				</a>
				<a href="#">
					<div>扩展功能</div>
				</a>
			</div>
			<div class="clfloat" id="right">
				<div id="nav">
					首页>>>>员工管理
				</div>
				<table border="1" width="100%" cellspacing="0">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>住址</th>
						<th>电话</th>
						<th>银行卡号</th>
						<th>操作&emsp;|&emsp;<a href="/emp_add.jsp">新增</a></th>
					</tr>
					<c:forEach items="${emps }" var="e">
						<tr>
							<td>${e.eid }</td>
							<td>${e.ename }</td>
							<td>${e.sex }</td>
							<td>${e.address }</td>
							<td>${e.tel }</td>
							<td>${e.card }</td>
							<td>
								<a href="/emp/update1?eid=${e.eid }">编辑</a>&emsp;|&emsp;
								<a href="/emp/del?eid=${e.eid }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>