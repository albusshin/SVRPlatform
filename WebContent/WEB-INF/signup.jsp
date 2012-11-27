<%@ page language="java" contentType="text/html;  charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>SVRPlatform Sign UP!</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>

<body>
	<style type="text/css">
			/* ------- Body ------- */
		
		body {
			background: #eeeeee url(images/sgbg.jpg) top left no-repeat;
		}

	</style>
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
							<input type="search" placeholder="Search">
						</form>
                    </div>
                </ul>
            </div>
        <br />
        <br />
	</div>
-	
-    ${message }
    
    
    		<div id="container">
			<form action="/SVRPlatform/signup" class="loginform" method="post">
				<div class="login">SIGN UP!</div>
				<div class="username-text">Email:</div>
				<div class="password-text">Password:</div>
				<div class="username-field">
					<input type="text" name="email"/>
				</div>
				<div class="password-field">
					<input type="password" name="password"/>
				</div>
				<input type="checkbox" name="remember" id="remember-me" value="remembered"/><label for="remember-me">Remember me</label>
				<div class="forgot-usr-pwd">First time using <a href='home.html'>SVRPlatform</a>?</div>
				<input type="submit" name="submit" id="signingo" value="GO" />
			</form>
		</div>
        
        
		   
    

    	<div id="footer" align="center">
            <p align="center" style="color:#000">Copyright © www.SVRPlatform.com</p>
            <p> <a class="footer" style="color:#000" href="javascript:;">Terms of Service</a></p>
            <p> <a class="footer" style="color:#000" href="javascript:;">License of Development</a></p>
            <p> <a class="footer" style="color:#000" href="javascript:;">Privacy</a></p>
        	<img src="images/SVRPlatformPUR.png" width=400px align="middle"/>
    	</div>
</body>
</html>
