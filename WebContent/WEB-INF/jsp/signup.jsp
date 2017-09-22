<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.min.js"></script>
<script src="js/fn.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/la-management.js"></script>
<style type="text/css">
.err {
	color: red;
}
    .box-content h3{
    	color: #ffffff;
    }
    .sub-page-content{
    background-color: #0b3d65;
    }

</style>
</head>
<body class="login">
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.10&appId=1460539560694186";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<div class="reg-container">
		<div class="g-row">
			<div class="one-half centered">
				<div class="nav-buttons">
					<ul id="box-content-tabs">
						<li><a href="#" data-tab="tab1"> <span><i
									class="fa fa-thumbs-up"></i></span> <label>Quyền lợi học viên</label>
						</a></li>
						<li><a href="#" data-tab="tab2"> <span><i
									class="fa fa-line-chart"></i></span> <label>Lộ trình khóa học</label>
						</a></li>
						<li><a href="#"> <span><i class="fa fa-list-alt"></i></span>
								<label>Điều kiện tham gia</label>
						</a></li>
						<li><a href="#"> <span><i
									class="fa fa-graduation-cap"></i></span> <label>Học viên tiêu
									biểu</label>
						</a></li>
					</ul>
				</div>
				<!-- .nav-buttons -->

				<div class="box-content">
					<div class="tab-content" id="tab1">
						<h3>This is tab1!</h3>
						<div class="fb-comments"
							data-href="http://localhost:8081/LA_Management/RegisterController"
							data-width="600px" data-numposts="5"></div>
					</div>
					<div class="tab-content" id="tab2">
					<br>
					<br>
							<div class="head row">
								<img id="head-img-1"
									class="col-xs-3 col-sm-2 head-img nopadding"
									src="img/JapanandVietNam-min.png" alt="JapanAndVietNam">
									<h3>Điều kiện tham gia!</h3>
							</div>
							<div id="sub-page-content-1" class="sub-page-content">
							<div class="col-sm-8 col-sm-offset-2">
								<p>Là dự án chiến lược của FPT Software, đào tạo nguồn lực
									Kỹ Sư Công Nghệ Thông Tin giỏi tiếng Nhật trong thời gian ngắn
									nhất để cung cấp cho thị trường Nhật Bản và Việt Nam.</p>
							</div>
							<div class="col-md-8 col-md-offset-2 col-xs-12">
								<p class="title">ĐIỀU KIỆN THAM GIA</p>
								<p>Nếu bạn là:</p>
								<ul>
									<li>Nam, nữ dưới 30 tuổi.</li>
									<li>Tốt nghiệp đại học chuyên ngành CNTT/ Điện tử viễn
										thông/ Kỹ thuật máy tính</li>
									<li>Có kiến thức nền tảng vững, thành thạo ngôn ngữ C, C#,
										Java, PHP, .net,...</li>
									<li>Có khả năng tự học, tư duy tốt</li>
								</ul>
								<p>Hãy cùng FPT Software lập trình lộ trình sự nghiệp 5 năm
									của bạn!</p>
							</div>
						</div>
					</div>
					<div class="tab-content" id="tab3">
						<div class="fb-comments"
							data-href="https://developers.facebook.com/docs/plugins/comments#configurator"
							data-width="600px" data-numposts="5"></div>
					</div>
				</div>

				<div class="reg-content register">
					<img src="../img/little-dude.png" class="little-dude" alt="" />
					<div class="reg-heading">
						<h2>Đăng ký nhận thông tin</h2>
					</div>
					<!-- .reg-heading -->

					<div class="reg-inner">
						<form id="reg-form" action="RegisterController" method="post">
							<ul>
								<li><input id="txtHoTen" name="full_name" type="text" value = "${registerInfo.fullName}"
									placeholder="Họ và tên" autofocus>
									<div class="err">
										<c:if test="${listError.containsKey('full_name')}">${listError.get('full_name')}</c:if>
										
									</div></li>

								<li><input id="txtMobile" name="phone" type="text" value = "${registerInfo.email}"
									placeholder="Điện thoại">
									<div class="err">
										<c:if test="${listError.containsKey('tel')}">${listError.get('tel')}</c:if>
										
									</div></li>
								<li><input id="txtEmail" name="email" type="text" value = "${registerInfo.tel}"
									placeholder="Email">
									<div class="err">
										<c:if test="${listError.containsKey('email')}">${listError.get('email')}</c:if>
										
									</div></li>
								<li><input readonly type="text" name="txtNgaydangky" value = "${registerInfo.birthday}"
									id="txtNgaydangky" class="width-half" placeholder="Ngày sinh"
									value="">
									<button class="btn" title="Clean" id="btnClrNgaydangky"
										style="margin-right: 10px; padding: 4px 4px;">
										<i class="fa fa-refresh" aria-hidden="true"></i>
									</button>
									<div class="err">
										<c:if test="${listError.containsKey('birthday')}">${listError.get('birthday')}</c:if>
									</div>
									</li>
								<li><label class="lbl-slb"> <select name = "selectStatus">
											<option value = "0">--Trạng thái tốt nghiệp--</option>
											<c:forEach var="status" items="${listStatus}">
												<option value="${status.id}">${status.nameStatus}</option>
											</c:forEach>

									</select>
								</label>
								<div class="err">
										<c:if test="${listError.containsKey('status')}">${listError.get('status')}</c:if>
										
									</div></li>
								<li><input id="txtTruong" name="school" type="text" value = "${registerInfo.school}"
									placeholder="Trường">
									<div class="err">
										<c:if test="${listError.containsKey('school')}">${listError.get('school')}</c:if>
										
									</div></li>
								<li><input id="txtMajor" name="major" type="text" value = "${registerInfo.major}"
									placeholder="Chuyên ngành">
									<div class="err">
										<c:if test="${listError.containsKey('major')}">${listError.get('major')}</c:if>
									</div></li>
								<li><input id="txtGraduatedYear" name="graduated_year" value = "${registerInfo.graduatedYear}"
									type="text" placeholder="Năm tốt nghiệp">
									<div class="err">
										<c:if test="${listError.containsKey('year_graduate')}">${listError.get('year_graduate')}</c:if>
									</div></li>
								<li>
									<button class="btnSubmit" type="submit">
										<span>Đăng ký</span>
									</button>
								</li>
							</ul>
						</form>
						<!-- .reg-form -->
						<div class="row">
							<div>
								Bạn đã có tài khoản? <a href="/login">Đăng nhập</a>
							</div>
						</div>
					</div>
					<!-- .reg-inner -->
				</div>
				<!-- .reg-content -->
			</div>
			<div class="clear"></div>
		</div>
	</div>

</body>
</html>