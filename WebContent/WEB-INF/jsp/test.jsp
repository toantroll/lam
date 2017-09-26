<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>test</title>
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
<style type="text/css">
.err {
	color: red;
}

.box-content h3 {
	color: #ffffff;
}

.sub-page-content {
	background-color: #0b3d65;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>T2</th>
						<th>T3</th>
						<th>T4</th>
						<th>T5</th>
						<th>T6</th>
					</tr>
				</thead>
				<tbody id="time_table">
					<tr>
						<th scope="row">1</th>
						<td class="subject" data-date="25/09/2017" data-hours="13:00"><div>
								<p>25/09/2017</p>
								<p>Project</p>
								<p>13:00</p>
							</div></td>
						<td class="subject" data-date="26/09/2017" data-hours="14:00"><div>
								<p>25/09/2017</p>
								<p>Project</p>
								<p>13:00</p>
								<td>@mdo</td>
								<td>Otto</td>
								<td>@mdo</td>
								<td>Otto</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Jacob</td>
						<td>Thornton</td>
						<td>@fat</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- .reg-content -->
	<div class="clear"></div>

	<!-- Modal -->
	<div class="modal fade" id="timeTableDetail" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="titleTableDetail">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
					<div class="row">
						<div class='col-sm-3'>
							 <label for="timeTimeTable">Giờ bắt đầu</label>
						</div>
						<div class='col-sm-6'>
							<input type='text' class="form-control" id='timeTimeTable' name="time" />
						</div>
						<script type="text/javascript">
							$(function() {
								$('#timeTimeTable').datetimepicker({
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
							<select name="subject" class="form-control">
								<option selected="selected" value="0">--Chọn Môn học--</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class='col-sm-3'>
							 <label for="timeTimeTable">Môn học:</label>
						</div>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<script src="js/test.js"></script>
</body>
</html>