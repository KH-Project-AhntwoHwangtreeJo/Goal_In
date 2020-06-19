<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.semi.auth.model.vo.*, java.util.*"  %>
<% 
	ArrayList<Auth> alist = (ArrayList<Auth>)request.getAttribute("allalist"); 
	Auth a1 = (Auth)request.getAttribute("auth");
	/* Goal g = (Goal)request.getAttribute("goal"); */
	/* PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); */
%>

 <%@ include file="/views/common/header.jsp" %>
        <!-- header-end -->

            <div class="explorer_europe">  <!-- 골 목록-->
                <div class="container">
                    <div class="explorer_wrap">
                        <div class="row align-items-center">
                            <div class="col-xl-6 col-md-4">
                                <h3>GOAL-IN list</h3>
                            </div>
                            <div class="col-xl-6 col-md-8">
                                <div class="explorer_tab">
                                    
        
                                </div>
                            </div>
                        </div>
                    </div>
                    

                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                            <div class="row">
                            <% for(Auth a : alist){ %>
                            <!-- 게시글 하나 시작 -->
                                <div class="col-xl-4 col-lg-4 col-md-6">

                                    <div class="single_explorer">
                                    <input type="hidden" name="gno" value="<%= a.getGno() %>"/>
                                        <div class="thumb">
                                            <img src="/Goal_In/resources/authUploadFiles/<%= a.getSigncf() %>" alt="">
                                        </div>
                                        <div class="explorer_bottom d-flex">
                                        <input type="hidden" name="signnum" value="<%= a.getSignnum() %>"/>
                                            <div class="icon">
                                                <i class="flaticon-beach"></i>
                                            </div>
                                            <div class="explorer_info">
                                            <div style="display: inline-block;">
                                                <ul>
                                                   <li>아이디 : <%= a.getUserid() %> </li>
                                                    <li>등록 날짜 : <%= a.getSigndate() %></li>
                                                </ul>
                                                </div>
                                                <div style="display: inline-block;">
                                                
                                                <% if (m == null) {%>
                                       
                                                <button type="button" class="btn btn-danger " onclick="declaration();">신고하기</button>
                                               
                                              <% } else {%>
                                              <a href="<%= request.getContextPath() %>/aDeclaration.ao?userid=<%= m.getUserid() %>&signnum=<%= a.getSignnum() %>&gno=<%= a.getGno()%>">
                                                <button type="button" class="btn btn-danger ">신고하기</button>
                                                </a>
                                                  <% } %>
                                                
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                   </div>
                                <% } %>
                                <!-- 게시글 하나 끝 -->
                            </div>
                        </div>
                    </div>
         			
                </div>
            </div>
            <script>	
          		function declaration() {
          			alert("회원만 가능합니다 가입해!");
          			
          		}
          </script>
          
              <%@ include file="/views/common/footer.jsp" %>