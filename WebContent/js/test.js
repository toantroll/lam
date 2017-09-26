$(document).ready(function() {
	function get_time_table(id){
		$.ajax({
			url: "TestAjax?id="+id,
			type: "GET"
		}).done(function(result){
			if(result.code == 1){
				var data = result.data;
				var day = new Date(data[0]['startDate']).getDay();
				for(var i = 1; i < day; i++){
					data.unshift({});
				}
				render_time_table(data);
			}
		}).fail(function(xhr){
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
	get_time_table(11);
	console.log('asdasdasd');
	function render_time_table(data){
		var week = Math.ceil(data.length/5);
		var html = '';
		for(var i = 0; i < week; i++){
			html+='<tr>';
			html+='<th scope="row">'+(i+1)+'</th>';
			html+=render_week_detail(data, i);
			html+='</tr>';
		}
		$('#time_table').html(html);
		$(".subject").click(function(e){
			var date = $(this).data("date");
			var hours = $(this).data("hours") === 'undefined'? '' : $(this).data("hours");
			$('#titleTableDetail').html('Thời khóa biểu ngày '+date)
			$('#timeTableDetail').modal('show');
			$("#timeTimeTable").val(hours);
		});
	}
	
	function render_week_detail(data, week){
		var html = '';
		for(var i = 0; i < 5; i++ ){
			const e = data[week*5+i];
			if(e==undefined) break;
			if(e['subjectId'] == undefined){
				 html+='<td></td>';
			} else{
		      html+='<td class="subject" data-date="'+ e['startDateString'] +'" data-hours="'+e['startHours']+'" data-id="'+e['subjectId']+'"><div>';
		      html+='<p>'+e['startDateString']+'</p>';
		      if(e['subjectId'] != 0){
		    	  html+='<p>'+e['subjectName']+'</p>';
			      html+='<p>'+e['startHours']+'</p></div></td>';
		      } else {
		    	  html+='<p>Chưa có</p>';
			      html+='<p>Chưa có</p></div></td>';
		      }
		}
		      
		}
		
		return html;
	}
	
});
