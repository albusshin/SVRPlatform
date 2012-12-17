<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
<title>Error page</title>
</head>
<body>
	<%
	
	String str = (String) session.getAttribute("email");
	if (str != null){
		str = "signedin";
	}
	
	%>
 		<jsp:include page="header.jsp" flush="true">
 			<jsp:param name="type" value="<%=str%>"/>
 		</jsp:include>
<div id="content">
	<div class="commentstitle" style="padding-top:30px;">
	There's an error occured while processing your request.
	</div>
	<div class="comments" >
	<h4>Exception Name:<br> ${exception } </h4>

   <h4>Exception Details:<br> ${exceptionStack }</h4> 
	</div>
</div>

 		<jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
