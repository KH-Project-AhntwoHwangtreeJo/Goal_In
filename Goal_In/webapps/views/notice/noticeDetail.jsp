<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.notice.model.vo.*"%>
    
<%
	notice n = (notice)request.getAttribute("notice");
%>
 <%@ include file="/views/common/header.jsp" %>
 <style>
	.outer{
		width:800px;
		height:500px;
		background:#001D38;
		color:lightgoldenrodyellow;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
		border-radius : 20px;
		padding-top:20px;
	}
	
		.tableArea {
		background:white;
		width:650px;
		height:350px;
		margin:auto;
		border-radius : 15px;
		padding: 20px;
	}
	
	.table {
		width: 600px;
		padding: 20px;
		color: black;
		border:1px solid black;
		border-right:1px solid black;
	}
	
	#tableborder {
		border-top: 1px solid black;
		border-right: 1px solid #E2E2E2;
		border-left: 1px solid black;
		border-bottom: 1px solid #E2E2E2
		
	}
	
	#tablecontan {
		border-bottom: 1px solid black;
	}
	
	#tabletitle {
		border-top: 1px solid black;
		border-right : 1px solid black;
		border-bottom: 1px solid #E2E2E2;
	}
	
	#tabledate {
		border-right : 1px solid black;
		border-bottom: 1px solid #E2E2E2;
	}
	#yogi {
		border-right : 1px solid black;
	}

	span {
		font-size:15pt;
		background: black;
		color: white;
	}
</style>
<br /><br /><br /><br /><br /><br /><br />
<title>공지 사항 내용</title>
</head>
<body>
	<div class="outer">
		<br>
		<h2 align="center">공지 사항 내용</h2>
		<div class="tableArea">
				<table class="table">
					<tr>
						<td id="tableborder">제목 : </td>
						<td colspan="3" id="tabletitle"><%= n.getNtitle() %></td>
					</tr>
					<tr>
						<td id="tableborder">작성자 :</td>
						<td id="tableborder">
							<%= n.getNwriter() %>
						</td>
						<td id="tableborder">작성일 : </td>
						<td id="tabledate"><%= n.getNdate() %></td>
					</tr>
					<tr>
						<td colspan="4" id="tablebordercontan" >내용 </td>
					</tr>
					<tr>
						<td colspan="4" id="tablecontan"><br>
							<span ><%= n.getNcontent().charAt(0) %></span><%= n.getNcontent().substring(1) %>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					
					<button onclick="location.href='unls.no'">메뉴로 돌아가기</button>
					
					
				</div>
		</div>
	</div>
 <br /><br /><br /><br />
 
 
 <%@ include file="/views/common/footer.jsp" %>