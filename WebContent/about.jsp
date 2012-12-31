<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>About - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		document.body.setAttribute("style", "background: url('images/sgbg9.jpg') left top no-repeat");
	});
	</script>
	<style type="text/css">
	
		.aboutus{
			opacity:0.8;
			background:black;
			color:white;
		}
		.person{
			width:180px;
			height:220px;
		}
		.avatar{
			float:left;
			width:180px;
			margin-bottom:40px;
		}
		.workload{
			font-size:13px;
		}
		.ourname{
			margin-top:-50px;
			float:left;
			font-size:20px;
		}
	</style>
	</head>
<body>
 	<%
 		String stat = request.getParameter("stat");
 		if (stat != null)
	 		if (stat.equals("wrong")){
	 			out.println("<div id=\"wrongmessage\" class=\"alert-messages\" style=\"display:block\">");
	 			out.println("<div class=\"message\">");
	 			out.println("<div class=\"message-inside\">");
	 			out.println("<div class=\"message-text\">");
	%>
		<div>
	 			${message }
	 	</div>
	<%
	 			out.println("</div>");
	 			out.println("<a class=\"dismiss\" href=\"javascript:dismiss();\">×</a>");
	 			out.println("</div>");
	 			out.println("</div>");
	 			out.println("</div>");
	 		}
 	%>
             	<script type="text/javascript">
             		function dismiss(){
             			document.getElementById("wrongmessage").setAttribute("style", "display:none");
             		}
             	</script>

<%
out.println("<div id='credittipsy' class='tipsy tipsy-n' style='top: 210px; right: 372px; visibility:visible; display:none; opacity:0.8; '>"
		+ "<div class='tipsy-arrow tipsy-arrow-n'></div>"
		+ "<div class='tipsy-inner'>My credits</div>"
		+ "</div>"
		+ "<div id='signinicontipsy' class='tipsy tipsy-n' style='top: 210px; right: 258px; visibility:visible; display:none; opacity:0.8; '>"
		+ "<div class='tipsy-arrow tipsy-arrow-n'></div>"
		+ "<div class='tipsy-inner'>Sign In</div>"
		+ "</div>"
		+ "<div id='signupicontipsy' class='tipsy tipsy-n' style='top: 210px; right: 142px; visibility:visible; display:none; opacity:0.8; '>"
		+ "<div class='tipsy-arrow tipsy-arrow-n'></div>"
		+ "<div class='tipsy-inner'>Sign UP as a Normal User</div>"
		+ "</div>"
		+ "<div align='right'>"
		+ "<div id='menu2' class='menu'>"
		+ "<ul>"
		+ "<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>"
		+ "<li><a href='myhome'><image src='images/logowhite.png' width='54px' margin='10px'></image>SVRP HOME</a></li>"
		+ "<li><a href='ranking.jsp'>Bugs</a></li>"
		+ "<li><a href='javascript:;'>Vulnerabilities</a></li>"
		+ "<li><a href='activities.jsp'>Activities</a></li>"
		+ "<li><a href='about.jsp'>About</a></li>"
		+ "<div class='searchinput' align='right'>"
		+ "<form action='searchbug'>"
		+ "	<input type='search' placeholder='Search' name='strBugNumber'/>"
		+ "						<input type='submit' style='display:none'/>"
		+ "</form>"
		+ "</div>"
		+ "</ul>"
		+ "</div>");
%>
	<div id="content" class="aboutus" style="opacity:0.9;
			background:black;
			color:white;
			height:900px">
			<div  align="center" style="font-size:30px">NBGroup Proudly Presents<br><img src="images/logo.png" width="300px"/><br>www.SVRPlatform.com</div>
			<br><br><br>
			
			
	<div class="person" style="float:left">
	<img src="images/aboutus/JX.png" class="avatar" />

	<div class="ourname" >韩景轩<a style="color:white" href="/userprofile_display?strEmail=povergoing@gmail.com">@Povergo</a><br><div class="workload" align="center">DB | Logic | Service<br>Action | Hibernate</div></div>
			<br><br><br>
	</div>
			
	<div class="person" style="float:right">
	<img src="images/aboutus/QW.png" class="avatar"/>
	
	<div class="ourname">吴庆伟<a style="color:white" href="/userprofile_display?strEmail=gokeii1943@gmail.com">@Gok3ii</a><br><div class="workload" align="center">Logic | Service | Action<br>Debug | Design</div></div>
	</div>
			<br><br><br>
			
	<div class="person" style="float:left">
	<img src="images/aboutus/XT.png" class="avatar"/>
	<div class="ourname">辛田<a style="color:white" href="/userprofile_display?strEmail=albusshin@gmail.com">@Albus Shin</a><br><div class="workload" align="center">Scrum master | View layer <br> Action | Design </div></div>
	</div>
			<br><br><br>
			
	<div class="person" style="float:right">
	<img src="images/aboutus/GS.png" class="avatar"/>
	<div class="ourname">徐俊晟<a style="color:white" href="/userprofile_display?strEmail=owenxu10@yahoo.com">@Owenxu10</a><br><div class="workload" align="center">Document | Testing <br> Action</div></div>
	</div>
	<br><br><br>
	
	<div class="person" style="float:left">
	<img src="images/aboutus/SY.png" class="avatar"/>
	<div class="ourname" >江焕钊<a style="color:white" href="/userprofile_display?strEmail=jamesjiang@gmail.com">@JamesJiang</a><br><div class="workload" align="center">Testing | Document </div></div>
	</div>
			</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>