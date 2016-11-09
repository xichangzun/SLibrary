<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16-10-8
  Time: ????9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!doctype html>
<!--[if IE 9 ]><html class="ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en"><!--<![endif]-->
<head>
    <title>Slibrary - Circulation</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!--meta info-->
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="icon" type="image/ico" href="images/fav.ico">
    <!--stylesheet include-->
    <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/jquery.custom-scrollbar.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/style.css">
    <!--font include-->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <style type="text/css">
        #search_input{
            width : 10%;
            height: 10px;
            float:left;
        }
    </style>
</head>
<body>
<!--wide layout-->
<div class="wide_layout relative">
    <!--[if (lt IE 9) | IE 9]>
    <div style="background:#fff;padding:8px 0 10px;">
        <div class="container" style="width:1170px;"><div class="row wrapper"><div class="clearfix" style="padding:9px 0 0;float:left;width:83%;"><i class="fa fa-exclamation-triangle scheme_color f_left m_right_10" style="font-size:25px;color:#e74c3c;"></i><b style="color:#e74c3c;">Attention! This page may not display correctly.</b> <b>You are using an outdated version of Internet Explorer. For a faster, safer browsing experience.</b></div><div class="t_align_r" style="float:left;width:16%;"><a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode" class="button_type_4 r_corners bg_scheme_color color_light d_inline_b t_align_c" target="_blank" style="margin-bottom:2px;">Update Now!</a></div></div></div></div>
    <![endif]-->
    <!--markup header-->
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
                            <li><a href="user_info.jsp" class="default_t_color">My Account</a></li>
                            <li><a href="/User/logout" class="default_t_color">Checkout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <!--main menu container-->
        <section class="menu_wrap relative">
            <div class="container clearfix">
                <!--button for responsive menu-->
                <button id="menu_button" class="r_corners centered_db d_none tr_all_hover d_xs_block m_bottom_10">
                    <span class="centered_db r_corners"></span>
                    <span class="centered_db r_corners"></span>
                    <span class="centered_db r_corners"></span>
                </button>
                <!--main menu-->
                <nav role="navigation" class="f_left f_xs_none d_xs_none">
                    <ul class="horizontal_list main_menu clearfix">
                        <li class="relative f_xs_none m_xs_bottom_5"><a href="user_info.jsp" class="tr_delay_hover color_light tt_uppercase"><b>My Information</b></a></li>
                        <li class="relative current f_xs_none m_xs_bottom_5"><a href="circulation.jsp" class="tr_delay_hover color_light tt_uppercase"><b>Borrowing&Reservation</b></a></li>
                        <li class="relative f_xs_none m_xs_bottom_5"><a href="recommendation.jsp" class="tr_delay_hover color_light tt_uppercase"><b>Recommendation</b></a></li>
                        <li class="relative f_xs_none m_xs_bottom_5"><a href="changepwd.jsp" class="tr_delay_hover color_light tt_uppercase"><b>Change Password</b></a></li>
                    </ul>
                </nav>
                <button class="f_right search_button tr_all_hover f_xs_none d_xs_none">
                    <i class="fa fa-search"></i>
                </button>
            </div>
            <!--search form-->
            <div class="searchform_wrap tf_xs_none tr_all_hover">
                <div class="container vc_child h_inherit relative">
                    <form role="search" class="d_inline_middle full_width">
                        <input type="text" name="search" placeholder="Type text and hit enter" class="f_size_large">
                    </form>
                    <button class="close_search_form tr_all_hover d_xs_none color_dark">
                        <i class="fa fa-times"></i>
                    </button>
                </div>
            </div>
        </section>
    </header>




    <section class="breadcrumbs">
        <div class="container">
            <ul class="horizontal_list clearfix bc_list f_size_medium">
                <li class="m_right_10 current"><a href="index.jsp" class="default_t_color">Home<i class="fa fa-angle-right d_inline_middle m_left_10"></i></a></li>
                <li><a href="circulation.jsp" class="default_t_color">Borrowing&Reservation </a></li>
            </ul>
        </div>
    </section>





    <!--content-->
    <div class="page_content_offset">
        <div class="container">
            <div class="row clearfix">
                <!--left content column-->
                <section >
                    <h2 class="tt_uppercase color_dark m_bottom_25">My Circulation</h2>
                    <!--sort-->
                    <div class="row clearfix m_bottom_10"></div>

                    <hr class="m_bottom_10 divider_type_3">
                    <!--products list type-->
                    <section class="container list_type clearfix m_bottom_5 m_left_0 m_right_0">
                        <!--product item-->
                        <div class="product_item full_width list_type hit m_left_0 m_right_0">

                            <figure class="r_corners photoframe tr_all_hover type_2 shadow clearfix">
                                <!--product preview-->
                                <!--description and price of product-->

                                <div class="clearfix" style="text-align:center; margin:0 auto">
                                    <div style=" margin:50px auto 50px">
                                        <table class="font-awesome.min" style="margin:auto">
                                            <!--<tbody>
      </tbody><caption><a href="http://www.lib.xidian.edu.cn/circulate.jspx"></a><a href="http://al.lib.xidian.edu.cn/F/">???б┬???иж???и╣?ид?????????ии????????????</a></caption> -->
                                            <tbody>
                                            <tr>
                                                <th>Borrowing</th>
                                                <td><a href="javascript:show_waijie()" >${cur_borrow_count}</a></td>
                                            </tr>
                                            <tr>
                                                <th>Borrowed Records</th>
                                                <td><a href="javascript:show_lishi()">${borrow_count}</a></td>
                                            </tr>
                                            <tr>
                                                <th>Reservation Requests</th>
                                                <td><a href="javascript:show_yuyue()">${reserve_count}</a></td>
                                            </tr>
                                            <tr>
                                                <th>Recommendation Requests</th>
                                                <td><a href="javascript:show_recom()">${reserve_count}</a></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <figure class="r_corners photoframe tr_all_hover type_2 shadow relative clearfix">

                                        <div style="text-align:center; "class="table_sm_wrap r_corners wrapper shadow bg_light_color_1 m_bottom_30">
                                            <table id="lishijilu" style="display: none;padding:0 50px" class="table_type_8 full_width">
                                                <tbody>
                                                <tr class="f_size_large">
                                                    <th style="width:350px">Book_Name</th>
                                                    <th style="width:250px">Author</th>
                                                    <th style="width:150px">Pub Year</th>
                                                    <th style="width:150px">Return Date</th>
                                                    <th style="width:150px">Actual Date</th>
                                                </tr>
                                                <s:iterator value="#attr.borrow_books" id ="book">
                                                    <tr>
                                                        <td>${book.book_name}</td>
                                                        <td>${book.author}</td>
                                                        <td>${book.pub_year}</td>
                                                        <td>${book.return_date}</td>
                                                        <td>${book.actual_date}</td>
                                                    </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                            <!-- add yujie -->
                                            <table id="yuyue" style="display: none;padding:0 100px" class=" table_type_8 full_width">
                                                <tbody>
                                                <tr class="f_size_large">
                                                    <th style="width:350px">Book_Name</th>
                                                    <th style="width:300px">Author</th>
                                                    <th style="width:250px">Request Status</th>
                                                </tr>
                                                <s:iterator value="#attr.reserve_books" id = "book">
                                                    <tr>
                                                        <td>${book.book_name}</td>
                                                        <td>${book.author}</td>
                                                        <td>${book.status}</td>
                                                    </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                            <!--  end-->
                                            <!-- chencunxiang add -->
                                            <table id="waijie" style="display: none;padding:0 50px" class=" table_type_2 full_width">
                                                <tbody>
                                                <tr class="f_size_large">
                                                    <th style="width:350px">Book_Name</th>
                                                    <th style="width:250px">Author</th>
                                                    <th style="width:150px">Publication Year</th>
                                                    <th style="width:150px">ISBN</th>
                                                    <th style="width:150px">Call Number</th>
                                                </tr>
                                                <s:iterator value="#attr.cur_borrow_books" id = "book">
                                                    <tr >
                                                        <td>${book.book_name}</td>
                                                        <td>${book.author}</td>
                                                        <td>${book.pub_year}</td>
                                                        <td>${book.ISBN}</td>
                                                        <td>${book.call_no}</td>
                                                    </tr>
                                                </s:iterator>

                                                </tbody>
                                            </table>
                                            <!-- add end -->
                                            <table id="recom" style="display: none;padding:0 100px" class=" table_type_8 full_width">
								                <tbody>
							                      	<tr class="f_size_large">
	                                                    <th style="width:350px">Book_Name</th>
	                                                    <th style="width:300px">ISBN</th>
	                                                    <th style="width:250px">Status</th>
	                                                </tr>
                                                    <tr >
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
							                    </tbody>
						                  	</table>
                                        </div>
                                    </figure>

                                </div>

                            </figure>

                        </div>


                    </section>
                    <hr class="m_bottom_10 divider_type_3">
                    <div class="row clearfix m_bottom_15 m_xs_bottom_30"></div>
                </section>
            </div>
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
        <form>
            <ul>
                <li class="m_bottom_15">
                    <label for="username" class="m_bottom_5 d_inline_b">Username</label><br>
                    <input type="text" name="" id="username" class="r_corners full_width">
                </li>
                <li class="m_bottom_25">
                    <label for="password" class="m_bottom_5 d_inline_b">Password</label><br>
                    <input type="password" name="" id="password" class="r_corners full_width">
                </li>
                <li class="m_bottom_15">
                    <input type="checkbox" class="d_none" id="checkbox_10"><label for="checkbox_10">Remember me</label>
                </li>
                <li class="clearfix m_bottom_30">
                    <button class="button_type_4 tr_all_hover r_corners f_left bg_scheme_color color_light f_mxs_none m_mxs_bottom_15">Log In</button>
                    <div class="f_right f_size_medium f_mxs_none">
                        <a href="#" class="color_dark">Forgot your password?</a><br>
                        <a href="#" class="color_dark">Forgot your username?</a>
                    </div>
                </li>
            </ul>
        </form>
    </section>
