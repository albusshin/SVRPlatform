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
 		<jsp:include page="WEB-INF/headerSignedIn.jsp" flush="true"/>
	<div id="content">
		<div class="commentstitle" style="padding-top:30px;">
			Forgot your password?
		</div>
		<p class="bugvultext" style="font-size:14px;">
		<br>
		<br>
			 Don't worry. 
		<br>
			Please input your email address below and we'll send a link leading you to reset your password. 
		<br>
		</p>
		<form id="retrieve" action="RetrievePassword" method="post">
			<table class="submitbugtable">
                <tr>
                	<td class="submitbugkey">
                    	<label for="email" > Email </label>
                    </td>
                    <td class="submitbugvalue">
                    	<input id="email" name="email" maxlength="300" tabindex="100" placeholder="Input your email address"/>
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
