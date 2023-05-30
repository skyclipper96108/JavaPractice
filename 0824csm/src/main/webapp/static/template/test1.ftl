<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<marquee>
				<h1>${name}</h1>
				<h1>
					<#if age lt 18>
						未成年
					<#elseif age gte 18 && age lt 50>
						奋斗的年龄
					<#else>
						养老
					</#if>			
				</h1>
		</marquee>
</body>
</html>