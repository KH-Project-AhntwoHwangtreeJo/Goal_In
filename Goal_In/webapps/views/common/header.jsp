<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    import="com.semi.member.model.vo.*" %>
    <%
Member 	m = (Member)session.getAttribute("member");
%>
<!doctype html>
<html class="no-js" lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Goal-In</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="/Goal_In/resources/img/icon/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="/Goal_In/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/themify-icons.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/nice-select.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/flaticon.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/gijgo.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/animate.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/slick.css">
    <link rel="stylesheet" href="/Goal_In/resources/css/slicknav.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <!-- slide  -->

    <link rel="stylesheet" href="/Goal_In/resources/css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">

    <!-- login css -->
    <!--===============================================================================================-->	
	    <link rel="icon" type="image/png" href="/Goal_In/resources/img/icons/favicon.ico"/>
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/js/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/css/animate.css">
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/js/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/js/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/js/vendor/select2/select2.min.css">
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/js/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/css/util.css">
        <link rel="stylesheet" type="text/css" href="/Goal_In/resources/css/main.css">
    <!--===============================================================================================-->
		<link rel="stylesheet" href="/Goal_In/resources/css/uploadpicture.css">
    
    <!-- Demo styles -->
    <style>
        html, body {
        position: relative;
        height: 100%;
        }
        body {
        background: #eee;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color:#000;
        margin: 0;
        padding: 0;
        }
        .swiper-container {
        width: 100%;
        height: 90%;
        border-radius : 20px;
        }
        .swiper-slide {
        text-align: center;
        font-size: 18px;
        /*background: #fff; */
        width: 350px;
        /* height: 500px; */
        
        /* Center slide text vertically */
        /* display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex; */
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
        }

        .swiper-button-next, .swiper-button-prev {
            color: tomato;
        }
        @media (max-width: 760px) {
            .swiper-button-next {
                right: 20px;
                transform: rotate(90deg);
            }

            .swiper-button-prev {
                left: 20px;
                transform: rotate(90deg);
            }
        }
        

    </style>
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
    <script src="/Goal_In/resources/js/vendor/jquery-1.12.4.min.js"></script>
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"> </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>

<body>
    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
        <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area" style="background-color: #001D38;">
                <div class="container-fluid ">
                    <div class="header_bottom_border">
                        <div class="row align-items-center">
                            <div class="col-xl-3 col-lg-2">
                                <div class="logo">
                                    <a href="/Goal_In/index.jsp">
                                        <img src="/Goal_In/resources/img/mlogo4.png" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-7">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a href="/Goal_In/index.jsp">홈</a></li>
                                            <li>
                                            <a href="/Goal_In/goalList.go">전체 목록 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="/Goal_In/goalList.go">진행중 골</a></li>
                                                <li><a href="<%=request.getContextPath()%>/goalCompleteList.go">완료된 골</a></li>
                                            </ul>
                                            </li>
                                            
                                            <%if ( m == null ) { %>
                                            <li><a href=href="void(0);" onclick="alert('로그인이 필요합니다.');return false;">골 등록하기 </a></li>
                                            <li><a href=href="void(0);" onclick="alert('로그인이 필요합니다.');return false;">마이페이지 <i class="ti-angle-down"></i></a></li>
                                            <%}else { %>
                                            <li><a href="<%=request.getContextPath()%>/views/goal/goalEnroll.jsp">골 등록하기 </a></li>
                                            <li><a href="<%=request.getContextPath()%>/myJoin.jo?userid=<%= m.getUserid() %>">마이페이지 <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                    <li><a href="<%=request.getContextPath()%>/myJoin.jo?userid=<%= m.getUserid() %>" > 참여중인 골</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/myLove.lo?userid=<%= m.getUserid() %>" > 관심가진 골</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/pList.po?userid=<%= m.getUserid() %>">포인트 관리</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/selectReviews.bo?userId=<%= m.getUserid() %>">리뷰 관리</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/views/member/memberUpdateForm.jsp">개인정보수정 / 탈퇴</a></li>
                                                </ul>
                                            </li>
                                            <%} %>
                                            <li><a href="#">고객센터 <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                    <li><a href="<%=request.getContextPath()%>/unls.no">공지사항</a></li>
                                                    <li><a href="/Goal_In/views/cs/defaultFAQ.jsp">FAQ</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="/Goal_In/views/cs/contact.jsp">Contact</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 d-none d-lg-block">
								<%if ( m == null ) { %>
								<div class="Appointment">
									<div class="book_btn d-none d-lg-block">
										<button class="btn btn-danger" data-toggle="modal"
											data-target="#loginForm">로그인</button>
									</div>
								</div>

								<% } else { %>
									<% if(m != null && m.getUserid().equals("admin")){ %>
										<div id="userInfo">
											<div class="btns" align="right">
											<label style="color:white">어서오세요.<%=m.getUsername()%>님!</label> &nbsp;&nbsp;&nbsp;
												<button class="btn btn-danger" id="logoutBtn" onclick='logout()'>로그아웃</button>
												<button class="btn btn-info" id="logoutBtn" onclick='admin()'>admin</button>
											</div>
										</div>
									<% }else{	%>
										<div id="userInfo">
												<div class="btns" align="right">
												<label style="color:white">어서오세요.<%=m.getUsername()%>님!</label> &nbsp;&nbsp;&nbsp;
													<button class="btn btn-danger" id="logoutBtn" onclick='logout()'>로그아웃</button>
												</div>
										</div>
									
									
								<% }}	%>
                            </div>
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->
    <!-- 로그인 모달 시작 -->
    <div class="container modal fade" id="loginForm" tabindex="-1" role="dialog" aria-labelledby="loginForm" aria-hidden="true" 
    	style="scrollbar-width: none;">

        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54 modal-dialog">
            <div class="modal-content border-0">
                <form class="login100-form validate-form" action="/Goal_In/login.me">
                    <div class="modal-header border-0">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <span class="login100-form-title p-b-49">
                        Login
                    </span>

                    <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                        <span class="label-input100">ID</span>
                        <input class="input100" type="text" name="userid" placeholder="Type your username">
                        <span class="focus-input100" data-symbol="&#xf206;"></span>
                    </div>

                    <div class="wrap-input100 validate-input" data-validate="Password is required">
                        <span class="label-input100">Password</span>
                        <input class="input100" type="password" name="userpwd" placeholder="Type your password">
                        <span class="focus-input100" data-symbol="&#xf190;"></span>
                    </div>
                    
                    <div class="text-right p-t-8 p-b-31">
                        <a href="#">
                            Forgot password?
                        </a>
                    </div>
                    
                    <div class="container-login100-form-btn">
                        <div class="wrap-login100-form-btn">
                            <div class="login100-form-bgbtn"></div>
                            <button class="login100-form-btn" onclick="login();">
                                Login
                            </button>
                        </div>
                        
                    </div>

                    <div style="text-align:center">
                    <br /><br />
                        <a href="/Goal_In/views/member/memberJoin.jsp" class="txt2">
                            Sign Up
                        </a>
                    </div>
                </form>
             </div>
        </div>
    </div>
    <!-- 로그인 모달 끝 -->
    
   	<script>
    	function login(){
    		$('#loginForm').submit();
    	}
    	
    	function admin(){
    		location.href="/Goal_In/adminIndex.jsp";
    	}
    	
    	function logout(){
    		location.href="/Goal_In/logout.me";
    	}
    	
  
    </script>
    