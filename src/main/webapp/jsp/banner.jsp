<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="../jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <script src="${pageContext.request.contextPath}/boot/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/boot/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${pageContext.request.contextPath}/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="${pageContext.request.contextPath}/boot/js/ajaxfileupload.js"></script>

    <script>
        $(function () {
            $("#list").jqGrid({
                url: "${pageContext.request.contextPath}/Banner/all",
                editurl:"${pageContext.request.contextPath}/Banner/edit",
                styleUI:"Bootstrap",
                datatype: "json",
                rowNum: 2,
                height:'40%',
                rowList: [2, 3,5],
                multiselect:true,
                autowidth: true,
                viewrecords: true,
                pager: "#pager",
               /* caption: "轮播图表",*/
                colNames: ["ID", "标题", "图片", "上传时间", "状态"],
                colModel: [
                    {name: "id"},
                    {name: "title", editable: true},
                    {name: "img", editable: true,edittype:'file',formatter:function (cellvalue,options,rowObject) {
                            return"<img style='width:100%;height: 80px' src='${pageContext.request.contextPath}/img/"+cellvalue+"'height='50' width='50'/>"
                        }},
                    {name: "create_date", editable: true,edittype:"date"},
                    {name: "status", editable: true,edittype: "select", editoptions: {
                            value: "激活:激活;未激活:未激活"
                        }},
                ]
            }).jqGrid("navGrid", "#pager", {},{
                closeAfterEdit:true,
                afterSubmit:function (response) {
                    var bid = response.responseJSON.id;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/Banner/upload",
                        fileElementId:"img",
                        data:{bNid:bid},
                        type:"post",
                        success:function () {
                            $("#msg").show();
                            setTimeout(function () {
                                $("#msg").hide();
                            },3000);
                            $("#list").trigger("reloadGrid");
                        }
                    });
                    return response;
                }
            },{
                closeAfterAdd:true,
                afterSubmit:function (response) {
                    console.log(111);
                    var bid = response.responseJSON.id;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/Banner/upload",
                        fileElementId:"img",
                        data:{bNid:bid},
                        type:"post",
                        success:function () {
                            $("#msgDiv").show();
                            setTimeout(function () {
                                $("#msgDiv").hide();
                            },3000);
                            $("#list").trigger("reloadGrid");
                        }
                    });
                        return response;
                }
            });
        })

    </script>


</head>
<body>
<div class="well well-lg" style="height: 150px">
    <h2 style="text-align: left;color:#8c8c8c ;margin-top: 35px">轮播图管理</h2>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">轮播图详情</a></li>
</ul>
<div>
    <table id="list"></table>
    <div id="pager" style="height: 50px;"></div>
    <div   class="alert alert-success" style="display:none" id="msgDiv">
        <b>添加成功</b>
    </div>
    <div   class="alert alert-success" style="display:none" id="msg">
        <b>修改成功</b>
    </div>
</div>
</body>
</html>