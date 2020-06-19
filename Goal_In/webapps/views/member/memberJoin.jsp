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
		<div class="section-top-border">
			<div class="row">
				<div class="col-lg-8 col-md-8">
					<h3 class="mb-30">회원가입</h3>
					

					<form  id="joinForm" action="<%= request.getContextPath() %>/mInsert.me" 
                            method="post" enctype="multipart/form-data" id="enroll" style="padding-left:auto">
						<!--사진 등록-->
					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Username is reauired">
						<label for="thumbnailImg"><img
							src="/Goal_In/resources/img/업로드.JPG" id="contentImg"
							style="width: 400px;"></label> <br>
						<input type="file" id="thumbnailImg" name="gimg"
							onchange="loadImg(this);" style="display: none;"> 
							<span class="focus-input100"></span>
					</div>
					<!--아이디-->
					<div class="mt-10">
						<input type="text" name="userid" id="userid" placeholder="아이디"
							class="form-control" required="required">
						<div id="idCheck" class="btn btn-warning" onclick="idCheckClickEvent()">중복확인</div>
						<div type="text" id="idCheckMsg"></div>
					</div>
					<!--패스워드-->
					<div class="mt-10">
						<input type="password" name="userpwd" id="userpwd"
							placeholder="패스워드" required="required" maxlength="30"
							class="form-control" data-rule-required="true">
					</div>
					<!--패스워드 확인-->
					<div class="mt-10">
						<input type="password" name="userpwd1" id="userpwd1"
							placeholder="패스워드 확인" maxlength="30" class="form-control"
							data-rule-required="true">
							<div type="text" id="passwdMsg"></div>
					</div>
					<!--본 이름-->
					<div class="mt-10">
						<input type="text" name="username" id="username" placeholder="이름"
							required maxlength="15" class="form-control">
					</div>
					<!--닉네임-->
						<div class="mt-10">
							<input type="text" name="nickname" id="nickname"
								placeholder="닉네임" required maxlength="15" class="form-control">
						</div>
						<!--휴대폰-->
						<div class="mt-10">
							휴대폰 번호 :<input type="text" id="tel1" maxlength="3" name="tel1" size="4">- 
							<input type="text" id="tel2" maxlength="4" name="tel2" size="4">- 
							<input type="text" id="tel3" maxlength="4" name="tel3" size="4">
						</div>
						<!--이메일-->
						<div class="mt-10">
							<input type="email" name="email" placeholder="이메일"
								class="form-control">
						</div>
						<!--주소-->
						<div class="mt-10">
							<input type="text" name="address" id="address" placeholder="주소"
								class="form-control">
						</div>
						<!--제출버튼-->
						<div class="mt-10">
							<div id="goMain" type="button" class="btn btn-primary" onclick="goMain();">메인으로</div>
							<button id="joinBtn" class="btn btn-danger"
								onclick="insertMember();">가입하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<script>

		function insertMember() {
			
			  /*  if($("#username").val() ==''){
		            alert('이름을 입력하세요');
		            $("#username").focus();
		            return false;
		        } 
 */
		
			   
		        	$("#joinForm").submit();				
		}
		
		$("#joinForm").submit(function(event){
			if($("#userpwd").val() == "" || $("#userid").val() == "") alert("아이디나 비밀번호는 필수 값입니다.");
			else if($('#userpwd').val() != $('#userpwd1').val()) alert("비밀번호 확인 값과 다릅니다.");
			else return;
			event.preventDefault();
		});
		
		/*  function idIsEmptyCheck(){
			if ($("#userid").val() == ""){
		 		 alert("아이디는 필수 값입니다."); 
				 $("#userid").focus(); 
			}
		} */

		/* function pwdIsEmptyCheck(){
			if ($("#userpwd").val() == ""){
			 	alert("비밀번호는 필수 값입니다.");
				 $("#userpwd").focus(); 
			}
		}   
 */
		/* function passwordEqualCheck(){
			if($('#userpwd1').val() == ""){

			} else {
				if ($('#userpwd').val() != $('#userpwd1').val()){
					$("#passwdMsg").text("비밀번호 확인 값과 다릅니다. :p");
					$("#passwdMsg").css("color", "blue");
				} else {
					$("#passwdMsg").text("확인 :)");
					$("#passwdMsg").css("color", "blue");
				}
			}
		} */
		
		
		
		/*  $("#joinForm").submit(function(event) {
			if ($("#userpwd").val() == "" || $("#userid").val() == "")
				alert("아이디나 비밀번호는 필수 값입니다.");
			else
				return;
			event.preventDefault();
		});  */

		function goMain() {
			location.href = '/Goal_In/index.jsp';
		};

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
	      
	      function idCheckClickEvent(){
				$.ajax({
					url : '/Goal_In/idDup.do',
					type : 'post',
					data : { userid : $('#userid').val() },
					success : function(data){

						console.log(data);

						//결과가 0이면 사용자 없음 : 가입 가능
						// 	  1 이면 1명 사용중  : 가입 불가
						if($("#userid").val() == "") {
							alert("아이디는 필수값입니다.");
						} else if( data == 0){
							$("#idCheckMsg").text("사용가능한 아이디입니다 :p");
							$("#idCheckMsg").css("color", "blue");
						} else {
							$("#idCheckMsg").text("사용중인 아이디입니다 :p");
							$("#idCheckMsg").css("color", "red");
						}

					}, error : function(){
						console.log("에러 발생~!!");
					}
				});
			}


	</script>
<%@ include file="/views/common/footer.jsp" %>