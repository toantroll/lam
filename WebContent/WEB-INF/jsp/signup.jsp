<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
     <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/datepicker.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/fn.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/bootstrap-datepicker.js"></script>
    <script src="../js/la-management.js"></script>
</head>
<body class="login">

<div class="reg-container">
    <div class="g-row">
        <div class="one-half centered">
            <div class="nav-buttons">
                <ul id="box-content-tabs">
                    <li>
                        <a href="#" data-tab="tab1">
                            <span><i class="fa fa-thumbs-up"></i></span>
                            <label>Quyền lợi học viên</label>
                        </a>
                    </li>
                    <li>
                        <a href="#" data-tab="tab2">
                            <span><i class="fa fa-line-chart"></i></span>
                            <label>Lộ trình khóa học</label>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span><i class="fa fa-list-alt"></i></span>
                            <label>Điều kiện tham gia</label>
                        </a>                        
                    </li>
                    <li>
                        <a href="#">
                            <span><i class="fa fa-graduation-cap"></i></span>
                            <label>Học viên tiêu biểu</label>
                        </a>
                    </li>
                </ul>
            </div><!-- .nav-buttons -->

            <div class="box-content">
                <div class="tab-content" id="tab1">
                    <h3>This is tab1!</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
                <div class="tab-content" id="tab2">
                    <h3>This is tab2!</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
            </div>

            <div class="reg-content register">
                <img src="../img/little-dude.png" class="little-dude" alt=""/>
                <div class="reg-heading">
                    <h2>Đăng ký sinh viên</h2>
                </div><!-- .reg-heading -->

                <div class="reg-inner">
                    <form id="reg-form" action="#" method="post">
                        <ul>
                            <li>
                                <input id="txtHoTen" name="full_name" type="text" placeholder="Họ và tên" autofocus>
                            </li>
                            <li>
                                <input id="txtMobile" name="phone" type="text" placeholder="Điện thoại">
                            </li>
                            <li>
                                <input id="txtEmail" name="email" type="text" placeholder="Email">
                            </li>
                            <li>
                            <input readonly type="text" name="txtNgaydangky" id="txtNgaydangky" class="width-half" placeholder = "Ngày sinh"
                                           value="">
                               <button class="btn" title="Clean" id="btnClrNgaydangky" style="margin-right: 10px; padding: 4px 4px;"><i class="fa fa-refresh" aria-hidden="true"></i></button>
                               <div class="one-third no-pr">
                                        <label class="lbl-slb">
                                            <select>
                                                <option selected> Giới tính </option>
                                                <option>Nam</option>
                                                <option>Nữ</option>
                                                <option>Khác</option>
                                            </select>
                                        </label>
                                    </div>
                            </li>
                            <li>
                                <label class="lbl-slb">
                                    <select>
                                        <option selected>Chưa tốt nghiệp</option>
                                        <option>Đã tốt nghiệp</option>
                                    </select>
                                </label>
                            </li>
                            <li>
                                <input id="txtTruong" name="school" type="text" placeholder="Trường">
                            </li> 
                            <li>
                                <input id="txtMajor" name="major" type="text" placeholder="Chuyên ngành">
                            </li>
                            <li>
                                <input id="txtGraduatedYear" name="graduated_year" type="text" placeholder="Năm tốt nghiệp">
                            </li>
                            <li>
                                <button class="btnSubmit" type="submit"><span>Đăng ký</span></button>
                            </li>
                        </ul>
                    </form><!-- .reg-form -->
                    <div class="row">
                        <div>Bạn đã có tài khoản?
                        <a href="/login">Đăng nhập</a>                        </div>
                    </div>
                </div><!-- .reg-inner -->
            </div><!-- .reg-content -->
        </div>
        <div class="clear"></div>
    </div>
</div>

</body>
</html>