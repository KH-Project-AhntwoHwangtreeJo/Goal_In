<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.goal.model.vo.*, java.util.*, com.semi.join.model.vo.*
				, com.semi.member.model.vo.*, com.semi.auth.model.vo.*, com.semi.reviews.model.vo.*"%>
<%
	Goal g = (Goal)request.getAttribute("goal");
	Auth a = (Auth)request.getAttribute("auth");
	Join j = (Join)request.getAttribute("join");
	Reviews reviews = (Reviews)request.getAttribute("reviews");
	int[] cnt = (int[]) request.getAttribute("cnt"); // 0 : 후기 개수 / 1 : 좋아요 개수 / 2 : 인증 개수 
	Member w = (Member)request.getAttribute("writer"); // 골 작성자 정보
%>
<%@ include file="/views/common/header.jsp" %>

	 <!--================GoalDetail Area =================-->
    <section class="blog_area single-post-area section-padding" style="background:white;">
      <div class="container">
         <div class="row" style="margin-left:200px;">
            <div class="col-lg-8 posts-list">
               <div class="single-post">
                  <div class="feature-img">
                     <img class="img-fluid" src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" style="width:100%">
                  </div>
                  <div class="blog_details">
                  <input type="hidden" name="gno" value=<%=g.getGno() %> />
                     <h2><%= g.getGoalname() %>
                     </h2>
                     <ul class="blog-info-link mt-3 mb-4">
                        <li><a href="#"><i class="fa fa-user"></i><%= g.getGcategory() %></a></li>
                        <li><a href="#"><i class="fa fa-comments"></i> 후기 <%=  cnt[0] %>개</a></li>
                        <li><a><i class="fa"></i><%= g.getStartdate() %> ~ <%= g.getEnddate() %></a></li>
                     </ul>
                     <p class="excert">
				         <%= g.getGoalinone() %>
                     </p>
                     <br>
                     <div class="d-sm-flex justify-content-between text-center">
                        <p class="like-info"><span class="align-middle"><i class="fa fa-heart" ></i></span>
                           관심있는 사람 <%= cnt[1] %>명
                        </p>
                     </div>
                     <% if(m != null ) { %>
                       		<button type="button" class="btn btn-warning btn-lg btn-block"
                         data-toggle="modal" data-target="#Joinform" >참여하기</button>
                         
                        <button type="button"  id="likeGoal" class="btn btn-outline-danger btn-lg btn-block"
                        onclick="insertLove();">관심 목록에 저장
                           &nbsp;<i class="fa fa-heart" ></i></button> </form>
                       	<%} else { %>
                     	<button type="button" class="btn btn-warning btn-lg btn-block notyet">참여하기</button>
                        <button type="button" class="btn btn-outline-danger btn-lg btn-block notyet">관심 목록에 저장
                           &nbsp;<i class="fa fa-heart" ></i></button>
                           <script>
                           		$('.notyet').on('click',function(){
                           				alert("로그인해야만 가능합니다!");
                           		});
                           		
           
                           </script>
                           <%} %>
                  </div>
 					<div class="blog-author">
                     <div class="media align-items-center">
                           <img class="img-fluid" src="/Goal_In/resources/memberImg/<%=w.getMimage() %>" alt="">
                        <div class="media-body" >
                           <a><strong><%= w.getNickname() %></strong></a>
                           <p><%= g.getGcontent()%></p>
                        </div>
                     </div>
               </<div>	</div>
               <div class="navigation-top">
                  
                  
               </div>
              
               <div class="comments-area" style="margin-top: auto;">
					<h4 style="display: inline;">후기 <%=  cnt[0] %>개</h4>
					<div style='width: 80px; float: right;'>

						<h6>
							<a href="<%=request.getContextPath()%>/ReivewsAllList.ao?gno=<%=g.getGno()%>">더보기>
							</a>						
						</h6>
					</div>

							<div class="comment-list">
								<div class="single-comment_area">

									<div class="row" id="top3Review">
										<div class="col-xl-3 col-md-4 col-lg-3 comment" style="">
											<div class="single_category" style="width:550px"></div>
										</div>
									</div>
								</div>
							</div>

						</div>

                <div class="comments-area" style="margin-top: auto;">
                  <h4 style="display: inline;" class="authcount">인증 <%=  cnt[2] %>개</h4>
                  <div style='width:80px;float: right;'>

                     <h6><a href="<%=request.getContextPath()%>/AuthImgAllList.ao?gno=<%=g.getGno() %>">더보기 > </a></h6>
                     
                  </div>
                  
                  <div class="comment-list"> 
                    <div class="popular_catagory_area">
       					
                            <div class="row" id="authImage">
                                 <!-- 이미지 6개 반복 -->
                                <div class="col-xl-3 col-md-4 col-lg-3 authOne" style="display:none;">
                                    <div class="single_catagory">
                                        <div class="thumb">
                                        	<img src="" alt="">  <!-- 이미지를 비워 주고 ajax로 추가 해주기 -->
                                        </div>
                                    </div>
                                </div>
								
                            </div> <!-- div .row 끝-->
                        </div>
                    </div>
                  <script>
                  	$(function(){
                  		$.ajax({
                  			url : '<%=request.getContextPath()%>/DetailImgTop6.ao',
                  			type : 'get',
                  			data : { gno : "<%= g.getGno() %>"},
                  			success : function(alist){
                  				console.log(alist);
                  				for(var i in alist){
                  				  var img = $($('.authOne')[0]).clone();
                  				  
                  				  img.find('img').attr('src', '/Goal_In/resources/authUploadFiles/' + alist[i].signcf); // alist i번째 부터 순서대로 바꿔주기
                  				  
                  				  $('#authImage').append(img); // 바뀐 이미지를 #authImage에 추가
                  				  
                  				  img.css('display', 'inline-block');
                  					
                  				}
                  			}
                  		});
                  	});
                  	
