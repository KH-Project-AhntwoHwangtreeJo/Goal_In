<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.semi.goal.model.vo.*, java.util.*"  %>

<% 
	ArrayList<Goal> list = (ArrayList<Goal>)request.getAttribute("list"); 
	/* PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); */
%>

 <%@ include file="/views/common/header.jsp" %>
        <!-- header-end -->
    <!-- slider_area_start -->
   
    <%@ include file="/views/common/searchBar.jsp" %>
    
    <!-- slider_area_end -->
        
        
            <div class="explorer_europe">  <!-- 골 목록-->
                <div class="container">
                    <div class="explorer_wrap">
                        <div class="row align-items-center">
                            <div class="col-xl-6 col-md-4">
                                <h3>GOAL-IN list</h3>
                            </div>
                            <div class="col-xl-6 col-md-8">
                                <div class="explorer_tab">
                                    <nav>
                                        <div class="nav" id="nav-tab" role="tablist" style="width : 600px;">
                                            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab"
                                                href="#nav-home" role="tab" aria-controls="nav-home"
                                                aria-selected="true">전체 리스트</a>
                                            <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
                                                href="#nav-profile" role="tab" aria-controls="nav-profile"
                                                aria-selected="false">식단</a>
                                            <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
                                                href="#nav-contact" role="tab" aria-controls="nav-contact"
                                                aria-selected="false">유산소</a>
                                            <a class="nav-item nav-link" id="nav-contact-tab2" data-toggle="tab"
                                                href="#nav-contact2" role="tab" aria-controls="nav-contact"
                                                aria-selected="false">웨이트</a>
                                            <a class="nav-item nav-link" id="nav-contact-tab3" data-toggle="tab"
                                                href="#nav-contact3" role="tab" aria-controls="nav-contact"
                                                aria-selected="false">스트레칭</a>
                                            <a class="nav-item nav-link" id="nav-contact-tab4" data-toggle="tab"
                                                href="#nav-contact4" role="tab" aria-controls="nav-contact"
                                                aria-selected="false">생활습관</a>
                                        </div>
                                    </nav>
        
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                            <div class="row">
                            <% for(Goal g : list){ %>
                            <!-- 게시글 하나 시작 -->
                            
                                <div class="col-xl-4 col-lg-4 col-md-6">
                               <a href="<%=request.getContextPath()%>/gsol.go?gno=<%=g.getGno()%>">
                                
                                
                                    <div class="single_explorer">
                                   <input type="hidden" name="gno" value="<%= g.getGno() %>"/>
                                        <% if (g.getGimg() == null) { %>
                                   		<div class="thumb">
                                            <img src="/Goal_In/resources/img/업로드.JPG" alt="">
                                        </div>
                                        <% }else{ %>
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
                                        </div>
                                        <% } %>
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><%= g.getGoalname() %></h3>
                                                <p> 목표 : <%= g.getGoalinone() %> </p>
                                                <ul>
                                                   <li>누적포인트 : <%= g.getGspoint() %> </li>
                                                    <li><%= g.getStartdate() %> ~ <%= g.getEnddate() %></li>
                                                    <li>인원 현황 : <%= g.getGcurrnum() %> / <%= g.getGmaxnum() %></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                   </a> 
                                    </div>

                      
                                
                                <% } %>
                                <!-- 게시글 하나 끝 -->
                            </div>
                        </div>
                        
                        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                            <div class="row">
                            	<% for(Goal g : list){ %>
                            	<% if(g.getGcategory().equals("식단")) { %>
                            <!-- 게시글 하나 시작 -->
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="single_explorer">
                                    <input type="hidden" value="<%= g.getGno() %>"/>
                                        <% if (g.getGimg() == null) { %>
                                   		<div class="thumb">
                                            <img src="/Goal_In/resources/img/업로드.JPG" alt="">
                                        </div>
                                        <% }else{ %>
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
                                        </div>
                                        <% } %>
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><%= g.getGoalname() %></h3>
                                                <p> 목표 : <%= g.getGoalinone() %> </p>
                                                <ul>
                                                   <li>누적포인트 : <%= g.getGspoint() %> </li>
                                                    <li><%= g.getStartdate() %> ~ <%= g.getEnddate() %></li>
                                                    <li>인원 현황 : <%= g.getGcurrnum() %> / <%= g.getGmaxnum() %></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%} } %>
                                <!-- 게시글 하나 끝 -->
                            </div>
                        </div>
                        
                        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                            <div class="row">
                                <% for(Goal g : list){ %>
                            	<% if(g.getGcategory().equals("유산소")) { %>
                            <!-- 게시글 하나 시작 -->
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="single_explorer">
                                    <input type="hidden" value="<%= g.getGno() %>"/>
                                        <% if (g.getGimg() == null) { %>
                                   		<div class="thumb">
                                            <img src="/Goal_In/resources/img/업로드.JPG" alt="">
                                        </div>
                                        <% }else{ %>
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
                                        </div>
                                        <% } %>                                        
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><%= g.getGoalname() %></h3>
                                                <p> 목표 : <%= g.getGoalinone() %> </p>
                                                <ul>
                                                   <li>누적포인트 : <%= g.getGspoint() %> </li>
                                                    <li><%= g.getStartdate() %> ~ <%= g.getEnddate() %></li>
                                                    <li>인원 현황 : <%= g.getGcurrnum() %> / <%= g.getGmaxnum() %></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%} } %>
                                <!-- 게시글 하나 끝 -->
                            
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-contact2" role="tabpanel" aria-labelledby="nav-contact-tab2">
                            <div class="row">
                                <% for(Goal g : list){ %>
                            	<% if(g.getGcategory().equals("웨이트")) { %>
                            <!-- 게시글 하나 시작 -->
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="single_explorer">
                                    <input type="hidden" value="<%= g.getGno() %>"/>
                                        <% if (g.getGimg() == null) { %>
                                   		<div class="thumb">
                                            <img src="/Goal_In/resources/img/업로드.JPG" alt="">
                                        </div>
                                        <% }else{ %>
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
                                        </div>
                                        <% } %>
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><%= g.getGoalname() %></h3>
                                                <p> 목표 : <%= g.getGoalinone() %> </p>
                                                <ul>
                                                   <li>누적포인트 : <%= g.getGspoint() %> </li>
                                                    <li><%= g.getStartdate() %> ~ <%= g.getEnddate() %></li>
                                                    <li>인원 현황 : <%= g.getGcurrnum() %> / <%= g.getGmaxnum() %></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%} } %>
                                <!-- 게시글 하나 끝 -->
                            </div>
                        </div>
                        
                        <div class="tab-pane fade" id="nav-contact3" role="tabpanel" aria-labelledby="nav-contact-tab3">
                            <div class="row">
                                <% for(Goal g : list){ %>
                            	<% if(g.getGcategory().equals("스트레칭")) { %>
                            <!-- 게시글 하나 시작 -->
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="single_explorer">
                                    <input type="hidden" value="<%= g.getGno() %>"/>
                                        <% if (g.getGimg() == null) { %>
                                   		<div class="thumb">
                                            <img src="/Goal_In/resources/img/업로드.JPG" alt="">
                                        </div>
                                        <% }else{ %>
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
                                        </div>
                                        <% } %>
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><%= g.getGoalname() %></h3>
                                                <p> 목표 : <%= g.getGoalinone() %> </p>
                                                <ul>
                                                   <li>누적포인트 : <%= g.getGspoint() %> </li>
                                                    <li><%= g.getStartdate() %> ~ <%= g.getEnddate() %></li>
                                                    <li>인원 현황 : <%= g.getGcurrnum() %> / <%= g.getGmaxnum() %></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%} } %>
                                <!-- 게시글 하나 끝 -->
                                
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-contact4" role="tabpanel" aria-labelledby="nav-contact-tab4">
                            <div class="row">
                                <% for(Goal g : list){ %>
                            	<% if(g.getGcategory().equals("생활습관")) { %>
                            <!-- 게시글 하나 시작 -->
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="single_explorer">
                                    <input type="hidden" value="<%= g.getGno() %>"/>
                                        <% if (g.getGimg() == null) { %>
                                   		<div class="thumb">
                                            <img src="/Goal_In/resources/img/업로드.JPG" alt="">
                                        </div>
                                        <% }else{ %>
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/enrollFiles/<%= g.getGimg() %>" alt="">
                                        </div>
                                        <% } %>
                                        <div class="explorer_bottom d-flex">
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                                <h3><%= g.getGoalname() %></h3>
                                                <p> 목표 : <%= g.getGoalinone() %> </p>
                                                <ul>
                                                   <li>누적포인트 : <%= g.getGspoint() %> </li>
                                                    <li><%= g.getStartdate() %> ~ <%= g.getEnddate() %></li>
                                                    <li>인원 현황 : <%= g.getGcurrnum() %> / <%= g.getGmaxnum() %></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%} } %>
                                <!-- 게시글 하나 끝 -->
                            </div>
                        </div>
                    </div>
        
                </div>
            </div>


              
              
              <%@ include file="/views/common/footer.jsp" %>