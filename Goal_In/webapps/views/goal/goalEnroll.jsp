<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/views/common/header.jsp" %>

<!--  head -->
 <!-- Start Align Area -->
 <%--  <% if (m != null) { %>      --%>
    <div class="whole-wrap" style="background:white;">
		<div class="container box_1170" style="margin-left : 600px"> <!-- 왼쪽 띄고-->
			
			<div class="section-top-border">
				<div style="margin-left:auto;">
				
					<div class="col-lg-8 col-md-8">
						<br /><br /><br />
						
						<form action="<%= request.getContextPath() %>/gInsert.go" 
                            method="post" enctype="multipart/form-data" id="enroll" style="padding-left:auto">
                            <br />
                            <input type="hidden" name="gwriter" value="<%= m.getUserid() %>"/>
                            
							<h3 class="mb-30">GOAL-IN 개설하기</h3>
                            <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                              
                              <div class="mt-10">
                                <label>GOAL 대표 이미지 등록 :  </label><br />
								 <label for="thumbnailImg" ><img src="/Goal_In/resources/img/업로드.JPG"  id="contentImg"   style="width: 400px;"></label>
                                <br><input type="file" id="thumbnailImg" name="gimg" onchange="loadImg(this);" style="display:none;">
                            </div><br>  
                            
                            
                            
							<div class="mt-10">
                                <label>GOAL_IN 제목 : </label>
								<input type="text" name="goalname" placeholder="GOAL-TITLE"
									onfocus="this.placeholder = ''" onblur="this.placeholder = '제목 적어야해요 ㅠㅠ'" required
									class="single-input">
                            </div><br>
                            <div class="mt-10">
                                <label>GOAL 목표 및 소개 : </label>
								<input type="text" name="goalinone" placeholder="GOAL-TITLE"
									onfocus="this.placeholder = ''" onblur="this.placeholder = '제목 적어야해요 ㅠㅠ'" required
									class="single-input">
                            </div><br>
                            <div class="mt-10">
                                <label>GOAL Reader 소개글 : </label><br>
								<textarea class="single-textarea"  name="gcontent"
								placeholder="GOAL을 만드신 이유나 간단한 소개글을 적어주세요" onfocus="this.placeholder = ''"
									onblur="this.placeholder = '소개글을 작성해주세요!'" required></textarea>
                            </div><br>
                             <div class="mt-10">
								<div class="form-select" id="category">
                                    <label>카테고리 : </label><br>
									<select name="gcategory" >
								    	<option value="식단">식단</option>
                                        <option value="유산소">유산소</option>
                                        <option value="웨이트">웨이트</option>
                                        <option value="스트레칭">스트레칭</option>
                                        <option value="생활습관">생활습관</option>
									</select>
								</div>
								<div id="selectResult"></div>
							</div><br><br> 

							<div class="mt-10">
                                <label>GOAL_IN 시작일 : </label>
								<input type="date"" name="startdate" id="startdate" placeholder="startDate" min=""
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'startDate'" required
									class="single-input">
							</div><br>
							<div class="mt-10">
                                <label>GOAL_IN 종료일 : </label>
								<input type="date" name="enddate"  id="edate" placeholder="endDate" min=""
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'endDate'" required
									class="single-input">
							</div><br>
							
		
							<div class="mt-10">
                                <label>나의 투자금 설정 : </label>
								<input type="text" name="money" placeholder="얼마나 투자하실지 적어주세요."
									onfocus="this.placeholder = ''" onblur="this.placeholder = '돈을 설정해야죠 -_-+'" required
									class="single-input">
                            </div><br>
                            
							<!-- <div class="mt-10">
								<div class="form-select" id="week-set">
                                    <label>인증 빈도 설정 : </label><br>
									<select>
								    	<option value="1">월 ~ 일 매일 인증하기</option>
                                        <option value="2">월 ~ 금 매일 인증하기</option>
                                        <option value="3">토 ~ 일 매일 인증하기</option>
                                        <option value="4">주 5회 인증하기</option>
                                        <option value="5">주 4회 인증하기</option>
                                        <option value="6">주 3회 인증하기</option>
                                        <option value="7">주 2회 인증하기</option>
                                        <option value="8">주 1회 인증하기</option>
									</select>
								</div>
							</div><br><br><br> -->
                            
                            
							<div class="mt-10">
                                <label>최대 수용 인원 : </label>
								<input type="text" name="gmaxnum" placeholder="person"
									onfocus="this.placeholder = ''" onblur="this.placeholder = '몇 명까지 가능해요?'" required
									class="single-input">
                            </div><br>
                        
                        

                        <!-- <div class="mt-10">
                            <div class="form-select" id="pri">
                                <label>비공개 유무 : </label><br>
                                <select>
                                    <option value="1">공개 GOAL-IN</option>
                                    <option value="2">비공개 GOAL-IN</option>
                                </select>
                            </div>
                        </div><br><br>

                        <div class="mt-10" id="pripass">
                            <label>비밀번호 설정 : </label>
                            <input type="text" name="pass"" placeholder="비공개시 작성해주세요"
                                onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 적어주세요'" required
                                class="single-input">
                        </div><br> -->
						<div style="text-align:center">
                        <button type="submit" class="btn btn-primary" >GOAL-IN 만들기</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="reset" class="btn btn-secondary" data-toggle="button" aria-pressed="false">취소하기</button>
                        </div>
                        </form>  
                    </div>
                </div>
            </div>
        </div>
    </div>
  <%--<% } else { 
		request.setAttribute("msg", "회원만 작성가능합니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
	 } %>  --%>

	<!-- End Align Area -->

<script>
		$( function() {
			 $('#thumbnailImg').hide();
			 
		    $( "#slider-range" ).slider({
		        range: true,
		        min: 0,
		        max: 500,
		        values: [ 75, 300 ],
		        slide: function( event, ui ) {
		            $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
		        }
		    });
		    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
		        " - $" + $( "#slider-range" ).slider( "values", 1 ) );
		} );
