<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="zh-CN">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">


    <script type="text/javascript" src="/js/jquery.js"/>
    <script type="text/javascript" src="/js/bootstrap.js"></script>


    <link rel="stylesheet" href="css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/publish.css"/>

</head>
<body class="bodys">
<#--顶部导航栏-->
<nav class="navbar navbar-default head">
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
            <a class="navbar-brand" href="/">蚊子社区</a>
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
                <#if  Session["user"]?exists>
                    <li>
                        <a href="#">
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

<#--页面主体-->
<div class="container-fluid content">
    <div class="row">
    <#--发起-->
        <div class="col-md-9 col-xs-12 left-content">
            <h4>
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                发起
            </h4>
            <hr>

            <form method="post" action="/publish">
            <#--问题标题-->
                <div class="form-group">
                    <div class="col-md-10 col-xs-10">
                        <label for="title">问题标题（简单扼要）:</label>
                        <input type="text" class="form-control" id="title" placeholder="问题标题"
                               name="title"  <#if title??> value="${title}"</#if>>
                    </div>

                    <div class="col-md-2 col-xs-2 dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            选择分类
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <li><a href="#">默认分类</a></li>
                            <li><a href="#">活动</a></li>
                            <li><a href="#">开源项目</a></li>
                            <li><a href="#">灌水区</a></li>
                            <li role="separator" class="divider"></li>
                        </ul>
                    </div>
                </div>

            <#--问题补充描述-->
                <div class="form-group ">
                    <div class="col-md-10 col-xs-10 mar-top">
                        <label for="title">问题补充 (必填，请参照右侧提示):</label>
                        <textarea class="form-control" rows="6" id="des" name="description"
                                  placeholder="问题描述">
                            <#if description??>
                                ${description}
                            </#if>
                        </textarea>
                    </div>
                </div>

            <#--上传附件-->
            <#--<div class="form-group">-->
            <#--<input type="file" id="exampleInputFile">-->
            <#--</div>-->

            <#--添加标签-->
                <div class="form-group">
                    <div class="col-md-6 mar-top">
                        <label for="add">添加标签：</label>
                        <input type="text" class="form-control"<#if tag??>
                           value="${tag}"
                        </#if>
                               id="add" name="tag" placeholder="创建搜索条件按，分割">
                    </div>
                </div>

                <div class="container-fluid">
                   <#if errorMessage??>
                       <div class="alert alert-danger alert-dismissible col-md-10 " role="alert">
                           <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                   aria-hidden="true">&times;</span></button>
                           <strong>错误：</strong>  ${errorMessage}
                       </div>

                       <input type="submit" class="btn btn-success submit col-md-offset-1 col-md-1"></input>
                   <#else>
                       <input type="submit" class="btn btn-success col-md-offset-11 submit col-md-1"></input>
                   </#if>

                </div>
            <#--提交-->
            </form>


        </div>
    <#--问题指南-->
        <div class="col-md-3 col-xs-12 mar-top">
            <h4><strong>
                问题发起指南
            </strong></h4>
            <ul>
                <li>
                    <strong>问题标题: </strong>
                    请用精简的语言描述您发布的问题，不超过25字
                </li>
                <li>
                    <strong>问题补充: </strong>
                    详细补充您的问题内容，并确保问题描述清晰直观, 并提供一些相关的资料：
                </li>
            </ul>

        </div>
    </div>
</div>

</body>
</html>


