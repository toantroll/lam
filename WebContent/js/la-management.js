/*== Xử lý các sự kiện ở màn hình hệ thống quản lý tài sản ==*/

$(document).ready(function() {
/* Show import-icon on Chrome, Firefox.. */
    if (!isBrowserIE()) {
        $('#import-form').css('display', 'none');
        $('#import-icon').append("<button class='btn' onclick='getImportDiv();'><img src='../img/import-icon.png' alt='import-icon'><span>Import</span></button>");
    }
/*---- Sự kiện ở màn hình tìm kiếm người dùng ----*/
    $('#btnEditUser').on('click', function () {
        var username = $.trim($(this).closest('tr').children('td.username').text());
        location.href = '/users/edit?username=' + username;
    });

/* hiển thị mầu cho nút ở trang hiện tại, và vô hiệu hóa nút đó */
    var button = $('div.pagination').find('li.active').find('a');
    button.css('background', '#0e5882').css('color', '#FFF');
    button.attr('href', 'javascript:void(0)');

/* Xử lí import người dùng */
    $("form#import-form").submit(function () {
        // show loading animation
        $("#importing").show();
        // Tạo đối tượng file tải lên
        var formData = new FormData($(this)[0]);
        console.log(formData);

        $.ajax({
            url: '/users/import',
            type: 'POST',
            data: formData,
            // async: false,
            // beforeSubmit: loading,
            success: function (data) {
                // Hide loading animation
                $("#importing").hide();
                // console.log(data);
                if (data.isEmpty === 'yes') {
                    // Hiện thông báo: trường hợp chưa chọn file import
                    showImportMsg('no_file');
                } else {
                    if (data.fail.length === 0 && data.err.length === 0) {
                        // Hiện thông báo: trường hợp import thành công
                        showImportMsg('success');
                    } else {
                        // Hiện thông báo: trường hợp import gặp lỗi
                        showImportMsg('fail_and_err', data.err);
                    }
                }
            },
            cache: false,
            contentType: false,
            processData: false
        });

        return false;
    });

/* Xử lí export người dùng, xuất ra file .xlsx */
    $('#exportXLSX').on('click' , function () {
        var exportQuery = 'txtHoten=' + $.trim($('#txtHoten').val()) + '&txtEmail='
        + $.trim($('#txtemail').val()) + '&txtKhoa=' + $.trim($('#txtKhoa').val()) + '&txtNgaydangky='
        + $.trim($('#txtNgaydangky').val()) + '&txtTruonghoc=' + $.trim($('#txtTruonghoc').val())
        + '&txtNamtotnghiep=' + $.trim($('#txtNamtotnghiep').val()) + '&txtChuyennganh='
        + $.trim($('#txtChuyennganh').val());
        location.href = '/users/exportXLSX?' + exportQuery;
        return false;
    });

/* Xử lí export người dùng, xuất ra file .csv */
    $('#exportCSV').on('click', function () {
        // Xây dựng đối tượng ajax
        var ajaxObject = {
            url: '/users/exportCSV',
            type: 'get',
            data: {
                txtHoten: $('#txtHoten').val(),
                txtEmail: $('#txtEmail').val(),
                txtKhoa: $('#txtKhoa').val(),
                txtNgaydangky: $('#txtNgaydangky').val(),
                txtTruonghoc: $('#txtTruonghoc').val(),
                txtNamtotnghiep: $('#txtNamtotnghiep').val(),
                txtChuyennganh: $('#txtChuyennganh').val()
            },
            dataType: 'json',
            success: function (result) {
                // Export ra file excel từ chuỗi json nhận được
                if ( result.length === 0) {
                    // Hiện thông báo: không có dữ liệu để export
                    $('#result-box').fadeIn(100);
                    $('.result-title').html("Không có dữ liệu để export");
                    $('body').append('<div id="over1"></div>');
                    $('#over1').fadeIn(100);

                    // Ẩn thông báo khi click xác nhận OK
                    $('#confirmDelResult, #over1').on('click', function () {
                        $('#over1, #result-box').fadeOut(100, function () {
                            $('#over1').remove();
                        });
                        return false;
                    });
                } else {
                    // Export dữ liệu tìm kiếm ra file excel
                    var x = new CSVExport(result);
                    return false;
                }
            }
        };
        $.ajax(ajaxObject);
    });

/*  Xử lý ajax chức năng xóa người dùng */
    $('.btndelete').on('click', function(){
        // Lấy id của user muốn xóa
        var id = $(this).find('#userId').val();
        // Lấy full name của user muốn xóa
        var fullName = $.trim($(this).find('#fullName').val());
        // Tạo đối tượng ajax
        var ajaxObject = {
            url: '/users/delete',
            type: 'get',
            dataType: 'json',
            data: { id: id},
            success: function(result){
                // Lấy các giá trị trả về để kiểm tra
                var status = result['status'];
                var permission = result['permission'];
                var checkDel = result['checkDel'];

                // KIỂM TRA QUYỀN XÓA CỦA USER ĐANG LOGON, USER MUỐN XÓA CÓ ĐƯỢC PHÉP XÓA KHÔNG?
                if (permission === "yes") {         // user đang logon có quyền xóa

                    if (checkDel === "yes") {       // user muốn xóa được phép xóa đi

                        if (status === "success") {
                            // Pop-up: đã xóa thành công
                            showResultOfDelFunc(1);
                        } else {
                            // Pop-up: xóa thất bại
                            showResultOfDelFunc(2);
                        }

                    } else {
                        // Pop-up: user muốn xóa không được phép xóa đi
                        showResultOfDelFunc(3);
                    }

                } else {
                    // Pop-up: user đang logon không có quyền xóa
                    showResultOfDelFunc(4);
                }
            }
        };

        // Hiện hộp xác nhận
        $('.valid-title').html("Bạn có muốn xóa người dùng \""+fullName+"\" không?");
        $('#valid-box').fadeIn("slow");

        // Thêm phần tử id="over" vào sau body
        $('body').append('<div id="over"></div>');
        $('#over').fadeIn(300);

        // Gọi ajax khi click nút xác nhận đồng ý
        $('#valid-button').on('click', function () {
            $.ajax(ajaxObject);
        });
    });


    // khi click đóng hộp xác nhận
    $(".close-box, #over").on('click', function() {
        $('#over, #valid-box').fadeOut(300 , function() {
            $('#over').remove();
        });
        return false;
    });

    // Create datepicker at txtNgaydangky field
    $('#txtNgaydangky').datepicker({
        format: 'dd/mm/yyyy'
    });
    
	$('#datetimepicker6').datetimepicker();
	$('#datetimepicker7').datetimepicker({
		useCurrent : false
	// Important! See issue #1075
	});
	$("#datetimepicker6").on("dp.change", function(e) {
		$('#datetimepicker7').data("DateTimePicker").minDate(e.date);
	});
	$("#datetimepicker7").on("dp.change", function(e) {
		$('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
	});
 

    // Create datepicker at txtBirthDay field
    $('#txtBirthDay').datepicker({
        format: 'dd/mm/yyyy'
    });

    // Clear field Ngay dang ky
    $('#btnClrNgaydangky').on('click', function () {
        $('#txtNgaydangky').val("");
        return false;
    });

    // Submit on Enter key in textbox
    $('input[type="text"]').keyup(function (e) {
        if (e.keyCode == 13) {
            $('.one-half.no-pad > .btnSubmit').click();
        }
    });

    // $(window).click(function(e) {
    //     console.dir(e);
    // });

/* Reset text input border after validating */
    $('input[type="text"], input[type="password"], input[type="email"], input[type="number"]').focusin(function() {
        $( this ).css( "border", "1px solid #e1e1e1" );
    });
    $('input[type="text"], input[type="password"], input[type="email"], input[type="number"]').blur(function() {
        $( this ).css( "border", "1px solid #e1e1e1" );
    });
    $('input[type="text"], input[type="password"], input[type="email"], input[type="number"]').keypress(function() {
        $( this ).css( "border", "1px solid #e1e1e1" );
    });

});


/**
 * Hàm hiển thị thông báo kết quả của chức năng xóa người dùng
 * @param code: mã tương ứng với các kết quả xóa người dùng
 * @return box thông báo kết quả xóa người dùng
 */
function showResultOfDelFunc(code) {
    // Gỡ bỏ pop-up xác nhận
    $('#over, #valid-box').fadeOut(100, function () {
        $('#over').remove();
    });
    // Kiểm tra code và thiết lập thông báo tương ứng
    switch (code) {
        case 1:
            $('.result-title').html("Đã xóa người dùng");
            break;
        case 2:
            $('.result-title').html("Xóa thất bại");
            break;
        case 3:
            $('.result-title').html("User không được phép xóa");
            break;
        case 4:
            $('.result-title').html("Tài khoản đang đăng nhập không có quyền xóa user");
            break;
    }
    // Tạo và hiển thị pop-up thông báo kết quả xóa
    $('#result-box').fadeIn(100);
    $('body').append('<div id="over1"></div>');
    $('#over1').fadeIn(100);
    if (code === 1) {
        // Trở về search page khi click nút xác nhận thông báo
        $('#confirmDelResult, #over1').on('click', function () {
            var searchQuery = 'txtHoten=' + $.trim($('#txtHoten').val()) + '&txtEmail='
                + $.trim($('#txtemail').val()) + '&txtKhoa=' + $.trim($('#txtKhoa').val()) + '&txtNgaydangky='
                + $.trim($('#txtNgaydangky').val()) + '&txtTruonghoc=' + $.trim($('#txtTruonghoc').val())
                + '&txtNamtotnghiep=' + $.trim($('#txtNamtotnghiep').val()) + '&txtChuyennganh='
                + $.trim($('#txtChuyennganh').val());
            location.href = '/users/search?' + searchQuery;
        });
    } else {
        // Ở lại search page khi click nút xác nhận thông báo
        $('#confirmDelResult, #over1').on('click', function () {
            $('#over1, #result-box').fadeOut(100, function () {
                $('#over1').remove();
            });
            return false;
        });
    }
}

function onchangeLevel() {
    // var tlevel = $("input[name='level']:checked").val();
    // if(tlevel === 0){
    //     $("#txtTruong").prop("disabled", true);
    // }

}

/**
 * Hàm thay đổi số ngày tương ứng với tháng
 * @return thay đổi số ngày tương ứng trong tháng được chọn
 */
function onchangeMonth() {
    // Lấy năm, tháng, ngày đang chọn
    var selectedYear = $('select[name="birthyear[year]"]').val();
    var selectedMonth = $('select[name="birthmonth[month]"]').val();
    var selectedDay = $('select[name="birthdate[day]"]').val();
    // Lấy các ngày 29, 30, 31
    var day_29 = $('select[name="birthdate[day]"] option[value="29"]');
    var day_30 = $('select[name="birthdate[day]"] option[value="30"]');
    var day_31 = $('select[name="birthdate[day]"] option[value="31"]');
    // Lấy day select box
    var daySelectBox = $('select[name="birthdate[day]"]');

    // KIỂM TRA THÁNG ĐANG CHỌN:
    if (selectedMonth == "") {
        // Nếu chọn option reset: Hiện ngày 29, 30, 31
        day_29.css('display', 'block');
        day_30.css('display', 'block');
        day_31.css('display', 'block');
    } else if (isFebruary(selectedMonth)) {
        // Nếu chọn tháng 2: Lấy năm đang chọn, kiểm tra có phải năm nhuận không
        if ((selectedYear == "") || isLeapYear(selectedYear)) {
            // Nếu chọn năm nhuận thì ẩn ngày 30, 31
            day_29.css('display', 'block');
            day_30.css('display', 'none');
            day_31.css('display', 'none');
            // Nếu đang chọn ngày 30, 31 thì reset ngày đã chọn
            if (selectedDay == 31 || selectedDay == 30) {
                daySelectBox.val("").trigger('change');
            }
        } else {
            // Nếu chọn năm không phải năm nhuận
            // Ẩn ngày 29, 30, 31
            day_29.css('display', 'none');
            day_30.css('display', 'none');
            day_31.css('display', 'none');
            // Nếu đang chọn ngày 29, 30, 31 thì reset ngày đã chọn
            if (selectedDay == 31 || selectedDay == 30 || selectedDay == 29) {
                daySelectBox.val("").trigger('change');
            }
        }
    } else if (is31_DayMonths(selectedMonth)) {
        // Nếu chọn một trong các tháng có 31 ngày: Hiện ngày 29, 30, 31
        day_29.css('display', 'block');
        day_30.css('display', 'block');
        day_31.css('display', 'block');
    } else if (is30_DayMonths(selectedMonth)) {
        // Nếu là các tháng có 30 ngày: Hiện ngày 29, 30 và ẩn ngày 31
        day_29.css('display', 'block');
        day_30.css('display', 'block');
        day_31.css('display', 'none');
        // Nếu đang chọn ngày 31 thì reset ngày đã chọn
        if (selectedDay == 31) {
            daySelectBox.val("").trigger('change');
        }
    }
}

/**
 * Hàm thay đổi số ngày tương ứng với tháng
 * @return thay đổi số ngày tương ứng của tháng trong năm được chọn
 */
function onchangeYear() {
    // Lấy năm, tháng, ngày đang chọn
    var selectedYear = $('select[name="birthyear[year]"]').val();
    var selectedMonth = $('select[name="birthmonth[month]"]').val();
    var selectedDay = $('select[name="birthdate[day]"]').val();
    // Lấy các ngày 29, 30, 31
    var day_29 = $('select[name="birthdate[day]"] option[value="29"]');
    var day_30 = $('select[name="birthdate[day]"] option[value="30"]');
    var day_31 = $('select[name="birthdate[day]"] option[value="31"]');
    // Lấy day select box
    var daySelectBox = $('select[name="birthdate[day]"]');

    // KIỂM TRA NĂM ĐANG CHỌN:
    if (selectedYear == "") {
            // Nếu chọn option reset: Hiện ngày 29, 30, 31
            day_29.css('display', 'block');
            day_30.css('display', 'block');
            day_31.css('display', 'block');
    } else if (isLeapYear(selectedYear)) {
            // Năm nhuận: KIỂM TRA THÁNG ĐANG CHỌN
            if (selectedMonth == "") {
                // Nếu chưa chọn tháng: Hiện ngày 29, 30, 31
                day_29.css('display', 'block');
                day_30.css('display', 'block');
                day_31.css('display', 'block');
            } else if (isFebruary(selectedMonth)) {
                // Nếu chọn tháng 2 - năm nhuận thì ẩn ngày 30, 31
                day_29.css('display', 'block');
                day_30.css('display', 'none');
                day_31.css('display', 'none');
                // Nếu đang chọn ngày 30, 31 thì reset ngày đã chọn
                if (selectedDay == 31 || selectedDay == 30) {
                    daySelectBox.val("").trigger('change');
                }
            } else if (is31_DayMonths(selectedMonth)) {
                // Nếu chọn một trong các tháng có 31 ngày: Hiện ngày 29, 30, 31
                day_29.css('display', 'block');
                day_30.css('display', 'block');
                day_31.css('display', 'block');
            } else if (is30_DayMonths(selectedMonth)) {
                // Nếu chọn một trong các tháng có 30 ngày: Hiện ngày 29, 30 và ẩn ngày 31
                day_29.css('display', 'block');
                day_30.css('display', 'block');
                day_31.css('display', 'none');
                // Nếu đang chọn ngày 31 thì reset ngày đã chọn
                if (selectedDay == 31) {
                    daySelectBox.val("").trigger('change');
                }
            }
    } else {
            // Không phải năm nhuận: KIỂM TRA THÁNG ĐANG CHỌN
            if (selectedMonth == "") {
                // Nếu chưa chọn tháng: Hiện ngày 29, 30, 31
                day_29.css('display', 'block');
                day_30.css('display', 'block');
                day_31.css('display', 'block');
            } else if (isFebruary(selectedMonth)) {
                // Nếu chọn tháng 2 thì ẩn ngày 30, 31
                day_29.css('display', 'none');
                day_30.css('display', 'none');
                day_31.css('display', 'none');
                // Nếu đang chọn ngày 29, 30, 31 thì reset ngày đã chọn
                if (selectedDay == 31 || selectedDay == 30 || selectedDay == 29) {
                    daySelectBox.val("").trigger('change');
                }
            } else if (is31_DayMonths(selectedMonth)) {
                // Nếu chọn một trong các tháng có 31 ngày: Hiện ngày 29, 30, 31
                day_29.css('display', 'block');
                day_30.css('display', 'block');
                day_31.css('display', 'block');
            } else if (is30_DayMonths(selectedMonth)) {
                // Nếu chọn một trong các tháng có 30 ngày: Hiện ngày 29, 30 và ẩn ngày 31
                day_29.css('display', 'block');
                day_30.css('display', 'block');
                day_31.css('display', 'none');
                // Nếu đang chọn ngày 31 thì reset ngày đã chọn
                if (selectedDay == 31) {
                    daySelectBox.val("").trigger('change');
                }
            }
    }
}

/**
 * Hàm kiểm tra tháng truyền vào có phải là tháng có 31 ngày không
 * @param month
 * @return {boolean}
 */
function is31_DayMonths(month) {
    var _31_DayMonths = ['1', '3', '5', '7', '8', '10', '12'];
    return ($.inArray(month, _31_DayMonths) != -1);
}

/**
 * Hàm kiểm tra tháng truyền vào có phải là tháng có 30 ngày không
 * @param month
 * @return {boolean}
 */
function is30_DayMonths(month) {
    var _30_DayMonths = ['4', '6', '9', '11'];
    return ($.inArray(month, _30_DayMonths) != -1);
}

/**
 * Hàm kiểm tra tháng truyền vào có phải là tháng 2 không
 * @param month
 * @return {boolean}
 */
function isFebruary(month) {
    return (month == 2);
}

/**
 * Hàm kiểm tra năm nhuận
 * @param year
 * @returns {boolean}
 */
function isLeapYear(year) {
    // nếu năm chia hết cho 100
    // thì kiểm tra nó có chia hết cho 400 hay không
    if (year % 100 == 0) {
        // nếu chia hết cho 400 thì là năm nhuận
        // ngược lại không phải năm nhuận
        return (year % 400 == 0);
    } else {
        // nếu chia hết cho 4 thì là năm nhuận
        // ngược lại không phải năm nhuận
        return (year % 4 == 0);
    }
}

/**
 * Kiểm tra email có đúng định dạng hay không
 * @param email 
 * Trả về TRUE nếu đúng định dạng của email, FALSE nếu không đúng định dạng của email
 */
function isValidEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

/**
 * Validate định dạng số điện thoại
 * @param phoneNumber số điện thoại nhập vào
 * Trả về true nếu số điện thoại đúng định dạng, false nếu sai định dạng
 */
function isValidPhoneNumber(phoneNumber) {
    var partern = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
    return partern.test(phoneNumber);
}

/**
 * Kiểm tra đã nhập dữ liệu hay chưa
 * @param data
 * trả về true nếu dữ liệu là rỗng, false nếu không phải là null
 */
function isNull(data) {
    return ($.trim(data) === '' || data === null);
}

/**
 * Kiểm tra có xác nhận đúng mật khẩu đã nhập
 * @param  pass mật khẩu
 * @param confirmPass mật khẩu xác nhận
 * Trả về true nếu mật khẩu trùng với mật khẩu xác nhận, false nếu không trùng
 */
function isEqualPassword(pass, confirmPass) {
    return (pass === confirmPass);
}



function isPositiveInteger(str) {
    if ((/.*\D+.*/.test(str)) || (str < 0)) {
        return false;
    }
    return true;
}
//Kiểm tra ngày hợp lệ dd/mm/yyyy
function isValidDate(str) {
    if (!(/^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/.test(str))) {
        return false;
    }
    return true;
}

/**
 * Hàm chuyển định dạng ngày từ dd/mm/yyyy sang yyyy-mm-dd hh:mm:ss
 * @param date định dạng dd/mm/yyyy
 * @returns date định dạng yyyy-mm-dd
 */
function convertDatetoDateTime(date) {
    if (date !== '') {
        var arrDate = date.split("/");
        return arrDate[2] + "-" + arrDate[1] + "-" + arrDate[0] + " 00:00:00";
    } else {
        return null;
    }
}



/**
 * Hàm xử lí export dữ liệu từ màn hình tìm kiếm
 * Người tạo: SonNV
 * 
 */
function exportData() {
    // Lấy kiểu export từ radio button ở màn hình tìm kiếm
    var exportType = $("input[name='exportType']:checked").val();
    var urlAction;
    var action = getAction(location.pathname);
    var queryString = $("[method='POST'][action='" + action + "']").serialize();
    if (exportType === "Excel") {
        urlAction = "/exportExcel";
        exportType = 'xlsx';
    } else if (exportType === "Csv") {
        urlAction = "/exportCsv";
        exportType = 'Csv';
    }

    if (action.includes('update')) {
        location.href = "/exportLog?" + queryString + '&exportType=' + exportType;
    } else {
        $("div#error-export-message").text("");

        var dateAlloStart = $("#dateAlloFrom").val();
        var dateAlloEnd = $("#dateAlloTo").val();

        if (dateAlloStart === "" && dateAlloEnd === "") {
            location.href = urlAction + "?" + queryString;

        } else {

            if (!isValidDate(dateAlloStart) || !isValidDate(dateAlloEnd)) {
                $("div#error-export-message").text("Ngày cấp phát không đúng");
            } else if (!isBeforeDate(dateAlloStart, dateAlloEnd)) {
                $("div#error-export-message").text("Ngày cấp phát bắt đầu phải trước ngày kết thúc");

            } else {

                // url export data
                location.href = urlAction + "?" + queryString;
            }
        }
    }


    
}
/**
 * Hàm kiểm tra trình duyệt internet explorer
 * @returns {boolean}
 */
function isBrowserIE() {
    var msie = !!navigator.userAgent.match(/Trident/g) || !!navigator.userAgent.match(/MSIE/g);
    return (msie > 0);
}

/**
 * Hàm xuất thông báo khi click nút import người dùng
 * @param status: mã trạng thái tương ứng với các trường hợp || Chưa chọn file || Import thành công || Import gặp lỗi ||
 * @param data: danh sách tên người dùng import không thành công
 */
function showImportMsg(status, data = null) {
    switch (status) {
        case 'no_file':
            $('#btnResetImp').click();
            // Hiện thông báo:
            $('#result-box').fadeIn(100);
            $('.result-title').html("Chưa chọn file để import");
            $('.import-result').css('display', 'none');
            $('body').append('<div id="over1"></div>');
            $('#over1').fadeIn(100);
            break;
        case 'success':
            // Hiện thông báo:
            $('#result-box').fadeIn(100);
            $('.result-title').html("Import thành công");
            $('.import-result').css('display', 'none');
            $('body').append('<div id="over1"></div>');
            $('#over1').fadeIn(100);
            break;
        case 'fail_and_err':
            $('#btnResetImp').click();
            var userList = '';
            $(data).each(function (index, value) {
                userList += index + 1 + ' => ' + value + '<br/>';
            });
            var failMsg = 'Vui lòng kiểm tra lại các thông tin về username, email <br/>của những người dùng sau: <br/>' + userList;
            console.log(userList);
            // Hiện thông báo:
            $('#result-box').fadeIn(100);
            $('.import-result').css('display', 'block');
            $('.import-result').css("text-align", "left");
            $('.import-result').css("margin-right", "7px");
            $('.import-result').css("max-height", "243px");
            $('.result-title').html("Import không thành công");
            $('.import-result').html(failMsg);
            console.log('pre');
            $('body').append('<div id="over1"></div>');
            $('#over1').fadeIn(100);
            break;
    }
    // Ẩn thông báo khi click xác nhận OK
    $('#confirmDelResult, #over1').on('click', function () {
        $('#over1, #result-box').fadeOut(100, function () {
            $('#over1').remove();
        });
        return false;
    });
}

/**
 * Hàm validate dữ liệu form add user
 * @return {boolean}
 */
function validAddForm() {
    /* Xử lí validate dữ liệu form addUser */
    var check = true;
    // Lấy các trường cần kiểm tra
    var txtHoTen = $('#txtHoTen');
    var txtUsername = $('#txtUsername');
    var txtPassword = $('#txtPassword');
    var txtMobile = $('#txtMobile');
    var txtEmail = $('#txtEmail');
    var txtStudent_ID = $('#txtStudent_ID');
    var txtBirthDay = $('#txtBirthDay');
    var birthdayVal = $.trim(txtBirthDay.val());
    // KIỂM TRA
    if ($.trim(txtHoTen.val()) == '') {
        txtHoTen.css('border', '1px solid red');
        check = false;
    }
    if ($.trim(txtUsername.val()) == '') {
        txtUsername.css('border', '1px solid red');
        check = false;
    }
    if ($.trim(txtPassword.val()) == '') {
        txtPassword.css('border', '1px solid red');
        check = false;
    }
    if ($.trim(txtMobile.val()) == '') {
        txtMobile.css('border', '1px solid red');
        check = false;
    }
    if ($.trim(txtEmail.val()) == '') {
        txtEmail.css('border', '1px solid red');
        check = false;
    }
    if ($.trim(txtStudent_ID.val()) == '') {
        txtStudent_ID.css('border', '1px solid red');
        check = false;
    }
    // if (birthdayVal == '' || !isValidDate(birthdayVal)) {
    //     txtBirthDay.css('border', '1px solid red');
    //     check = false;
    // }
    // console.log(check);
    return check;
}

/**
 * Show and hide importDiv
 */
function getImportDiv() {
    $('#import-icon .btn span').toggle();
    $('#import-form').toggle(500);
}
