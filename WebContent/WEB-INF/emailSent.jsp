<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
<title>Email sent - SVRPlatform</title>
</head>
<body>
 		<jsp:include page="headerTourist.jsp" flush="true"/>
<div id="content">
	<div class="commentstitle" style="padding-top:30px;">
	Password reset confirmation sent successfully!
	</div>
   	<p class="bugvultext">
   	We’ve sent an email to <strong>${email }</strong> containing a temporary link that will allow you to reset your password for the next 24 hours. Please check your spam folder if the email doesn’t appear within a few minutes.
    </p>
</div>

 		<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>
