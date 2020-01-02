<%@page language="java" isELIgnored="false" contentType="text/html; UFT-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script charset="UTF-8" src="../kindeditor/kindeditor-all-min.js"></script>
    <script charset="UTF-8" src="../kindeditor/lang/zh-CN.js"></script>
    <script>
        KindEditor.ready(function (K) {
            editor = K.create('textarea[name="content"]', {
            });
        });
    </script>
</head>
<body>
<textarea id="editor_id" name="content" style="width:700px;height:300px;"> </textarea>
</body>
</html>