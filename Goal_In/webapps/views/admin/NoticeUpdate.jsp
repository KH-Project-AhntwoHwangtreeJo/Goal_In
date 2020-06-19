<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.semi.notice.model.vo.*"%>
<%
	ArrayList<notice> list = (ArrayList<notice>) request.getAttribute("list");
%>

<%
	notice n = (notice) request.getAttribute("notice");
%>

<!DOCTYPE html>
<html>
<link
	href="/Goal_In/resources/resource/vendors/datatables/dataTables.bootstrap.css"
	rel="stylesheet" media="screen">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- jQuery UI -->
<script src="https://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/Goal_In/resources/resource/bootstrap/js/bootstrap.min.js"></script>

<script
	src="/Goal_In/resources/resource/vendors/datatables/js/jquery.dataTables.min.js"></script>

<script
	src="/Goal_In/resources/resource/vendors/datatables/dataTables.bootstrap.js"></script>

<script src="/Goal_In/resources/resource/js/custom.js"></script>
<script src="/Goal_In/resources/resource/js/tables.js"></script>
<head>

<title>Goalin page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="/Goal_In/resources/resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- styles -->
<link href="/Goal_In/resources/resource/css/styles.css" rel="stylesheet">

<style>
.outer {
	width: 800px;
	height: 500px;
	background: black;
	color: white;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}

table {
	border: 1px solid white;
	text-align: left;
}

.tableArea {
	width: 650px;
	height: 350px;
	margin-left: auto;
	margin-right: auto;
}

.searchArea {
	width: 650px;
	margin-left: auto;
	margin-right: auto;
}
</style>

<%@ include file="/views/common/adminHeader.jsp"%>
<!--header-->
</head>
<body>

	<div class="page-content">
		<div class="row">
			<%@ include file="/views/common/adminMenu.jsp"%>

			<div class="col-md-10">
				<div class="content-box-large">
					<div class="panel-heading">
						<div class="panel-title"></div>
					</div>
					<div class="panel-body">


						<table class="table table-bordered">
							<thead>
							<caption>
								<h3>공지사항 수정</h3>
							</caption>
							</thead>
							<form id="updateForm" method="post">
								<tbody>
									<tr>
										<th>제목:</th>
										<td><input type="text" placeholder="제목을 입력하세요. "
											name="title" class="form-control"
											value="<%=n.getNtitle().replace("\"", "&#34;")%> "></td>
										<input type="hidden" name="nno" value="<%=n.getNno()%>">
									</tr>
									<td>작성자</td>
									<td><input type="text" value='관리자' name="userId" readonly>
									</td>
									<tr>

										<td>작성일</td>
										<td><input type="date" name="date"
											value="<%=n.getNdate()%>"></td>
									</tr>
									<tr>
										<th>내용</th>
										<td><textarea cols="10" placeholder="내용을 입력하세요. "
												name="content" class="form-control"><%=n.getNcontent()%></textarea></td>
									</tr>
									<tr>
										<td colspan="2">
											<button type="submit" onclick="complete();">수정완료</button>
											<button type="submit" onclick="deleteNotice();">삭제하기</button>
										</td>
									</tr>
								</tbody>
						</table>



					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
					function complete(){
						$("#updateForm").attr("action","<%=request.getContextPath()%>/nUpdate.no");
						
					}
						
					function deleteNotice(){
						// delete 는 예약어 이므로 deleteNotice 로 ...!
						$("#updateForm").attr("action","<%=request.getContextPath()%>/nDelete.no");
		}
	</script>



	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<footer>
		<div class="container">

			<div class="copy text-center">
				Copyright 2020 <a href='#'>Website</a>
			</div>

		</div>
	</footer>

</body>
</html>
