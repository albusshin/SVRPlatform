<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
<title>Sorry, error - SVRPlatform</title>
</head>
<body>
 		<jsp:include page="headerTourist.jsp" flush="true"/>
<div id="content">
	<div class="commentstitle" style="padding-top:30px;">
	Failed to open submit bug page.
	</div>
   	<p class="bugvultext">
   	It seems that you haven't signed in SVRPlatform. Bug information submission must be logged on to perform. <br>
   	Please <a href="/signin.jsp">Sign in</a> or <a href="/signup.jsp">Sign up...</a>
    </p>
</div>

 		<jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
