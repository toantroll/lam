<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main teacher</title>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/fn.js"></script>
</head>
<body>

<div class="wrapper">
    <div class="db-container">
        <div class="db-head">
            <div class="g-row">
                <div class="one-half">
                    <h1 class="logo"><img src="../img/logo.png" alt=""/></h1>
                </div>
                <div class="one-half">
                    <div class="one-third">
                        <div class="avatar"><a href="#"><img src="../img/profile-ava.png"></a></div>
                    </div>
                    <div class="two-thirds">
                        <div class="db-head-control">
                            <div class="db-head-mess">Xin chào, <span>administrator</span></div>
                            <div class="db-head-nav">
                                <a href="/login"><i class="fa fa-home"></i>Trang chủ</a>                                    
                                <a href="#"><i class="fa fa-gears"></i> Cài đặt</a> |
                                <a href="/users/logout"><i class="fa fa-sign-out"></i>Đăng xuất</a>
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div><!-- .db-head -->

        <div class="g-row">
            <div class="full-width">
                <div class="db-breadcrums">
                    <ul>
                        <li><a href="/users/login">Dashboard </a></li>
                    </ul>
                </div><!-- .db-breadcrums -->
            </div>
        </div>

        <div class="db-main">
            
            <div class="g-row">
                <div class="one-quarter">
                    <div class="menu">
                        <ul class="nav">
                            <li><a href="#">Nội dung</a></li>
                            <li>
                                <a href="#">Tin tức <i class="fa fa-plus-square-o"></i></a>                               
                            </li>
                            <li><a href="#">Thời khóa biểu</a></li>
                            <li><a href="#">Cài đặt hệ thống</a></li>
                        </ul>
                    </div>
                </div>
                <div class="three-quarters">
                    <div class="main-content">
                        <div class="content-bl subject">
                            <ul class="info-class">
                            <c:forEach items="${listArticle}" var="article" >
                            	<p><a href="ViewDetailArticle.do?id=${article.id}">${article.title}</a></p>
                            </c:forEach>
                            </ul>
                        </div><!-- .content-bl -->                       
                    </div><!-- .main-content -->
                </div>
            </div>
           
        </div><!-- .db-main -->

        <div class="db-foot">
            <p>LA - Management 2017</p>
        </div><!-- .db-foot -->

    </div><!-- .search-container -->
</div><!-- .wrapper -->

</body>
</html>