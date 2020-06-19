<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.semi.goal.model.vo.*"%>
<%
	ArrayList<Goal> list = (ArrayList<Goal>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<title>Goalin page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="/Goal_In/resources/resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- styles -->
<link href="/Goal_In/resources/resource/css/styles.css" rel="stylesheet">

		<style>
@charset "UTF-8";

.switch {
	position: relative;
	display: inine-block;
	width: 60px;
	height: 34px;
}

.switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.slider:before {
	position: absolute;
	content: "";
	height: 26px;
	width: 26px;
	left: 4px;
	bottom: 4px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #2196f3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196f3;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px);
	-ms-transform: translateX(26px);
	transform: translateX(26px);
}

.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}
</style>
<%@ include file="/views/common/adminHeader.jsp" %>

	<div class="page-content">
		<div class="row">
			<%@ include file="/views/common/adminMenu.jsp" %>


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
								<th>골번호</th>
								<th>골카테고리</th>
								<th>골 이름</th>
								<th>골 소개글</th>
								<th>골 목표</th>
								<th>수용 인원</th>
								<th>활성화 여부</th>
							</tr>
						</thead>


						<tbody>
							<%
								for (Goal n : list) {
							%>
							<tr>
								<td><%=n.getGno()%></td>
								<td><%=n.getGcategory()%></td>
								<td><%=n.getGoalname()%></td>
								<td><%=n.getGcontent()%></td>
								<td><%=n.getGoalinone()%></td>
								<td><%=n.getGmaxnum()%></td>
								<td><label class="switch"> <input type="checkbox"
										onclick="togglee(this)"
										<%=n.getGstatus().equals("Y") ? "checked" : ""%> /> <span
										class="slider round"></span>
								</label></td>


							</tr>
							<%
								}
							%>
						</tbody>
					</table>
						<script>
						function togglee(obj) {

							var str = ""
							var tdArr = new Array();
							
							var tr = $(obj).parent().parent().parent();
							var td = tr.children();
							
							var no = td.eq(0).text();
							console.log(no + " : " + $(obj).prop('checked'));
							$.ajax({
								url : "GoalStatus.do",
								data : {
									Gno : no,
									status : $(obj).prop('checked')
								}, success : function(data){
									console.log(data);
									if( data > 0 ){										
										console.log("회원 활성성화 상태 변경 완료");
									}  else {
										console.log("변경 실패");
									}
								}
							});
						};
					</script>
					
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
				Copyright 2014 <a href='#'>Website</a>
			</div>

		</div>
	</footer>

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
</body>
</html>