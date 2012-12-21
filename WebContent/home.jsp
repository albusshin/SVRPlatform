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
		<a href="bugpage?strBugNumber=SVRB-2012-00000023">23号bug。</a><br>
		<a href="displaycomments?strBugNumber=SVRB-2012-00000023&strNowPage=1">23号bug的comments.</a><br>
		<a href="displaysolutions?strBugNumber=SVRB-2012-00000023&strNowPage=1">23号bug的solutions.</a>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
