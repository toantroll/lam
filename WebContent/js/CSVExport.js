/**
 * Created by LA Management on 2017/08/18.
 */
/**
 @namespace Converts JSON to CSV.

 Compress with: http://jscompress.com/
 */
(function (window) {
    "use strict";
    /**
     Default constructor
     */
    var _CSV = function (JSONData) {
        if (typeof JSONData === 'undefined')
            return;

        // Get current time on client
        var timePrint = new Date();
        var dayPrint = (timePrint.getDate() < 10) ? "0" + timePrint.getDate() : timePrint.getDate();
        var monthPrint = (timePrint.getMonth() < 9) ? "0" + (timePrint.getMonth() + 1) : (timePrint.getMonth() + 1);
        // console.log(monthPrint);
        var yearPrint = timePrint.getFullYear();
        var hourPrint = (timePrint.getHours() < 10) ? "0" + timePrint.getHours() : timePrint.getHours();
        var minutesPrint = (timePrint.getMinutes() < 10) ? "0" + timePrint.getMinutes() : timePrint.getMinutes();
        var secondsPrint = (timePrint.getSeconds() < 10) ? "0" + timePrint.getSeconds() : timePrint.getSeconds();
        var datePrint = dayPrint + "-" + monthPrint + "-" + yearPrint + " " + hourPrint + ":" + minutesPrint + ":" + secondsPrint;
        // // Get condition search
        // var txtHoten = ($.trim($('#txtHoten').val()) == "") ? "" : "Họ tên SV: " + $('#txtHoten').val() + "\n";
        // var txtEmail = ($.trim($('#txtEmail').val()) == "") ? "" : "Email: " + $('#txtEmail').val() + "\n";
        // var txtKhoa = ($.trim($('#txtKhoa').val()) == "") ? "" : "Khóa học: " + $('#txtKhoa').val() + "\n";
        // var txtNgaydangky = ($.trim($('#txtNgaydangky').val()) == "") ? "" : "Ngày đăng kí: " + $('#txtNgaydangky').val() + "\n";
        // var txtTruonghoc = ($.trim($('#txtTruonghoc').val()) == "") ? "" : "Trường học: " + $('#txtTruonghoc').val() + "\n";
        // var txtNamtotnghiep = ($.trim($('#txtNamtotnghiep').val()) == "") ? "" : "Năm tốt nghiệp: " + $('#txtNamtotnghiep').val() + "\n";
        // var txtChuyennganh = ($.trim($('#txtChuyennganh').val()) == "") ? "" : "Chuyên ngành: " + $('#txtChuyennganh').val() + "\n";
        // var subTitle = (txtHoten == '' && txtEmail == '' && txtKhoa == '' && txtNgaydangky == '' && txtTruonghoc == '' && txtNamtotnghiep == '' && txtChuyennganh == '') ? "" : "Tìm kiếm theo:\n";

        var csvData = typeof JSONData != 'object' ? JSON.parse(settings.JSONData) : JSONData,
            csvHeaders,
            csvEncoding = 'data:text/csv;charset=utf-8,%EF%BB%BF',
            csvOutput = "DANH SÁCH HỌC VIÊN LA\n"+"\r\n Ngày in: "+datePrint+" \r\n Người in: Admin\r\n \r\n",
            csvRows = [],
            BREAK = '\r\n',
            DELIMITER = ',',
            FILENAME = "LA_Students_List.csv";

// Get and Write the headers
        csvHeaders = Object.keys(csvData[0]);
        csvOutput += csvHeaders.join(',') + BREAK;

        for (var i = 0; i < csvData.length; i++) {
            var rowElements = [];
            for(var k = 0; k < csvHeaders.length; k++) {
                rowElements.push(csvData[i][csvHeaders[k]]);
            } // Write the row array based on the headers
            csvRows.push(rowElements.join(DELIMITER));
        }

        csvOutput += csvRows.join(BREAK);

// Initiate Download
        var a = document.createElement("a");

        if (navigator.msSaveBlob) { // IE10
            navigator.msSaveBlob(new Blob([csvOutput], { type: "text/csv" }), FILENAME);
        } else if ('download' in a) { //html5 A[download]
            a.href = csvEncoding + encodeURIComponent(csvOutput);
            a.download = FILENAME;
            document.body.appendChild(a);
            setTimeout(function() {
                a.click();
                document.body.removeChild(a);
            }, 66);
        } else if (document.execCommand) { // Other version of IE
            var oWin = window.open("about:blank", "_blank");
            oWin.document.write(csvOutput);
            oWin.document.close();
            oWin.document.execCommand('SaveAs', true, FILENAME);
            oWin.close();
        } else {
            alert("Support for your specific browser hasn't been created yet, please check back later.");
        }
    };

    window.CSVExport = _CSV;

})(window);

// From https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/keys
if (!Object.keys) {
    Object.keys = (function() {
        'use strict';
        var hasOwnProperty = Object.prototype.hasOwnProperty,
            hasDontEnumBug = !({ toString: null }).propertyIsEnumerable('toString'),
            dontEnums = [
                'toString',
                'toLocaleString',
                'valueOf',
                'hasOwnProperty',
                'isPrototypeOf',
                'propertyIsEnumerable',
                'constructor'
            ],
            dontEnumsLength = dontEnums.length;

        return function(obj) {
            if (typeof obj !== 'object' && (typeof obj !== 'function' || obj === null)) {
                throw new TypeError('Object.keys called on non-object');
            }

            var result = [], prop, i;

            for (prop in obj) {
                if (hasOwnProperty.call(obj, prop)) {
                    result.push(prop);
                }
            }

            if (hasDontEnumBug) {
                for (i = 0; i < dontEnumsLength; i++) {
                    if (hasOwnProperty.call(obj, dontEnums[i])) {
                        result.push(dontEnums[i]);
                    }
                }
            }
            return result;
        };
    }());
}