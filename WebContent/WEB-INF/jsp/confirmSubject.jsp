<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Xác nhận môn học</title>
<link rel="icon" type="favicon" href="img/logo-icon.png" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
#reg-form label {
	font-style: bold;
}
</style>
</head>
<body>
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
						<div class="db-head-control">
							<div class="db-head-mess">
								Xin chào, <span>administrator</span>. Bạn có <a href="#">...
									thông báo</a> chưa đọc.
							</div>
							<div class="db-head-nav">
								<a href="/login"><i class="fa fa-home"></i>Trang chủ</a> <a
									href="#"><i class="fa fa-gears"></i> Cài đặt</a> | <a
									href="/users/logout"><i class="fa fa-sign-out"></i>Đăng
									xuất</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .db-head -->

			<div class="db-breadcrums">
				<ul>
					<li><a href="/users/login">Dashboard </a></li>
					<li><i class="fa fa-angle-double-right"> Thêm mới môn học</i></li>
				</ul>
			</div>
			<!-- .db-breadcrums -->

			<c:choose>
				<c:when test="${param.type eq 'edit'}">
					<c:set var="action"
						value="editSubjectConfirm.do?ssid=${ssid}&type=edit" />
					<c:set var="back" value="editSubject.do?ssid=${ssid}&type=back" />
				</c:when>
				<c:otherwise>
					<c:set var="action"
						value="addSubjectConfirm.do?ssid=${ssid}&type=add" />
					<c:set var="back" value="addSubject.do?ssid=${ssid}&type=back" />
				</c:otherwise>
			</c:choose>
			<div class="db-main">
				<div class="wrapper">
					<div class="reg-container">
						<div class="reg-content">
							<div class="reg-inner">
								<form id="reg-form" action="${action}" method="post">
									<div>
										<table>
											<tr>
												<th style="background-color: #CC3333"><label>Mã
														môn học:</label></th>
											</tr>
											<tr>
												<td><c:out value="${subject.id }"></c:out></td>
											</tr>
											<tr>
												<th style="background-color: #CC3333"><label>Tên
														môn học:</label></th>
											</tr>
											<tr>
												<td><c:out value="${subject.name }"></c:out></td>
											</tr>
											<tr>
												<th style="background-color: #CC3333"><label>Giáo
														viên giảng dạy:</label></th>
											</tr>
											<tr>
												<td><c:out value="${subject.giaoVienName }"></c:out></td>
											</tr>
											<tr>
												<th style="background-color: #CC3333"><label>Nội
														dung:</label></th>
											</tr>
											<tr>
												<td><c:out value="${subject.content }"></c:out></td>
											</tr>
										</table>
									</div>
									<div>
										<button class="btnSubmit btn" style="margin: 20px"
											type="submit">
											<span>Xác nhận</span>
										</button>
										<button class="btnSubmit btn" type="button"
											onclick="window.location.href='${back}'">
											<span>BACK</span>
										</button>
									</div>
								</form>
								<!-- .reg-form -->
							</div>
							<!-- .reg-inner -->
						</div>
						<!-- .reg-content -->
					</div>
					<!-- .reg-container -->
				</div>
				<!-- .wrapper -->

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