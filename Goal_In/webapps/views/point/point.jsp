<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.*, com.semi.point.model.vo.*, java.util.*,com.semi.join.model.vo.*, com.semi.goal.model.vo.*"%>
    
<%
	ArrayList<Point> list = (ArrayList<Point>) request.getAttribute("list");
	ArrayList<GetPoint> pList = (ArrayList<GetPoint>) request.getAttribute("plist");
	PageInfo upi = (PageInfo)request.getAttribute("upi");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
    
<%@ include file="/views/common/header.jsp" %>


    
 <div class="explorer_europe list_wrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget mx-auto text-center">

                                <div class="form-group">
                                
                                    <div class="input-group mb-3">
                                        <img src="/Goal_In/resources/memberImg/user01.jpg" class="mx-auto text-center rounded-circle" >
                    
                                    </div>
                                    
                                    <div>
                                    	<span style="line-height: 4;"><strong>닉네임</strong></span><br>
                                    	<span style="line-height: 4;"><strong>잔여포인트</strong></span><br>
                                    	<span style="line-height: 4;"><strong>참여중인 골 갯수</strong></span><br>
                                    	
                                    </div>
                                </div>
                        </aside>
						
                        <aside class="single_sidebar_widget post_category_widget">
                            
                            <ul class="list cat-list">
                                 <li>
                                    <a href="<%=request.getContextPath()%>/myJoin.jo?userid=<%= m.getUserid() %>" class="d-flex">
                                        <p >참여중인 골</p>
                                        
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/pList.po" class="d-flex">
                                        <p>포인트 내역</p>
                                        
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>리뷰 관리</p>
                                       
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>개인정보 수정 / 탈퇴</p>
                                        
                                    </a>
                                </li>
                            </ul>
                        </aside>

                        
                    </div>
                </div>
                <div class="col-xl-8 col-lg-8">
				<h3 class="exp_title"  style="margin-bottom:10px">
					<strong>포인트 사용 내역</strong>
					<!-- <button class="btn btn-danger" style="margin-left:450px" onclick="chargBtn()">포인트 충전하기</button> -->
				</h3>
				<div></div>
				<div class="row">


					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>골번호</th>
								<th>성공여부</th>
								<th>참여한 골 날짜</th>
								<th>참여한 골 포인트</th>
								<th>활성화여부</th>
								<th>비율</th>
								<th>합계</th>
								<th>개이득</th>
							</tr>
						</thead>
						<tbody>
							<% if (pList != null ) { %>
							<% for(GetPoint gp : pList){ %>
							<tr>
								
								<td><%= gp.getGno() %></td>
								<td><%= gp.getmYn() %></td>
								<td><%= gp.getmDate() %></td>
								<td><%= gp.getmPoint() %></td>
								<td><%= gp.getjStatus() %></td>
								<td><%= gp.getRatio() %></td>
								<td><%= gp.getCalc() %></td>
								<td><%= gp.getErn() %></td>

							</tr>
							<% } } else { %>
								<tr>
									<td colspan="4">
										<h3>아직 참가한 골이 없습니다.<br>
										지금 바로 골에 참가해보세요! <br>
										<button class="btn btn-primary" type="button" onclick="goGoal();">골에 참가하러 가기</button></h3>
										<script>
											function goGoal(){
												location.href="/Goal_In/views/goal/goalAllList.jsp";
											}
										</script>
									</td>
								</tr>
							<% } %>			
						</tbody>
					</table>
				</div>
				
				<div class="row">
					<!-- <div class="col-4"></div> -->
					<div class="col-12">
						<div class="page_nation text-center">
							<ul>
							<%  if(upi.getCurrentPage() <= 1){  %>
								<li><a href="#"> <i class="ti-angle-left"></i>
								</a></li>
								<%  }else{ %>
								<li><a href="<%= request.getContextPath() %>/pList.po?currentPage2=<%=upi.getCurrentPage() - 1 %>&currentPage=<%= pi.getCurrentPage() %>"> <i class="ti-angle-left"></i>
								</a></li>
								<%  } %>
								<% for(int p = upi.getStartPage(); p <= upi.getEndPage(); p++){
										if(p == upi.getCurrentPage()){	
								%>
									<li><a href="#"><%= p %></a></li>
								<%      }else{ %>
									<li><a href="<%= request.getContextPath() %>/pList.po?currentPage2=<%= p %>&currentPage=<%= pi.getCurrentPage() %>"><%= p %></a></li>
								<%      } %>
								<% } %>
							<%  if(upi.getCurrentPage() >= upi.getMaxPage() ){  %>
								<li><a href="#"> <i class="ti-angle-right"></i>
								</a></li>
								<%  }else{ %>
								<li><a href="<%= request.getContextPath() %>/pList.po?currentPag2e=<%=upi.getCurrentPage() + 1 %>&currentPage=<%= pi.getCurrentPage() %>"> <i class="ti-angle-right"></i>
								</a></li>
								<%  } %>
								
							</ul>
						</div>
					</div>
				</div>
				
				<h3 class="exp_title"  style="margin-bottom:10px">
					<strong>포인트 충전 내역</strong>
					<button class="btn btn-danger" style="margin-left:450px" onclick="chargBtn()">포인트 충전하기</button>
				</h3>
				<div></div>
				<div class="row">


					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>충전날짜</th>
								<th>충전 금액</th>
								<th>결제수단</th>
								<th>잔액 포인트</th>
							</tr>
						</thead>
						<tbody>
						<% if (list != null ) { %>
							<% for(Point p : list){ %>
							<tr>
								<td><%= p.getPaydate() %></td>
								<td><%= p.getPrice() %></td>
								<td><%= p.getMethod() %></td>
								<td><%= p.getpBalance() %></td>

							</tr>
							<% } } else { %>
								<tr>
									<td colspan="4">
										<h3>아직 결제 내역이 없습니다.<br>
										지금 바로 결제해 보세요! <br>
										<button class="btn btn-primary" type="button" onclick="goPay();">포인트 구매하러 가기</button></h3>
										<script>
											function goPay(){
												location.href="/Goal_In/views/iamport/pay.jsp";
											}
										</script>
									</td>
								</tr>
							<% } %>							
						</tbody>
					</table>
				</div>
				
				
				<div class="row">
					<!-- <div class="col-4"></div> -->
					<div class="col-12">
						<div class="page_nation text-center">
							<ul>
							<%  if(pi.getCurrentPage() <= 1){  %>
								<li><a href="#"> <i class="ti-angle-left"></i>
								</a></li>
								<%  }else{ %>
								<li><a href="<%= request.getContextPath() %>/pList.po?currentPage=<%=pi.getCurrentPage() - 1 %>&currentPage2=<%= upi.getCurrentPage() %>"> <i class="ti-angle-left"></i>
								</a></li>
								<%  } %>
								<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){
										if(p == pi.getCurrentPage()){	
								%>
									<li><a href="#"><%= p %></a></li>
								<%      }else{ %>
									<li><a href="<%= request.getContextPath() %>/pList.po?currentPage=<%= p %>&currentPage2=<%= upi.getCurrentPage() %>"><%= p %></a></li>
								<%      } %>
								<% } %>
							<%  if(pi.getCurrentPage() >= pi.getMaxPage() ){  %>
								<li><a href="#"> <i class="ti-angle-right"></i>
								</a></li>
								<%  }else{ %>
								<li><a href="<%= request.getContextPath() %>/pList.po?currentPage=<%=pi.getCurrentPage() + 1 %>&currentPage2=<%= upi.getCurrentPage() %>"> <i class="ti-angle-right"></i>
								</a></li>
								<%  } %>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
          </div>
        </div>
    </div>
    
    <script>
    	function chargBtn() {
    		location.href="/Goal_In/views/iamport/pay.jsp";
    	}
    </script>
 

<%@ include file="/views/common/footer.jsp" %>