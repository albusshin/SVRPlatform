<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Welcome to SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<style type="text/css">
</style>
	<style>
		div#contains{
			clear:both;
			margin: auto;
			width: 1350px;
		}
		div#biglogo{
			width: 700px;
			margin-left:200px;
			float:left;
		}
		div#buttons{
			width: 200px;
			float:left;
		}
		div#threemen{
			clear:both;
			margin: auto;
			width: 1050px;
		}
		div.oneofthree{
			width: 350px;
			padding-top:100px;
			font-family: "微软雅黑", "黑体", "新宋体", "宋体";
			float:left;
		}
		img.button{
			margin-top:32px;
		}
	</style>
	<script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>
	<jsp:include page="headerTourist.jsp" flush="true"/>
    <div id="contains">
        <div id="biglogo">
            <a href="javascript:;" style="border-bottom:none"><img src="images/SVRPlatform.png" width="600px"/></a>
        </div>
        <div id="buttons">
            <a href="signInAutomaticallyUp" style="border-bottom:none"><img class="button"  onmouseover="this.src='images/registerbuttonpressed.png'" onmouseout="this.src='images/registerbutton.png' "src="images/registerbutton.png" width="240"/></a>
            <a href="signInAutomatically" style="border-bottom:none"><img class="button"  onmouseover="this.src='images/loginbuttonpressed.png'" onmouseout="this.src='images/loginbutton.png'"  src="images/loginbutton.png" width="240"/></a>
		</div>
    </div>
    
    <div id="threemen">
    	<div class="oneofthree" align="center">
        	<img src="images/normaluser.png" height="180px"/><br />
            <p align="center"> Normal user
            <br />
            <p> Some dsecriptions.
        </div>
    	<div class="oneofthree" align="center">
        	<img src="images/blackhat.jpg" height="180px"/><br />
            <p align="center"> Advanced user
            <br />
            Some description
        </div>
    	<div class="oneofthree" align="center">
        	<img src="images/developer.jpg" height="180px"/><br />
            <p align="center"> Developer
            <br />
            Some description
        </div>
    </div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>