<%@ page import="com.xcz.search.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16-10-9
  Time: 上午3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<!--[if IE 9 ]><html class="ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en"><!--<![endif]-->
<head>
    <title>E-Res Search Result</title>
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
<%
    if(session.getAttribute("id") != null)
    {

%>
<script language="javascript">
    function init()
    {
        document.getElementById("LoginButton").style.display = "none";
        document.getElementById("InfoButton").style.display = "inline";
        document.getElementById("InfoButton").style.display = "inline";
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
            </div>
        </section>
    </header>

    <!--content-->
    <div class="">
        <div class="container">
            <div class="row clearfix">
                <!--left content column-->
                <section >
                    <h2 class="tt_uppercase color_dark m_bottom_25">Search Result</h2>
                    <hr class="m_bottom_10 divider_type_3">
                    <!--products list type-->
                    <div class="container page_content_offset">
                        <section class="row products_container clearfix m_bottom_5 m_left_0 m_right_0">
                            <!--product item-->
                            <s:iterator value="#attr.ebook_result" id="ebook" status="status">
                                <div style="width:580px;" class="col-lg-6 product_item full_width list_type hit m_left_0 m_right_0">
                                    <figure class="r_corners photoframe tr_all_hover type_2 shadow relative clearfix">
                                        <!--product preview-->
                                        <a href="read_online.html?pdf=${ebook.pdf}" class="d_block f_left relative pp_wrap m_right_30 m_xs_right_25">
                                            <!--hot product-->
                                            <!--<span class="hot_stripe"><img src="images/hot_product.png" alt=""></span>-->
                                            <img src="${ebook.cover}" class="tr_all_hover" alt="">
                                            <span role="button" data-popup="#quick_view_product" class="button_type_5 box_s_none color_light r_corners tr_all_hover d_xs_none">Read Online</span>
                                        </a>
                                        <!--description and price of product-->
                                        <figcaption>
                                            <div class="clearfix">
                                                <div class="f_left p_list_description f_sm_none w_sm_full m_xs_bottom_10">
                                                    <h4 class="fw_medium"><a href="read_online.html?pdf=${ebook.pdf}" class="color_dark">${ebook.ebook_name}</a></h4>
                                                    <br>
                                                    <hr class="m_bottom_10">
                                                    <p class="d_sm_none d_xs_block">
                                                    <ul>
                                                        <li>
                                                            Author: ${ebook.author}
                                                        </li>
                                                        <li>
                                                            Press: ${ebook.press}
                                                        </li>
                                                        <li>
                                                            Year: ${ebook.pub_year}
                                                        </li>
                                                        <li>
                                                            ISBN: ${ebook.ISBN}
                                                        </li>
                                                    </ul>
                                                    </p>
                                                </div>

                                            </div>
                                        </figcaption>
                                    </figure>
                                </div>
                            </s:iterator>

                        </section>
                    </div>

                    <div class="row clearfix m_xs_bottom_30">
                        <div class="col-lg-7 col-md-7 col-sm-7 col-xs-5">
                            <p class="d_inline_middle f_size_medium"></p>
                        </div>
                        <div id="pagination" class="col-lg-5 col-md-5 col-sm-4 t_align_r t_xs_align_l">
                            <!--pagination-->
                            <a role="button" id = "pre_page" class="button_type_10 color_dark d_inline_middle bg_cs_hover bg_light_color_1 t_align_c tr_delay_hover r_corners box_s_none"><i class="fa fa-angle-left"></i></a>
                            <ul class="horizontal_list clearfix d_inline_middle f_size_medium m_left_10">
                                <li class="m_right_10"><a class="scheme_color" href="#" id="cur_page">${EPindex}</a></li>
                                <li class="m_right_10 color_dark">/</li>
                                <li class="m_right_10 color_dark" id="page_cnt">${EPageCount}</li>
                            </ul>
                            <a role="button" id="tail_page" class="button_type_10 color_dark d_inline_middle bg_cs_hover bg_light_color_1 t_align_c tr_delay_hover r_corners box_s_none"><i class="fa fa-angle-right"></i></a>
                            <a role="button" id="jump_page" class="f_right button_type_10 color_dark d_inline_middle bg_cs_hover bg_light_color_1 t_align_c tr_delay_hover r_corners box_s_none"><span style="margin:4px">go</span></a>
                            <input id="page" style="width:50px;margin:0 6px 0 15px;height:23px" type="text" class="r_corners f_right type_2" >
                        </div>
                    </div>
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
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/retina.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.tweet.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.custom-scrollbar.js"></script>
<script src="js/scripts.js"></script>
<script src="js/ebook_search_result.js"></script>
</body>
</html>