<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta charset="UTF-8">
		<title>新增员工信息</title>
		<link rel="stylesheet" href="/css/main.css" />
		<link rel="stylesheet" href="/css/content.css" />
	</head>

	<body>
		<div>
			<div id="head">
				<marquee>人生没有彩排，每天都是现场直播!!!</marquee>
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
					首页>>>>员工管理>>>>新增数据
				</div>
				<form action="/emp/add">
					<table border="1" cellspacing="0" width="100%">
						<tr>
							<th>姓名</th>
							<th><input type="text" name="ename" required="required"></th>
						</tr>
						<tr>
							<th>性别</th>
							<th>
								<select name="sex">
									<option value="男" selected="selected">男 </option>
									<option value="女">女</option>
								</select>
							</th>
						</tr>
						<tr>
							<th>住址</th>
							<th><input type="text" name="address"></th>
						</tr>
						<tr>
							<th>电话</th>
							<th><input type="text" name="tel" required="required"></th>
						</tr>
						<tr>
							<th>银行卡号</th>
							<th><input type="text" name="card" required="required"></th>
						</tr>
						<tr>
							<th colspan="2">
								<input type="submit" value="新增数据">
							</th>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>

</html>