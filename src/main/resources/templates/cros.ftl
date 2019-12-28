<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>跨域测试</title>
</head>

<body>
<button id="test">测试</button>
<script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#test").on("click", function() {
            $.ajax({
                "url": "http://localhost:8080/fastjson/test",
                "type": "get",
                "dataType": "json",
                "success": function(data) {
                    console.log(data);
                }
            })
        });
    });
</script>
</body>

</html>