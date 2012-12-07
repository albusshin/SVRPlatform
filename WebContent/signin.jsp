<%@ page language="java" contentType="text/html;  charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>SVRPlatform Sign In</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>
<script type="text/javascript">
	/**
	* Albus Shin
	* Up background bar
	*/
	function loadbackgroundname(){
		var strallbg = "url(images/sgbg";
		var ran = parseInt(Math.random()*9 + 1);
		strallbg += ran;
		strallbg += ".jpg) left top no-repeat";
		document.body.style.background=strallbg;
	}

	/**
	*	Albus Shin 
	*	User Animation Bar
	*/

		  var status = "In";
		  var animating = false;
		  
	$(document).ready(function(){
		loadbackgroundname();
	  $("#userbaravatar").click(function(){
		  if (status == "Out"){
			  $("#userbar").animate({width:100},"slow");
			  document.getElementById("userbarelse").style.display="none";
			  status = "In";
		  }
		  else{
	 		  $("#userbar").animate({width:780},"slow");
			  document.getElementById("userbarelse").style.display="block";
			  status = "Out";
		  }
	  });
	  
	});

</script>

<body>
 	
	<div id="wrongmessage" class="alert-messages" style="display:none">
    	<div class="message">
        	<div class="message-inside">
            	<div class="message-text">
   			 		${message }
             	</div>
             	<script type="text/javascript">
             		function dismiss(){
             			document.getElementById("wrongmessage").setAttribute("style", "display:none");
             		}
             	</script>
                <a class="dismiss" href="javascript:dismiss();">×</a>
            </div>
        </div>
    </div>

<div id="credittipsy" class="tipsy tipsy-n" style="top: 210px; right: 372px; visibility:visible; display:none; opacity:0.8; ">
		<div class="tipsy-arrow tipsy-arrow-n"></div>
		<div class="tipsy-inner">My credits</div>
	</div>
	<div id="signinicontipsy" class="tipsy tipsy-n" style="top: 210px; right: 258px; visibility:visible; display:none; opacity:0.8; ">
		<div class="tipsy-arrow tipsy-arrow-n"></div>
		<div class="tipsy-inner">Sign In</div>
	</div>

	<div id="signupicontipsy" class="tipsy tipsy-n" style="top: 210px; right: 142px; visibility:visible; display:none; opacity:0.8; ">
		<div class="tipsy-arrow tipsy-arrow-n"></div>
		<div class="tipsy-inner">Sign UP as a Normal User</div>
	</div>
	<div align="right">
            <div id="menu2" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>
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
            <div id="userbar">
                     <img id="userbaravatar" src="http://www.gravatar.com/avatar/http://www.gravatar.com/avatar/<HASH>?s=45" align="left"/>
                     <div id="userbarelse">
                        <div id="username">Tourist</div>
                        <img class="seperator" src="images/seperator.png" align="middle"/>
                        <div id="userbarcredit" onMouseOver="document.getElementById('credittipsy').style.display='block'" onmouseout="document.getElementById('credittipsy').style.display='none'">0</div>
                        <img class="seperator" src="images/seperator.png" align="middle"/>
                        <img id="signinicon" src="images/signinicon.png" onmouseover="this.src='images/signiniconpressed.png';document.getElementById('signinicontipsy').style.display='block'" onmouseout="this.src='images/signinicon.png';document.getElementById('signinicontipsy').style.display='none'" onclick="window.location.href='signin.jsp'"/>
                        <img id="signupicon" src="images/signupicon.png" onmouseover="this.src='images/signupiconpressed.png';document.getElementById('signupicontipsy').style.display='block'" onmouseout="this.src='images/signupicon.png';document.getElementById('signupicontipsy').style.display='none'" onclick="window.location.href='signup.jsp'"/>
                     </div>
            </div>
</div>    
    		<div id="container">
			<form action="SigningIn" class="loginform" method="post">
				<div class="login">SIGN IN</div>
				<div class="username-text">Email:</div>
				<div class="password-text">Password:</div>
				<div class="username-field">
					<input type="text" name="email"/>
				</div>
				<div class="password-field">
					<input type="password" name="password"/>
				</div>
				<input type="checkbox" name="remember" id="remember-me" value="remembered"/><label for="remember-me">Remember me</label>
				<div class="forgot-usr-pwd">Forgot password? <a href='RetrievePassword.jsp'>Retrieve it...</a></div>
				<input type="submit" id="signingo" name="submit" value="GO" />
			</form>
		</div>
		<style type="text/css"></style>
    	<div id="footer" align="center">
            <p align="center" style="color:#000">Copyright ï¿½ www.SVRPlatform.com</p>
            <p> <a class="footer" style="color:#000" href="javascript:;">Terms of Service</a></p>
            <p> <a class="footer" style="color:#000" href="javascript:;">License of Development</a></p>
            <p> <a class="footer" style="color:#000" href="javascript:;">Privacy</a></p>
        	<img src="images/SVRPlatformPUR.png" width=400px align="middle"/>
    	</div>
    <script type="text/javascript">
	    function showWrongMessage(){
		    document.getElementById("wrongmessage").style.display="block";
	    }
    </script>
</body>
</html>
