<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Ranking - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>
	<%
	
	String str = (String) session.getAttribute("email");
	if (str != null){
		str = "signedin";
	}
	
	%>
 		<jsp:include page="WEB-INF/header.jsp" flush="true">
 			<jsp:param name="type" value="<%=str%>"/>
 		</jsp:include>
	<div id="content">
		Vulnerability Ranking Page. <br>
		大家加油编程啊！<br>
		<a href="trysubmitvulnerability">上传vulnerability试试。</a><br>
		<br>
		<a href="vulnerabilitypage?strVulnerabilityNumber=SVRV-2012-00000001">1号vulnerability。</a><br>
		<br>
		<p>你的userID是：
		<%
		out.println(VerifyUser.getNowUserID(request));
		
		%>
		</p>
		<p>你的useremail是：
		<%
		
		out.println(VerifyUser.getNowUser(request));
		%>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
