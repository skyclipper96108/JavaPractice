<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>download practice</title>
</head>
<body style="background-color: fuchsia;">
	<div style="width: 400px; margin: 50 px auto;">
		<marquee><h2>download</h2></marquee>
		<ul style="style-size: 25px">
			<li>
				<a href="downLoad?fileName=words.txt">words.txt</a>
			</li>
			<li>
				<a href="downLoad?fileName=suiji.zip">suiji.zip</a>
			</li>
			<li>
				<a href="downLoad?fileName=star.mp4">star.mp4</a>
			</li>
			<li>
				<a href='downLoad?fileName=<%=URLEncoder.encode("美女.jpg", "UTF-8") %>'>美女.jpg</a>
			</li>
		</ul>
	</div>
</body>
</html>