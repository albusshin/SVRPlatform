<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <script type="text/javascript">
	/**
	* Albus Shin
	* Up background bar
	*/
		function loadbarname(){
			var strupbar = "url(images/upbar";
			var ran = parseInt(Math.random()*5+1);
			strupbar += ran;
			strupbar += ".png) left top no-repeat";
			document.getElementById("upbar").style.background=strupbar;
		}

	/**
	*	Albus Shin 
	*	User Animation Bar
	*/

		  var status = "In";
		  var animating = false;
		  
	$(document).ready(function(){
		loadbarname();
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
                    <li><a href="home.jsp"><image src="images/logowhite.png" width="54px" margin="10px"></image>SVRP HOME</a></li>
                    <li><a href="home.jsp">Bugs</a></li>
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
        <div id="upbar">
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
</div>