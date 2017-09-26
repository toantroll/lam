<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Add User</title>
    <link rel="icon" type="favicon" href="../img/logo-icon.png"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/datepicker.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/fn.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/la-management.js"></script>
</head>
<body>
<body>
<div class="wrapper">
    <div class="db-container">
        <div class="db-head">
            <div class="g-row">
                <div class="one-half">
                    <h1 class="logo"><img src="/img/logo.png" alt=""/></h1>
                </div>
                <div class="one-half">
                    <div class="db-head-control">
                        <div class="db-head-mess">Xin chào, <span>administrator</span>. Bạn có <a href="#">... thông báo</a> chưa đọc.</div>
                        <div class="db-head-nav">
                            <a href="/login"><i class="fa fa-home"></i>Trang chủ</a>                                    <a href="#"><i class="fa fa-gears"></i> Cài đặt</a> |
                            <a href="/users/logout"><i class="fa fa-sign-out"></i>Đăng xuất</a>                                </div>
                    </div>
                </div>
            </div>
        </div><!-- .db-head -->

        <div class="db-breadcrums">
            <ul>
                <li><a href="/users/login">Dashboard </a></li>
                <li><i class="fa fa-angle-double-right"> Thêm mới giáo viên</i></li>
            </ul>
        </div><!-- .db-breadcrums -->

        <div class="db-main">
            <div class="wrapper">
                <div class="reg-container">
                    <div class="reg-content">
                        <div class="reg-heading">
                            <h2>Thêm mới giáo viên</h2>
                        </div><!-- .reg-heading -->
                        <div class="reg-inner">
                            <div id="import">
                                <div id="import-icon"></div>
                                <form id="import-form" action="import" method="post" enctype="multipart/form-data">
                                    <label id="lblImport" class="full-width">Import danh sách giáo viên từ file excel</label>
                                    <div class="pre-import">
                                        <a class="one-half block-dis btn" href="../asset/Import_Template.xlsx">Template</a>
                                        <input class="one-half block-dis btn" id="import_file" name="import_file" type="file" value="Chọn file">
                                    </div>
                                    <button id="btnImport" class="btn" type="submit" style="margin-top: 5px; width: 100%;">Import</button>
                                    <input id="btnResetImp" type="reset">
                                    <div id="importing"><img id="imgImporting" src="/img/loading.gif" alt="loading"></div>
                                </form>
                            </div>
                            <hr/>
                            <form id="reg-form" action="add" method="post" onsubmit="return validAddForm();">
                                <ul>
                                    <!--            <li class="hidden">-->
                                    <!--                --><!--            </li>-->
                                    <li>
                                        <div class="input text"><input type="text" name="full_name" id="txtHoTen" placeholder="Họ và tên (*)" autofocus="autofocus" required="required" value=""/></div>            </li>
                                    <li>
                                        <div class="input text"><input type="text" name="username" id="txtUsername" placeholder="Tên đăng nhập (*)" required="required" value=""/></div>
                                    </li>
                                    <li>
                                        <input id="txtPassword" name="password" type="password" placeholder="Mật khẩu (*)" required>
                                    </li>
                                    <li>
                                        <div class="input text"><input type="text" name="phone" id="txtMobile" placeholder="Điện thoại (*)" required="required" value=""/></div>            </li>
                                    <li>
                                        <div class="input email"><input type="email" name="email" id="txtEmail" placeholder="Email (*)" required="required" value=""/></div>            </li>
                               
                                    <li>
                                        <button class="btnSubmit btn" type="submit"><span>Thêm mới</span></button>
                                    </li>
                                </ul>
                            </form><!-- .reg-form -->
                        </div><!-- .reg-inner -->        </div><!-- .reg-content -->
                </div><!-- .reg-container -->
            </div><!-- .wrapper -->
            <!--Modal validate-->
            <div id="valid-box" class="valid">
                <a class="close-box link-btn"><i class="fa fa-window-close img-close" aria-hidden="true"></i></a>
                <p class="valid-title"></p>
                <button id="valid-button" class="button-s valid-button" type="button">Đồng ý</button>
            </div><!--Modal validate-->

            <!--Modal result message-->
            <div id="result-box" class="valid" style="max-height: 350px;">
                <p class="result-title"></p>
                <!--    <iframe>-->
                <pre class="import-result"></pre>
                <!--    </iframe>-->
                <button id="confirmDelResult" class="btn button-s valid-button" type="button">OK</button>
            </div><!--Modal result message-->                </div><!-- .db-main -->

        <div class="db-foot">
            <p>LA - Management 2017</p>
        </div><!-- .db-foot -->

    </div><!-- .search-container -->
</div><!-- .wrapper -->
</body>
</html>