<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thêm mới môn học</title>
<link rel="icon" type="favicon" href="img/logo-icon.png" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="db-container">
			<div class="db-head">
				<div class="g-row">
					<div class="one-half">
						<h1 class="logo">
							<img src="../img/logo.png" alt="" />
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
				<c:when test="${subject.flag == 1}">
					<c:set var="action"
						value="editSubject.do?subjectId=${subject.id}&type=edit&validate=true" />
				</c:when>
				<c:otherwise>
					<c:set var="action" value="addSubject.do?type=add" />
				</c:otherwise>
			</c:choose>
			<div class="db-main">
				<div class="wrapper">
					<div class="reg-container">
						<div class="reg-content">
							<div class="reg-inner">
								<form id="reg-form" action="${action}" method="post">
									<ul>
										<c:forEach items="${listError}" var="error">
											<li>
												<div align="left">
													<label><c:out value="${ error}"></c:out></label>
												</div>
											</li>
										</c:forEach>
										<li>
											<div align="left">
												<label>Mã môn học:</label>
											</div>
										</li>
										<li>
											<div class="input text">
												<input type="text" name="subjectId" id="txtMamonhoc"
													autofocus="autofocus" required="required"
													<c:if test="${subject.flag == 1}">readonly="readonly"</c:if>
													value='<c:out value="${subject.id }"></c:out>' />
											</div>
										</li>
										<li>
											<div align="left">
												<label>Tên môn học:</label>
											</div>
										</li>
										<li>
											<div class="input text">
												<input type="text" name="subjectName" id="txtTenmonhoc"
													autofocus="autofocus" required="required"
													value='<c:out value="${subject.name }"></c:out>' />
											</div>
										</li>
										<!--	<li><label class="lbl-slb"> <select
												name="slbGiaovien" id="slbGiaovien">
													<option value="" selected="selected">GiÃ¡o viÃªn dáº¡y</option>
											</select>
										</label></li>
										<li>
											<div class="input text">
												<input type="text" name="txtSotiet" id="txtSotiet"
													placeholder="Sá» tiáº¿t há»c (*)" required="required"
													value="" />
											</div>
											<li>
											<div class="input text">
												<textarea placeholder="ChÃº Ã½"></textarea>
											</div>
										</li>
										</li>-->
										<li><div class="input text"></div></li>
										<li>
											<div align="left">
												<label>Nội dung:</label>
											</div>
										</li>
										<li>
											<div class="input text">
												<textarea required="required" placeholder=""
													name="subjectContent">${subject.content}</textarea>
											</div>
										</li>
										<li>

											<button class="btnSubmit btn" type="submit">
												<span>Thêm mới</span>
											</button>
										</li>
										<li>
											<button class="btnSubmit btn" type="button"
												onclick="window.location.href='listSubject.do'">
												<span>BACK</span>
											</button>
										</li>
									</ul>
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