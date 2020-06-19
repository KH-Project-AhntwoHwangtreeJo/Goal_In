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
							<caption><h2>공지사항 작성하기<h2></caption>
							</thead>
							<tbody>
								<form action="<%=request.getContextPath()%>/nInsert.no"
									method="post">
									<tr>
										<th><h5>제목</h5></th>
										<td><input type="text" placeholder="제목을 입력하세요. "
											name="title" class="form-control" /></td>
									</tr>
									<th><h5>작성자</h5></th>
									 <td> <input type="text" value="admin" name="userId"  readonly="readonly"></td>
									<tr>

										<th><h5>작성일</h5></th>
										<td><input type="date" name="date"  style="padding-left:50px"></td>
									</tr>
									<tr>
										<th><h5>내용</h5></th>
										<td><textarea style="resize: none" cols=60 
												placeholder="내용을 입력하세요. "name="content"
												class="form-control" >	</textarea></td>
									</tr>
									<tr>
										<td colspan="2"><button type="submit">등록하기</button>
								</form>

								<button onclick="location.href='/Goal_In/NselectList.no'">취소하기</button>

								</tr>
							</tbody>
						</table>



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