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
	<div id="menu" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </li>
                    <li><a href="myhome"><image src="images/logo.png" width="54px" margin="10px"></image>MY HOME</a></li>
                    <li><a href="ranking.jsp">RANKING</a></li>
                    <li><a href="javascript:;">ACTIVITIES</a></li>
                </ul>
            </div>
        <hr/>
		<br>
		<p>目前有如下活动：
		<p>1. 踢Carry Zhu 两脚
		<p>2. 踹Carry Zhu 两脚
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