$(function(){
                  		
                  		
                  		$.ajax({
                  			url : '<%=request.getContextPath()%>/top3Review.bo',
                  			type : 'get',
                  			data : { gno : "<%=g.getGno()%>"},
                  			success : function(top3List){
                  				console.log(top3List);
                  				
                  				var $tab_content = $('.col-xl-3.col-md-4.col-lg-3.comment>.single_category')[0];
            				
            					for(var i in top3List) {
            						var html = //'<div>' + 
            			                       //'<ul>' + 
            			                       '<li>' + 
            			                       '<strong>'+ top3List[i].userId +'</strong>'+ '&nbsp;&nbsp;&nbsp;&nbsp;' + top3List[i].rContent +'<hr>' +
            			                       '</li>';  
            			                       //'</ul>' + 
            			                       //'</div>';
            			               console.log($('.col-xl-3.col-md-4.col-lg-3.comment>.single_category')[0]);
            	        			$tab_content.append($(html)[0]);
            					}
            				}
            			});
					 });
                  				
                  				<%--for(var i in top3List){
                  
                  				 /* 	$('.comment').text(top3List[i].rContent) */
                  					 /* 
                  					text.find('td').attr('src', "/Goal_In/reviews/updateReviews.bo/" + top3List[i].rContent);
                  					 */
                  					 console.log(top3List[i].rContent);
                  					$('#top3Review').append(top3List[i].userId);
                  					$('#top3Review').append(top3List[i].rContent);
                  					//$('#top3Review').append(top3List[i].rDate);// 바뀐 후기내용을 #top3Review에 추가
                  					
                  					/* text.css('display', 'inline-block');  */					
                  				}
                  			}
                  				
                  		});
                  	}); --%>
					

                  </script>
                  
               </div>

            </div>
            
         </div>
      </div>
   </section>
   <!--================ GoalDetail Area end =================-->
<% if( m != null ) {%>
   <div class="container modal fade" id="Joinform" tabindex="-1" role="dialog" aria-labelledby="loginForm" aria-hidden="true" 
    	style="scrollbar-width: none;">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54 modal-dialog">
            <div class="modal-content border-0">
                <form class="login100-form validate-form" action="/Goal_In/ij.jo">
                <input type="hidden" name="user_id" value="<%= m.getUserid() %>">
                <input type="hidden" name="gno" value="<%= g.getGno() %>">
                    <div class="modal-header border-0">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <span class="login100-form-title p-b-49">
                        참여하시겠어요?
                    </span>

                    <div class="wrap-input100 validate-input m-b-23">
                        <span class="label-input150" style="font-size:20px;"><%= g.getGoalname() %></span><br>
                        <span class="label-input100">현재 <%= g.getGcurrnum() %> / <%= g.getGmaxnum() %>명 참여 중</span><br>
                        <span class="label-input100">날짜 : <%= g.getStartdate() %> ~ <%= g.getEnddate() %></span><br>

                    </div>

                    <div class="wrap-input100 validate-input">
                        <span class="label-input150" style="font-size:20px;">투자할 포인트</span>
                        <input type="number" class="input100" name="point" max="<%= m.getBalance() %>" placeholder="10000원에서 1000000원까지 가능합니다" onchange="validate();">
                        <script>
                        	function validate(){
                        		if($('[name=point]').val() > <%= m.getBalance() %> || 
                        		   $('[name=point]').val() < 0) {
                        			alert("포인트 부족! 골을 등록하고싶음 포인트를 충전하세요.");
                        			location.href="<%=request.getContextPath()%>/pList.po";
                        		}
                        	}
                        	
                        	function insertLove(){
                        		location.href="<%=request.getContextPath()%>/il.lo?userid=<%= m.getUserid() %>&gno=<%= g.getGno() %>";
                        	}
                        	
                        </script>
                    </div>
                   <BR>
                    
                    <div class="container-login100-form-btn">
                        <div class="wrap-login100-form-btn">
                            <div class="login100-form-bgbtn"></div>
                            <button class="login100-form-btn">
                                도전하기
                            </button>
                        </div>
                        
                    </div>
  
                </form>
             </div>
        </div>
    </div>
  <% } %>
    
	
<%@ include file="/views/common/footer.jsp" %>