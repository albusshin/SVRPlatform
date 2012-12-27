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
			$("#mybugsbugcard" + nowmybugsbugcard).hide(1000);
			$("#mybugsbugcard" + nextmybugsbugcard).show(1000);
			if (nextmybugsbugcard == ("${myBugsAmount }")){
				$("#mybugsrightbutton").hide(1000);
			}
			nowmybugsbugcard++;
			nextmybugsbugcard++;
			$("#mybugsleftbutton").show(1000);
		});
		$("#mybugsleftbutton").click(function(){
			nowmybugsbugcard--;
			nextmybugsbugcard--;
			$("#mybugsbugcard" + nowmybugsbugcard).show(1000);
			$("#mybugsbugcard" + nextmybugsbugcard).hide(1000);
			if (nowmybugsbugcard == 0){
				$("#mybugsleftbutton").hide(1000);
			}
			$("#mybugsrightbutton").show(1000);
		});
		
		
		$("#watchingbugsrightbutton1").click(function(){
			$("#watchingbugsbugcard1" + nowwatchingbugsbugcard1).hide(1000);
			$("#watchingbugsbugcard1" + nextwatchingbugsbugcard1).show(1000);
			if (nextwatchingbugsbugcard1 == (document.getElementById("watchingbugsamount1").getAttribute("amount"))){
				$("#watchingbugsrightbutton1").hide(1000);
			}
			nowwatchingbugsbugcard1++;
			nextwatchingbugsbugcard1++;
			$("#watchingbugsleftbutton1").show(1000);
		});
		$("#watchingbugsleftbutton1").click(function(){
			nowwatchingbugsbugcard1--;
			nextwatchingbugsbugcard1--;
			$("#watchingbugsbugcard1" + nowwatchingbugsbugcard1).show(1000);
			$("#watchingbugsbugcard1" + nextwatchingbugsbugcard1).hide(1000);
			if (nowwatchingbugsbugcard1 == 0){
				$("#watchingbugsleftbutton1").hide(1000);
			}
			$("#watchingbugsrightbutton1").show(1000);
		});
		
		
		$("#watchingbugsrightbutton2").click(function(){
			$("#watchingbugsbugcard2" + nowwatchingbugsbugcard2).hide(1000);
			$("#watchingbugsbugcard2" + nextwatchingbugsbugcard2).show(1000);
			if (nextwatchingbugsbugcard2 == (document.getElementById("watchingbugsamount2").getAttribute("amount"))){
				$("#watchingbugsrightbutton2").hide(1000);
			}
			nowwatchingbugsbugcard2++;
			nextwatchingbugsbugcard2++;
			$("#watchingbugsleftbutton2").show(1000);
		});
		$("#watchingbugsleftbutton2").click(function(){
			nowwatchingbugsbugcard2--;
			nextwatchingbugsbugcard2--;
			$("#watchingbugsbugcard2" + nowwatchingbugsbugcard2).show(1000);
			$("#watchingbugsbugcard2" + nextwatchingbugsbugcard2).hide(1000);
			if (nowwatchingbugsbugcard2 == 0){
				$("#watchingbugsleftbutton2").hide(1000);
			}
			$("#watchingbugsrightbutton2").show(1000);
		});
		
		$("#mysolutionsrightbutton").click(function(){
			$("#mysolutionssolutioncard" + nowsolutionssolutioncard).hide(1000);
			$("#mysolutionssolutioncard" + nextsolutionssolutioncard).show(1000);
			if (nextsolutionssolutioncard == (document.getElementById("mysolutionsamount").getAttribute("amount"))){
				$("#mysolutionsrightbutton").hide(1000);
			}
			nowsolutionssolutioncard++;
			nextsolutionssolutioncard++;
			$("#mysolutionsleftbutton").show(1000);
		});
		$("#mysolutionsleftbutton").click(function(){
			nowsolutionssolutioncard--;
			nextsolutionssolutioncard--;
			$("#mysolutionssolutioncard" + nowsolutionssolutioncard).show(1000);
			$("#mysolutionssolutioncard" + nextsolutionssolutioncard).hide(1000);
			if (nowsolutionssolutioncard == 0){
				$("#mysolutionsleftbutton").hide(1000);
			}
			$("#mysolutionsrightbutton").show(1000);
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
	
	<div id="menu" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>
                    <li><a href="javascript:;"><image src="images/logo.png" width="54px" margin="10px"></image>MY HOME</a></li>
                    <li><a href="ranking.jsp">RANKING</a></li>
                    <li><a href="activities.jsp">ACTIVITIES</a></li>
                </ul>
            </div>
        <hr/>
            <div class="mybugs">
		    	<div class="homepagesubtitle">My Bugs</div>
					<div class="anyrowbox">
						<div id="mybugsleftbutton" class="leftbuttonhomepage" style="display:none">
						</div>
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
					</div>
					<%
						if (lsMyBugs.size() > 2){
							out.println("<div id=\"mybugsrightbutton\" class=\"rightbuttonhomepage\">");
							out.println("</div>");
						}
					%>
     		</div>
    <div class="watchingbugs">
    	<div class="homepagesubtitle">Watching Bugs</div>
			<div class="anyrowbox">
				<div id="watchingbugsleftbutton1" class="leftbuttonhomepage" style="display:none">
				</div>
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
		    </div>
					<%
						if (lsWatchingBugs1.size() > 2){
							out.println("<div id=\"watchingbugsrightbutton1\" class=\"rightbuttonhomepage\">");
							out.println("</div>");
						}
					%>
			<div class="anyrowbox"> 
				<div id="watchingbugsleftbutton2" class="leftbuttonhomepage" style="display:none">
				</div>
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
		    </div>
					<%
						if (lsWatchingBugs2.size() > 2){
							out.println("<div id=\"watchingbugsrightbutton2\" class=\"rightbuttonhomepage\">");
							out.println("</div>");
						}
					%>
     </div>
     <div class="mysolutions">
    	<div class="homepagesubtitle">My Solutions</div>
	    	<div class="anyrowbox">
				<div id="mysolutionsleftbutton" class="leftbuttonhomepage" style="display:none">
				</div>
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
				                    "<div class=\"digest\">"+
				                    sd.getContent()+
				                        "<div class=\"date\">"+
				                      	"Published: "+ sd.getDatetime() +
				                        "</div>"+
				                    "</div>"+
				                    "<div class=\"imgbar\">"+
				                    "<a class=\"solutionsimg\" href=\"bugpage?strBugNumber="+ sd.getBugNumber() +"\"><img src=\"images/uppressed.png\"/>"+sd.getUp()+"</a>"+
						            "<br><br>"+
						            "<a class=\"solutionsimg\" href=\"bugpage?strBugNumber="+ sd.getBugNumber() +"\"><img src=\"images/downpressed.png\"/>"+sd.getDown()+"</a>"+
						            "</div>"+
						            "</div>");
			    		}
			    	%>
			        </div>
					<%
						if (lsMySolutions.size() > 2){
							out.println("<div id=\"mysolutionsrightbutton\" class=\"rightbuttonhomepage\">");
							out.println("</div>");
						}
					%>
	     	</div>
     </div>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
