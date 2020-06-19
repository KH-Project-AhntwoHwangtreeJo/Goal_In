<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.semi.notice.model.vo.*"%>
<%
	ArrayList<notice> list = (ArrayList<notice>) request.getAttribute("list");
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
	text-align: center;
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


					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>글번호</th>
								<th>글제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (notice a : list) {
							%>
							<tr id="hover">
								<td><%=a.getNno()%></td>
								<td><%=a.getNtitle()%></td>
								<td><%=a.getNwriter()%></td>
								<td><%=a.getNdate()%></td>
								<td><%=a.getNcount()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				<script>
			$(function(){
			
			$("#example td").click(function(){
				//console.log($(this).parent().children().eq(0).text());
				var nno = $(this).parent().children().eq(0).text();
				location.href="/Goal_In/adminSelectOne.no?nno="+ nno;
				});
					});
				</script>
				
					<button onclick="location.href='views/admin/NoticeInsertForm.jsp'">작성하기</button>
				</div>
			</div>
		</div>
	</div>
</div>




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