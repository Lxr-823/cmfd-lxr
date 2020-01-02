<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" language="java" %>
<script charset="UTF-8" src="../kindeditor/kindeditor-all-min.js"></script>
<script charset="UTF-8" src="../kindeditor/lang/zh-CN.js"></script>
<script>


    $(function () {


        $("#li").jqGrid({
            url: "${pageContext.request.contextPath}/Article/query",
            editurl: "${pageContext.request.contextPath}/Article/edit",
            datatype: "json",
            multiselect: true,
            styleUI: "Bootstrap",
            pager: "#pager",
            rowNum: 2,
            rowList: [1, 2, 3],
            viewrecords: true,
            autowidth: true,
            autowidth: true,
            records: true,
            align: "center",
            colNames: ["ID", "标题", "状态", "上传时间", "操作"],
            colModel: [
                {name: "id", hidden: true},
                {name: "title", align: "center"},
                {name: "status", align: "center"},
                {name: "create_date", align: "center"},
                {
                    name: "caozuo", align: "center", formatter: function (cellvalue, options, rowObject) {
                        return "<button class='btn-success'><span onclick='on()' data-target=\"#myMo\" class='glyphicon glyphicon-th-list'>查看</span></button>" + "&nbsp;&nbsp;&nbsp;&nbsp;" + "<button class='btn-success'><span onclick='xg()' data-target=\"#myModa2\" class='glyphicon glyphicon-pencil'>修改</span></button>"
                    }
                }
            ]
        }).jqGrid("navGrid", "#pager", {});



    });
     editor = KindEditor.create("#content1",{
        width:'100px',  //宽  类型是字符串
        minHeight:400,
        minWidth:795,
        resizeType:0,
        allowFileManager:true,    //是否展示 图片空间
        filePostName:'img',       //上传是后台接收的名字
        uploadJson:'${pageContext.request.contextPath}/kindeditor/kin', //上传后台的路径
        fileManagerJson:"${pageContext.request.contextPath}/kindeditor/img",
        afterBlur:function () {
            this.sync();
        }
    });
    function test() {
        $("#myModal").modal("hide");
        html = editor.html();
        console.log(html);
        $.ajax({
            url: "${pageContext.request.contextPath}/Article/add?text="+html,
            datatype: "json",
            data:$("#form").serialize(),
            type:"post",
            success:function (data) {
                $("#li").trigger("reloadGrid");
                document.getElementById("form").reset();
            }
        })
    };
    <!--查看信息-->
    function on() {
        //判断 用户是否选中一行
        var data = $("#li").jqGrid('getRowData',jqGrid);
        var jqGrid = $("#li").jqGrid('getGridParam','selrow');
        if (jqGrid == null){
            alert("请选中要查看的信息");
        } else {
            $("#sele").empty();
            $("#myMo").modal("show");
            var jqGrid1 = $("#li").jqGrid('getGridParam','selrow');
        $.ajax({
            url:"${pageContext.request.contextPath}/Article/select",
            datatype:"json",
            data: {"id":jqGrid},
            type: "post",
            success:function (data) {
                $("#ID").val(data.id);
                $("#title").val(data.title);
                $("#author").val(data.author);
                $("#guru_id").val(data.guru_id);
                $("#create_date").val(data.create_date);
                $("#status").val(data.status);
                $("#sele").append("<p style=\"width: 795px\">"+data.content+"</p>")

            }

        })

    }
    }
    //回显
    function xg() {
        //判断 用户是否选中一行
        var data = $("#li").jqGrid('getRowData', jqGrid);
        var jqGrid = $("#li").jqGrid('getGridParam', 'selrow');
        if (jqGrid == null) {
            alert("请选中要修改的信息");
        } else {
            $("#myModa2").modal("show");
            var jqGrid1 = $("#li").jqGrid('getGridParam', 'selrow');
            $.ajax({
                url:"${pageContext.request.contextPath}/Article/selectid",
                datatype:"json",
                data:{"id":jqGrid},
                type: "post",
                success:function (data) {
                    $("#di2").val(data.id);
                    $("#title2").val(data.title);
                    $("#author2").val(data.author);
                    $("#status2").val(data.status);
                    editor2.html(data.content);

                }
            })
        }
    }

    ///修改
    function nn() {
        console.log($("#for").serialize());

        $.ajax({
            url:"${pageContext.request.contextPath}/Article/update",
            datatype:"json",
            data:$("#for").serialize(),
            type: "post",
            success:function (data) {
                $("#li").trigger("reloadGrid");
                $("#myModa2").modal("hide");
            }
        })
    }

    editor2 = KindEditor.create("#content2", {
        width: '100px',  //宽  类型是字符串
        minHeight: 400,
        minWidth: 795,
        resizeType: 0,
        allowFileManager:true,    //是否展示 图片空间
        filePostName:'img',       //上传是后台接收的名字
        uploadJson:'${pageContext.request.contextPath}/kindeditor/kin', //上传后台的路径
        fileManagerJson:"${pageContext.request.contextPath}/kindeditor/img",
        afterBlur:function () {
            this.sync();
        }
    })

