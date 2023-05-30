<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload</title>
</head>
<body style="background-color: orange; ">
	<div style="width:400px; margin:50px auto; ">
		<form action="/upload" method="post" enctype="multipart/form-data">
			username: <input type="text" name="name"><br><br>
			password: <input type="password" name="pwd"><br><br>
			<!-- 复杂表单项 -->
			upload image: <input type="file" name="photo"><br><br>
			<input type="submit" value="submit">
			<span style="color: red; font-size: 15px">${ error }</span>
		</form>
	</div>
</body>
</html>