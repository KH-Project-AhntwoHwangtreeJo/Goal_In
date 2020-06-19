<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.*, com.semi.goal.model.vo.*, java.util.*, com.semi.join.model.vo.*"%>
    
<%@ include file="/views/common/header.jsp" %>

<%
	ArrayList<Join> list = (ArrayList<Join>)request.getAttribute("list"); 
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
                        <h3 class="exp_title">참여중인 골</h3>
                        <div class="row">
                        
                         	<% for (Goal g : glist) { %>
                         	<% for (Join j : list) { %>
                         	<% if( j.getGno() == g.getGno()) { %>
                                <div class="col-xl-6 col-lg-6 col-md-6">
                                    <div class="single_explorer">
										<% if (g.getGimg()==null) { %>
                                     <div class="thumb">
	                                        <a href="<%=request.getContextPath()%>/gsol.go?gno=<%=  g.getGno()%>">
	                                            <img src="/Goal_In/resources/img/업로드.JPG" alt="">
	                                        </a>
                                        </div>
                                        <% }else{ %>
										<div class="thumb">
	                                        <a href="<%=request.getContextPath()%>/gsol.go?gno=<%=  g.getGno()%>">
	                                            <img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
	                                        </a>
                                        </div>
                                        <% } %>
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><a href="single_listings.html"><%= g.getGoalname() %></a></h3>
                                                <p>투자 포인트 : <span style="font-weight : 600;"><%= j.getMpoint() %></span></p>
                                                <ul>
                                                    <li> 
                                                        	<%= g.getStartdate() %> ~ <%= g.getEnddate() %></li><br>  
                                                    <li>
	                                                    <a href="/Goal_In/views/auth/auth.jsp?gno=<%= j.getGno() %>&userid=<%=m.getUserid() %>" class="genric-btn danger circle small">인증하기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                                                    <a href="<%=request.getContextPath()%>/joinCancel.jo?userid=<%= m.getUserid() %>&gno=<%= g.getGno() %>" 
	                                                    class="genric-btn success-border circle small">참여취소</a>
	                                                  
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                               <% } } } %>
                             
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