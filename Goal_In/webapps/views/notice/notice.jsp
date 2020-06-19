<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.notice.model.vo.*, java.util.*"%>
<% 
   ArrayList<notice> list = (ArrayList<notice>)request.getAttribute("list"); 
%>
 <%@ include file="/views/common/header.jsp" %>


    <!-- slider_area_end -->
    <section class="sample-text-area">
    <div class="section-top-border">
        <div class="row">
            <div class="col-lg-8 col-md-8 mx-auto">
                <table class="table table-hover" id="noticeList"> <!-- style="text-align:center" -->
                    <thead>
                    
                      <tr>
                        <th scope="col">No</th>
                        <th scope="col">제목</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col">작성일</th>
                         <th scope="col">조회수</th>
                      </tr>
                    </thead>

                    <% for(notice n : list){ %>

                    	<tr>
                        <th scope="row"><%= n.getNno() %></th>
                        <td colspan="5">
                            <%= n.getNtitle() %>
                        </td>
                        <td> <%= n.getNdate() %></td>
                        <td> <%= n.getNcount()%></td>
                      </tr>
                      
                      <% } %>
                  </table>
				<br /><br /><br />
                  <nav aria-label="...">
                    <ul class="pagination justify-content-center">
                      <li class="page-item disabled">
                        <span class="page-link">Previous</span>
                      </li>
                      <li class="page-item active"><a class="page-link" href="#">1</a></li>
                      <li class="page-item" aria-current="page">
                        <span class="page-link">
                          2
                          <span class="sr-only">(current)</span>
                        </span>
                      </li>
                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                      <li class="page-item"><a class="page-link" href="#">4</a></li>
                      <li class="page-item"><a class="page-link" href="#">5</a></li>
                      <li class="page-item"><a class="page-link" href="#">6</a></li>
                      <li class="page-item"><a class="page-link" href="#">7</a></li>
                      <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                      </li>
                    </ul>
                  </nav>
            </div>
            
        </div>
    </div>
</section>
	<script>
		$(function(){
			$("#noticeList td").click(function(){
				var nno = $(this).parent().children().eq(0).text();
				location.href="<%=request.getContextPath()%>/selectOne.no?nno=" + nno;
			});
		});
	</script>
 <%@ include file="/views/common/footer.jsp" %>