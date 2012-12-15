<%@ page language="java" import="org.apache.commons.codec.digest.DigestUtils" contentType="text/html; charset=utf-8"
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
	<%
		String str = (String) session.getAttribute("email");
		if (str!=null){
			String hash = DigestUtils.md5Hex(str.trim().toLowerCase());
			str = "http://www.gravatar.com/avatar/" + hash + "?s=45&d=identicon&r=PG";
		}

		String type = request.getParameter("type");
		if (type==null || type.equals("null")){
			out.println("<div id='credittipsy' class='tipsy tipsy-n' style='top: 210px; right: 372px; visibility:visible; display:none; opacity:0.8; '>"+
					"<div class='tipsy-arrow tipsy-arrow-n'></div>"+
					"<div class='tipsy-inner'>My credits</div>"+
				"</div>"+
				"<div id='signinicontipsy' class='tipsy tipsy-n' style='top: 210px; right: 258px; visibility:visible; display:none; opacity:0.8; '>"+
					"<div class='tipsy-arrow tipsy-arrow-n'></div>"+
					"<div class='tipsy-inner'>Sign In</div>"+
				"</div>"+
				"<div id='signupicontipsy' class='tipsy tipsy-n' style='top: 210px; right: 142px; visibility:visible; display:none; opacity:0.8; '>"+
					"<div class='tipsy-arrow tipsy-arrow-n'></div>"+
					"<div class='tipsy-inner'>Sign UP as a Normal User</div>"+
				"</div>"+
				"<div align='right'>"+
			            "<div id='menu2' class='menu'>"+
			                "<ul>"+
			                	"<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>"+
			                    "<li><a href='home.jsp'><image src='images/logowhite.png' width='54px' margin='10px'></image>SVRP HOME</a></li>"+
			                    "<li><a href='home.jsp'>Bugs</a></li>"+
			                    "<li><a href='javascript:;'>Vulnerabilities</a></li>"+
			                    "<li><a href='javascript:;'>Exploits</a></li>"+
			                    "<li><a href='javascript:;'>About</a></li>"+
			                    "<li><a href='javascript:;'>Contact</a></li>"+
			                    "<div class='searchinput' align='right'>"+
			                    	"<form action='searchbug'>"+
									"	<input type='search' placeholder='Search' name='strBugNumber'/>"+
						  	"						<input type='submit' style='display:none'/>" +
									"</form>"+
			                    "</div>"+
			                "</ul>"+
			            "</div>"+
			        "<div id='upbar'>"+
			        "    <div id='userbar'>"+
			                     "<img id='userbaravatar' src='http://www.gravatar.com/avatar/http://www.gravatar.com/avatar/<HASH>?s=45' align='left'/>"+
			                     "<div id='userbarelse'>"+
			                     "   <div id='username'>Tourist</div>"+
			                        "<img class='seperator' src='images/seperator.png' align='middle'/>"+
			                        "<div id='userbarcredit' onMouseOver='document.getElementById('credittipsy').style.display='block'' onmouseout='document.getElementById('credittipsy').style.display='none''>0</div>"+
			                        "<img class='seperator' src='images/seperator.png' align='middle'/>"+
			                        "<img id='signinicon' src='images/signinicon.png' onmouseover=\"this.src='images/signiniconpressed.png';document.getElementById('signinicontipsy').style.display='block'\" onmouseout=\"this.src='images/signinicon.png';document.getElementById('signinicontipsy').style.display='none'\" onclick=\"window.location.href='signin.jsp'\"/>"+
			                        "<img id='signupicon' src='images/signupicon.png' onmouseover=\"this.src='images/signupiconpressed.png';document.getElementById('signupicontipsy').style.display='block'\" onmouseout=\"this.src='images/signupicon.png';document.getElementById('signupicontipsy').style.display='none'\" onclick=\"window.location.href='signup.jsp'\"/>"+
			                     "</div>"+
			            "</div>"+
			        "</div>"+
			"</div>");
		}
		else{
			out.println("<div id='credittipsy' class='tipsy tipsy-n' style='top: 210px; right: 372px; visibility:visible; display:none; opacity:0.8; '>"+
			"<div class='tipsy-arrow tipsy-arrow-n'></div>"+
			"<div class='tipsy-inner'>My credits</div>"+
		"</div>"+
		"<div id='usericontipsy' class='tipsy tipsy-n' style='top: 210px; right: 250px; visibility:visible; display:none; opacity:0.8; '>"+
			"<div class='tipsy-arrow tipsy-arrow-n'></div>"+
		"<div class='tipsy-inner'>My Profile</div>"+
				"</div>"+
		"<div id='watchingtipsy' class='tipsy tipsy-n' style='top: 210px; right: 166px; visibility:visible; display:none; opacity:0.8; '>"+
			"<div class='tipsy-arrow tipsy-arrow-n'></div>"+
		"<div class='tipsy-inner'>My watching bugs</div>"+
		"</div>"+
		"<div id='logouttipsy' class='tipsy tipsy-n' style='top: 210px; right: 128px; visibility:visible; display:none; opacity:0.8; '>"+
		"	<div class='tipsy-arrow tipsy-arrow-n'></div>"+
		"	<div class='tipsy-inner'>Log out</div>"+
		"</div>"+
	    "        <script type='text/javascript'>"+
	    "        	function navigateLogout(){"+
	     "       		window.navigate('/Logout');"+
	      "      	}"+
	    "        </script>"+
		"<div align='right'>"+
	    "        <div id='menu2' class='menu'>"+
	    "            <ul>"+
	    "            	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>"+
	    "                <li><a href='home.jsp'><image src='images/logowhite.png' width='54px' margin='10px'></image>SVRP HOME</a></li>"+
	    "                <li><a href='home.jsp'>Bugs</a></li>"+
	    "                <li><a href='javascript:;'>Vulnerabilities</a></li>"+
	    "                <li><a href='javascript:;'>Exploits</a></li>"+
	    "                <li><a href='javascript:;'>About</a></li>"+
	    "                <li><a href='javascript:;'>Contact</a></li>"+
	    "                <div class='searchinput' align='right'>"+
	    "                	<form action='searchbug'>"+
		"						<input type='search' placeholder='Search' name='strBugNumber'/>"+
	   	"						<input type='submit' style='display:none'/>" +
		"					</form>"+
	    "                </div>"+
	    "            </ul>"+
	    "        </div>"+
	    "    <div id='upbar'>"+
	    "        <div id='userbar'>"+
	    "                 <img id='userbaravatar' src='");
			%>
	    <%=str %>
	   		<% out.print( "' align='left'/>"+
	    "                 <div id='userbarelse'>"+
	    "                    <div id='username'>");
	   		%>
	    ${sessionScope.email}
	    <%
	    out.print("</div>"+
	    "                    <img class='seperator' src='images/seperator.png' align='middle'/>"+
	    "                    <div id='userbarcredit' onMouseOver=\"document.getElementById('credittipsy').style.display='block'\" onmouseout=\"document.getElementById('credittipsy').style.display='none'\">1,023</div>"+
	    "                    <img class='seperator' src='images/seperator.png' align='middle'/>"+
	    "                    <img id='userbarusericon' src='images/usericon.png' onmouseover=\"this.src='images/usericonpressed.png';document.getElementById('usericontipsy').style.display='block'\" onmouseout=\"this.src='images/usericon.png';document.getElementById('usericontipsy').style.display='none'\""+
	    "                    onclick=\"javascript:;\"/>"+
	    "                    <img id='userbarwatching' src='images/watching.png' onmouseover=\"this.src='images/watchingpressed.png';document.getElementById('watchingtipsy').style.display='block'\" onmouseout=\"this.src='images/watching.png';document.getElementById('watchingtipsy').style.display='none'\""+
	    "                    onclick=\"javascript:;\"/>"+
	    "                    <img id='userbarlogout' src='images/logout.png' onmouseover=\"this.src='images/logoutpressed.png';document.getElementById('logouttipsy').style.display='block'\" onmouseout=\"this.src='images/logout.png';document.getElementById('logouttipsy').style.display='none'\""+
	    "                    onclick=\"window.location.href='Logout'\"/>"+
	    "                </div>"+
	    "        </div>"+
	    "    </div>"+
"	</div>");
		}
	%>
	
	
	
	
	
	
	

    
