<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.*, com.semi.goal.model.vo.*, java.util.*, com.semi.love.model.vo.*"%>
    
<%@ include file="/views/common/header.jsp" %>

<%
	ArrayList<Love> list = (ArrayList<Love>)request.getAttribute("list"); 
	ArrayList<Goal> glist = (ArrayList<Goal>)request.getAttribute("glist"); 

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
                <div class="col-xl-8 col-lg-8">
                        <h3 class="exp_title">관심가진 골</h3>
                        <div class="row">
                        
                         	<% for (Goal g : glist) { %>
                         	<% for (Love l : list) { %>
                         	<% if( l.getGno() == g.getGno()) { %>
                                <div class="col-xl-6 col-lg-6 col-md-6" id="love-<%= g.getGno() %>">
                                    <div class="single_explorer">
                                        <div class="thumb">
                                        	<a href="<%=request.getContextPath()%>/gsol.go?gno=<%=  g.getGno()%>">
                                            	<img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
                                            </a>
                                        </div>
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><%= g.getGoalname() %></h3>
                                                
                                                <ul>
                                                    <li> 
                                                        	<%= g.getStartdate() %> ~ <%= g.getEnddate() %>
                                                    </li>
                                                    <li>
                                                    <button type="button" class="genric-btn success-border circle small" id="love" onclick="deleteLove(<%= g.getGno() %>);">
														관심 끄기
                                                    </button>
                                                    </li> 
    
                                                </ul>
                                            </div>
                                        </div>
		                                </div>
                                    </div>
                               <% } } } %>
                               <script>
                               function deleteLove(gno){
                            	   $.ajax({
                            		   url: "<%= request.getContextPath() %>/dl.lo",
                            		   data : {
                            			   userId : '<%= m.getUserid() %>',
                            			   gno : gno
                            		   }, success: function(data){
                            			   alert("좋아요 취소 완료!");
                            			   $('#love-'+gno).remove();
                            		   }
                            	   });
                               }
                               </script>
                             
                            </div>
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="page_nation text-center">
                                <ul>
                                    <li>
                                        <a href="#">01</a>
                                    </li>
                                    <li>
                                        <a href="#">02</a>
                                    </li>
                                    <li>
                                        <a href="#">03</a>
                                    </li>
                                    <li>
                                        <a href="#"> <i class="ti-angle-right"></i> </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
 

<%@ include file="/views/common/footer.jsp" %>