<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>头条资讯 - 牛客网</title>
    <link href="/styles/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/styles/bootstrap-table/dist/bootstrap-table.min.css"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/styles/font-awesome.min.css">
    <link rel="stylesheet" media="all" href="/styles/style.css">

    <!--<script src="/styles/query/jquery.min.js"></script>-->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script src="/styles/bootstrap/js/bootstrap.min.js"></script>
    <script src="/styles/bootstrap-table/dist/bootstrap-table.min.js"></script>
    <script src="/styles/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js"></script>

    <script type="text/javascript" src="/scripts/main/base/base.js"></script>
    <script type="text/javascript" src="/scripts/main/base/util.js"></script>
    <script type="text/javascript" src="/scripts/main/base/event.js"></script>
    <script type="text/javascript" src="/scripts/main/base/sort.js"></script>
    <script type="text/javascript" src="/scripts/main/base/select.js"></script>
    <script type="text/javascript" src="/scripts/main/base/upload.js"></script>
    <script type="text/javascript" src="/scripts/main/component/component.js"></script>
    <script type="text/javascript" src="/scripts/main/component/popup.js"></script>
    <script type="text/javascript" src="/scripts/main/component/popupLogin.js"></script>
    <script type="text/javascript" src="/scripts/main/component/upload.js"></script>
    <script type="text/javascript" src="/scripts/main/component/popupUpload.js"></script>
    <script type="text/javascript" src="/scripts/main/site/home.js"></script>

</head>
<body class="welcome_index">

<header class="navbar navbar-default navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a href="/" class="navbar-brand logo">
                <h1>在线投票系统</h1>
                <h3>为你认可的选项头上一票</h3>
            </a>
        </div>

        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">

            <ul class="nav navbar-nav navbar-right">

                #if ($user)
                <li class="js-share"><a href="javascript:void(0);">分享</a></li>
                <li class=""><a href="/msg/list">站内信</a></li>
                <li class=""><a href="/user/$!{user.id}/">$!{user.UserName}</a></li>
                #else
                <li class="js-login"><a href="javascript:void(0);">登陆</a></li>
                #end
            </ul>

        </nav>
    </div>
</header>