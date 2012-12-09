<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Retrieve Password - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>
	<style type="text/css">
		input#email {
				font-family: "微软雅黑", "黑体", "新宋体", "宋体";
				width: 500px;
				font-size: 22px;
				line-height: 2.0;
				border-width: 1px;
				border-style: solid;
				border-radius: 11px;
				border-color: #ccc;
				padding: 5px;
				line-height: 1.6;
		}
		</style>
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
			Forgot your password?
		</div>
		<p class="bugvultext" style="font-size:14px;">
		<br>
		<br>
			 You've chosen to reset your password.
		<br>
			Please input your new password below to reset your password.
		<br>
		</p>
		<form id="retrieve" action="ResetPassword" method="post">
			<table class="submitbugtable">
                <tr>
                	<td class="submitbugkey">
                    	<label for="password" > Password </label>
                    </td>
                    <td class="submitbugvalue">
                    	<input id="password" name="password" maxlength="300" tabindex="100"/>
                    </td>
					<td>
						<input type="image" alt="submit" src="images/submitbutton.png" style="height:50px; padding-top:20px; padding-left:30px" onMouseOver="this.src='images/submitbuttonpressed.png'" onMouseOut="this.src='images/submitbutton.png'">
					</td>
	   			</tr>
	   		 </table>
		</form>
		
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
