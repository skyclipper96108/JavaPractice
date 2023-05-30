<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- 引入头部的静态资源 -->
	<%@include file="/WEB-INF/views/common/topArticle.jsp"%>
	
	<title>CMS登陆</title>
</head>
<body>
	<section class="material-half-bg">
		<div class="cover"></div>
	</section>
	<section class="login-content">
	<div class="logo">
		<h1>cms后台登陆</h1>
	</div>
	<div class="login-box">
		<form class="login-form" method="post" action="/system/login" id="loginForm">
			<h3 class="login-head">
				<i class="fa fa-lg fa-fw fa-user"></i>登陆&emsp;<span id="loginMessage"></span>
			</h3>
			<div class="form-group">
				<label class="control-label">用户名</label> <input class="form-control"
					type="text" name="username" placeholder="用户名" required="required" autofocus>
			</div>
			<div class="form-group">
				<label class="control-label">密码</label> <input class="form-control"
					type="password" name="password" placeholder="密码" required="required">
			</div>
			<div class="form-group">
				<div class="utility">
					<div class="animated-checkbox">
						<label> <input type="checkbox" name="remember" value="1"><span
							class="label-text">记住我</span>
						</label>
					</div>
				</div>
			</div>
			<div class="form-group btn-container">
				<!-- button标签在form表单中默认是提交按钮，需要加上type="button" 才会变成普通按钮 -->
				<button type="button" class="btn btn-primary btn-block" id="loginButton">
					<i class="fa fa-sign-in fa-lg fa-fw"></i>登陆
				</button>
			</div>
		</form>
	</div>
	</section>
	
	<!-- 引入底部的静态资源 -->
	<%@include file="/WEB-INF/views/common/bottomArticle.jsp"%>
	<script type="text/javascript">
	<!-- 引入底部的静态资源 -->
		$(function(){
			$("#loginButton").on ("click",function(){
				login();
			});
		});
		//整个文档绑定事件 e事件源
		$(document).on('keypress',function(e){
			if(e.keyCode==13){//回车键是13
				login();
			}
		});
		function login(){
			$("#loginForm").ajaxSubmit({
				success:function(data){
					if(data.success){
						//跳转到后台首界面
						location.href="/system/index";
					}else{
						$("#loginMessage").html(data.msg).css("color","red").css("font-size","18px");
					}
				}
			});
		}
		//1.获取所有cookie 2.获取到username和password的cookie的值 3.将cookie设置到表单中
		var cookies = document.cookie; // 获取自定义的所有cookie
		if(cookies.indexOf("username")!=-1){
			var arr = cookies.split(";");
			var username = null;
			var password = null;
			for(var i=0; i<arr.length;i++){
				if(arr[i].indexOf("username")!=-1){
					username = arr[i].substring(arr[i].lastIndexOf("=")+1);
				}
				if(arr[i].indexOf("password")!=-1){
					password = arr[i].substring(arr[i].lastIndexOf("=")+1);
				}
			}
			alert(username);
			$("input[name='username']").val(username);
			$("input[name='password']").val(password);
			$("input[name='remember']").prop("checked",true);
		}else{
			$("input[name='username']").val("");
			$("input[name='password']").val("");
			$("input[name='remember']").prop("checked",false);
		}
	</script>

</body>
</html>
