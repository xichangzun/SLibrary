<%@ page import="com.xcz.recommendation.domain.Recommendation" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<!--[if IE 9 ]><html class="ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en"><!--<![endif]-->
	<head>
		<title>Slibrary - UserInfo</title>
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
								<li class="relative current f_xs_none m_xs_bottom_5"><a href="borrow.html" class="tr_delay_hover color_light tt_uppercase"><b>Borrow And Return</b></a></li>
								<li class="relative f_xs_none m_xs_bottom_5"><a href="books_update.html" class="tr_delay_hover color_light tt_uppercase"><b>Book Management</b></a></li>
								<li class="relative f_xs_none m_xs_bottom_5"><a href="index.jsp" class="tr_delay_hover color_light tt_uppercase"><b>E-Resource</b></a></li>
								<li class="relative f_xs_none m_xs_bottom_5"><a href="admin_newsManage.html" class="tr_delay_hover color_light tt_uppercase"><b>News Management</b></a></li>
								<li class="relative f_xs_none m_xs_bottom_5"><a href="admin_recommendation.html" class="tr_delay_hover color_light tt_uppercase"><b>Recommendation</b></a></li>
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
			<!--breadcrumbs-->
			<section class="breadcrumbs">
				<div class="container">
					<ul class="horizontal_list clearfix bc_list f_size_medium">
						<li class="m_right_10"><a href="#" class="default_t_color">Home<i class="fa fa-angle-right d_inline_middle m_left_10"></i></a></li>
						<li class="m_right_10"><a href="admin_recommendation.html" class="default_t_color">Recommendation Management<i class="fa fa-angle-right d_inline_middle m_left_10"></i></a></li>
						<li><a href="admin_recommendation_detail.html" class="current default_t_color">Recommendation Detail</a></li>
					</ul>
				</div>
			</section>
			<!--content-->
			<div class="page_content_offset">
				<div class="container">
					<div class="row clearfix">
						<!--left content column-->
                        <section class="col-lg-1 col-md-1 col-sm-1">
                        </section>
						<section class="col-lg-10 col-md-9 col-sm-9">
							
							<div class=" row clearfix r_corners photoframe  shadow m_bottom_45">
								<h2 style="margin:50px 60px" class="tt_uppercase color_dark m_bottom_25">Recommendation Information</h2>
                            	<div class="col-lg-2 col-md-8 col-sm-8 m_xs_bottom_30">
                                </div>
								<div class="col-lg-9 col-md-8 col-sm-8 m_xs_bottom_30">
                                	<br>

									<%
										ArrayList<Recommendation> list = (ArrayList<Recommendation>) session.getAttribute("recom_result");
										int index = Integer.parseInt(request.getParameter("index"));
										Recommendation recom = list.get(index);
									%>
									<%--Infomation--%>
									<form>
                                    	<table style="font-size:16px">
                                        	<tr class="m_bottom_45">
                                            	<td width="200" height="50" align="right" valign="middle">
                                            		<label class="m_bottom_5 d_inline_b">Book Name</label>&nbsp;
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
	                                                <label class="m_bottom_5 d_inline_b color_dark"><%=recom.getBook_name()%></label>
                                                </td>
                                            </tr>
                                            <tr class="m_bottom_25">
                                            	<td width="200" height="50" align="right" valign="middle">
                                                	<label class="m_bottom_5 d_inline_b">Language</label>&nbsp;
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
                                               		<label class="m_bottom_5 d_inline_b color_dark"><%=recom.getLang()%></label>
                                                </td>
                                            </tr>
                                            <tr class="m_bottom_25">
                                            	<td width="200" height="50" align="right" valign="middle">
                                                	<label class="m_bottom_5 d_inline_b">Author</label>
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
                                                	<label class="m_bottom_5 d_inline_b color_dark"><%=recom.getAuthor()%></label>
                                                </td>
                                            </tr>
                                            <tr class="m_bottom_45">
                                            	<td width="200" height="50" align="right" valign="middle">
                                            		<label  class="m_bottom_5 d_inline_b">Press</label>&nbsp;
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
	                                                <label class="m_bottom_5 d_inline_b color_dark"><%=recom.getPress()%></label>
                                                </td>
                                            </tr>
                                            <tr class="m_bottom_45">
                                            	<td width="200" height="50" align="right" valign="middle">
                                            		<label  class="m_bottom_5 d_inline_b">ISBN</label>&nbsp;
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
	                                                <label class="m_bottom_5 d_inline_b color_dark"><%=recom.getUionPK().getISBN()%></label>
                                                </td>
                                            </tr>
                                            <tr class="m_bottom_45">
                                            	<td width="200" height="50" align="right" valign="middle">
                                            		<label  class="m_bottom_5 d_inline_b">Price</label>&nbsp;
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
	                                                <label class="m_bottom_5 d_inline_b color_dark"><%=recom.getPrice()%></label>
                                                </td>
                                            </tr>
                                            <tr class="m_bottom_45">
                                            	<td width="200" height="50" align="right" valign="middle">
                                            		<label  class="m_bottom_5 d_inline_b">Expected Amount</label>&nbsp;
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
	                                                <label class="m_bottom_5 d_inline_b color_dark"><%=recom.getAmount()%></label>
                                                </td>
                                            </tr>
                                            <tr class="m_bottom_45">
                                            	<td width="200" height="50" align="right" valign="middle">
                                            		<label  class="m_bottom_5 d_inline_b">Recommending Reason</label>&nbsp;
                                                </td>
                                                <td width="40" height="50" align="right" valign="middle">
                                                </td>
                                                <td width="300" height="50" align="left" valign="middle">
	                                                <label class="m_bottom_5 d_inline_b color_dark"><%=recom.getReason()%></label>
                                                </td>
                                            </tr>
											<tr class="m_bottom_45">
												<td width="200" height="50" align="right" valign="middle">
													<label  class="m_bottom_5 d_inline_b">Treatment</label>&nbsp;
												</td>
												<td width="40" height="50" align="right" valign="middle">
												</td>
												<td width="300" height="50" align="left" valign="middle">
													<label class="m_bottom_5 d_inline_b color_dark"><%=recom.getState()%></label>
												</td>
											</tr>
                                            <tr class="m_bottom_25">
                                            	<td width="100" height="20" align="right" valign="middle">
                                                </td>
                                            </tr>
                                    	</table>
                                    </form>
								</div>
							</div>
							<div class="row clearfix">
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
	</body>
</html>

    
