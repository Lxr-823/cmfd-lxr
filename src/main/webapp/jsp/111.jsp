<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="${app}/boot/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="https://cdn.goeasy.io/goeasy-1.0.3.js"></script>
    <script charset="utf-8" src="${app}/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="${app}/kindeditor/lang/zh-CN.js"></script>
    <script>
        <%--
            goeasy
        --%>
        var goEasy = new GoEasy({
            host:'hangzhou.goeasy.io',//应用所在的区域地址，杭州：hangzhou.goeasy.io，新加坡：singapore.goeasy.io
            appkey: "BC-d3cdcedfd9f3434aa8c4bff111250266",//替换为您的应用appkey
        });
        goEasy.subscribe({
            channel: "my_channel",//替换为您自己的channel
            onMessage: function (message) {
                var date = new Date();
                var newDate = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
                $("#d").append(message.content);
            }
        });

        KindEditor.ready(function (K) {
            window.editor = K.create('#editor_id', {
                resizeType: 0
            });
        });
        //给按钮一个单击事件
        function send() {
            //拼接发送的人名及时间
            var date = new Date();
            var newDate = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
            //获取里面的文本
            html = editor.html();
            goEasy.publish({
                channel: "my_channel", //替换为您自己的channel
                message:  "<p>鬼子:"+newDate+"</p>"+html //替换为您想要发送的消息内容
            });
            editor.html("");

        }
    </script>
</head>
<body>
<div style="width: 700px;height:400px;border: 1px solid" id="d">

</div>

<textarea id="editor_id" name="content" style="width:700px;height:300px;">

</textarea>
<button style="margin-left: 660px" type="button" onclick="send();">发送</button>
</body>
</html>
