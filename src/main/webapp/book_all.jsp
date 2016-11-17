<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16-11-14
  Time: 上午12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if IE 9 ]><html class="ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en"><!--<![endif]-->
<head>
    <title>All Volume</title>
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
        td {
            line-height: 32px;
        }
        td:first-child {
            line-height: 20px;
        }
    </style>
</head>

<body >
<!--wide layout-->
<div class="wide_layout relative">
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
                            <li id="LoginButton"><a href="#" data-popup="#login_popup">Log In</a></li>
                            <li id="ReButton"><a href="user_register.html" class="default_t_color">Register</a></li>
                            <li id="InfoButton"><a href="user_info.jsp" class="default_t_color">My Account</a></li>
                            <li id="CheckOutButton"><a href="/User/logout" class="default_t_color">Checkout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
    </header>
    <!--breadcrumbs-->
    <section class="breadcrumbs">
        <div class="container">
            <ul class="horizontal_list clearfix bc_list f_size_medium">
                <li class="m_right_10"><a href="index.jsp" class="default_t_color">Home<i class="fa fa-angle-right d_inline_middle m_left_10"></i></a></li>
                <li class="m_right_10"><a href="#" class="current default_t_color">Book Detail<i class="fa fa-angle-right d_inline_middle m_left_10"></i></a></li>
                <li><a href="#" class="current default_t_color">All Volume</a></li>
            </ul>
        </div>
    </section>
    <!--content-->
    <div class="page_content_offset">
        <div class="container">
            <div class="row clearfix">
                <!--right column-->
                <aside class="col-lg-1 col-md-3 col-sm-3">

                </aside>
                <!--left content column-->

                <section class="col-lg-10 col-md-9 col-sm-9">

                    <div class="clearfix m_bottom_30">
                        <figure>
                            <div class="row clearfix r_corners photoframe  shadow m_bottom_45">
                                <h2 style="margin:40px 40px" class="tt_uppercase color_dark m_bottom_30">${all_isbn[0].book_name}</h2><input id = 'ISBN'type="hidden" value="${all_isbn[0].ISBN}">
                                <hr style="margin:0px 40px" >
                                <figcaption style="margin:0px 40px 40px 30px"  class="f_size_large">
                                    <table style="text-align:center" class="table_type_2 responsive_table full_width r_corners wraper shadow bg_light_color_1 m_bottom_30">
                                        <thead>
                                        <tr class="f_size_large">
                                            <!--titles for td-->
                                            <th>Action</th>
                                            <th>Book ID</th>
                                            <th>Status</th>
                                            <th>Call No.</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <s:iterator value="#attr.all_isbn" id ="item" status="index">
                                            <tr>
                                                <s:if test="#item.state == 'Borrowed'">
                                                    <!--Reserve-->
                                                    <td>
                                                        <button class="button_type_15 bg_scheme_color r_corners tr_all_hover color_light mw_0">Reserve</button><br>
                                                    </td>
                                                </s:if>
                                                <s:else>
                                                    <td> </td>
                                                </s:else>
                                                <!--Book ID-->
                                                <td>${item.id}</td>
                                                <!--Book Status-->
                                                <td>${item.state}</td>
                                                <!--Book Call_no-->
                                                <td>${item.call_no}</td>
                                            </tr>
                                        </s:iterator>
                                        </tbody>
                                    </table>
                                </figcaption>
                            </div>

                        </figure>
                    </div>
                </section>
                <aside class="col-lg-1 col-md-3 col-sm-3">

                </aside>
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
        <form id="loginform" method="post">
            <ul>
                <li class="m_bottom_15">
                    <label for="username" class="m_bottom_5 d_inline_b">Username</label><br>
                    <input type="text" name="Username" id="username" class="r_corners full_width">
                </li>
                <li class="m_bottom_25">
                    <label for="password" class="m_bottom_5 d_inline_b">Password</label><br>
                    <input type="password" name="PWD" id="password" class="r_corners full_width">
                </li>
                <li class="clearfix m_bottom_30">
                    <button class="button_type_4 tr_all_hover r_corners f_left bg_scheme_color color_light f_mxs_none m_mxs_bottom_15">Log In</button>
                </li>
            </ul>
        </form>
    </section>
</div>

<button class="t_align_c r_corners tr_all_hover type_2 animate_ftl" id="go_to_top"><i class="fa fa-angle-up"></i></button>
<!--scripts include-->
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/retina.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.tweet.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.custom-scrollbar.js"></script>
<script src="js/scripts.js"></script>
<script src="js/book_all.js"></script>
</body>
</html>
