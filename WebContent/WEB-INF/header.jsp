<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java"
	import="org.apache.commons.codec.digest.DigestUtils"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/XRegExp.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shCore.js"></script>
<!--  暂时用不到
<script type="text/javascript" src="/codehighlite/scripts/shBrushAppleScript.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushAS3.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushColdFusion.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushDiff.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushErlang.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushGroovy.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushJavaFX.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushScala.js"></script>
 -->
<script type="text/javascript" src="/codehighlite/scripts/shBrushBash.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushVb.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushPhp.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushCpp.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushCSharp.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushCss.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushDelphi.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushPlain.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushSql.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushXml.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushPython.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushRuby.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushJScript.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushPerl.js"></script>
<script type="text/javascript" src="/codehighlite/scripts/shBrushJava.js"></script>
<link href="/codehighlite/styles/shCore.css" rel="stylesheet" type="text/css" />
<link href="/codehighlite/styles/shThemeDjango.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	/**
	 * Albus Shin
	 * Up background bar
	 */
	function loadbarname() {
		var strupbar = "url(images/upbar";
		var ran = parseInt(Math.random() * 5 + 1);
		strupbar += ran;
		strupbar += ".png) left top no-repeat";
		document.getElementById("upbar").style.background = strupbar;
	}

	/**
	 *	Albus Shin 
	 *	User Animation Bar
	 */

	var status = "In";
	var animating = false;

	$(document).ready(function() {
		loadbarname();
		$("#userbaravatar").click(function() {
			if (status == "Out") {
				$("#userbar").animate({
					width : 100
				}, "slow");
				document.getElementById("userbarelse").style.display = "none";
				status = "In";
			} else {
				$("#userbar").animate({
					width : 780
				}, "slow");
				document.getElementById("userbarelse").style.display = "block";
				status = "Out";
			}
		});

	});
	SyntaxHighlighter.all();
