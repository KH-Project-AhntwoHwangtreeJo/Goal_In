<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<%
	String userid = request.getParameter("userid");
	int gno =Integer.parseInt(request.getParameter("gno"));
			
%>
	<!--  <style>
		input[type="file"] { /* 파일 필드 숨기기 */ 
			position: absolute;
			width: 1px;
			height: 1px;
			padding: 0;
			margin: -1px;
			overflow: hidden;
		    clip:rect(0,0,0,0);
			border: 0; }
	</style>
</head>
<body>
-->
<% if (m != null) { %>

	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
			
				<form class="login100-form validate-form" action="<%= request.getContextPath() %>/aInsert.ao" 
							method="post" enctype="multipart/form-data">
					<p style="text-align: center;">Goal-In</p>
					<span class="login100-form-title p-b-49">
						인증하기
					</span>
					
					<input type="hidden" name="gno" value="<%=gno %>"/>
					<input type="hidden" name="userid" value="<%=userid %>"/> 	
					<div class="wrap-input100 validate-input m-b-23"  data-validate = "Username is reauired">
						<span class="label-input100" >사진등록</span>		
						<label for="thumbnailImg" ><img src="/Goal_In/resources/img/업로드.JPG"  id="contentImg" style="width: 400px;"></label>
						<br><input type="file" id="thumbnailImg" name="signcf" onchange="loadImg(this);" style="display:none;">
						<span class="focus-input100" ></span>
					</div>
					


					
					<div class="text-right p-t-8 p-b-31">
						<a href="#"> <!-- 문의사항으로 !-->
							자주 묻는 질문으로 가기!
						</a>
					</div>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="submit" class="login100-form-btn">
								제출하기
							</button>
						</div>
					</div>
					</form>
					<%	} %>
					
					</div>
			</div>
		</div>
	

	<div id="dropDownSelect1"></div>

	<script>
		// 사진 게시판 미리보기 기능 지원 스크립트
	
		function loadImg(value){
			
			if(value.files && value.files[0])  {
				
				var reader = new FileReader();
				
				reader.onload = function(e){
	 				$('#contentImg').attr('src', e.target.result);
				}
				reader.readAsDataURL(value.files[0]);
			}
		}
	</script>
	
<!-- footer start -->
<%@ include file="/views/common/footer.jsp" %>
