<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="zh-CN">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/publish.css">
    <link rel="stylesheet" href="layui/css/layui.css">

    <script src="js/jquery.min.js"></script>
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

<div class="container-fluid content">
    <div class="row">
        <#--发起-->
        <div class="col-md-9 col-xs-12 left-content">
            <h4>
                <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                发起
            </h4>
            <hr>
            <span>
                ${questions.getCurrent()}.....总数:${questions.getTotal()}
            </span>
            <#list questions.getRecords() as question >
                <#if question??>
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object item_image"
                                     src="${question.user.avatarUrl}">
                            </a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading item_title">${question.title}</h4>
                            <span class="item_desc">发起了问题 • ${question.likeCount} 人关注 • ${question.commentCount} 个回复 • ${question.viewCount}次浏览 • ${question.lastTime}前</span>
                        </div>
                    </div>

                </#if>
            </#list>
            <div id="page_div"></div>

        </div>
        <#--问题指南-->
        <div class="col-md-3 col-xs-12 mar-top">
            <h4>
                <strong>
                    热门话题
                </strong>
            </h4>

        </div>
    </div>
</div>

<script src="layui/layui.js"></script>
<script>
    $(function () {
        var url = "/getquestions";
        var currentPage = 2;
        var size = 10;
        var data = {
            "page":currentPage,
            "size": size
        };
        $.get(url, data, function (data, status) {
            console.error("41111");
            console.error(data)
        });
    });

    //
    //
    // layui.use('laypage', function () {
    //     var laypage = layui.laypage;
    //     laypage.render({
    //         elem: 'page_div',
    //         count: 20,
    //         limit: 10,
    //         limits: [10, 20, 30, 40, 50],
    //         groups: 5,
    //         first: "首页",
    //         last: "尾页",
    //         layout: ['first', 'prev', 'last', 'page', 'next', 'limit', 'count'],
    //         jump: function (obj, first) {
    //             //obj包含了当前分页的所有参数，比如：
    //             console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
    //             console.log(obj.limit); //得到每页显示的条数
    //
    //             //首次不执行
    //             if (!first) {
    //                 //do something
    //             }
    //         }
    //     });
    // });
</script>
</body>
</html>


