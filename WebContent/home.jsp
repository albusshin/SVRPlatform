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
	<script type="text/javascript">
	function loadbackgroundname(){
			var strallbg = "url(images/sgbg";
			var ran = parseInt(Math.random()*9 + 1);
			strallbg += ran;
			strallbg += ".jpg) left top no-repeat";
			document.getElementById("content").setAttribute("style","background:"+strallbg+";");
		}
	$(document).ready(function(){
		loadbackgroundname();
		$("#mybugsrowrightbutton").click(function(){
			$("#mybugsbugcard1").hide(1000);
			$("#mybugsbugcard3").show(1000);
	});

});
	</script>
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
	Home page. Comming soon.
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
