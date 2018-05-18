<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
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
        <#list pageInfo.list as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.countryName}</td>
            <td>${item.countryCode}</td>
        </tr>
        </#list>
        </tbody>
    </table>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination" page_num="${pageInfo.pageNum}">
                <li id="previous_li">
                    <a href="#" aria-label="Previous" id="previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li id="next_">
                    <a href="#" aria-label="Next" id="next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</div>

</body>
<script src="http://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
    $(function () {

        // 前一页
        $('#previous').click(function () {
            var pageNum = parseInt($('.pagination').attr('page_num')) - 1;
            var pageSize = 5;
            $('#table').html('');// 清除当前 tbody
            clickPage(pageNum, pageSize)
        });

        // 后一页
        $('#next').click(function () {
            var pageNum = parseInt($('.pagination').attr('page_num')) + 1;
            var pageSize = 5;
            $('#table').html('');// 清除当前 tbody
            clickPage(pageNum, pageSize)
        });
    });

    /**
     * 点击分页
     * @param pageNum
     * @param pageSize
     */
    function clickPage(pageNum, pageSize) {

        $.ajax({
            url: "/country/page?pageNum=" + pageNum + '&pageSize=' + pageSize,
            type: "GET",
            dataType: "json",
            data: '',
            success: function (data) {
                $('#table tr:gt(0)').remove();//删除之前的数据
                var dataArr = data.list;
                var htmlStr = '';
                for (var i = 0; i < 5; i++) {
                    var item = dataArr[i];
                    htmlStr += '<tr>' + '<td>' + item.id + '</td>' + '<td>' + item.countryName + '</td>' + '<td>' + item.countryCode + '</td>' + '</tr>';
                }
                $('#table').html(htmlStr);
                $('.pagination').attr('page_num', data.pageNum);
                if (data.pageNum == data.pages) {
                    $('.pagination li:last').addClass('disabled');
                    return;
                };
                if (data.pageNum == 1) {
                    $('.pagination li:first').addClass('disabled');
                    return;
                };
            }
        });
    }
</script>
</html>