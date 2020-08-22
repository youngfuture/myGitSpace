<%@ page language = "java" contentType= "text/html; charset=UTF-8" pageEncoding= "UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贵金属期货</title>
</head>
<body>
<h1>贵金属期货</h1>
<div>
    <div>
        <h2>贵金属列表</h2>
    </div>
    <div>
        <h2 id="hint"></h2>
    </div>
    <hr>
    <div>
        <div><p>黄金</p><p id="c0" style="color:#F00"></p><b><p id="s0">历史价格：</p></b></div>
        <div><p>白银</p><p id="c1" style="color:#F00"></p><b><p id="s1">历史价格：</p></b></div>
    </div>
    <hr>

</div>
<script type="text/javascript" src="assets/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

    function showPrice(index,data){
        $("#c"+index).html("当前价格："+data);
        var s = $("#s"+index).html();
        $("#s"+index).html(s+data+" ");
    }

    if(!!window.EventSource){
        var source = new EventSource('needPrice');
        source.onmessage=function (e) {
            var dataObj=e.data;
            var arr = dataObj.split(',');
            $.each(arr, function (i, item) {
                showPrice(i,item);
            });
            $("#hint").html("");
        };

        source.onopen=function (e) {
            console.log("Connecting server!");
        };

        source.onerror=function () {
            console.log("error");
        };
    }
    else{
        $("#hint").html("您的浏览器不支持SSE！");
    }





/*        source.onmessage=function (e) {
            var dataObj=e.data;
            var arr = dataObj.split(',');
            $.each(arr, function (i, item) {
                showPrice(i,item);
            });
            $("#hint").html("");
        };

        source.onopen=function (e) {
            console.log("Connecting server!");
        };

        source.onerror=function () {
            console.log("error");
        };
*/



</script>
</body>
</html>