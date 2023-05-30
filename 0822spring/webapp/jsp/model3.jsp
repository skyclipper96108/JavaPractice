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
	<h2>练习重定向和forward转发</h2>
	<a href="${pageContext.request.contextPath}/jsp/controller.jsp">点我回去赛</a>
	<hr>
	
	<%-- 练习重定向 --%>
	<form action="${pageContext.request.contextPath}/login/form8">
		<div> 
			<h3>登录8：练习重定向（redirect）</h3>
			返回信息：${message8 }<br/>
			<input style="margin-left: 50px;" value="登录8" type="submit"/>
		</div>
	</form>
	
	<%-- 练习forward转发 --%>
	<form action="${pageContext.request.contextPath}/login/form9">
		<div> 
			<h3>登录9：练习转发（forward）</h3>
			返回信息：${message9 }<br/>
			<input style="margin-left: 50px;" value="登录9" type="submit"/>
		</div>
	</form>
	
</body>
</html>