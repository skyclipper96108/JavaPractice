<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	ul{
		font-size: 20px;
	}
	li{
		margin-top: 10px;
	}
</style>
</head>
<body>
	<h2>控制器常用操作</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath }/jsp/model1.jsp">练习接收请求参数</a></li>
		<li><a href="${pageContext.request.contextPath }/jsp/model2.jsp">练习向页面传值</a></li>
		<li><a href="${pageContext.request.contextPath }/jsp/model3.jsp">练习重定向和forward转发</a></li>
	</ul>
	
</body>
</html>