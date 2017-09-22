<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="icon" type="favicon" href="img/logo-icon.png"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="login">
<div class="login-container">
    <div class="login-header">
        <h1>LA - Management</h1>
    </div><!-- .login-header -->

    <div class="login-content">
        <img src="../img/little-dude.png" class="little-dude" alt=""/>
        <div class="login-heading">
            <h2>Đăng nhập</h2>
        </div><!-- .login-heading -->
		<c:if test="${not empty errorMess}">
			<c:forEach items="${errorMess}" var="message">
				<p class="errMsg" >
					${message}
					</p>
			</c:forEach>
			</c:if>
        <div class="login-inner">
            <form id="login-form" action="LoginController" method="post">
                <ul> 
                    <li> 
                        <input id="username" name="username" type="text" value="<c:out value="${userName}"></c:out>" placeholder="Tên đăng nhập" autofocus>
                        <i class="fa fa-user"></i>
                    </li>
                    <li>
                        <input id="password" name="password" type="password" placeholder="Mật khẩu">
                        <i class="fa fa-lock"></i>
                    </li>
                    <li>
                        <button class="btnSubmit" type="submit"><span>Đăng nhập</span></button>
                    </li>
                </ul>
            </form><!-- .login-form -->

        </div><!-- .login-inner -->
    </div><!-- .login-content -->

    <div class="login-footer">
        <a href="/users/signup">Đăng ký tài khoản</a>    </div><!-- .login-footer -->
</div> <!-- .login-container -->
</body>
</html>