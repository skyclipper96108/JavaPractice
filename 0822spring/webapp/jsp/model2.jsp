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
	<h2>练习向页面传值</h2>
	<a href="${pageContext.request.contextPath}/jsp/controller.jsp">点我回去赛</a>
	<hr>
	
	<%-- 向页面传值示例1 --%>
	<form action="${pageContext.request.contextPath}/login/form5">
		<div>
			<h3>登录5：HttpServletRequest传递</h3>
			返回信息：${message5 }<br/>
			<input style="margin-left: 50px;" value="登录5" type="submit"/>
		</div>
	</form>
	
	<%-- 向页面传值示例2 --%>
	<form action="${pageContext.request.contextPath}/login/form6">
		<div>
			<h3>登录6：使用Model方式</h3>
			返回信息：${message6 }<br/>
			<input style="margin-left: 50px;" value="登录6" type="submit"/>
		</div>
	</form>
	
	<%-- 向页面传值示例3 --%>
	<form action="${pageContext.request.contextPath}/login/form7">
		<div>
			<h3>登录7：ModelAndView对象传递</h3>
			返回信息：${message7 }<br/>
			<input style="margin-left: 50px;" value="登录7" type="submit"/>
		</div>
	</form>

</body>
</html>