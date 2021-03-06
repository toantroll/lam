<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main User</title>
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
                                <ul class="sub-menu">
                                    <li><a href="#">Thêm mới bài viết</a></li>
                                    <li><a href="#">Tìm kiếm bài viết</a></li>
                                </ul>
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
                                <li><span><i class="fa fa-book"></i>Môn học:</span> ABCXYZ</li>
                                <li><span><i class="fa fa-user-circle-o"></i>Giáo viên:</span> Tên giáo viên</li>
                                <li><span><i class="fa fa-clock-o"></i>Thời gian:</span> 00:00 AM - 12:00 AM</li>
                            </ul>
                        </div><!-- .content-bl -->
                        <div class="content-bl subject">
                            <h3>Nội dung môn học</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
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