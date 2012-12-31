<%@page import="com.SVRPlatform.Utils.VerifyUser,java.util.List,com.SVRPlatform.data.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<%
		List<BugData> lsMyBugs = (List<BugData>) request.getAttribute("lsMyBugs");
		List<BugData> lsWatchingBugs1 = (List<BugData>) request.getAttribute("lsWatchingBugs1");
		List<BugData> lsWatchingBugs2 = (List<BugData>) request.getAttribute("lsWatchingBugs2");
		List<SolutionData> lsMySolutions = (List<SolutionData>) request.getAttribute("lsMySolutions");
		request.setAttribute("myBugsAmount", lsMyBugs.size() - 1);
		request.setAttribute("watchingBugs1Amount", lsWatchingBugs1.size() - 1);
		request.setAttribute("watchingBugs2Amount", lsWatchingBugs2.size() - 1);
		request.setAttribute("mySolutionsAmount", lsMySolutions.size() - 1);
		BugData bd;
		SolutionData sd;
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Home - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript">
	function loadbackgroundname(){
			var strallbg = "url(images/sgbg";
			var ran = parseInt(Math.random()*9 + 1);
			strallbg += ran;
			strallbg += ".jpg) left top no-repeat";
			document.getElementById("content").setAttribute("style","background:"+strallbg+";");
		}
	
	var nowmybugsbugcard = 0;
	var nextmybugsbugcard = nowmybugsbugcard + 2;

	var nowwatchingbugsbugcard1 = 0;
	var nextwatchingbugsbugcard1 = nowwatchingbugsbugcard1 + 2;

	var nowwatchingbugsbugcard2 = 0;
	var nextwatchingbugsbugcard2 = nowwatchingbugsbugcard2 + 2;
	
	var nowsolutionssolutioncard = 0;
	var nextsolutionssolutioncard = nowsolutionssolutioncard + 2
	$(document).ready(function(){
		loadbackgroundname();
		$("#mybugsrightbutton").click(function(){
			if (nextmybugsbugcard == (${myBugsAmount }+1)){
				return;
			}
			$("#mybugsbugcard" + nowmybugsbugcard).hide(200);
			$("#mybugsbugcard" + nextmybugsbugcard).show(200);
			if (nextmybugsbugcard == ("${myBugsAmount }")){
				$("#mybugsrightbutton").animate({opacity:0}, "fast");
			}
			nowmybugsbugcard++;
			nextmybugsbugcard++;
			$("#mybugsleftbutton").animate({opacity:0.9}, "fast")
		});
		$("#mybugsleftbutton").click(function(){
			if (nowmybugsbugcard == 0){
				return;
			}
			nowmybugsbugcard--;
			nextmybugsbugcard--;
			$("#mybugsbugcard" + nowmybugsbugcard).show(200);
			$("#mybugsbugcard" + nextmybugsbugcard).hide(200);
			if (nowmybugsbugcard == 0){
				$("#mybugsleftbutton").animate({opacity:0}, "fast");
			}
			$("#mybugsrightbutton").animate({opacity:0.9}, "fast")
		});
		
		
		$("#watchingbugsrightbutton1").click(function(){
			if (nextwatchingbugsbugcard1 == (${watchingBugs1Amount })+1){
				return;
			}
			$("#watchingbugsbugcard1" + nowwatchingbugsbugcard1).hide(200);
			$("#watchingbugsbugcard1" + nextwatchingbugsbugcard1).show(200);
			if (nextwatchingbugsbugcard1 == ("${watchingBugs1Amount }")){
				$("#watchingbugsrightbutton1").animate({opacity:0}, "fast")
			}
			nowwatchingbugsbugcard1++;
			nextwatchingbugsbugcard1++;
			$("#watchingbugsleftbutton1").animate({opacity:0.9}, "fast")
		});
		$("#watchingbugsleftbutton1").click(function(){
			if (nowwatchingbugsbugcard1 == 0){
				return;
			}
			nowwatchingbugsbugcard1--;
			nextwatchingbugsbugcard1--;
			$("#watchingbugsbugcard1" + nowwatchingbugsbugcard1).show(200);
			$("#watchingbugsbugcard1" + nextwatchingbugsbugcard1).hide(200);
			if (nowwatchingbugsbugcard1 == 0){
				$("#watchingbugsleftbutton1").animate({opacity:0}, "fast")
			}
			$("#watchingbugsrightbutton1").animate({opacity:0.9}, "fast")
		});
		
		
		$("#watchingbugsrightbutton2").click(function(){
			if (nextwatchingbugsbugcard2 == (${watchingBugs2Amount })+1){
				return;
			}
			$("#watchingbugsbugcard2" + nowwatchingbugsbugcard2).hide(200);
			$("#watchingbugsbugcard2" + nextwatchingbugsbugcard2).show(200);
			if (nextwatchingbugsbugcard2 == ("${watchingBugs2Amount }")){
				$("#watchingbugsrightbutton2").animate({opacity:0}, "fast")
			}
			nowwatchingbugsbugcard2++;
			nextwatchingbugsbugcard2++;
			$("#watchingbugsleftbutton2").animate({opacity:0.9}, "fast")
		});
		$("#watchingbugsleftbutton2").click(function(){
			if (nowwatchingbugsbugcard2 == 0){
				return;
			}
			nowwatchingbugsbugcard2--;
			nextwatchingbugsbugcard2--;
			$("#watchingbugsbugcard2" + nowwatchingbugsbugcard2).show(200);
			$("#watchingbugsbugcard2" + nextwatchingbugsbugcard2).hide(200);
			if (nowwatchingbugsbugcard2 == 0){
				$("#watchingbugsleftbutton2").animate({opacity:0}, "fast")
			}
			$("#watchingbugsrightbutton2").animate({opacity:0.9}, "fast")
		});
		
		$("#mysolutionsrightbutton").click(function(){
			if (nextsolutionssolutioncard == (${mySolutionsAmount })+1){
				return;
			}
			$("#mysolutionssolutioncard" + nowsolutionssolutioncard).hide(200);
			$("#mysolutionssolutioncard" + nextsolutionssolutioncard).show(200);
			if (nextsolutionssolutioncard == ("${mySolutionsAmount}")){
				$("#mysolutionsrightbutton").animate({opacity:0}, "fast")
			}
			nowsolutionssolutioncard++;
			nextsolutionssolutioncard++;
			$("#mysolutionsleftbutton").animate({opacity:0.9}, "fast")
		});
		$("#mysolutionsleftbutton").click(function(){
			if (nowsolutionssolutioncard == 0){
				return;
			}
			nowsolutionssolutioncard--;
			nextsolutionssolutioncard--;
			$("#mysolutionssolutioncard" + nowsolutionssolutioncard).show(200);
			$("#mysolutionssolutioncard" + nextsolutionssolutioncard).hide(200);
			if (nowsolutionssolutioncard == 0){
				$("#mysolutionsleftbutton").animate({opacity:0}, "fast")
			}
			$("#mysolutionsrightbutton").animate({opacity:0.9}, "fast")
		});
});
	</script>
