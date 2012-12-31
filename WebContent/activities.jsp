<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Activities - SVRPlatform</title>
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
		<br>
		<div class="bugvultext" align="center">
		<div class="commentstitle" style="font-size:20px; font-weight:bold">
		
		SVRPlatform Carnival！！！
		</div>
		<br><br><br>
		<div class="commentstext">
		Hack this site with your 1337 ability.<br><br>
		Send your Proof Of Concept email to <a href="mailto:svrplatform@gmail.com">svrplatform@gmail.com</a> to win your prize.<br>
		<br><br>
		The NBGroup
		
		</div>
		</div>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
