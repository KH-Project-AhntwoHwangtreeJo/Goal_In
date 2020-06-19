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
				<h3 class="mb-30">회원탈퇴</h3>


				<form id="deleteForm" action="<%= request.getContextPath() %>/mDelete.me"
					method="post" style="padding-left: auto">
					<!--아이디-->
					<div class="mt-10"><%= m.getUserid() %>
						
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
					</div>

					<!--탈퇴버튼-->
					<div class="mt-10">
					   <div id="goMain" type="button" class="btn btn-primary" onclick="goMain();">메인으로</div>&nbsp;
						<button id="deleteBtn" class="btn btn-danger"
							onclick="deleteMember()">회원 탈퇴</button>
					</div>
				</form>
			</div>
		</div>
		</div>
	</section>
<script>

	/* function memberDelete() {
		$.ajax({
			url : '/Goal_In/mDelete.me',
			type : 'post',
			data : {
				userpwd : $('#userpwd').val()
			},
			success : function(data) {

				console.log(data);

				if (data == 0) {// 실패
					alert("비밀번호가 맞지 않습니다. :p")
				} else { // 성공
					alert("비밀번호가 확인되었습니다.")
					location.href = '/Goal_In/index.jsp';
				}

			},
			error : function() {
				console.log("에러 발생~!!");
			}
		});
	} */
	
	function deleteMember() {
		$("#deleteForm").submit();
	}

	$("#deleteForm").submit(function(event) {

			if($("#userpwd").val() == "") alert("비밀번호는 필수 값입니다.");
			else if($('#userpwd').val() != $('#userpwd1').val()) alert("비밀번호 확인 값과 다릅니다.");
			else return;
			event.preventDefault();
		});
	
	function goMain() {
		location.href = '/Goal_In/index.jsp';
	};
</script>
<%@ include file="/views/common/footer.jsp" %>