<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.semi.reviews.model.vo.*, java.util.*"%>
<%
	ArrayList<Reviews> Reviewslist = (ArrayList<Reviews>) request.getAttribute("Reviewslist");
	Reviews a1 = (Reviews) request.getAttribute("Reviews");
	// Goal g1 = (Goal)request.getAttribute("goal");
	/* PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); */
%>

<%@ include file="/views/common/header.jsp"%>
<!-- header-end -->

<div class="explorer_europe">
	<!-- 골 목록-->
	<div class="container">
		<div class="explorer_wrap">
			<div class="row align-items-center">
				<div class="col-xl-6 col-md-4">
					<h3>GOAL-IN list</h3>
				</div>
				<div class="col-xl-6 col-md-8">
					<div class="explorer_tab"></div>
				</div>
			</div>
		</div>


		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
				aria-labelledby="nav-home-tab">
				<div class="row">
					<%
						for (Reviews a : Reviewslist) {
					%>
					<!-- 게시글 하나 시작 -->
					<div class="col-xl-4 col-lg-4 col-md-6">

						<div class="single_explorer">
							<input type="hidden" name="gno" value="<%=a.getGno()%>" />
							<div class="thumb"></div>
							<div class="explorer_bottom d-flex">

								<div class="icon">
									<i class="flaticon-beach"></i>
								</div>
								<div class="explorer_info">
									<div style="display: inline-block;">
										<ul>
											<li>회원 아이디 : <%=a.getUserId()%></li>
											<li>등록 날짜 : <%=a.getRDate()%></li>
											<li>작성내용 : <%=a.getRDate()%></li>
										</ul>
									</div>

								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>
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

<%@ include file="/views/common/footer.jsp"%>