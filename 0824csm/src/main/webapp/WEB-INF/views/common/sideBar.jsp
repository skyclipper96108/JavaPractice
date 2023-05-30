<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    	<!-- Sidebar menu-->
	<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
	<aside class="app-sidebar">
		<div class="app-sidebar__user">
			<img class="app-sidebar__user-avatar" width="48px" height="48px"
				src="/static/system/images/m1.jpg" alt="User Image">
			<div>
				<p class="app-sidebar__user-name">${user_in_session.nickName}</p>
			</div>
		</div>
		<ul class="app-menu">
			<li><a class="app-menu__item"
				href="/system/article/index"> 
				<i class="app-menu__icon fa fa-dashboard"></i> <span
					class="app-menu__label">文章管理</span>
			</a></li>
			<li><a class="app-menu__item"
				href="/system/slide/index"> 
				<i class="app-menu__icon fa fa-dashboard"></i> <span
					class="app-menu__label">轮播图管理</span>
			</a></li>
		</ul>
	</aside>
 	</body>
</html>