</head>
<body>
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
            <div class="mybugs">
		    	<div class="homepagesubtitle">My Bugs</div>
					<div class="anyrowbox">
				    	<div class="mybugsrow">
					    	<%
					    	for (int i=0; i<lsMyBugs.size(); i++){
					    		bd = lsMyBugs.get(i);
					    		out.print("<div class=\"bugcard\" id=\"mybugsbugcard" + i + "\"");
					    		if (i > 1){
					    			out.print("style='display:none'");
					    		}
					    		out.println(">"+
					                	"<a href=\"bugpage?strBugNumber="+ bd.getBugNumber() +"\">"+bd.getBugNumber()+"</a>"+
					                    "<div class=\"digest\">");
					    		if (bd.getDigest().length()>70){
					    			out.print(bd.getDigest().substring(0, 65) + "   ...");
					    		}
					    		else{
					    			out.print(bd.getDigest());
					    		}
					                        out.println("<div class=\"date\">"+
					                      	"Published: "+ bd.getPublishDate() +
					                        "</div>"+
					                    "</div>"+
					                    "<a class=\"comments\" href=\"displaycomments?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Comments ("+ bd.getCommentsCount() +")</a>"+
					                    "&nbsp;&nbsp;"+
					                    "<a class=\"solutions\" href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Solutions ("+ bd.getSolutionsCount() +")</a>");
					    		if (bd.isHasOfficial()){
					    			out.println("<a href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1#official\" class=\"solutionsimg\"><img src=\"images/official.png\"/></a>");
					    		}
					    		if (bd.isHasBest()){
					    			out.println("<a href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1#official\" class=\"solutionsimg\"><img src=\"images/best.png\"/></a>");
					    		}
					            out.println("</div>");
					    	}
					    	%>
				        </div>
				    <div class="leftrightbuttonbar">
						<div id="mybugsleftbutton" class="leftbuttonhomepage" style="opacity:0">
						</div>
						<br>
						
						<div id="mybugsrightbutton" class="rightbuttonhomepage"
						<%
						if (lsMyBugs.size() <= 2)
							out.print("style='opacity:0'");
						%>
						>
						</div>
				    </div>
					</div>
     		</div>
    <div class="watchingbugs">
    	<div class="homepagesubtitle">Watching Bugs</div>
			<div class="anyrowbox">
		    		<div class="watchingbugsrow" id="watchingbugsrow1">
		    						<%
							    	for (int i=0; i<lsWatchingBugs1.size(); i++){
							    		bd = lsWatchingBugs1.get(i);
							    		out.print("<div class=\"bugcard\" id=\"watchingbugsbugcard1" + i + "\"");
							    		if (i > 1){
							    			out.print("style='display:none'");
							    		}
							    		out.println(">"+
							                	"<a href=\"bugpage?strBugNumber="+ bd.getBugNumber() +"\">"+bd.getBugNumber()+"</a>"+
							                    "<div class=\"digest\">"+
							                    bd.getDigest()+
							                        "<div class=\"date\">"+
							                      	"Published: "+ bd.getPublishDate() +
							                        "</div>"+
							                    "</div>"+
							                    "<a class=\"comments\" href=\"displaycomments?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Comments ("+ bd.getCommentsCount() +")</a>"+
									                    "&nbsp;&nbsp;"+
							                    "<a class=\"solutions\" href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Solutions ("+ bd.getSolutionsCount() +")</a>");
							    		if (bd.isHasOfficial()){
							    			out.println("<a href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1#official\" class=\"solutionsimg\"><img src=\"images/official.png\"/></a>");
							    		}
							    		if (bd.isHasBest()){
							    			out.println("<a href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1#official\" class=\"solutionsimg\"><img src=\"images/best.png\"/></a>");
							    		}
							            out.println("</div>");
							    	}
							    	%>
		     		</div>
					    <div class="leftrightbuttonbar">
							<div id="watchingbugsleftbutton1" class="leftbuttonhomepage" style="opacity:0">
							</div>
							<br>
							<div id="watchingbugsrightbutton1" class="rightbuttonhomepage"
						<%
						if (lsWatchingBugs1.size() <= 2)
							out.print("style='opacity:0'");
						%>
						>
						</div>
		   			</div>
				    </div>
			<div class="anyrowbox"> 
    				<div class="watchingbugsrow" id="watchingbugsrow2">
		    						<%
							    	for (int i=0; i<lsWatchingBugs2.size(); i++){
							    		bd = lsWatchingBugs2.get(i);
							    		out.print("<div class=\"bugcard\" id=\"watchingbugsbugcard2" + i + "\"");
							    		if (i > 1){
							    			out.print("style='display:none'");
							    		}
							    		out.println(">"+
							                	"<a href=\"bugpage?strBugNumber="+ bd.getBugNumber() +"\">"+bd.getBugNumber()+"</a>"+
							                    "<div class=\"digest\">"+
							                    bd.getDigest()+
							                        "<div class=\"date\">"+
							                      	"Published: "+ bd.getPublishDate() +
							                        "</div>"+
							                    "</div>"+
							                    "<a class=\"comments\" href=\"displaycomments?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Comments ("+ bd.getCommentsCount() +")</a>"+
									                    "&nbsp;&nbsp;"+
							                    "<a class=\"solutions\" href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Solutions ("+ bd.getSolutionsCount() +")</a>");
							    		if (bd.isHasOfficial()){
							    			out.println("<a href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1#official\" class=\"solutionsimg\"><img src=\"images/official.png\"/></a>");
							    		}
							    		if (bd.isHasBest()){
							    			out.println("<a href=\"displaysolutions?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1#official\" class=\"solutionsimg\"><img src=\"images/best.png\"/></a>");
							    		}
							            out.println("</div>");
							    	}
							    	%>
		     		</div>
		     		<div class="leftrightbuttonbar">
						<div id="watchingbugsleftbutton2" class="leftbuttonhomepage" style="opacity:0">
						</div>
						<br>
						<div id="watchingbugsrightbutton2" class="rightbuttonhomepage"
						<%
						if (lsWatchingBugs2.size() <= 2)
							out.print("style='opacity:0'");
						%>
						>
					</div>
		    </div>
     </div>
					</div>
     <div class="mysolutions">
    	<div class="homepagesubtitle">My Solutions</div>
	    	<div class="anyrowbox">
			        <div class="mysolutionsrow">
					<%
						for (int i=0; i<lsMySolutions.size(); i++){
				    		sd = lsMySolutions.get(i);
				    		out.print("<div class=\"solutioncard\" id=\"mysolutionssolutioncard" + i + "\"");
				    		if (i > 1){
				    			out.print("style='display:none'");
				    		}
				    		out.println(">"+
				                	"<a href=\"bugpage?strBugNumber="+ sd.getBugNumber() +"\">"+sd.getBugNumber()+"</a>"+
				                    "<div class=\"digest\">");
				    		if (sd.getRawContent().length() > 70){
				    			out.print(sd.getRawContent().substring(0,65) + "   ...");
				    		}
				    		else{
				    			out.print(sd.getRawContent());
				    		}
				                   out.println("<div class=\"date\">"+
				                      	"Published: "+ sd.getDatetime() +
				                        "</div>"+
				                    "</div>"+
				                    "<div class=\"imgbar\">"+
				                    "<a class=\"solutionsimg\" href=\"displaysolutions?strBugNumber="+ sd.getBugNumber() +"&strNowPage=1#official\"><img src=\"images/uppressed.png\"/>"+sd.getUp()+"</a>"+
						            "<br><br>"+
						            "<a class=\"solutionsimg\" href=\"displaysolutions?strBugNumber="+ sd.getBugNumber() +"&strNowPage=1#official\"><img src=\"images/downpressed.png\"/>"+sd.getDown()+"</a>"+
						            "</div>"+
						            "</div>");
			    		}
			    	%>
			        </div>
					
		     	<div class="leftrightbuttonbar">
					<div id="mysolutionsleftbutton" class="leftbuttonhomepage" style="opacity:0">
					</div>
					<br>
					<div id="mysolutionsrightbutton" class="rightbuttonhomepage"
						<%
						if (lsMySolutions.size() <= 2)
							out.print("style='opacity:0'");
						%>
						>
				</div>
	     	</div>
     </div>
	</div>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
