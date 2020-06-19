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
<style>
.c {
	word-break: keep-all;
}
</style>
<!-- header-end -->

<div class="explorer_europe">
	<!-- 골 목록-->
	<div class="container">
		<div class="explorer_wrap">
			<div class="row align-items-center">
				<div class="col-xl-6 col-md-4">
					<br /> <br /> <br /> <br /> <br />
				</div>

			</div>
		</div>

		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
				aria-labelledby="nav-home-tab">
				<h2>후기 리스트</h2>

				<%
					for (Reviews a : Reviewslist) {
				%>
				<!-- 게시글 하나 시작 -->

				<div class="comments-area" type="text/css"
					style="margin-top: auto; , overflow: hidden; text-overflow: ellipsis;">

					<ul>
						<li>회원 아이디 : <%=a.getUserId()%></li>
						<br>
						<li>등록 날짜 : <%=a.getRDate()%></li>
						<br>
						<li style="overflow: hidden; , text-overflow: ellipsis;">
							작성내용 :
							<p class="c">
								<span> <%=a.getRContent()%>
								</span>
						</li>
					</ul>
				</div>
		<%
			}
		%>
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