<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
		<% response.setHeader("refresh", "3; URL=index");%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Logging out - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>
 		<jsp:include page="WEB-INF/headerTourist.jsp" flush="true"/>
	<div id="content">
		<div id="commentstitle">
			You've successfully logged out.
		</div>
		<p class="bugvultext">
			We'll redirect you to our index page.
		</p>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
