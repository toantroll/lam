<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Tìm kiếm môn học</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.min.js"></script>
<script src="js/fn.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/la-management.js"></script>
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
					<li><i class="fa fa-angle-double-right">Danh sách môn học</i></li>
				</ul>
			</div>
			<!-- .db-breadcrums -->

			<div class="db-main">
				<div class="db-main-search-form">
					<form id="search-form" action="listSubject.do?" method="get">
						<div>
							<input type="hidden" name="type" value="search">
						</div>
						<div class="g-row">
							<div class="one-half">
								<div class="input-component">
									<div class="one-quarter no-pad">
										<label for="txtSubject">Mã môn học: </label>
									</div>
									<div class="three-quarters no-pad">
										<input type="text" name="subjectId" id="txtSubject"
											value="${subjectId}">
									</div>
									<div class="clear"></div>
								</div>

								<div class="input-component">
									<div class="one-third no-pad">&nbsp</div>
									<div class="two-thirds no-pad addSubject">
										<button class="btnSubmit btn" type="button"
											onclick="window.location.href='addSubject.do'">
											<span>Thêm mới môn học</span>
										</button>
									</div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="one-half">
								<div class="input-component">
									<div class="one-quarter no-pad">
										<label for="slbClass">Tên môn học: </label>
									</div>
									<div class="three-quarters no-pad">
										<input type="text" name="subjectName" id="txtSubject"
											value="${subjectName}">
									</div>
									<!--<div class="three-quarters no-pad">
										<label class="lbl-slb"> <select name="slbClass"
											id="slbClass" class="slbClass">
												<option value="" selected="selected">Lá»±a chá»n lá»p há»c</option>
										</select>
										</label>
									</div> -->
									<div class="clear"></div>
								</div>

								<div class="input-component">
									<div class="one-half no-pad" style="width: 45%;">
										<button class="btnSubmit btn" type="submit">
											<span>Tìm kiếm</span>
										</button>
									</div>
									<div class="inline" style="float: right;">
										<button type="button" class="btn pull-right" id="exportCSV">Export
											to .CSV</button>
										<button type="button" class="btn pull-right" id="exportXLSX"
											style="margin-right: 1px;">Export to .XLSX</button>
									</div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</form>
				</div>
				<!-- .db-main-search-form -->
				<c:if test="${checkNotFound == 0 }">
					<font color="red"><c:out value="${messageNotFound}"></c:out></font>
				</c:if>
				<c:if test="${checkNotFound != 0 }">
					<div class="db-main-table-results">
						<table>
							<thead>
								<tr>
									<th><input type="checkbox" name="deleteAll"></th>
									<th>Mã môn học</th>
									<th>Tên môn học</th>
									<th>Giáo viên giảng dạy</th>
									<th>Tùy chọn</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listSubject}" var="subject">
									<tr>
										<td><input type="checkbox" name="deleteAll"></td>
										<td>${subject.id}</td>
										<td>${subject.name}</td>
										<td>${subject.giaoVienName}</td>
										<td>
											<ul class="tbl-actions">
												<li><a
													href="./editSubject.do?subjectId=${subject.id}&type=edit"
													id="btnEdit" class="btnedit"><i class="fa fa-edit"></i></a></li>
												<li><a
													href="./deleteSubject.do?subjectId=${subject.id}"
													id="btnDelUser" class="btndelete"
													onclick="return confirm('${messageDelete}');"><i
														class="fa fa-trash-o"></i></a></li>
											</ul>
										</td>
									</tr>
								</c:forEach>
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
											href="./listSubject.do?type=paging&page=${listPaging[0] - pageLimit}">&lt;&lt;</a>
											&nbsp;</li>
									</c:if>
									<c:forEach items="${listPaging}" var="page">
										<c:if test="${page == currentPage}">
											<li>${page}&nbsp;</li>
										</c:if>
										<c:if test="${page != currentPage}">
											<li><a
												style="background: rgb(14, 88, 130); color: rgb(255, 255, 255);"
												href="./listSubject.do?type=paging&page=${page}">${page}</a>&nbsp;</li>
										</c:if>
									</c:forEach>
									<c:if test="${listPaging[lengthPaging - 1] < totalPage}">
										<li><a
											style="background: rgb(14, 88, 130); color: rgb(255, 255, 255);"
											href="./listSubject.do?type=paging&page=${listPaging[lengthPaging - 1] + 1}">&gt;&gt;</a>&nbsp;</li>
									</c:if>
								</c:if>
								<!-- <li><a href="javascript:void(0)"
								style="background: rgb(14, 88, 130); color: rgb(255, 255, 255);">1</a></li>
							<li><a href="#">2</a></li> -->
							</ul>
						</div>
					</div>
				</c:if>
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