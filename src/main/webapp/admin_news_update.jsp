<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16-11-6
  Time: 上午12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if IE 9 ]><html class="ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en"><!--<![endif]-->
<head>
    <title>Edit News</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!--meta info-->
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="icon" type="image/ico" href="images/fav.ico">
    <!--stylesheet include-->
    <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/style.css">
    <!--font include-->
    <link href="css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<!--wide layout-->
<div class="wide_layout relative">

    <!--markup header-->
    <header role="banner">
        <!--header bottom part-->
        <section class="h_bot_part container">
            <div class="clearfix row">
                <div class="col-lg-8 col-md-6 col-sm-4 t_xs_align_c">
                    <a href="#" class="logo m_xs_bottom_15 d_xs_inline_b">
                        <img src="images/logo.png" alt="">
                    </a>
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
                        <li class="relative f_xs_none m_xs_bottom_5"><a id="nav1" href="#" class="tr_delay_hover color_light tt_uppercase"><b>Borrow And Return</b></a></li>
                        <li class="relative f_xs_none m_xs_bottom_5"><a id="nav2" href="#" class="tr_delay_hover color_light tt_uppercase"><b>Book Management</b></a></li>
                        <li class="relative f_xs_none m_xs_bottom_5"><a id="nav3" href="#" class="tr_delay_hover color_light tt_uppercase"><b>E-Resource</b></a></li>
                        <li class="relative current f_xs_none m_xs_bottom_5"><a id="nav4" href="#" class="tr_delay_hover color_light tt_uppercase"><b>News Management</b></a></li>
                        <li class="relative f_xs_none m_xs_bottom_5"><a id="nav5" href="#" class="tr_delay_hover color_light tt_uppercase"><b>Recommendation</b></a></li>
                    </ul>
                </nav>
            </div>
        </section>
    </header>
    <!--breadcrumbs-->
    <section class="breadcrumbs">
        <div class="container">
            <ul class="horizontal_list clearfix bc_list f_size_medium">
                <li class="m_right_10"><a href="user_info.jsp" class="default_t_color">Home<i class="fa fa-angle-right d_inline_middle m_left_10"></i></a></li>
                <li><a href="admin_newsManage.jsp" class="current default_t_color">News Management</a></li>
            </ul>
        </div>
    </section>
    <!--content-->
    <div class="page_content_offset">
        <div class="container">
            <div class="row clearfix">
                <!--left column-->
                <aside class="col-lg-3 col-md-3 col-sm-3">
                    <!--widgets-->
                    <figure class="widget shadow r_corners wrapper m_bottom_30">
                        <figcaption>
                            <h3 class="color_light">Menu</h3>
                        </figcaption>
                        <div class="widget_content">
                            <!--Categories list-->
                            <ul class="categories_list">
                                <li>
                                    <a href="admin_newsManage.jsp" class="f_size_large scheme_color d_block relative">
                                        <b>Update News</b>
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="admin_news_add.html" class="f_size_large color_dark d_block relative">
                                        <b>Add News</b>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </figure>
                </aside>
                <!--right content column-->

                <section class="col-lg-9 col-md-9 col-sm-9">
                    <div class="clearfix m_bottom_30">
                        <div style="padding:40px 20px"class="row clearfix r_corners photoframe shadow m_bottom_45">
                            <!--add news-->
                            <h2 class="tt_uppercase color_dark m_bottom_30">Update News</h2>
                            <hr>
                            <form class="bs_inner_offsets full_width bg_light_color_3 r_corners m_xs_bottom_30" id="news_update">
                                <ul>
                                    <li class="m_bottom_15">
                                        <label for="name" class="required  d_inline_b m_bottom_5">Title</label><br>
                                        <input type="text" id="name" name="title" class="r_corners full_width" value="${news_item.title}">
                                    </li>
                                    <li class="m_bottom_15">
                                        <label for="shortcut" class="required  d_inline_b m_bottom_5">Summary</label><br>
                                        <input type="text" id="shortcut" name="summary" class="r_corners full_width" value="${news_item.summary}">
                                    </li>
                                    <li class="m_bottom_15">
                                        <label for="comments" class="required  d_inline_b m_bottom_5">Content</label><br>
                                        <textarea id="comments" name="content" class="r_corners full_width"> ${news_item.content}</textarea>
                                    </li>
                                    <li class="m_bottom_10" align="center" valign="middle">
                                        <button class="r_corners button_type_4 bg_scheme_color f_mxs_none m_mxs_bottom_15 color_light tr_all_hover">Submit</button>

                                    </li>
                                </ul>
                            </form>
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

<button class="t_align_c r_corners tr_all_hover type_2 animate_ftl" id="go_to_top"><i class="fa fa-angle-up"></i></button>

<!--scripts include-->
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/navigation.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/retina.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.tweet.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.custom-scrollbar.js"></script>
<script src="js/scripts.js"></script>
<script src="js/news_update.js"></script>
</body>
</html>
