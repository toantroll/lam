<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Thông báo hệ thống</title>
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
.center {
	width: 50%;
	height: 50%;
	margin: auto;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="db-container">
			<jsp:include page="header.jsp" />
			<!-- .db-head -->
			<div>
				<div>
					<form id="search-form" action="listSubject.do?" method="get">
						<div style="margin-top: 10%">
							<span style="color: red"><c:out value="${message}"></c:out></span>
						</div>
						<div>
							<button class="btnSubmit" type="submit">
								<span>OK</span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>