<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"  lang="zh-CN">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.js"></script>

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">蚊子社区</a>
        </div>


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="搜索关键字">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>


            <ul class="nav navbar-nav navbar-right">
                <#if  Session["user"]??>
                    <li>
                        <a href="/publish">
                            发布
                        </a>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            ${Session["user"].name}
                            <span class="caret">
                            </span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">信息中心</a></li>
                            <li><a href="#">个人中心</a></li>
                            <li><a href="#">退出登陆</a></li>
                        </ul>
                    </li>
                <#else >
                      <li>
                          <a href=" https://github.com/login/oauth/authorize?client_id=df63f61d85eee25089b8&redirect_uri=http://localhost:8080/callback&scope=user&state=1">
                              登录
                          </a>
                      </li>
                </#if>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>


