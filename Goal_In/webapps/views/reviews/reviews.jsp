<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.*, com.semi.goal.model.vo.*, java.util.*, com.semi.join.model.vo.*, com.semi.reviews.model.vo.*"%>
<%@ include file="/views/common/header.jsp" %>
<%
	ArrayList<Join> list = (ArrayList<Join>)request.getAttribute("list");
	ArrayList<Goal> glist = (ArrayList<Goal>)request.getAttribute("glist");
	ArrayList<Reviews> reviewList = (ArrayList<Reviews>)request.getAttribute("reviewList");
	/* ArrayList<Review> reviewTop3List = (ArrayList<Review>)request.getAttribute("reviewTop3List"); */
%>

<div class="explorer_europe list_wrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="blog_right_sidebar">
                         <%@ include file="/views/common/myProfile.jsp" %>
                        <%@ include file="/views/common/myMenu.jsp" %>

                        
                    </div>
                </div>
                
                <div class="col-8">
	 <div class="container">
		<div class="jumbotron">
			<h2>Review</h2>
			<p>* 별점 및 리뷰 작성 후 작성하기 버튼을 클릭해 주세요.</p>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>골번호</th>
					<th>골이름</th>
					<th>성공여부</th>
					<th>작성일</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<% if(list != null && list.size() > 0) { %> <%--내가 참여한 골이 있을 때 --%>
				<% for (Goal g : glist) { %>
				<% for (Join j : list) { %>
				<% if( j.getGno() == g.getGno()) { %>
				<tr class="info" id="gno-<%= g.getGno() %>">
					
					<td><%= g.getGno() %></td>
					<td><a data-toggle="modal" data-target="#myModal2" onclick="review_read(${review_Bean.review_num})"><%= g.getGoalname() %></a></td>
					<!-- 성공 여부 체크 -->
					<td>
						<%= j.getSuccess().equals("Y") ?
							"<span style='font-size : 20px;'><i class='zmdi zmdi-check text-success'></i></span>" 
							: "<span style='font-size : 20px;'><i class='zmdi zmdi-close text-danger'></i></span>" %>
					</td>
					<td>
					<% for(Reviews r : reviewList){ %><!-- 리뷰안에 있는 내용을 다 가져온다.  -->
					<% if( r.getGno() == g.getGno() && r.getrStatus().equals("Y")) {%><!-- 글이 작성된 상태라면 작성일을 띄워준다. -->
					<%= r.getRDate() %>
					<% } else if(r.getGno() == g.getGno() && r.getrStatus().equals("N")) { %>
					<%= "Not Yet..." %>
					<% } } %>
					</td>
					<td><button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal" onclick="reviewRead(<%= g.getGno() %>);">Write</button></td>
				</tr>
				
			<% } } } } else { %> <%--내가 참여한 골이 없을 때 --%>
				<tr>
						<td style="text-align : center;"colspan="5">
							<h3>아직 참여가 끝난 Goal이 없어요! <br>
							참여한 Goal을 인증하러 가볼까요? <br>
							<button type="button" class="btn btn-info" onclick="goGoalList()">골 인증하러 가기</button></h3>
						<script>
						function goGoalList(){
							location.href="/Goal_In/myJoin.jo?userid=<%=m.getUserid()%>";
						}
						</script>
						</td>
				</tr>
			<% } %>
			</tbody>
		</table>
	<script>
		function reviewRead(gno){ // 팝업
			var userId = '<%= m.getUserid() %>';
			console.log(gno+ ", " + userId);
			$('#user_id').val(userId);
			$('#review_goal_name').val(gno);
			$.ajax({
				url : '/Goal_In/selectWritedReviews.bo',
				type : 'get',
				data : {
					userId : userId,
					gno : gno
				}, success : function(data){
					
					console.log(data);

					$('#review_content').text(data);
				}
			});
		}
	</script>
		<div class="row">
			<div class="col-sm-6">
			
				<div style="text-align:left">
					<ul class="pagination" id="page_num">
						<li>
									
						
						 <%-- <% for(int i = 1 ; i<=tot ; i++){ %>
   						 
   						 <a href="review.credu?Page_num=<%=i%>"><%=i%></a>
  						 
  						 <% } %> --%>
										
						</li>
					</ul>
				</div>
			
			
			</div>
		</div>
		 
		
		 <!-- Modal -->
  	<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog modal-lg">
    
      	<!-- Modal content-->
      	<div class="modal-content">
	        <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
        
        <div class="modal-body">
          
			<div class="panel-group">
			<div class="panel panel-success" style="margin-top: 10px;">
				<div class="panel-heading">Goal Review</div>
				<div class="panel-body">
					<%-- form --%>
					<div class="form-group">
						<label class="control-label col-sm-2">작성자(ID):</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="user_id"
								name="user_id" readonly>
						</div>
					</div>
					<!-- <div class="form-group">
						<label class="control-label col-sm-2" for="pwd">제목:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="review_title"
								name="review_title" placeholder="Title">
						</div> -->
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">골번호:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="review_goal_name"
								name="review_goal_name"  readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">후기:</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="5"	placeholder="review_content" name="review_content" id="review_content"></textarea>
						</div>
					</div>
					<!-- <div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label><input type="checkbox" value="1"
									id="review_buy_opt" name="review_buy_opt" checked="checked">평점</label>
							</div> -->
						</div>
					</div>
					<!-- <div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="radio">
							
								<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="1" checked="checked">★☆☆☆☆</label>
								<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="2">★★☆☆☆</label>
								<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="3">★★★☆☆</label>
								<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="4">★★★★☆</label>
								<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="5">★★★★★</label>
								
							</div>
						</div>
					</div> -->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-success" 
								    data-dismiss="modal" onclick="insertReview();">등록</button>	    
							<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteReviews();">삭제</button>
						</div>
					</div>
				</div>
					<script>
					function deleteReviews(){
						// delete 는 예약어 이므로 deleteNotice 로 ...!
						location.href='<%=request.getContextPath() %>/deleteReviews.bo?gno='+$('#review_goal_name').val()+"&userId="+$('#user_id').val();
					}
					
					function insertReview(){
						$.ajax({
							url : "/Goal_In/reviewDuplicate.bo",
							type: "get",
							data : {
								userId : $('#user_id').val(),
								gno : $('#review_goal_name').val()
							}, success : function(data){
								if(data > 0) {
									// 리뷰가 있었을 경우 (UPDATE)
									$.ajax({
										url : "/Goal_In/updateReviews.bo",
										type: "post",
										data :{
											userId : $('#user_id').val(),
											gno : $('#review_goal_name').val(),
											rContent : $('#review_content').val()
										}, success : function(data){
											alert("리뷰 작성 성공!");
											var gno = $('#review_goal_name').val();
											var $gno_tr = $('#gno-'+gno);
											$gno_tr.children('td').eq(3).text(new Date().format('yyyy-MM-dd'));
											console.log($gno_tr);
											console.log($gno_tr.children('td').eq(3));
										}
									});
								} else {
									// 리뷰가 없었을 경우 (INSERT)
									$.ajax({
										url : "/Goal_In/insertReviews.bo",
										type: "post",
										data :{
											userId : $('#user_id').val(),
											gno : $('#review_goal_name').val(),
											rContent : $('#review_content').val()
										}, success : function(data){
											alert("리뷰 작성 성공!");
											var gno = $('#review_goal_name').val();
											var $gno_tr = $('#gno-'+gno);
											$gno_tr.children('td').eq(3).text(new Date().format('yyyy-MM-dd'));
											console.log($gno_tr);
											console.log($gno_tr.children('td').eq(3));
										}
									});
								}
							}
						});
						
					}
					
					Date.prototype.format = function(f) {
					    if (!this.valueOf()) return " ";
					 
					    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
					    var d = this;
					     
					    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
					        switch ($1) {
					            case "yyyy": return d.getFullYear();
					            case "yy": return (d.getFullYear() % 1000).zf(2);
					            case "MM": return (d.getMonth() + 1).zf(2);
					            case "dd": return d.getDate().zf(2);
					            case "E": return weekName[d.getDay()];
					            case "HH": return d.getHours().zf(2);
					            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
					            case "mm": return d.getMinutes().zf(2);
					            case "ss": return d.getSeconds().zf(2);
					            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
					            default: return $1;
					        }
					    });
					};
					 
					String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
					String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
					Number.prototype.zf = function(len){return this.toString().zf(len);};
					</script>
			</div>
		</div>
        </div>
       <!--  <div class="modal-footer">
          <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
        </div> -->
      </div>
      
    </div>
  </div>
  
  
  <!-- Modal2 _ read review -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Review Detail</h4>
        </div>
        <div class="modal-body">
                   	
          <textarea rows="10" class="form-control" readonly="readonly" id="content"></textarea>	
                    
        </div>
        <div class="modal-footer">
        						
          <button type="button" class="btn btn-danger" onclick="review_delete()">Delete</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	
        </div>
      </div>
      
    </div>
  </div>
		</div>
	</div>
                
              </div>
            </div>
           </div>




<%@ include file="/views/common/footer.jsp" %>