</script>
<%
	String str = (String) session.getAttribute("email");
	if (str != null) {
		String hash = DigestUtils.md5Hex(str.trim().toLowerCase());
		str = "http://www.gravatar.com/avatar/" + hash
				+ "?s=45&d=identicon&r=PG";
	}

	String type = request.getParameter("type");
	if (type == null || type.equals("null")) {
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
				+ "<li><a href='myhomeBugs'><image src='images/logowhite.png' width='54px' margin='10px'></image>SVRP HOME</a></li>"
				+ "<li><a href='bugsRanking?timeType=5'>Bugs</a></li>"
				+ "<li><a href='vulnerabilitiesRanking?timeType=5'>Vulnerabilities</a></li>"
				+ "<li><a href='activities.jsp'>Activities</a></li>"
				+ "<li><a href='about.jsp'>About</a></li>"
				+ "<div class='searchinput' align='right'>"
				+ "<form action='searchsite'>"
				+ "	<input type='search' placeholder='Search' name='strNumber'/>"
				+ "						<input type='submit' style='display:none'/>"
				+ "</form>"
				+ "</div>"
				+ "</ul>"
				+ "</div>"
				+ "<div id='upbar'>"
				+ "    <div id='userbar'>"
				+ "<img id='userbaravatar' src='http://www.gravatar.com/avatar/http://www.gravatar.com/avatar/<HASH>?s=45' align='left'/>"
				+ "<div id='userbarelse'>"
				+ "   <div id='username'>Tourist</div>"
				+ "<img class='seperator' src='images/seperator.png' align='middle'/>"
				+ "<div id='userbarcredit' onMouseOver='document.getElementById('credittipsy').style.display='block'' onmouseout='document.getElementById('credittipsy').style.display='none''>0</div>"
				+ "<img class='seperator' src='images/seperator.png' align='middle'/>"
				+ "<img id='signinicon' src='images/signinicon.png' onmouseover=\"this.src='images/signiniconpressed.png';document.getElementById('signinicontipsy').style.display='block'\" onmouseout=\"this.src='images/signinicon.png';document.getElementById('signinicontipsy').style.display='none'\" onclick=\"window.location.href='signin.jsp'\"/>"
				+ "<img id='signupicon' src='images/signupicon.png' onmouseover=\"this.src='images/signupiconpressed.png';document.getElementById('signupicontipsy').style.display='block'\" onmouseout=\"this.src='images/signupicon.png';document.getElementById('signupicontipsy').style.display='none'\" onclick=\"window.location.href='signup.jsp'\"/>"
				+ "</div>" + "</div>" + "</div>" + "</div>");
	} else {
		out.println("<div id='credittipsy' class='tipsy tipsy-n' style='top: 210px; right: 372px; visibility:visible; display:none; opacity:0.8; '>"
				+ "<div class='tipsy-arrow tipsy-arrow-n'></div>"
				+ "<div class='tipsy-inner'>My credits</div>"
				+ "</div>"
				+ "<div id='usericontipsy' class='tipsy tipsy-n' style='top: 210px; right: 250px; visibility:visible; display:none; opacity:0.8; '>"
				+ "<div class='tipsy-arrow tipsy-arrow-n'></div>"
				+ "<div class='tipsy-inner'>My Profile</div>"
				+ "</div>"
				+ "<div id='bugtipsy' class='tipsy tipsy-n' style='top: 210px; right: 150px; visibility:visible; display:none; opacity:0.8; '>"
				+ "<div class='tipsy-arrow tipsy-arrow-n'></div>"
				+ "<div class='tipsy-inner'>Submit bug information</div>"
				+ "</div>"
				+ "<div id='vulnerabilitytipsy' class='tipsy tipsy-n' style='top: 210px; right: 53px; visibility:visible; display:none; opacity:0.8; '>"
				+ "<div class='tipsy-arrow tipsy-arrow-n'></div>"
				+ "<div class='tipsy-inner'>Submit vulnerability information</div>"
				+ "</div>"
				+ "<div id='logouttipsy' class='tipsy tipsy-n' style='top: 210px; right: 60px; visibility:visible; display:none; opacity:0.8; '>"
				+ "	<div class='tipsy-arrow tipsy-arrow-n'></div>"
				+ "	<div class='tipsy-inner'>Log out</div>"
				+ "</div>"
				+ "        <script type='text/javascript'>"
				+ "        	function navigateLogout(){"
				+ "       		window.navigate('/Logout');"
				+ "      	}"
				+ "        </script>"
				+ "<div align='right'>"
				+ "        <div id='menu2' class='menu'>"
				+ "            <ul>"
				+ "            	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>"
				+ "<li><a href='myhomeBugs'><image src='images/logowhite.png' width='54px' margin='10px'></image>SVRP HOME</a></li>"
				+ "<li><a href='bugsRanking?timeType=5'>Bugs</a></li>"
				+ "<li><a href='vulnerabilitiesRanking?timeType=5'>Vulnerabilities</a></li>"
				+ "<li><a href='activities.jsp'>Activities</a></li>"
				+ "<li><a href='about.jsp'>About</a></li>"
				+ "                <div class='searchinput' align='right'>"
				+ "                	<form action='searchsite'>"
				+ "						<input type='search' placeholder='Search' name='strNumber'/>"
				+ "						<input type='submit' style='display:none'/>"
				+ "					</form>"
				+ "                </div>"
				+ "            </ul>"
				+ "        </div>"
				+ "    <div id='upbar'>"
				+ "        <div id='userbar'>"
				+ "                 <img id='userbaravatar' src='");
%>
<%=str%>
<%
	out.print("' align='left'/>"
				+ "                 <div id='userbarelse'>"
				+ "                    <div id='username'>");
%>
${sessionScope.realname}
<%
	out.print("</div>"
				+ "                    <img class='seperator' src='images/seperator.png' align='middle'/>"
				+ "                    <div id='userbarcredit' onMouseOver=\"document.getElementById('credittipsy').style.display='block'\" onmouseout=\"document.getElementById('credittipsy').style.display='none'\"> "
				+ request.getSession().getValue("credit")
				+ "</div>"
				+ "                    <img class='seperator' src='images/seperator.png' align='middle'/>"
				+ "                    <img id='userbarusericon' src='images/usericon.png' onmouseover=\"this.src='images/usericonpressed.png';document.getElementById('usericontipsy').style.display='block'\" onmouseout=\"this.src='images/usericon.png';document.getElementById('usericontipsy').style.display='none'\" "
				+						"onclick=\"window.location.href='userprofile_display?strEmail="
				+ VerifyUser.getNowUser(request)
				+ "';\"/>"
				+ "                    <img id='userbarbug' src='images/uploadbug.png' onmouseover=\"this.src='images/uploadbugpressed.png';document.getElementById('bugtipsy').style.display='block'\" onmouseout=\"this.src='images/uploadbug.png';document.getElementById('bugtipsy').style.display='none'\""
				+ "                    onclick=\"window.location.href='TrySubmitBug'\"/>"
				+ "                    <img id='userbarvulnerability' src='images/uploadvulnerability.png' onmouseover=\"this.src='images/uploadvulnerabilitypressed.png';document.getElementById('vulnerabilitytipsy').style.display='block'\" onmouseout=\"this.src='images/uploadvulnerability.png';document.getElementById('vulnerabilitytipsy').style.display='none'\""
				+ "                    onclick=\"window.location.href='trysubmitvulnerability'\"/>"
				+ "                    <img id='userbarlogout' src='images/logout.png' onmouseover=\"this.src='images/logoutpressed.png';document.getElementById('logouttipsy').style.display='block'\" onmouseout=\"this.src='images/logout.png';document.getElementById('logouttipsy').style.display='none'\""
				+ "                    onclick=\"window.location.href='Logout'\"/>"
				+ "                </div>" + "        </div>"
				+ "    </div>" + "	</div>");
	}
%>









