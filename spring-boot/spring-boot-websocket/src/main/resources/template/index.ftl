<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Code</th>
        </tr>
        </thead>
        <tbody id="table">
        </tbody>
    </table>
</div>
</body>
<script src="http://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
    $(function () {
        $.ajax({
            url: "/country",
            type: "GET",
            dataType: "json",
            data: "",
            success: function (data) {
                var dataArr = data;
                var htmlStr = '';
                $('#table tr:gt(0)').remove();//删除之前的数据
                for (var i = 0; i < 5; i++) {
                    var item = dataArr[i];
                    htmlStr += '<tr>' + '<td>' + item.id + '</td>' + '<td>' + item.countryName + '</td>' + '<td>' + item.countryCode + '</td>' + '</tr>';
                }
                $('#table').append(htmlStr);
            }
        });
    });
</script>
</html>