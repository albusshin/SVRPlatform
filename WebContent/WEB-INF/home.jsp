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
<body><div align="right">
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
        <div id="upbar">
            <div id="userbar">
                     <img id="userbaravatar" src="http://www.gravatar.com/avatar/a6dc91974119e1d3ab253c7311e072fe?s=45&d=identicon&r=PG" align="left"/>
                     <div id="userbarelse">
                        <div id="usersname">${sessionScope.email}</div>
                        <img class="seperator" src="images/seperator.png" align="middle"/>
                        <div id="userbarcredit">1,023</div>
                        <img class="seperator" src="images/seperator.png" align="middle"/>
                        <img id="userbarusericon" src="images/usericon.png" onmouseover="this.src='images/usericonpressed.png'" onmouseout="this.src='images/usericon.png'" onclick="javascript:;"/>
                        <img id="userbarwatching" src="images/watching.png" onmouseover="this.src='images/watchingpressed.png'" onmouseout="this.src='images/watching.png'" onclick="javascript:;"/>
                        <img id="userbarlogout" src="images/logout.png" onmouseover="this.src='images/logoutpressed.png'" onmouseout="this.src='images/logout.png'" onclick="javascript:;"/>
                     </div>
            </div>
        </div>
        <br />
        <br />
	</div>
	<div id="content">
		infsda
	</div>
    <div id="footer" align="center">
            <p align="center">Copyright © www.SVRPlatform.com</p>
            <p> <a href="javascript:;">Terms of Service</a></p>
            <p> <a href="javascript:;">License of Development</a></p>
            <p> <a href="javascript:;">Privacy</a></p>
        	<img src="images/SVRPlatform.png" width=400px align="middle"/>
    	</div>
</body>
</html>
