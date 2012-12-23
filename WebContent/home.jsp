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
		Home page. <br>
		大家加油编程啊！<br>
		<a href="TrySubmitBug">上传bug试试。</a><br>
		<br>
		<a href="bugpage?strBugNumber=SVRB-2012-00000023">23号bug。</a><br>
		<br>
		<a href="displaycomments?strBugNumber=SVRB-2012-00000023&strNowPage=1">23号bug的comments.</a><br>
		<br>
		<a href="displaysolutions?strBugNumber=SVRB-2012-00000023&strNowPage=1#official">23号bug的solutions.</a>
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
