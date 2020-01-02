<%@page language="java" isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="../jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <script src= "../boot/js/jquery-3.1.1.min.js"></script>
    <script src= "../boot/js/bootstrap.min.js"></script>
    <script src="../jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="../jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="../boot/js/ajaxfileupload.js"></script>
    <script charset="UTF-8" src="../kindeditor/kindeditor-all-min.js"></script>
    <script charset="UTF-8" src="../kindeditor/lang/zh-CN.js"></script>
</head>
<body>
<div>
    <nav class="navbar navbar-default navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">持名法洲后台管理系统</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎:${sessionScope.admin.username}</a></li>
                <li class="dropdown">
                    <a href="../jsp/login.jsp" class="dropdown-toggle" style="margin-right: 15px;" aria-haspopup="true" aria-expanded="false"><span
                            class="glyphicon glyphicon-hand-right">&nbsp;</span>退出登录</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-2">
                <div class="panel-group" id="accordion"  role="tablist" style="text-align: center" >
                    <div class="panel panel-default" >
                        <div class="panel-heading" id="headingOne" style="height: 50px" >
                            <h4 class="panel-title" style="margin-top:8px ">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    用户管理
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse " aria-labelledby="headingOne">
                            <div class="panel-body" style="height: 70px">
                                <div class="list-group">
                                    <a href="" onclick="" class="list-group-item list-group-item-danger">用户详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" id="headingTwo" style="height: 50px" >
                            <h4 class="panel-title" style="margin-top:8px ">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                    上师管理
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" aria-labelledby="headingTwo">
                            <div class="panel-body">
                                ---
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" id="headingThree" style="height: 50px">
                            <h4 class="panel-title" style="margin-top:8px ">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseThree" aria-expanded="false">
                                    文章管理
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse" aria-labelledby="headingThree">
                            <div class="panel-body" style="height: 70px">
                                <div class="list-group">
                                    <a href="javascript:$('#myContent').load('article.jsp')" class="list-group-item list-group-item-danger">文章详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" id="root" style="height: 50px">
                            <h4 class="panel-title" style="margin-top:8px ">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                   href="#roo" aria-expanded="false">
                                    专辑管理
                                </a>
                            </h4>
                        </div>
                        <div id="roo" class="panel-collapse collapse" aria-labelledby="root">
                            <div class="panel-body" style="height: 70px">
                                <div class="list-group">
                                    <a href="javascript:$('#myContent').load('album.jsp')" class="list-group-item list-group-item-danger">专辑详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" id="rot" style="height: 50px">
                            <h4 class="panel-title" style="margin-top:8px ">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                   href="#ro" aria-expanded="false">
                                    轮播图管理
                                </a>
                            </h4>
                        </div>
                        <div id="ro" class="panel-collapse collapse" aria-labelledby="rot">
                            <div class="panel-body" style="height: 70px">
                                <div class="list-group">
                                    <a href="javascript:$('#myContent').load('banner.jsp')" class="list-group-item list-group-item-danger">轮播图详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            <div>
                <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/poi/po">
                    <button class="btn btn-success">导出管理员信息表</button>
                </form>
            </div>
                <div>
                    <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/poi/Easy">
                        <button class="btn btn-success">easy导出管理员信息表</button>
                    </form>
                </div>
            </div>
            <div class="col-sm-10" id="myContent">
                    <div class="well well-lg" style="height: 150px">
                            <h2 style="text-align: left;color:#8c8c8c ;margin-top: 35px" >持名法洲后台管理系统</h2>
                    </div>
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="../img/shouye.jpg" alt="..." style="width: 1515px;height: 600px">
                            <div class="carousel-caption">
                                ...
                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/shouye.jpg" alt="..." style="width: 1515px;height: 600px">
                            <div class="carousel-caption">
                                ...
                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/shouye.jpg" alt="..." style="width: 1515px;height: 600px">
                            <div class="carousel-caption">
                                ...
                            </div>
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div>
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
           <h4 style="text-align: center;margin-top: 18px">@百知教育 baizhi@zparkhf.com.cn</h4>
        </div>
    </nav>
    </div>
</div>

</body>
</html>