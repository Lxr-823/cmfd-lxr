<%@page language="java" isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="${pageContext.request.contextPath}/boot/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/each/echarts.min.js"></script>
    <script type="text/javascript" src="https://cdn.goeasy.io/goeasy-1.0.3.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var goEasy = new GoEasy({
        host:'hangzhou.goeasy.io',//应用所在的区域地址，杭州：hangzhou.goeasy.io，新加坡：singapore.goeasy.io
        appkey: "BS-42c731f39ea54157a7873f2cc624a4ef",//替换为您的应用appkey
    });



    //1-7天的访问量
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: ["1","2","3","4","5","6","7"]
        },
        yAxis: { },
        series: [{
            name: '人数',
            type: 'bar'
        }]

    };

    //使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    $.ajax({
        url: "${pageContext.request.contextPath}/Echarts/day",
        datatype: "json",
        success:function (data) {
            myChart.setOption({
                series: [{
                    data: data
                }]
            })

        }

    });
    goEasy.subscribe({
        channel: "easy",
        onMessage: function (message) {
            var parse = JSON.parse(message.content);
            console.log(parse);
            myChart.setOption({
                series: [{
                    data: parse
                }]
            })
        },
    });
</script>
</body>
</html>