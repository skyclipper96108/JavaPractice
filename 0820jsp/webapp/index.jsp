<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
 		<tr>
 			<th>id</th>
 			<th>name</th>
 			<th>password</th>
 		</tr>
</thead>
 <tbody>
 		<c:forEach items="${emps }" var="e">
 		<tr class="c${s.index%2 }">
 			<td>${e.id }</td>
 			<td>${e.username }</td>
 			<td>${e.password }</td>
 		</tr>
 		</c:forEach>
</tbody>
</table>
</body>
</html>