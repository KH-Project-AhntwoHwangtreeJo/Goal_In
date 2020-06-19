<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/views/common/header.jsp" %>
<!--   <style>
        div{
            margin-left: auto;
        }
        .mb-30{
            padding-left: 100px;
            
        }
        form{
            
            padding-left: 100px;
            width: 500px;
        }
        
    </style> -->
	<section class="sample-text-area">
	<div class="container">
		<div class="section-top-border">
			<div class="row" style="margin-left:200px;">
				<div class="col-lg-8 col-md-8">
					<h3 class="mb-30">회원 정보 수정</h3>
					

					<form id="updateForm" action="<%= request.getContextPath() %>/mUpdate.me" 
                            method="post" enctype="multipart/form-data" id="update" style="padding-left:auto">
						<!--사진 등록-->
						<div class="wrap-input100 validate-input m-b-23"
							data-validate="Username is reauired">
								<label for="thumbnailImg" style="margin-left:100px">
								<img src="<%= request.getContextPath()%>/resources/memberImg/<%= m.getMimage() %>"  
									class="mx-auto text-center rounded-circle"
									id="contentImg"   style="width: 400px; margin-left:90px;">
								</label>
                                <br><input type="file" id="thumbnailImg" name="gimg" onchange="loadImg(this);" style="display:none;">
						 
								<span class="focus-input100"></span>
						</div>
						<!--아이디-->
						<div class="mt-10"><%= m.getUserid() %>
						</div>
						<!--패스워드-->
						<div class="mt-10">
							<input type="password" name="userpwd" id="userpwd"
								placeholder="변경할 비번" required="required" maxlength="30"
								class="form-control" data-rule-required="true">
						</div>
						<!--패스워드 확인-->
						<div class="mt-10">
							<input type="password" name="userpwd1" id="userpwd1"
								placeholder="변경 비번 확인" maxlength="30" class="form-control"
								data-rule-required="true" onfocusout="passwordEqualCheck()">
								<div type="text" id="passwdMsg"></div>
						</div>
						<!--본 이름-->
						<div class="mt-10"><%= m.getUsername() %>
						</div>
						<!--닉네임-->
						<div class="mt-10">
							<input type="text" name="nickname" id="nickname"
								placeholder="닉네임" required maxlength="15"  value="<%= m.getNickname() %>" class="form-control">
						</div>
						<!--휴대폰-->
						<div class="mt-10">
							휴대폰 번호 :<input type="text" maxlength="3" name="tel1" size="4">- 
							<input type="text" maxlength="4" name="tel2" size="4">- 
							<input type="text" maxlength="4" name="tel3" size="4">
						</div>
						<!--이메일-->
						<div class="mt-10">
							<input type="email" name="email" placeholder="이메일" value="<%= m.getEmail() %>"
								class="form-control">
						</div>
						<!--주소-->
						<div class="mt-10">
							<input type="text" name="address" id="address" placeholder="주소" value="<%= m.getAddress() %>"
								class="form-control">
						</div>
						<!--제출버튼-->
<div class="mt-10">
	<!-- <button id="goMain" class="btn btn-primary" onclick="goMain();">메인으로</button>&nbsp; -->
	<div id="updateBtn" class="btn btn-primary" onclick="updateMember();">수정하기</div>&nbsp;
	<div id="deleteBtn" class="btn btn-danger" onclick="deleteMember();">회원 탈퇴</div>
</div>
</form>
</div>
</div>
</div>
</div>
	</section>
	<script>


		function updateMember() {
			$("#updateForm").submit();
		}

		$("#updateForm").submit(function(event) {

				if($("#userpwd").val() == "") alert("비밀번호는 필수 값입니다.");
				else if($('#userpwd').val() != $('#userpwd1').val()) alert("비밀번호 확인 값과 다릅니다.");
				else return;
				event.preventDefault();
			});
		/* function passwordEqualCheck() {

			if ($("#userpwd").val() == "") {
				alert("비밀번호는 필수 값입니다.");
			}
			if ($('#userpwd').val() != $('#userpwd1').val()) {
				$("#passwdMsg").text("비밀번호 확인 값과 다릅니다. :p");
				$("#passwdMsg").css("color", "red");
			} else {
				$("#passwdMsg").text("확인 :)");
				$("#passwdMsg").css("color", "blue");
			}
		} */

		// 사진 게시판 미리보기 기능 지원 스크립트
		function loadImg(value) {

			if (value.files && value.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {
					$('#contentImg').attr('src', e.target.result);
				}
				reader.readAsDataURL(value.files[0]);
			}
		}

		function updateMember() {
			$("#updateForm").submit();
		}

		/* function goMain() {
			location.href = '/Goal_In/index.jsp';
		}; */

		function deleteMember() {
			location.href = '/Goal_In/views/member/memberDelete.jsp';
		};
	</script>
<%@ include file="/views/common/footer.jsp" %>