<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    import="com.semi.member.model.vo.*" %>
    <%
	Member m = (Member)session.getAttribute("member");
%>
<!doctype html>
<html class="no-js" lang="ko">

</head>
<body>
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<!-- Logo -->
					<div class="logo">
						<h1>
							<a href="/Goal_In/adminIndex.jsp">Goal in</a>
						</h1>
					</div>
				</div>
				<div class="col-md-5">
					<div class="col-lg-12">
						<div class="input-group form"></div>
					</div>
				</div>


				<div class="col-md-2">
					<div class="navbar navbar-inverse" role="banner">
						<nav
							class="collapse navbar-collapse bs-navbar-collapse navbar-right"
							role="navigation">
							<ul class="nav navbar-nav">
								<li class="dropdown"><a href="/Goal_In/index.jsp">메인으로 가기</a>
									<ul class="dropdown-menu animated fadeInUp">

									</ul></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<!--container-->
	</div>
	<!--header-->