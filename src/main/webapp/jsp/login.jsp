<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  isELIgnored="false" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form Template</title>
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="../jsp/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../jsp/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../jsp/assets/css/form-elements.css">
    <link rel="stylesheet" href="../jsp/assets/css/style.css">
    <link rel="shortcut icon" href="../jsp/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../jsp/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../jsp/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../jsp/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../jsp/assets/ico/apple-touch-icon-57-precomposed.png">
    <script src="../boot/js/jquery-2.2.1.min.js"></script>
    <script src="../jsp/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../jsp/assets/js/jquery.backstretch.min.js"></script>
    <script src="../jsp/assets/js/scripts.js"></script>
    <script src="../boot/js/jquery.validate.min.js"></script>
    <script src="../boot/js/jquery.validate.js"></script>
    <script>
       $(function () {
           //刷新图片
           $("#captchaImage").click(function () {
               $("#captchaImage").prop("src","${pageContext.request.contextPath}/code/getCode?time="+new Date().getTime())
           });
           //ajax请求
           $("#loginButtonId").click(function () {
               $.ajax({
                   url:"${pageContext.request.contextPath}/admin/login",
                   datatype:"json",
                   type:"POST",
                   data:$("#loginForm").serialize(),
                   success:function (result) {
                       console.log(result);
                       if (result=="ok"){
                            location.href="${pageContext.request.contextPath}/jsp/home.jsp";
                       } else {
                          $("#msgDiv").text(result);
                       }
                   }
               })
           });
           //表单验证
           $("#loginForm").validate({
               rules:{
                   username:{required:true},
                   password:{required: true,minlength:6,maxlength:6},
               },
               messages:{
                   username:{required:"此框必填"},
                   password: {required:"此框必填",minlength: "长度最少为6个字符",maxlength: "长度最长为6个字符"},
               }
           });
       });
        getTime=function () {
            var date = new Date();
            /*年*/
            var fullYear = date.getFullYear();
            /*月*/
            var month = date.getMonth()+1;
            /*日*/
            var day = date.getDate();
            /*时*/
            var hours = date.getHours();
            /*分*/
            var minutes = date.getMinutes();
            /*秒*/
            var seconds = date.getSeconds();
            var time=fullYear+"年"+month+"月"+day+"日"+""+hours+":"+minutes+":"+seconds;
            $("#time").html(time);
        };
            setInterval("getTime()",1000);
    </script>
</head>
<body>
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-lg-offset-4 text">
                    <h1 ><strong>CMFZ</strong> Login Form</h1>
                    <div class="description">
                        <p>
                            <a href="#"><strong id="time">CMFZ</strong></a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-7 col-lg-offset-4 form-box">
                    <div class="form-top" style="width: 450px">
                        <div class="form-top-left">
                            <h3>Login to showall</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom" style="width: 450px">
                        <form role="form" action="" method="post" class="login-form" id="loginForm">
                            <span id="msgDiv"> </span>
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="username" placeholder="请输入用户名..."
                                       class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="请输入密码..."
                                       class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <img id="captchaImage" style="height: 48px" class="captchaImage"
                                     src="${pageContext.request.contextPath}/code/getCode">
                                <input style="width: 289px;height: 50px;border:3px solid #ddd;border-radius: 4px;"
                                       type="test" name="enCode" id="form-code" placeholder="请输入验证码..." >
                            </div>
                            <input type="button" style="width: 400px;border:1px solid #9d9d9d;border-radius: 4px;" id="loginButtonId" value="登录">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>