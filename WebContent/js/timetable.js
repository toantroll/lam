$(document)
		.ready(
				function() {
					const ttid = $('#timetableid').val();
					console.log(ttid);
					function get_time_table(id) {
						$.ajax({
							url : "Ajax/getTimeTable?id=" + id,
							type : "GET"
						})
								.done(
										function(result) {
											if (result.code == 1) {
												var data = result.data;
												var day = new Date(
														data[0]['startDate'])
														.getDay();
												for (var i = 1; i < day; i++) {
													data.unshift({});
												}
												render_time_table(data);
											}
										}).fail(function(xhr) {
									console.log('error common back', xhr);
								});
					}
					$('#dateTable').datetimepicker();
					$('#timeTable').datetimepicker({
						useCurrent : false
					// Important! See issue #1075
					});
					$("#dateTable").on("dp.change", function(e) {
						$('#timeTable').data("DateTimePicker").minDate(e.date);
					});
					$("#dateTable").on("dp.change", function(e) {
						$('#timeTable').data("DateTimePicker").maxDate(e.date);
					});
					function render_time_table(data) {
						var week = Math.ceil(data.length / 5);
						var html = '';
						for (var i = 0; i < week; i++) {
							html += '<tr>';
							html += '<th scope="row">' + (i + 1) + '</th>';
							html += render_week_detail(data, i);
							html += '</tr>';
						}
						$('#time_table').html(html);
						createEventClicksubject();
					}

					function render_week_detail(data, week) {
						var html = '';
						for (var i = 0; i < 5; i++) {
							const e = data[week * 5 + i];
							if (e == undefined)
								break;
							if (e['subjectId'] == undefined) {
								html += '<td></td>';
							} else {
								html += '<td class="subject" data-date="'
										+ e['startDateString']
										+ '" data-title="'
										+ e['subjectContent']
										+ '" data-hours="' + e['startHours']
										+ '" data-subjectid="' + e['subjectId']
										+ '" data-id-detail="' + e['id']
										+ '" data-id-timetable="'
										+ e['timeTableInfoId']
										+ '" data-hoursperday="'
										+ e['hoursPerDay'] + '" data-istest="'
										+ e['status'] + '"><div>';
								html += '<p>' + e['startDateString'] + '</p>';
								if (e['subjectId'] != 0) {
									html += '<p>' + e['subjectName'] + '</p>';
									html += '<p>' + e['startHours']
											+ '</p></div></td>';
								} else {
									html += '<p>Chưa có</p>';
									html += '<p>Chưa có</p></div></td>';
								}
							}

						}

						return html;
					}
					function createEventClicksubject() {
						$(".subject")
								.click(
										function(e) {
											const date = $(this).data("date");
											const id_detail = $(this).data(
													"id-detail");
											const hours_per_day = $(this).data(
													"hoursperday");
											const is_test = $(this).data(
													"istest");
											const id_timetable = $(this).data(
													"id-timetable");
											const subject_id = $(this).data(
													"subjectid");
											const title = $(this).data("title") === 'undefined' ? ''
													: $(this).data("title");
											const hours = $(this).data("hours") === 'undefined' ? ''
													: $(this).data("hours");
											$('#titleTableDetail').html(
													'Thời khóa biểu ngày '
															+ date);
											$('.message').html('');
											$('#cbxSubject').val(subject_id);
											$('#hoursPerDay')
													.val(hours_per_day);
											$('#isTest').prop(
													'checked',
													is_test === 1 ? true
															: false);
											$('#date').val(date);
											$('#idDetail').val(id_detail);
											$('#idTimeTable').val(id_timetable);
											$("#titleSubject").val(title);
											$("#timeTimeTable").val(hours);
											$('#timeTableDetail').modal('show');
										});
					}

					$('#timeTableDetailForm')
							.submit(
									function(e) {
										e.preventDefault();
										const data = $(this).serializeArray();
										var formData = {};
										for (var i = 0; i < data.length; i++) {
											formData[data[i].name] = data[i].value;
										}
										$
												.ajax(
														{
															url : "AddTimeTableDetailController",
															type : "POST",
															data : formData
														})
												.done(
														function(result) {
															if (result.code === 0) {
																$('.message')
																		.html(
																				createErrorMessage(result['data']));
															} else {
																get_time_table(ttid);
																$('.message')
																		.html(
																				createSuccessMessage(result['data']));
															}
															
														})
												.fail(
														function(xhr) {
															console
																	.log(
																			'error common back',
																			xhr);
														});
									});

					function createErrorMessage(text) {
						return '<p class="text-danger">' + text + '</p>'
					}

					function createSuccessMessage(text) {
						return '<p class="text-info">' + text + '</p>'
					}
					
					
					$('#deleteDetail').click(function(){
						var i  = confirm("bạn có muốn xóa không?");
						if(i==1){
							var formData = {};
							formData['idDetail'] = $('#idDetail').val();
							formData['idtimeTable'] = $('#idtimeTable').val();
							$.ajax(
									{
										url : "DeleteTimeTableDetailController",
										type : "POST",
										data : formData
									})
							.done(function(result){
								if (result.code === 0) {
									$('.message')
											.html(
													createErrorMessage(result['data']));
								} else {
									$('.message')
											.html(
													createSuccessMessage(result['data']));
									get_time_table(ttid);
								}
								
								
							})
							.fail(function(xhr) {
										console.log('error common back',xhr);
									});;
						}
					});
					
					get_time_table(ttid);

				});
