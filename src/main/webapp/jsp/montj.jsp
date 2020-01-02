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
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
      xAxis: {
          data:["1","2","3","4","5","6","7","8","9","10","11","12"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'line',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
   myChart.setOption(option);
  $.ajax({
        url:"${pageContext.request.contextPath}/Echarts/month",
        datatype:"json",
        type: "post",
        success:function (data) {
            console.log(data);
             myChart.setOption({
                 series: [{
                     data: data
                 }]
             });
        }
            });
    var goEasy = new GoEasy({
        host:'hangzhou.goeasy.io',//应用所在的区域地址，杭州：hangzhou.goeasy.io，新加坡：singapore.goeasy.io
        appkey: "BS-42c731f39ea54157a7873f2cc624a4ef",//替换为您的应用appkey
    });
    goEasy.subscribe({
        channel: "easy",
        onMessage: function (message) {
            var parse = JSON.parse(message.content);
            myChart.setOption({
                series: [{
                    data: parse
                }]
            });
        },
    });

</script>
</body>
</html>