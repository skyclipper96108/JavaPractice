<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	*{margin: 0px;padding: 0px;}
	div{width: 280px;border: 6px solid gray;}
	h3{background-color: black; color: white;}
	input{margin: 7px 0px;width: 150px;height: 22px;}
	form {float: left;margin: 10px;}
	a{font-size: 23px;margin: 10px;}
</style>
</head>
<body>
	<h2>练习接收请求参数</h2>
	<a href="${pageContext.request.contextPath}/jsp/controller.jsp">点我回去赛</a>
	<hr>
	
	<%-- 获取请求参数示例1 --%>
	<form action="${pageContext.request.contextPath}/login/form1">
		<div>
			<h3>登录1：HttpServletRequest接收</h3>
			用户：<input name="name" value="tom1"/><br/>
			密码：<input name="pwd" type="password"/><br/>
			<input style="margin-left: 50px;" value="登录1" type="submit"/>
		</div>
	</form>
	
	<%-- 获取请求参数示例2 --%>
	<form action="${pageContext.request.contextPath}/login/form2" method="get">
		<div>
			<h3>登录2：通过参数接收</h3>
			用户：<input name="name" value="tom2"/><br/>
			密码：<input name="pwd" type="password"/><br/>
			<input style="margin-left: 50px;" value="登录2" type="submit"/>
		</div>
	</form>
	
	<%-- 获取请求参数示例3：并解决中文乱码 --%>
	<form action="${pageContext.request.contextPath}/login/form3" method="post">
		<div>
			<h3>登录3：对象接收</h3>
			用户：<input name="name" value="tom3"/><br/>
			密码：<input name="pwd" type="password"/><br/>
			<input style="margin-left: 50px;" value="登录3" type="submit"/>
		</div>
	</form>
	
	<%-- 获取请求参数示例4 --%>
	<form action="${pageContext.request.contextPath}/login/form4/3">
		<div>
			<h3>登录4：URL地址提取</h3>
			用户：<input name="name" value="tom4" /><br/>
			密码：<input name="pwd" type="password"/><br/>
			<input style="margin-left: 50px;" value="登录4" type="submit"/>
		</div>
	</form>
	
</body>
</html>