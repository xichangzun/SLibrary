<%@ page import="com.xcz.search.domain.Book" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>Book Detail</title>
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
                    <a href="index.jsp" class="logo m_xs_bottom_15 d_xs_inline_b">
                        <img src="images/logo.png" alt="">
                    </a>
                </div>
            </div>
        </section>
        <!--main menu container-->
    </header>
    <!--breadcrumbs-->
    <section class="breadcrumbs">
        <div class="container">
            <form method="post" action="/Search/execute" >
                <!-- filename: find-code-include -->
                <div style="margin-top:1px" class="custom_select f_size_medium relative f_left">
                    <div class="select_title r_corners relative color_dark">Book Name</div>
                    <ul class="select_list d_none"></ul>
                    <select name="type">
                        <option value="Book Name">Book Name</option>
                        <option value="Author">Author</option>
                        <option value="ISBN">ISBN</option>
                    </select>
                </div>
                <input autocomplete="off" class=" r_corners" style="width:30%; height:29px;" name="keyword"> &nbsp;
                <input style="height:30px" class="button_type_9 r_corners t_align_c" id="lookup" value="  Search  " type="submit">
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
                    <%
                        Book[] books = (Book[])session.getAttribute("result");
                        Book book = books[Integer.parseInt(request.getParameter("index"))];
                    %>
                        <table width="700" border="20" bordercolor="black" cellspacing="20">
                            <tr height="30">
                                <td>Call No.</td>
                                <td><%=book.getCall_no()%></td>
                            </tr>
                            <tr height="30">
                                <td>ISBN</td>
                                <td><%=book.getISBN()%></td>
                            </tr>
                            <tr height="30">
                                <td>Language</td>
                                <td><%=book.getLang()%></td>
                            </tr>
                            <tr height="30">
                                <td>Book Name</td>
                                <td><%=book.getBook_name()%></td>
                            </tr>
                            <tr height="30">
                                <td>Publication</td>
                                <td><%=book.getPress()%> : <%=book.getPub_year()%></td>
                            </tr>
                            <tr height="30">
                                <td>Descr.</td>
                                <td><%=book.getPages()%>p ; <%=book.getSize()%>cm</td>
                            </tr>
                            <tr height="30">
                                <td>Author</td>
                                <td><%=book.getAuthor()%></td>
                            </tr>
                            <tr height="30">
                                <td>Total Amount</td>
                                <td><%=book.getTotal_amount()%></td>
                            </tr>
                            <tr height="30">
                                <td>Available Amount</td>
                                <td><%=book.getAmount()%></td>
                            </tr>
                        </table>
                    <hr class="divider_type_3 m_bottom_45">

                </section>
                <!--right column-->
                <aside class="col-lg-3 col-md-3 col-sm-3">
                    <!--widgets-->
                    <figure class="widget shadow r_corners wrapper m_bottom_30"> </figure>
                    <!--banner-->
                    <br>
                    <br>
                    <br>
                    <a href="#" class="d_block r_corners m_bottom_30">
                        <img src="<%=book.getCover()%>" alt="">
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
<button class="t_align_c r_corners tr_all_hover type_2 animate_ftl" id="go_to_top"><i class="fa fa-angle-up"></i></button>

<script>

</script>
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