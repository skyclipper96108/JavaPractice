<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.BeanPractice.Emp" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new start</title>
<style type="text/css">
	table{
			width: 50%;
			text-align: center;
	}
	th,td{
			border: 1px solid red;
			height: 30px;
	}
	.c0{
		background-color:pink;
		}
	.c1{
		background-color:yellow;
	}
</style>
</head>
<body>
 <h1>baby one more time</h1>
 <%-- 这里的注释源代码是看不见的 --%>
 <% String msg="这里可以写java"; %>
 <%=msg %>

 	<!--el获取四大作用域的绑定值，依次从小到大获取--><br>
 <% 
	 pageContext.setAttribute("name", "tom");
	 request.setAttribute("name", "tony");
	 session.setAttribute("username", "lily");
	 application.setAttribute("user", "amy");
 %>
 	
 	${ name }
 	${ requestScope.name }
 	 <!--el获取Bean属性值--><br>
<%
		// 模拟从后台获取到的数据
		Emp emp=new Emp(5, "Armand", "45346384");
		request.setAttribute("emp", emp);
%>
<!-- 绑定名写错不报错，属性名写错会报错 --><br>
 	${emp.username }
 	
 	<%
 			ArrayList<Emp> emps = new ArrayList<>();
 			emps.add(new Emp(1, "kevin","326574464"));
 			emps.add(new Emp(2, "edward","463375745"));
 			emps.add(new Emp(3, "laura","14634575475"));
 			emps.add(new Emp(4, "ruby","236464334"));
 			emps.add(new Emp(5, "arseid","246454754"));
 			emps.add(new Emp(6, "gucci","1466436436"));
 			emps.add(new Emp(7, "jacob","346473344"));
 			emps.add(new Emp(8, "jack","5477324624"));
 			emps.add(new Emp(9, "lucy","2477554745"));
 			request.setAttribute("emps", emps);
 		    
 	%>
 <table>
 	<thead>
 		<tr>
 			<th>id</th>
 			<th>name</th>
 			<th>password</th>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach items="${emps }" var="e" varStatus="s">
 		<!-- forEach用来遍历 获取作用域中绑定的集合或者数组 
 				并声明一个变量 var 循环遍历集合中的每一个对象
 				varStatus记录遍历的状态
 		 -->
 		<tr class="c${s.index%2 }">
 			<td>${e.id }</td>
 			<!-- <td>${e.username }</td> -->
 			<td>
 					<c:if test="${e.username=='gucci' }" var="v">
 					<span style="color:red">${e.username } bag</span>
 					</c:if>
 					<c:if test="${!v }">
 						${e.username }
 					</c:if>
 			</td>
 			<td>${e.password }</td>
 		</tr>
 		</c:forEach>
 	</tbody>
 </table>
</body>
</html>