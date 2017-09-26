<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Main User</title>
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/fn.js"></script>
<link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<script src="js/moment.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/fn.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/timetable.js"></script>
</head>
<body class='default'>
	<input type="hidden" id="timetableid" value="${id}"/>
	<div class="wrapper">
		<div class="db-container">
			<div class="db-head">
				<div class="g-row">
					<div class="one-half">
						<h1 class="logo">
							<img src="img/logo.png" alt="" />
						</h1>
					</div>
					<div class="one-half">
						<div class="one-third">
							<div class="avatar">
								<a href="#"><img src="img/profile-ava.png"></a>
							</div>
						</div>
						<div class="two-thirds">
							<div class="db-head-control">
								<div class="db-head-mess">
									Xin chào, <span>administrator</span>
								</div>
								<div class="db-head-user-control">
									<a href="#"><i class="fa fa-user"></i>Thông tin cá nhân</a> | <a
										href="#"><i class="fa fa-gears"></i> Đổi mật khẩu</a>
								</div>
								<div class="db-head-nav">
									<a href="#"><i class="fa fa-home"></i>Trang chủ</a> <a href="#"><i
										class="fa fa-gears"></i> Cài đặt</a> | <a href="#"><i
										class="fa fa-sign-out"></i>Đăng xuất</a>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<!-- .db-head -->

			<div class="g-row">
				<div class="full-width">
					<div class="menu">
						<ul class="nav">
							<li><a href="#">Nội dung</a></li>
							<li><a href="#">Tin tức</a>
								<ul class="sub-menu">
									<li><a href="#">Thêm mới bài viết</a></li>
									<li><a href="#">Tìm kiếm bài viết</a></li>
								</ul></li>
							<li><a href="#">Thời khóa biểu</a></li>
							<li><a href="#">Cài đặt hệ thống</a></li>
						</ul>
					</div>
				</div>
				<div class="clear"></div>

				<div class="full-width">
					<div class="db-breadcrums">
						<ul>
							<li><a href="/users/login">Dashboard </a></li>
						</ul>
					</div>
					<!-- .db-breadcrums -->
				</div>
			</div>

			<div class="db-main">

				<div class="g-row">
					<div class="full-width">
						<div class="main-content">
							<div class="content-bl">
								<h3>Lịch thời khóa biểu</h3>

								<div id='jqxWidget'>
									<div style='margin-top: 3px;' id='calendar'></div>
								</div>
								<div class="clear"></div>
							</div>
							<!-- .content-bl -->
									<div class="row">
										<table class="table">
											<thead>
												<tr>
													<th>Tuần</th>
													<th>Thứ 2</th>
													<th>Thứ 3</th>
													<th>Thứ 4</th>
													<th>Thứ 5</th>
													<th>Thứ 6</th>
												</tr>
											</thead>
											<tbody id="time_table">
								
											</tbody>
										</table>
									</div>
								</div>
								<!-- .reg-content -->
								<div class="clear"></div>

								<!-- Modal -->
								<div class="modal fade" id="timeTableDetail" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<form id="timeTableDetailForm" method="POST">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h2 class="modal-title" id="titleTableDetail">Modal
														title</h2>
												</div>
												<div class="modal-body">
													<div class="row message"></div>
													<div class="row">
														<div class='col-sm-3'>
															<label for="timeTimeTable">Giờ bắt đầu</label>
														</div>
														<div class='col-sm-6'>
															<input type="hidden" name="date" id="date" /> <input
																type="hidden" name="idDetail" id="idDetail" /> <input
																type="hidden" name="idTimeTable" id="idTimeTable" /> <input
																type='text' class="form-control" id='timeTimeTable'
																name="time" />
														</div>
														<script type="text/javascript">
															$(function() {
																$(
																		'#timeTimeTable')
																		.datetimepicker(
																				{
																					format : 'HH:mm'
																				});
															});
														</script>
													</div>
													<div class="row">
														<div class='col-sm-3'>
															<label for="timeTimeTable">Môn học:</label>
														</div>
														<div class='col-sm-6'>
															<select name="subject" class="form-control"
																id="cbxSubject">
																<option selected="selected" value="0">--Chọn
																	Môn học--</option>
																<option value="9">Project</option>
															</select>
														</div>
													</div>
													<div class="row">
														<div class='col-sm-3'>
															<label for="timeTimeTable">Tiêu đề:</label>
														</div>
														<div class='col-sm-6'>
															<input type='text' class="form-control"
																name="titleSubject" id="titleSubject" />
														</div>
													</div>
													<div class="row">
														<div class='col-sm-3'>
															<label for="timeTimeTable">Số giờ:</label>
														</div>
														<div class='col-sm-6'>
															<input type='text' class="form-control"
																name="hoursPerDay" id="hoursPerDay" />
														</div>
													</div>
													<div class="row">
														<div class='col-sm-3'>
															<label for="timeTimeTable">Có bài kiểm tra:</label>
														</div>
														<div class='col-sm-6'>
															<input type="checkbox" class="form-control" name="isTest"
																id="isTest" />
														</div>
													</div>

												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Hủy</button>
													<button type="button" class="btn btn-danger" id="deleteDetail">Xóa</button>
													<button type="submit" class="btn btn-primary">Lưu</button>
												</div>
											</form>
										</div>
									</div>

								
							<!-- .content-bl -->
						</div>
						<!-- .main-content -->
					</div>
				</div>

			</div>
			<!-- .db-main -->

			<div class="db-foot">
				<p>LA - Management 2017</p>
			</div>
			<!-- .db-foot -->

		</div>
		<!-- .search-container -->
	</div>
	<!-- .wrapper -->

</body>
</html>