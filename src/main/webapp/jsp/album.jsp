<%@page language="java" isELIgnored="false" contentType="text/html; UFT-8" pageEncoding="UTF-8" %>
    <script>
    $(function () {
        $("#list").jqGrid({
            url:"${pageContext.request.contextPath}/Album/queryAll",
            datatype:"json",
            styleUI:"Bootstrap",
            rowNum: 3,
            height:'50%',
            rowList: [1, 2,3],
            pager:"#pager",
            autowidth: true,
            viewrecords: true,
           /* caption: "专辑管理",*/
            colNames:["ID","标题","图片","星级分数","作者","播音员","集数","简介","上传时间","状态"],
            colModel:[
                {name:"id"},
                {name:"title",editable:true},
                {name:"img",editable:true,formatter:function (cellvalue,options,rowObject) {
            return"<img style='width:100%;height: 80px' src='${pageContext.request.contextPath}/img/"+cellvalue+"'height='50' width='50'/>"
        }},
                {name:"score",editable:true},
                {name:"author",editable:true},
                {name:"broadcaster",editable:true},
                {name:"count",editable:true},
                {name:"brief",editable:true},
                {name:"create_date",editable:true},
                {name:"status",editable:true},
            ],
            subGrid:true,
            subGridRowExpanded:function (subGridld,albumld) {
                addSubGrid(subGridld,albumld);
            }
        }).jqGrid("navGrid", "#pager", {})
    });
        //添加子表格
        function addSubGrid(subGridld,albumld) {
            //动态table id
           var subGridTaBleld= subGridld + "table";
            //动态div id
            var subGridDivld = subGridld + "div";
            //动态添加子表格
            $("#"+subGridld).html("<table id='"+subGridTaBleld+"'></table>"+"<div id='"+subGridDivld+"' style='height:50px'></div>");
            $("#"+subGridTaBleld).jqGrid({
                url: "${pageContext.request.contextPath}/Chapter/cha?id="+albumld,
                editurl:"${pageContext.request.contextPath}/Chapter/edit?idd="+albumld,
                styleUI: "Bootstrap",
                datatype: "json",
                multiselect:true,
                autowidth: true,
                records:true,
                rowNum: 3,
                caption: "章节",
                toolbar:[true,"top"],
                pager:"#"+subGridDivld,
                rowList: [2,3,4],
                colNames: ["ID","标题","专辑ID","大小","时长","路径","状态"],
                colModel: [
                    {name:"id"},
                    {name:"title"},
                    {name:"album_id"},
                    {name:"size"},
                    {name:"duration"},
                    {name:"src",width:300 ,editable: true,edittype:'file',formatter:function (value,option,rows) {
                            return "<audio controls loop preload='auto'>\n" +
                                "<source src='${pageContext.request.contextPath}/audio/"+value+"' type='audio/mpeg'>\n"+
                                "<source src='${pageContext.request.contextPath}/audio/"+value+"' type='audio/ogg'>\n"+
                                "</audio>";
                        }},
                    {name:"status",editable: true,edittype: "select", editoptions: {
                            value: "激活:激活;未激活:未激活"
                        }},
                ]
            }).jqGrid("navGrid", "#"+subGridDivld, {},{
                closeAfterEdit:true,
                afterSubmit:function (response) {
                    var bid = response.responseJSON.id;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/Chapter/upload",
                        fileElementId:"src",
                        data:{id:bid},
                        type:"post",
                        success:function () {
                            $("#msg").show();
                            setTimeout(function () {
                                $("#msg").hide();
                            },3000);
                            $("#"+subGridTaBleld).trigger("reloadGrid");
                        }
                    });
                    return response;
                }
            },{
                closeAfterAdd:true,
                afterSubmit:function (response) {
                    var bid = response.responseJSON.id;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/Chapter/upload",
                        fileElementId:"src",
                        data:{id:bid},
                        type:"post",
                        success:function () {
                            $("#msgDiv").show();
                            setTimeout(function () {
                                $("#msgDiv").hide();
                            },3000);
                            $("#"+subGridTaBleld).trigger("reloadGrid");
                        }
                    });
                    return response;
                }
            });
            //添加按钮
            $("#t_"+subGridTaBleld).html("<button class='btn btn-danger' onclick=\"play('"+subGridTaBleld+"')\">播放<span class='glyphicon glyphicon-play'></span></button>"+"&nbsp;&nbsp;&nbsp;"+
                "<button class='btn btn-danger' onclick=\"download('"+subGridTaBleld+"')\">下载<span class='glyphicon glyphicon-arrow-down'></span></button>")
    }
        //播放
        function play(subGridTaBled) {
            //判断 用户是否选中一行
            var jqGrid = $("#"+subGridTaBled).jqGrid('getGridParam','selrow');
            var data = $("#"+subGridTaBled).jqGrid('getRowData',jqGrid);
            if (jqGrid == null){
                alert("请选中要播放的音频");
            } else {
                //将div清空
                $("#myA1").empty();
                //将模态框展示
                $("#mo").modal("show");
                //此时的data.src 是标签 模态框里添加标签
                $("#myA1").append(data.src);
            }
        }

   function download(subGridTaBled) {
       //判断 用户是否选中一行
       var jqGrid = $("#"+subGridTaBled).jqGrid('getGridParam','selrow');
       if (jqGrid == null){
           alert("请选中要下载的音频");
       } else {
             var jqGrid1 = $("#"+subGridTaBled).jqGrid('getGridParam','selrow');
           $.ajaxFileUpload({
               url:"${pageContext.request.contextPath}/Chapter/download",
               datatype:"json",
               data:{"id":jqGrid1},
               type:"post",
               success:function () {
                   $("#msg").show();
                   setTimeout(function () {
                       $("#msg").hide();
                   },3000);
               }
           });
           /* var grid = $("#"+subGridTaBled).jqGrid('getRowData',jqGrid);
           var src = grid.src;
           alert(src);
           location.href='{pageContext.request.contextPath}/Chapter/download?src='+src;*/
       }
   }

    </script>

<div class="well well-lg" style="height: 150px">
    <h2 style="text-align: left;color:#8c8c8c ;margin-top: 35px">专辑管理</h2>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">专辑详情</a></li>
</ul>
<table id="list"></table>
<div id="pager" style="height: 50px;"></div>
<div   class="alert alert-success" style="display:none" id="msgDiv">
    <b>添加成功</b>
</div>
<%--模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="mo">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">音乐播放器</h4>
            </div>
            <div class="modal-body">
                <div id="myA1" style="margin-left: 130px;"></div>
            </div>

        </div>
    </div>
</div>