</script>
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
   <script> //시작날짜 오늘이전으로 클릭x 설정
	   var today = new Date();
	   var dd = today.getDate();
	   var mm = today.getMonth()+1; 
	   var yyyy = today.getFullYear();
	    if(dd<10){
	           dd='0'+dd
	       } 
	       if(mm<10){
	           mm='0'+mm
	       } 
	
	   today = yyyy+'-'+mm+'-'+dd;
	   document.getElementById("startdate").setAttribute("min", today);
   </script>
   
 <!--     <script> // 종료날짜 시작일 이후로 
       $('#startdate').on('change',function(){  // 시작일이 바뀔때마다 함수 실행
		      var sdate = $('#startdate').val();   // 시작일 불러와서 
			   var dd = sdate.split('-')[2];
			   var mm = sdate.split('-')[1]; 
			   var yyyy = sdate.split('-')[0];
			   
		       sdate = yyyy+'-'+mm+'-'+dd;
		       document.getElementById("edate").setAttribute("min", sdate);
       });
   </script>   --> 
   
   <script> // 시작일 7일 이후 종료날짜 
 		  $('#startdate').on('change',function(){
	      var sdate = $('#startdate').val();
		   var dd = sdate.split('-')[2];
		   var mm = sdate.split('-')[1]; 
		   var yyyy = sdate.split('-')[0];
		   
	       sdate = yyyy+'-'+mm+'-'+dd;
	      	let date = new Date(sdate); // 데이트 로 형변환 해주는 ?
	      	
	      	date.setDate(date.getDate() +7);
	       
	 	   var dd = date.getDate();
		   var mm = date.getMonth()+1; 
		   var yyyy = date.getFullYear();
		   
		    if(dd<10){
		           dd='0'+dd
		       } 
		       if(mm<10){
		           mm='0'+mm
		       } 
		       
		   enddate = yyyy+'-'+mm+'-'+dd;
	       document.getElementById("edate").setAttribute("min", enddate);
	       
		});
   </script>

   
   
   
    <!-- footer start -->
      <%@ include file="/views/common/footer.jsp" %>