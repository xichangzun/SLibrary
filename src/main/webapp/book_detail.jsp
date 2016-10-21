<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16-10-15
  Time: 下午11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if IE 9 ]><html class="ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en"><!--<![endif]-->
<head>
    <title>Slibrary - Book Detail</title>
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
    <link rel="stylesheet" type="text/css" media="all" href="css/flexslider.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/camera.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/owl.transitions.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/jquery.custom-scrollbar.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/jackbox.min.css">
    <!--font include-->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css_files/exlchi.css" type="text/css">
    <link rel="icon" type="image/ico" href="images/fav.ico">

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
                    <a href="index.html" class="logo m_xs_bottom_15 d_xs_inline_b">
                        <img src="images/logo.png" alt="">
                    </a>
                </div>

                <div class="col-lg-4 col-md-6 col-sm-8 t_xs_align_c t_align_r m_xs_bottom_0">
                    <div class="row clearfix">
                        <ul class="d_inline_b horizontal_list clearfix f_size_medium users_nav">
                            <li><a href="#" data-popup="#login_popup">Log In</a></li>

                            <li><a href="user_info.html" class="default_t_color">My Account</a></li>
                            <li><a href="index.html" class="default_t_color">Checkout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <!--main menu container-->
    </header>
    <!--breadcrumbs-->
    <section class="breadcrumbs">
        <div class="container">
            <form name="cclform" method="get" action="http://al.lib.xidian.edu.cn/F/8FU9AMCBQLGV767VPYMJCJ9Q5N4N944P6ALHBV6PS53CTJVGJ8-33719" onsubmit="return presearch(this);">
                <input type="hidden" id="search_description" value="&lt;A HREF=http://al.lib.xidian.edu.cn:80/F/8FU9AMCBQLGV767VPYMJCJ9Q5N4N944P6ALHBV6PS53CTJVGJ8-33720?func=full-set-set&amp;set_number=002730&amp;set_entry=000003&amp;format=999&gt;&lt;img src=http://al.lib.xidian.edu.cn:80/exlibris/aleph/u20_1/alephe/www_f_chi/icon/f-next-record.gif border=0 alt=&#39;Next Record&#39;&gt;&lt;/A&gt;">
                <input name="func" id="func" value="find-b" type="hidden">
                <!-- filename: find-code-include -->
                <div style="margin-top:1px" class="custom_select f_size_medium relative f_left">
                    <div class="select_title r_corners relative color_dark">All</div>
                    <ul class="select_list d_none"></ul>
                    <select name="find_code" id="find_code">
                        <option value="TIT">BookName</option>
                        <option value="WAU">Author</option>
                        <option value="ISB">ISBN</option>
                    </select>
                </div>
                <input autocomplete="off" class=" r_corners" style="width:30%; height:29px;" name="request" value="" id="cclterm" oninput="clearTimeout(tm);if(event.keyCode!=13)tm=setTimeout(getsug,500)" onkeydown="if(&#39;\v&#39;==&#39;v&#39;){clearTimeout(tm);if(event.keyCode!=13&amp;&amp;event.keyCode!=38&amp;&amp;event.keyCode!=40)tm=setTimeout(getsug,500)}" onkeyup="if(event.keyCode==38){shiftsug(sugno-1)}else if(event.keyCode==40){shiftsug(sugno+1)}else if(event.keyCode==13)this.blur()"> &nbsp;
                <input style="height:30px" class="button_type_9 r_corners t_align_c" id="lookup" value="  Search  " type="submit">
                <script>
                    //document.write('<a id=rsslink href="/rss/newbookrss.php?base=XDU01&lib=XDU01&name='+document.getElementById("search_description").value+'&request=" target="_blank"><img border="0" width="24" src="/rss/style/pics/ico_rss.gif"></a>');
                </script>
                <!--
                <input type="text" size="8" alt="clrDlg" style="border:none;background:transparent;" readonly>
                -->
                <div id="colorpanel" style="position:absolute;display:none;width:253px;height:177px;"></div>
                <div id="details" style="display:none;font-size:14px;width:400px;position:absolute;z-index:10000;background:#fff;border:1px solid #aaa" onclick="this.style.display=&quot;none&quot;;if(g(&quot;format&quot;))g(&quot;format&quot;).style.display=&quot;&quot;"></div>
            </form>
        </div>
    </section>
    <!--content-->
    <div class="page_content_offset">
        <div class="container">
            <div class="row clearfix">
                <!--left content column-->
                <section class="col-lg-9 col-md-9 col-sm-9">
                    <!--blog post-->
                    <article class="m_bottom_15">
                        <div class="row clearfix m_bottom_15">
                            <div class="col-lg-9 col-md-9 col-sm-8">
                                <h2 class="tt_uppercase color_dark m_bottom_25">BOOK DETAILS</h2>
                            </div>
                        </div>
                    </article>
                    <hr class="divider_type_3 m_bottom_10">
                    <table width="700" border="20" bordercolor="black" cellspacing="20">
                        <tr height="30">
                            <td>Call No.</td>
                            <td>001</td>
                        </tr>
                        <tr height="30">
                            <td>ISBN</td>
                            <td>978-7-201-09973-6 : CNY32.80</td>
                        </tr>
                        <tr height="30">
                            <td>Language</td>
                            <td>chi</td>
                        </tr>
                        <tr height="30">
                            <td>Book Name</td>
                            <td>疯狂java</td>
                        </tr>
                        <tr height="30">
                            <td>Publication</td>
                            <td>天津 : 天津人民出版社, 2016</td>
                        </tr>
                        <tr height="30">
                            <td>Descr.</td>
                            <td>241页 ; 24cm</td>
                        </tr>
                        <tr height="30">
                            <td>Author</td>
                            <td>郭现杰</td>
                        </tr>
                        <tr height="30">
                            <td>Total Amount</td>
                            <td></td>
                        </tr>
                        <tr height="30">
                            <td>Available Amount</td>
                            <td></td>
                        </tr>

                    </table>
                    <hr class="divider_type_3 m_bottom_45">

                </section>
                <!--right column-->
                <aside class="col-lg-3 col-md-3 col-sm-3">
                    <!--widgets-->
                    <figure class="widget shadow r_corners wrapper m_bottom_30"> </figure>
                    <!--banner-->
                    <a href="#" class="d_block r_corners m_bottom_30">
                        <img src="images/banner_img_6.png" alt="">
                    </a>

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