</script>


<!--标题-->
<div class="well well-lg" style="height: 150px">
    <h2 style="text-align: left;color:#8c8c8c ;margin-top: 35px">文章管理</h2>
</div>
<!--标签页-->
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="" aria-controls="home" role="tab" data-toggle="tab">文章详情</a></li>
    <li role="presentation" data-toggle="modal" data-target="#myModal"><a href="#profile" aria-controls="profile"
                                                                          role="tab" data-toggle="tab">添加文章</a></li>
</ul>

<table id="li"></table>
<div id="pager" style="height: 50px;"></div>
<!--模态框-->
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 800px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">查看文章</h4>
            </div>
            <form id="form">
            <div class="form-group">
                <label>&nbsp;&nbsp;文章</label>
                <input type="text" class="form-control" id="title1" name="title">
            </div>
                <div class="form-group">
                    <label >&nbsp;&nbsp;作者</label>
                    <input type="text" class="form-control" id="author1" name="author">
                </div>
                <div class="form-group">
                    <label >&nbsp;&nbsp;状态</label>
                   <select class="form-control" name="status" id="status1">
                       <option value="激活">激活</option>
                       <option value="未激活">未激活</option>
                   </select>
                </div>
                <br>
                    <textarea id="content1" name="content" style="width:1000px;height:300px;">
                    </textarea>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="test();">Save changes</button>
            </div>
        </div>
    </div>
</div>

<!--修改模态框-->
<div class="modal fade" id="myModa2" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 800px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabe">修改文章信息</h4>
            </div>
            <form id="for">
                <div class="form-group">
                    <input type="hidden" class="form-control" id="di2" name="id" >
                </div>
                <div class="form-group">
                    <label>&nbsp;&nbsp;文章</label>
                    <input type="text" class="form-control" id="title2" name="title">
                </div>
                <div class="form-group">
                    <label >&nbsp;&nbsp;作者</label>
                    <input type="text" class="form-control" id="author2" name="author">
                </div>
                <div class="form-group">
                    <label >&nbsp;&nbsp;状态</label>
                    <select class="form-control" name="status" id="status2">
                        <option value="激活">激活</option>
                        <option value="未激活">未激活</option>
                    </select>
                </div>
                <br>
                <textarea id="content2" name="content" style="width:1000px;height:300px;">
                    </textarea>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="nn()">Save changes</button>
            </div>
        </div>
    </div>
</div>
<!--查看模态框-->
<div class="modal fade" id="myMo" role="dialog" aria-labelledby="myModal">
    <div class="modal-dialog" role="document" style="width: 800px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" >查看文章</h4>
            </div>
            <form id="fo">
                <div class="form-group">
                    <label >&nbsp;&nbsp;ID</label>
                    <input type="text" class="form-control" id="ID" name="id" readonly>
                </div>
                <div class="form-group">
                    <label>&nbsp;&nbsp;文章</label>
                    <input type="text" class="form-control" id="title" name="title" readonly>
                </div>
                <div class="form-group">
                    <label>&nbsp;&nbsp;作者</label>
                    <input type="text" class="form-control" id="author" name="author" readonly>
                </div>
                <div class="form-group">
                    <label>&nbsp;&nbsp;上师ID</label>
                    <input type="text" class="form-control" id="guru_id" name="guru_id" readonly>
                </div>
                <div class="form-group">
                <label >&nbsp;&nbsp;发表时间</label>
                <input type="text" class="form-control" id="create_date" name="create_date" readonly>
            </div>
                <div class="form-group">
                    <label >&nbsp;&nbsp;状态</label>
                    <select class="form-control" name="status" id="status" readonly>
                        <option value="激活">激活</option>
                        <option value="未激活">未激活</option>
                    </select>
                </div>
                <br>
                <div id="sele" ></div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>






