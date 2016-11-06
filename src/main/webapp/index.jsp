
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!--[if IE 9 ]><html class="ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en"><!--<![endif]-->
<head>
    <title>Slibrary - Index</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!--meta info-->
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="icon" type="image/ico" href="images/fav.ico">
    <!--stylesheet include-->
    <link rel="stylesheet" type="text/css" media="all" href="css/flexslider.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/camera.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/owl.transitions.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/jquery.custom-scrollbar.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/jackbox.min.css">
    <!--font include-->
    <link href="css/font-awesome.min.css" rel="stylesheet">

    <style type="text/css">
        .nav{
            background:url(images/nav_bg.jpg) no-repeat center;
            width:100%;
            height:240px;
        }
        .container{
            width:1150px;
            margin:0 auto;

        }
        .kuang{
            margin:10px auto;
            height:38px;
            width:66%;
            display:block;
            float:left;
            padding:5px;
            background:none;
            border:1px solid #dfdfdf;
        }
        .butn{
            width:106px;
            height:38px;
            background:no-repeat 75px 10px #af2125;
            border:#af2125  1px solid;
            color:#fff;
            padding-right:15px;
            margin-left:30px;
            text-align:center;
        }
        .w136{
            width:136px;
        }
        .seach{
            margin:50px 80px 0 auto;
            width:1020px;
            height:135px;
            background-color:#fff;
            padding:0 40px 12px 40px;
            box-shadow: #c1c1c1 2px 2px 5px;
            border-radius: 5px;
            z-index:1;
        }
        .aside1-tabs{
            margin:50px 64px 0 auto;
        }
        .downlist-tabs{ margin: 10px auto; 		}
        .butn-tabs{
            margin:10px;
        }
        .tabs1-nav li a:hover{
            color:#af2125;
        }


        .tabs1-nav {
            margin: 0;
            padding:0;
            padding-left:10px;
            width: 100%;
            list-style: none outside none;
        }

        .tabs1-nav li {
            position: relative;
            float: left;
            margin: 0;
            padding: 0;
            height: 40px;
            line-height: 40px;
            cursor: pointer;
            text-align:center;

        }

        .tabs1-nav li a {
            display: block;
            padding: 0 20px;
            font-size: 16px;
            color:#af2125;
            border-top:0;
            background-color:none;
        }
        .tabs1-nav li a:hover{
            color:#fff;
            background-color:#af2125;
        }
        .tabs1-nav li.active a {
            color:#fff;
            background-color:#af2125;
        }
        .tab-content h3 {margin-bottom: 1.2em;}

        .tab-content p {margin-bottom: 1.5em;}
        .tab-content ul{
            margin:0;
            padding:0;

        }

        .tab-content ul li a{
            color:#333;
        }
        .tab-content ul li a:hover{
            color:#af2125;
        }
        .input_select{
            display: block;
            width:115px;
            height:38px;
            padding:8px;
            padding-right:30px;
            text-align:center;
            border:1px solid #dfdfdf;
            border-left:none;
            background:no-repeat 90px 13px;
            color:#af2125;
            cursor:pointer;
        }
        .box-set:before,
        .box-set:after {
            content: "";
            display: table;
        }
        .box-set:after {
            clear: both;
        }
        .box-set {
            *zoom: 1;
        }
        <!--bootstrap-->
            [hidden],
            template {
                display: none;
            }
        .hidden {
            display: none !important;
            visibility: hidden !important;
        }
        button,
        input,
        optgroup,
        select,
        textarea {
            margin: 0;
            font: inherit;
            color: inherit;
        }
        button {
            overflow: visible;
        }
        button,
        select {
            text-transform: none;
        }
        button,
        html input[type="button"],
        input[type="reset"],
        input[type="submit"] {
            -webkit-appearance: button;
            cursor: pointer;
        }
        button[disabled],
        html input[disabled] {
            cursor: default;
        }
        button::-moz-focus-inner,
        input::-moz-focus-inner {
            padding: 0;
            border: 0;
        }
        input {
            line-height: normal;
        }
        input[type="checkbox"],
        input[type="radio"] {
            box-sizing: border-box;
            padding: 0;
        }
        input[type="number"]::-webkit-inner-spin-button,
        input[type="number"]::-webkit-outer-spin-button {
            height: auto;
        }
        input[type="search"] {
            -webkit-box-sizing: content-box;
            -moz-box-sizing: content-box;
            box-sizing: content-box;
            -webkit-appearance: textfield;
        }
        input[type="search"]::-webkit-search-cancel-button,
        input[type="search"]::-webkit-search-decoration {
            -webkit-appearance: none;
        }
        input[type="search"] {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
        input[type="search"] {
            -webkit-appearance: none;
        }
        input[type="submit"].btn-block,
        input[type="reset"].btn-block,
        input[type="button"].btn-block {
            width: 100%;
        }
    </style>

</head>
<%
    if(session.getAttribute("id") != null)
    {

%>
<script language="javascript">
    function init()
    {
        document.getElementById("LoginButton").style.display = "none";
        document.getElementById("ReButton").style.display = "none";
        document.getElementById("InfoButton").style.display = "inline";
        document.getElementById("CheckOutButton").style.display = "inline";
    }
</script>
<%
}
else if(session.getAttribute("error") != null)
{
%>
<script language="javascript">
    function init()
    {
        alert("username or password wrong");
        document.getElementById("LoginButton").style.display = "inline";
        document.getElementById("ReButton").style.display = "inline";
        document.getElementById("InfoButton").style.display = "none";
        document.getElementById("CheckOutButton").style.display = "none";
    }
</script>
<%
    }
    else
    {
%>
<script language="javascript">
    function init()
    {
        document.getElementById("InfoButton").style.display = "none";
        document.getElementById("CheckOutButton").style.display = "none";

    }
</script>
<%
    }
%>
<body onload="init()">


<!--boxed layout-->
<div class="wide_layout relative w_xs_auto">
    <!--[if (lt IE 9) | IE 9]>
    <div style="background:#fff;padding:8px 0 10px;">
        <div class="container" style="width:1170px;"><div class="row wrapper"><div class="clearfix" style="padding:9px 0 0;float:left;width:83%;"><i class="fa fa-exclamation-triangle scheme_color f_left m_right_10" style="font-size:25px;color:#e74c3c;"></i><b style="color:#e74c3c;">Attention! This page may not display correctly.</b> <b>You are using an outdated version of Internet Explorer. For a faster, safer browsing experience.</b></div><div class="t_align_r" style="float:left;width:16%;"><a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode" class="button_type_4 r_corners bg_scheme_color color_light d_inline_b t_align_c" target="_blank" style="margin-bottom:2px;">Update Now!</a></div></div></div></div>
    <![endif]-->
    <!--markup header type 2-->
    <header role="banner">
        <!--header bottom part-->
        <section class="h_bot_part container">
            <div class="clearfix row">
                <div class="col-lg-8 col-md-6 col-sm-4 t_xs_align_c">
                    <a href="index.jsp" class="logo m_xs_bottom_15 d_xs_inline_b">
                        <img src="images/logo.png" alt="">
                    </a>
                </div>

                <div class="col-lg-4 col-md-6 col-sm-8 t_xs_align_c t_align_r m_xs_bottom_0">
                    <div class="row clearfix">
                        <ul class="d_inline_b horizontal_list clearfix f_size_medium users_nav">
                            <li id="LoginButton"><a href="#" data-popup="#login_popup">Log In</a></li>
                            <li id="ReButton"><a href="user_register.jsp" class="default_t_color">Register</a></li>
                            <li id="InfoButton"><a href="user_info.jsp" class="default_t_color">My Account</a></li>
                            <li id="CheckOutButton"><a href="/User/logout" class="default_t_color">Checkout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
    </header>
    <!--search-->
    <section class="container">
        <div class="row clearfix">
            <!--tab-nav-->
            <div class="col-lg-12 col-md-9 col-sm-9 m_xs_bottom_30">
                <div class="nav">
                    <div class="container">
                        <div style="position: absolute; left: 66px;" class=" tabs aside1-tabs seach">
                            <nav>
                                <ul class="tabs_nav horizontal_list clearfix">
                                    <li class="w136 f_xs_none"><a href="#tab1" class="tr_delay_hover d_block f_size_small t_align_c">Book</a></li>
                                    <li class="w136 f_xs_none"><a href="#tab2" class="tr_delay_hover d_block f_size_small t_align_c">E-Resource</a></li>
                                </ul>
                            </nav>

                            <div class="tabs-container">
                                <!--Search book start-->
                                <div class="tab-content" id="tab1">
                                    <form class="form-horizontal" action="/Search/execute" method="post" >
                                        <input type="search" class="kuang" id="search1" name="keyword">
                                        <div style="float:left" class="custom_select relative color_dark portfolio_filter d_inline_b t_align_l downlist-tabs">
                                            <div class="select_title type_2 r_corners relative mw_0">Book Name</div>
                                            <ul  class="select_list d_none">
                                                <select  class="form-control" style="width: auto;position:relative; z-index:99999" name="type" >
                                                    <option value="Book Name">Book Name</option>
                                                    <option value="Author">Author</option>
                                                    <option value="ISBN">ISBN</option>
                                                </select>
                                            </ul>
                                        </div>
                                        <input style="float:left" type="submit" value="Search" class="butn butn-tabs r_corners">
                                    </form>
                                </div><!--/ tab-content end-->
                                <!-- end-->

                                <!--Search E-Res start-->
                                <div class="tab-content" id="tab2">
                                    <form action="/EBook/search"  method="post">
                                        <input type="search" name="keyword" id="search2" class="kuang" >
                                        <div style="float:left" class="custom_select relative color_dark portfolio_filter d_inline_b t_align_l  downlist-tabs">
                                        <div class="select_title type_2 r_corners relative mw_0">E-Res Name</div>
                                        <ul id="filter_portfolio" class="select_list d_none"></ul>
                                        <select class="form-control" style="width: auto;position:relative; z-index:99999" name="type">
                                            <option value="E-Res Name">E-Res Name</option>
                                            <option value="Author">Author</option>
                                        </select>
                                    </div>
                                        <input style="float:left" type="submit" value="Search" class="butn butn-tabs r_corners">
                                    </form>
                                </div>
                            </div><!--/ .tabs-container -->
                        </div><!--/ tab search end-->
                    </div><!--container end-->
                </div><!--nav END-->
            </div>
        </div><!--row clearfix END-->
    </section>
    <!--content-->
    <div class="page_content_offset">
        <div class="container">
            <!--banners-->
            <section class="row clearfix">
                <div class="col-lg-6 col-md-6 col-sm-6 m_bottom_50 m_sm_bottom_35">
                    <figure class="widget animate_ftr shadow r_corners wrapper m_bottom_30">
                       	<figcaption>
                            <h3 class="color_light">News</h3>
                        </figcaption>
                        <div style="min-height:400px" class="widget_content">
                            <div class="clearfix m_bottom_15">
                                <a href="#" class="color_dark d_block bt_link">Title 1.</a>
                                <p>Summary 1.</p>
                            </div>
                            <hr class="m_bottom_15">
                            <div class="clearfix m_bottom_15">
                                <a href="#" class="color_dark d_block bt_link">Title 2.</a>
                                <p>Summary 2.</p>
                            </div>
                            <hr class="m_bottom_15">
                            <div class="clearfix m_bottom_5">
                                <a href="#" class="color_dark d_block bt_link">Title 3.</a>
                                <p>Summary 3.</p>
                            </div>
                            <hr class="m_bottom_15">
                            <div class="clearfix m_bottom_5">
                                <a href="#" class="color_dark d_block bt_link">Title 4.</a>
                                <p>Summary 4.</p>
                            </div>
                            <hr class="m_bottom_15">
                            <div class="clearfix m_bottom_5">

                                <a href="#" class="color_dark d_block bt_link">Title 5.</a>
                                <p>Summary 5.</p>
                            </div>
                        </div>
                    	
                    </figure>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-6 m_bottom_50 m_sm_bottom_35">
                    <!--Bestsellers-->
                    <figure  class="widget animate_ftr shadow r_corners wrapper m_bottom_30">
                        <figcaption>
                            <h3 class="color_light">New Resource</h3>
                        </figcaption>
                        <div style="min-height:400px" class="widget_content">
                            <div class="clearfix m_bottom_0">
                                <table>
                                    <tr>
                                        <td width="600" height="50" align="left" valign="middle">
                                            <a href="book_detail.html" class="color_dark d_block bt_link"><span class="scheme_color t_align_r m_right_10">New Book :</span>Book Name</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="600" height="50" align="left" valign="middle">
                                            <a href="book_detail.html" class="color_dark d_block bt_link"><span class="scheme_color t_align_r m_right_10">New Book :</span>Book Name</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="600" height="50" align="left" valign="middle">
                                            <a href="book_detail.html" class="color_dark d_block bt_link"><span class="scheme_color t_align_r m_right_10">New Book :</span>Book Name</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="600" height="50" align="left" valign="middle">
                                            <a href="book_detail.html" class="color_dark d_block bt_link"><span class="scheme_color t_align_r m_right_10">New E-Res:</span>Resource Name</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="600" height="50" align="left" valign="middle">
                                            <a href="book_detail.html" class="color_dark d_block bt_link"><span class="scheme_color t_align_r m_right_10">New E-Res:</span>Resource Name</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="600" height="50" align="left" valign="middle">
                                            <a href="book_detail.html" class="color_dark d_block bt_link"><span class="scheme_color t_align_r m_right_10">New E-Res:</span>Resource Name</a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </figure>
                </div>
            </section>
        </div>
    </div>
    <!--markup footer-->
    <footer id="footer" class="type_2">
        <div style="height:30px" class="footer_top_part">
            <div class="row clearfix">
                <div class="col-lg-3 col-md-2 col-sm-2 m_xs_bottom_0"> </div>
                <div class="col-lg-6 col-md-2 col-sm-2 m_xs_bottom_0">
                    <table>
                        <tr height="50" valign="middle">
                            <td align="left">
                                <h3 class="scheme_color m_bottom_20">Links</h3>
                            </td>
                            <td width="80">
                            </td>
                            <td width="200">
                                <a class="color_light tr_delay_hover" href="#">Xidian University</a>
                            </td>
                            <td width="200">
                                <a class="color_light tr_delay_hover" href="#">Oxford University</a>
                            </td>
                            <td width="200">
                                <a class="color_light tr_delay_hover" href="#">KingBridge University</a>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="col-lg-3 col-md-2 col-sm-2 m_xs_bottom_0"> </div>
            </div>
        </div>
        <!--copyright part-->
        <div class="footer_bottom_part">
            <div class="col-lg-5 col-md-2 col-sm-2 m_xs_bottom_30"></div>
            <div class="col-lg-5 col-md-2 col-sm-2 m_xs_bottom_30">
                <div class="container clearfix t_mxs_align_c">
                    <p class="f_left f_mxs_none m_mxs_bottom_10">&copy; 2016 <span class=" scheme_color">&nbsp;Slibrary</span>. All Rights Reserved.</p><br>
                </div>
            </div>
        </div>

    </footer>
</div>



<!--login popup-->
<div class="popup_wrap d_none" id="login_popup">
    <section class="popup r_corners shadow">
        <button class="bg_tr color_dark tr_all_hover text_cs_hover close f_size_large"><i class="fa fa-times"></i></button>
        <h3 class="m_bottom_20 color_dark">Log In</h3>
        <form action="/User/login.action" method="post">
            <ul>
                <li class="m_bottom_15">
                    <label for="username" class="m_bottom_5 d_inline_b">Username</label><br>
                    <input type="text" name="Username" id="username" class="r_corners full_width">
                </li>
                <li class="m_bottom_25">
                    <label for="password" class="m_bottom_5 d_inline_b">Password</label><br>
                    <input type="password" name="PWD" id="password" class="r_corners full_width">
                </li>
                <li class="m_bottom_15">
                    <input type="checkbox" class="d_none" id="checkbox_10"><label for="checkbox_10">Remember me</label>
                </li>
                <li class="clearfix m_bottom_30">
                    <button class="button_type_4 tr_all_hover r_corners f_left bg_scheme_color color_light f_mxs_none m_mxs_bottom_15">Log In</button>
                    <div class="f_right f_size_medium f_mxs_none">
                        <a href="#" class="color_dark">Forgot your password?</a><br>
                    </div>
                </li>
            </ul>
        </form>
    </section>
</div>
<%--<button class="t_align_c r_corners type_2 tr_all_hover animate_ftl" id="go_to_top"><i class="fa fa-angle-up"></i></button>--%>
<!--scripts include-->
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/retina.js"></script>
<script src="js/jquery.flexslider-min.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.tweet.min.js"></script>
<script src="js/jquery.custom-scrollbar.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jackbox-packed.min.js"></script>



</body>
</html>