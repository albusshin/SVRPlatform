<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Home - SVRPlatform</title>
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
		Hello, Tourist. Please sign in our platform. <br>
		Here, you can join us watching Gousheng and MB Zhou getting married and divorced again and again, which is a great joy to experience. <br>
		And you can black Gousheng and black Shaoye for fun. <br>
		Do not hesitate and <a href="signup.jsp">Join us!</a>	
		<br><br>
		OR, you've already had an account on the platform, please don't fuck with me and <a href="signin.jsp">SIGN IN</a>.
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
