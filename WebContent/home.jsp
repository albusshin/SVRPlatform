<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>SVRPlatform Home</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>

<body>
	<div align="right">
            <div id="menu2" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </li>
                    <li><a href="javascript:;"><image src="images/logowhite.png" width="54px" margin="10px"></image>SVRP HOME</a></li>
                    <li><a href="javascript:;">Bugs</a></li>
                    <li><a href="javascript:;">Vulnerabilities</a></li>
                    <li><a href="javascript:;">Exploits</a></li>
                    <li><a href="javascript:;">About</a></li>
                    <li><a href="javascript:;">Contact</a></li>
                    <div class="searchinput" align="right">
                    	<form>
							<input type="search" placeholder="搜索">
						</form>
                    </div>
                </ul>
            </div>
        <hr/>
        <h1 class="msblack20"><a href="#" id="usersname" class="steelbluefont"> ${cookie.email.value}  </a>，Welcome to SVRPlatform.</h1>
	
        <br />
        <br />
	</div>
    
    
    
    
    
        <div id="footer" align="center">
            <p align="center">Copyright © www.SVRPlatform.com</p>
            <p> <a href="javascript:;">Terms of Service</a></p>
            <p> <a href="javascript:;">License of Development</a></p>
            <p> <a href="javascript:;">Privacy</a></p>
        	<img src="images/SVRPlatform.png" width=200px align="middle"/>
    	</div>
</body>
</html>