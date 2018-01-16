<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<base href="<%=basePath%>" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>用户登录</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="vicassets/i/faon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="assets/css/app.css">
<script src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body data-type="login">
<%
String username="";
String password="";
Cookie[] cook=request.getCookies();
if(cook!=null)
{
  for(int i=0;i<cook.length;i++)
  {
    if(cook[i].getName().equals("myCookieName"))
    {
        username=cook[i].getValue();
     }
    if(cook[i].getName().equals("myCookiePwd"))
    {
        password=cook[i].getValue();
     }
   }
 }
%>
	<script src="assets/js/theme.js"></script>
	<div class="am-g tpl-g">
		<!-- 风格切换 -->
		<div class="tpl-skiner">

			<div>
				<div>
					<h1 align="center">用户登录</h1>
				</div>
				<div>
					<h3 align="center">
						<c:if test="${fail==0}">
							<font color="red">用户名密码为空</font>
						</c:if>
						<c:if test="${fail==1}">
                此用户 <font color="red">${inputName}</font>密码错误
                    </c:if>
						<c:if test="${fail==2}">
                此用户 <font color="red">${inputName}</font>不存在
                    </c:if>
					</h3>
				</div>
				<div class="tpl-skiner-content-bar">
					<span class="skiner-color skiner-white" data-color="theme-white"></span>
					<span class="skiner-color skiner-black" data-color="theme-black"></span>
				</div>
			</div>
		</div>
		<div class="tpl-login">
			<div class="tpl-login-content">
				<div class="tpl-login-logo"></div>



				<form name="login" class="am-form tpl-form-line-form"
					  action="user/login" method="post">
					<div class="am-form-group">
					<%--<input   type="hidden"  value="true"  id="resubmit" name="resubmit"/>   --%>
						<%--<input type="hidden" value="login" name="methods" />--%>
					<%--</div>--%>

					<div class="am-form-group">
						<input type="text" class="tpl-form-input" value="<%=username%>" name="user.username"
							onblur="loginCheckUname()" onfocus="loginSpanUname()" id="username"
							placeholder="请输入账号" />
							<span id="unameSpan"></span>
						<input type="password" class="tpl-form-input" name="user.password" value="<%=password%>" id="password" placeholder="请输入密码">
						<span id="pwdSpan"></span>
					</div>
					<div class="am-form-group tpl-login-remember-me">
						<input id="remember-me" name="remember-me" type="checkbox"> <label
							for="remember-me"> 记住密码 </label>

					</div>
					<div class="am-form-group">
						<input type="submit"
							class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" placeholder="提交" />
					</div>
				</form>
				<div class="am-form-group">
					<button type="submit" formaction="user/toRegister"
						   class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" placeholder="提交" />
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>

</body>

</html>