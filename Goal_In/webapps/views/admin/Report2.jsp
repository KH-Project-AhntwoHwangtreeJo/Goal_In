
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.semi.report.model.vo.* ,com.semi.auth.model.vo.*"%>
<%
	ArrayList<Auth> alist = (ArrayList<Auth>) request.getAttribute("alist");
%>
<!DOCTYPE html>
<html>
<head>
<title>Goalin page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="/Goal_In/resources/resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- styles -->
<link href="/Goal_In/resources/resource/css/styles.css" rel="stylesheet">

<style>
@charset "UTF-8";

.switch {
	position: relative;
	display: inine-block;
	width: 60px;
	height: 34px;
}

.switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.slider:before {
	position: absolute;
	content: "";
	height: 26px;
	width: 26px;
	left: 4px;
	bottom: 4px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #2196f3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196f3;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px);
	-ms-transform: translateX(26px);
	transform: translateX(26px);
}

.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}

.small {
	width: 50px;
	height: 50px;
}
/* 평소큰이미지.pic 에대한스타일*/
.gallery .zoom {
	transition: all 0.3s ease-in-out; /* 웹킷브라우저에서트랜지션효과가나타나도록*/
	-webkit-transition: all 0.3s ease-in-out; /* 웹킷브라우저에서트랜지션효과가나타나도록*/
	width: 50px; /* 너비*/
	height: 50px; /* 높이*/
	opacity: 0; /* 페이드아웃효과*/
	visibility: hidden; /* 처음에는보이지않게*/
	position: absolute; /* 고정위치*/
	margin-top: 10px; /* 상단여백*/
	margin-left: -20px; /* 왼쪽으로20픽셀이동해서*/
	border: 1px solid black; /* 검은색테두리그림*/
	-webkit-box-shadow: #272229 2px 2px 10px; /* 박스그림자*/
	-moz-box-shadow: #272229 2px 2px 10px; /* 박스그림자*/
	box-shadow: #272229 2px 2px 10px; /* 박스그림자*/
}

/*마우스 오버 효과주기*/
.gallery img.small:hover {
	cursor: pointer;
}

/* 썸네일이미지위로마우스오버했을때큰이미지의스타일* */
.gallery:hover .zoom {
	width: 300px; /* 너비*/
	height: 300px; /* 높이*/
	opacity: 1; /* 불투명하게*/
	visibility: visible; /* 화면에보임*/
	float: right; /* 오른쪽으로플로팅*/
}
</style>
<%@ include file="/views/common/adminHeader.jsp"%>
<!--header-->


<div class="page-content">
	<div class="row">
		<%@ include file="/views/common/adminMenu.jsp"%>


		<div class="col-md-10">
			<div class="content-box-large">
				<div class="panel-heading">
					<div class="panel-title"></div>
				</div>
				<div class="panel-body">
					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>인증번호</th>
								<th>사용자ID</th>
								<th>골 넘버</th>
								<th>인증사진</th>
								<th>인증일자</th>

							</tr>
						</thead>
						<tbody>
							<%
								for (Auth a : alist) {
							%>


							<tr>
								<td><%=a.getSignnum()%></td>
								<td><%=a.getUserid()%></td>
								<td><%=a.getGno()%></td>
								<td class="gallery"><img class="img-fluid small"
									src="/Goal_In/resources/authUploadFiles/<%=a.getSigncf()%>"
									alt=""> <img class="img-fluid zoom"
									src="/Goal_In/resources/authUploadFiles/<%=a.getSigncf()%>"
									alt=""></td>
								<td><%=a.getSigndate()%></td>




							</tr>
							<%
								}
							%>
						</tbody>



					</table>


				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<footer>
	<div class="container">

		<div class="copy text-center">
			Copyright 2014 <a href='#'>Website</a>
		</div>

	</div>
</footer>

<link
	href="/Goal_In/resources/resource/vendors/datatables/dataTables.bootstrap.css"
	rel="stylesheet" media="screen">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- jQuery UI -->
<script src="https://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/Goal_In/resources/resource/bootstrap/js/bootstrap.min.js"></script>

<script
	src="/Goal_In/resources/resource/vendors/datatables/js/jquery.dataTables.min.js"></script>

<script
	src="/Goal_In/resources/resource/vendors/datatables/dataTables.bootstrap.js"></script>

<script src="/Goal_In/resources/resource/js/custom.js"></script>
<script src="/Goal_In/resources/resource/js/tables.js"></script>
</body>
</html>