</div>
<button class="t_align_c r_corners tr_all_hover type_2 animate_ftl" id="go_to_top"><i class="fa fa-angle-up"></i></button>
<!--scripts include-->
<script>

    function show_lishi(){
        //var myTable= document.getElementById("waijie"); myTable.style.display ="none";
        hidden();
        var myTable= document.getElementById("lishijilu"); myTable.style.display="block";
    }
    function show_waijie(){
        //var myTable= document.getElementById("lishijilu"); myTable.style.display ="none";
        hidden();
        var myTable= document.getElementById("waijie"); myTable.style.display="block";
    }
    function show_yuyue(){
        //var myTable= document.getElementById("lishijilu"); myTable.style.display ="none";
        hidden();
        var myTable= document.getElementById("yuyue"); myTable.style.display="block";
    }
    function show_recom(){
        //var myTable= document.getElementById("lishijilu"); myTable.style.display ="none";
        hidden();
        var myTable= document.getElementById("recom"); myTable.style.display="block";
    }
    function hidden(){
        var myTable= document.getElementById("lishijilu"); myTable.style.display ="none";
        var myTable1= document.getElementById("waijie"); myTable1.style.display ="none";
        var myTable1= document.getElementById("yuyue"); myTable1.style.display ="none";
        var myTable1= document.getElementById("recom"); myTable1.style.display ="none";
    }

</script>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/retina.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.tweet.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.custom-scrollbar.js"></script>
<script src="js/scripts.js"></script>

</body>
</html>