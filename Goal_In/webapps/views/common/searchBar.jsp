<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    import="com.semi.member.model.vo.*" %>
   
<!doctype html>
<!-- slider_area_start -->
    <div class="slider_area">
        <div class="single_slider  d-flex align-items-center slider_bg_1" style="height:650px;">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-xl-10">
                        <div class="slider_text text-center justify-content-center">
                            <p>Goal-In</p>
                            <h3>Goal Our Attainment Louder In Nearby</h3>
                            <div class="text" style="margin-bottom: 20px;">
                                <a style="color: white; margin-bottom: 10px;">가까운 곳에서 더 큰 소리로 목표를 달성해보세요</a>
                            </div>
                            <div class="search_form">
                                <form action="<%=request.getContextPath()%>/searchGoal.go" id="searchForm" method="get">
                                    <div class="row align-items-center">
                                        <div class="col-xl-9 col-md-8">
                                            <div class="input_field">
                                                <input type="text" id="keyword" name="keyword" placeholder="What's your Goal?  당신의 목표는 무엇인가요?">
                                            </div>
                                        </div>
                                        <div class="col-xl-3 col-md-4">
                                            <div class="button_search">
                                                <button class="boxed-btn2" type="submit">Search</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="quality">
                                <ul>
                                    <li>
                                        <button name="keyword" type="button" onclick="btnTitle(this)">유산소</button>
                                    </li>                               
                                    <li>                                  
                                        <button name="keyword" type="button" onclick="btnTitle(this)">식단</button>
                                    </li>                              
                                    <li>                               
                                        <button name="keyword" type="button" onclick="btnTitle(this)">스트레칭</button>
                                    </li>                      
                                    <li>                            
                                        <button name="keyword" type="button" onclick="btnTitle(this)">웨이트</button>
                                    </li>                            
                                    <li>                             
                                        <button name="keyword" type="button" onclick="btnTitle(this)">생활습관</button>
                                    </li>                        
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
       function btnTitle(obj) {
         //$('#keyword').val($(obj).text()).on('click', function() {
         //    $('.boxed-btn2').click();
         //    
         //});
          
          $('#keyword').val($(obj).text());
          $('#searchForm').submit();
			<%-- location.href="<%=request.getContextPath()%>/goalList.go; --%>
         // $('#nav-profile-tab').click();
       }   
    </script>