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
                <li><i class="fa fa-angle-double-right"> Thêm mới người dùng</i></li>
            </ul>
        </div><!-- .db-breadcrums -->

        <div class="db-main">
            <div class="wrapper">
                <div class="reg-container">
                    <div class="reg-content">
                        <div class="reg-heading">
                            <h2>Thêm mới người dùng</h2>
                        </div><!-- .reg-heading -->
                        <div class="reg-inner">
                            <div id="import">
                                <div id="import-icon"></div>
                                <form id="import-form" action="import" method="post" enctype="multipart/form-data">
                                    <label id="lblImport" class="full-width">Import danh sách học viên từ file excel</label>
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
                            <form id="reg-form" action="AddStudentController" method="post" onsubmit="return validAddForm();">
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
                                        <div class="input text"><input type="text" name="idCard" id="txtIdCard" placeholder="Số chứng minh nhân dân (*)" required="required" value=""/></div>            </li>    
                                    <li>
                                        <div class="input email"><input type="email" name="email" id="txtEmail" placeholder="Email (*)" required="required" value=""/></div>            </li>
                                    <li>
                                        <div class="g-row">
                                            <div class="one-half no-pad">
                                                <input type="text" id="txtBirthDay" name="birthday" placeholder="Ngày sinh (*)" style="height: 36px;" required>
                                            </div>
                                            <div class="one-half no-pr">
                                                <label class="lbl-slb">
                                                    <select name="gender" required="required"><option value="" selected="selected">Giới tính (*)</option><option value="0">Nữ</option><option value="1">Nam</option><option value="2">Không xác định</option></select>                        </label>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                    </li>

                                    <li>
                                        <input id="txtAddress" name="address" type="text" placeholder="Địa chỉ">
                                    </li>
                                    <li>
                                        <input id="txtHometown" name="hometown" type="text" placeholder="Quê quán">
                                    </li>
                                    <li class="student-only">
                                        <label class="lbl-slb">
                                            <select name="course" id="slCourse"><option value="" selected="selected">Khóa học</option><option value="None">Chưa học</option><option value="LA17_AM">LA17_AM</option><option value="LA17_PM">LA17_PM</option><option value="LA18_AM">LA18_AM</option><option value="LA18_PM">LA18_PM</option><option value="LA19_AM">LA19_AM</option><option value="LA19_PM">LA19_PM</option></select>                </label>
                                    </li>
                                    <li class="student-only">
                                        <div class="input text"><input type="text" name="student_id" id="txtStudent_ID" required="required" placeholder="Student_ID (*)"/></div>            </li>
                                    <li class="student-only">
                                        <label class="lbl-slb">
                                            <select name="japanese_level" id="slJapanese"><option value="" selected="selected">Trình độ tiếng Nhật</option><option value="none">Chưa học</option><option value="N1">JLPT N1</option><option value="N2">JLPT N2</option><option value="N3">JLPT N3</option><option value="N4">JLPT N4</option><option value="N5">JLPT N5</option></select>                </label>
                                    </li>
                                    <li class="student-only">
                                        <label class="lbl-slb">
                                            <select name="status"><option value="">Trạng thái người dùng</option><option value="0">Mới đăng kí người dùng</option><option value="1">Đang đăng kí học LA (chờ phê duyệt)</option><option value="2">Đã từng đăng kí khóa LA</option><option value="3">Đang học LA</option><option value="4">Đã học xong LA</option><option value="5">Bảo lưu kết quả</option></select>                </label>
                                    </li>
                                    <li class="student-teacher">
                                        <div class="input text"><input type="text" name="school" id="txtTruong" placeholder="Trường" value=""/></div>            </li>
                                    <li class="student-teacher">
                                        <div class="input text"><input type="text" name="major" id="txtMajor" placeholder="Chuyên ngành" value=""/></div>            </li>
                                    <li class="student-only">
                                        <div class="input number"><input type="number" name="gra_year" id="txtGraduatedYear" placeholder="Năm tốt nghiệp" value=""/></div>            </li>
                                    <li class="student-only">
                                        <div class="input number"><input type="number" name="iq" id="txtIQ" placeholder="Kết quả test IQ" value=""/></div>            </li>
                                    <li class="student-only">
                                        <label class="lbl-slb">
                                            <select name="interview" id="slInterview"><option value="" selected="selected">Kết quả phỏng vấn</option><option value="0">Đỗ</option><option value="1">Trượt</option><option value="2">Xét</option></select>                </label>
                                    </li>
                                    <li>
                                        <div class="input text"><input type="text" name="note" placeholder="Ghi chú" id="txtNote" value=""/></div>            </li>
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