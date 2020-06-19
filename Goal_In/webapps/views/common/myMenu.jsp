<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<aside class="single_sidebar_widget post_category_widget">
                            
                            <ul class="list cat-list">
                                <li>
                                    <a href="<%=request.getContextPath()%>/myJoin.jo?userid=<%= m.getUserid() %>"  class="d-flex"> 참여중인 골</a>
                                  
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/myLove.lo?userid=<%= m.getUserid() %>"  class="d-flex"> 관심가진 골</a>
                                  
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/pList.po" class="d-flex">
                                        <p>포인트 내역</p>
                                        
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/selectReviews.bo?userId=<%= m.getUserid() %>" class="d-flex">
                                        <p>리뷰 관리</p>
                                       
                                    </a>
                                </li>
                                <li>
                                    <a href="/Goal_In/views/member/memberUpdateForm.jsp" class="d-flex">
                                        <p>개인정보 수정 / 탈퇴</p>
                                        
                                    </a>
                                </li>
                               
                            </ul>
                        </aside>