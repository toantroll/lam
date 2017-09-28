<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Danh sách thời khóa biểu</title>
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
					<li><i class="fa fa-angle-double-right"> Danh sách người
							đăng ký khóa học</i></li>
				</ul>
			</div>
			<!-- .db-breadcrums -->

			<div class="db-main">
				<div class="db-main-search-form">
					<form id="search-form" action="search" method="GET">
						<div class="g-row">
							<div class=""></div>
							<div class="input-component">
								<div class="one-quarter no-pad">
									<label for="txtTitle">Tiêu đề: </label>
								</div>
								<div class="three-quarters no-pad">
									<input type="text" name="txtTitle" id="txtTitle" value="">
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
						</div>
					</form>
				</div>
				<!-- .db-main-search-form -->

				<div class="db-main-table-results">
					<!-- <div class="full-width no-pad">
                    <a href="#" class="deleteAll">Xóa</a>
                </div>
                <div class="clear"></div> -->

					<table>
						<thead>
							<tr>
								<th><input type="checkbox" name="deleteAll"></th>
								<th>Mã</th>
								<th>Lớp</th>
								<th>Thời gian</th>
								<th>Địa điểm</th>
								<th>Tùy chọn</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty listTimeTable}">
								<c:forEach var="item" items="${listTimeTable}">
									<tr>
										<td><input type="checkbox" name="deleteAll"></td>
										<td>${item.id}</td>
										<td>${item.courseName}</td>

										<td><fmt:formatDate pattern="dd/MM/yyyy"
												value="${item.startDate}" /> - <fmt:formatDate
												pattern="dd/MM/yyyy" value="${item.endDate}" /></td>
										<td>${item.place }</td>
										<td>
											<ul class="tbl-actions">
												<li><a href="./TimeTableController?id=${item.id }" id="btnEdit" class="btnedit"><i
														class="fa fa-edit"></i></a></li>
												<li><a id="btnDelUser" class="btndelete"><i
														class="fa fa-trash-o"></i></a></li>
											</ul>
										</td>
									</tr>
								</c:forEach>
							</c:if>

						</tbody>
					</table>

					<div class="pagination">
						<!-- Hiá»n thá» káº¿t quáº£ tá»« 1 Äáº¿n 2<span
							class="divider-vertical">|</span><strong>Trang: </strong><span
							class="page-number current-page">1 cá»§a 2</span> -->
						<ul>
							<c:set var="lengthPaging" value="${fn:length(listPaging)}" />
							<c:if test="${lengthPaging >= 1}">
								<!-- <tr class="lbl_paging"> -->
								<c:if test="${listPaging[0] != 1}">
									<li><a
										style="background: rgb(14, 88, 130); color: rgb(255, 255, 255);"
										href="./ListTimeTableInfoController?page=${listPaging[0] - pageLimit}">&lt;&lt;</a>
										<!-- &nbsp; --></li>
								</c:if>
								<c:forEach items="${listPaging}" var="page">
									<c:if test="${page == currentPage}">
										<li>${page}&nbsp;</li>
									</c:if>
									<c:if test="${page != currentPage}">
										<li><a
											style="background: rgb(14, 88, 130); color: rgb(255, 255, 255);"
											href="./ListTimeTableInfoController?page=${page}">${page}</a>&nbsp;</li>
									</c:if>
								</c:forEach>
								<c:if test="${listPaging[lengthPaging - 1] < totalPage}">
									<li><a
										style="background: rgb(14, 88, 130); color: rgb(255, 255, 255);"
										href="./ListTimeTableInfoController?page=${listPaging[lengthPaging - 1] + 1}">&gt;&gt;</a>&nbsp;</li>
								</c:if>
								<!-- </tr> -->
							</c:if>
							<!-- <li><a href="javascript:void(0)"
								style="background: rgb(14, 88, 130); color: rgb(255, 255, 255);">1</a></li>
							<li><a href="#">2</a></li> -->
						</ul>
					</div>
				</div>
				<!-- .db-main-table-results -->

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