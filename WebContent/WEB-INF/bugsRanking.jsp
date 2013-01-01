<%@page import="com.SVRPlatform.Utils.VerifyUser,java.util.List,com.SVRPlatform.data.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<%
		List<BugData> lsScoreBugsRanked = (List<BugData>) request.getAttribute("lsScoreBugsRanked");
		List<BugData> lsVotingBugsRanked = (List<BugData>) request.getAttribute("lsVotingBugsRanked");
		List<BugData> lsSolutionsBugsRanked = (List<BugData>) request.getAttribute("lsSolutionsBugsRanked");
		List<BugData> lsCommentsBugsRanked = (List<BugData>) request.getAttribute("lsCommentsBugsRanked");
		
		request.setAttribute("lsScoreBugsRankedAmount", lsScoreBugsRanked.size() - 1);
		request.setAttribute("lsVotingBugsRankedAmount", lsVotingBugsRanked.size() - 1);
		request.setAttribute("lsSolutionsBugsRankedAmount", lsSolutionsBugsRanked.size() - 1);
		request.setAttribute("lsCommentsBugsRankedAmount", lsCommentsBugsRanked.size() - 1);
		BugData bd;
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
	
	var nowscoresbugsbugcard = 0;
	var nextscoresbugsbugcard = nowscoresbugsbugcard + 2;

	var nowvotingbugsbugcard = 0;
	var nextvotingbugsbugcard = nowvotingbugsbugcard + 2;

	var nowsolutionsbugsbugcard = 0;
	var nextsolutionsbugsbugcard = nowsolutionsbugsbugcard + 2;
	
	var nowcommentsbugsbugcard = 0;
	var nextcommentsbugsbugcard = nowcommentsbugsbugcard + 2
	$(document).ready(function(){
		loadbackgroundname();
		$("#scoresbugsrightbutton").click(function(){
			if (nextscoresbugsbugcard == (${lsScoreBugsRankedAmount }+1)){
				return;
			}
			$("#scoresbugsbugcard" + nowscoresbugsbugcard).hide(200);
			$("#scoresbugsbugcard" + nextscoresbugsbugcard).show(200);
			if (nextscoresbugsbugcard == ("${lsScoreBugsRankedAmount }")){
				$("#scoresbugsrightbutton").animate({opacity:0}, "fast");
			}
			nowscoresbugsbugcard++;
			nextscoresbugsbugcard++;
			$("#scoresbugsleftbutton").animate({opacity:0.9}, "fast")
		});
		$("#scoresbugsleftbutton").click(function(){
			if (nowscoresbugsbugcard == 0){
				return;
			}
			nowscoresbugsbugcard--;
			nextscoresbugsbugcard--;
			$("#scoresbugsbugcard" + nowscoresbugsbugcard).show(200);
			$("#scoresbugsbugcard" + nextscoresbugsbugcard).hide(200);
			if (nowscoresbugsbugcard == 0){
				$("#scoresbugsleftbutton").animate({opacity:0}, "fast");
			}
			$("#scoresbugsrightbutton").animate({opacity:0.9}, "fast")
		});
		
		
		$("#votingbugsrightbutton").click(function(){
			if (nextvotingbugsbugcard == (${lsVotingBugsRanked })+1){
				return;
			}
			$("#votingbugsbugcard" + nowvotingbugsbugcard).hide(200);
			$("#votingbugsbugcard" + nextvotingbugsbugcard).show(200);
			if (nextvotingbugsbugcard == ("${lsVotingBugsRanked }")){
				$("#votingbugsrightbutton").animate({opacity:0}, "fast")
			}
			nowvotingbugsbugcard++;
			nextvotingbugsbugcard++;
			$("#votingbugsleftbutton").animate({opacity:0.9}, "fast")
		});
		$("#votingbugsleftbutton").click(function(){
			if (nowvotingbugsbugcard == 0){
				return;
			}
			nowvotingbugsbugcard--;
			nextvotingbugsbugcard--;
			$("#votingbugsbugcard" + nowvotingbugsbugcard).show(200);
			$("#votingbugsbugcard" + nextvotingbugsbugcard).hide(200);
			if (nowvotingbugsbugcard == 0){
				$("#votingbugsleftbutton").animate({opacity:0}, "fast")
			}
			$("#votingbugsrightbutton").animate({opacity:0.9}, "fast")
		});
		
		
		$("#solutionsbugsrightbutton").click(function(){
			if (nextsolutionsbugsbugcard == (${lsSolutionsBugsRanked })+1){
				return;
			}
			$("#solutionsbugsbugcard" + nowsolutionsbugsbugcard).hide(200);
			$("#solutionsbugsbugcard" + nextsolutionsbugsbugcard).show(200);
			if (nextsolutionsbugsbugcard == ("${lsSolutionsBugsRanked }")){
				$("#solutionsbugsrightbutton").animate({opacity:0}, "fast")
			}
			nowsolutionsbugsbugcard++;
			nextsolutionsbugsbugcard++;
			$("#solutionsbugsleftbutton").animate({opacity:0.9}, "fast")
		});
		$("#solutionsbugsleftbutton").click(function(){
			if (nowsolutionsbugsbugcard == 0){
				return;
			}
			nowsolutionsbugsbugcard--;
			nextsolutionsbugsbugcard--;
			$("#solutionsbugsbugcard" + nowsolutionsbugsbugcard).show(200);
			$("#solutionsbugsbugcard" + nextsolutionsbugsbugcard).hide(200);
			if (nowsolutionsbugsbugcard == 0){
				$("#solutionsbugsleftbutton").animate({opacity:0}, "fast")
			}
			$("#solutionsbugsrightbutton").animate({opacity:0.9}, "fast")
		});
		
		$("#commentsbugsrightbutton").click(function(){
			if (nextcommentsbugsbugcard == (${lsCommentsBugsRanked })+1){
				return;
			}
			$("#mycommentsbugsbugcard" + nowcommentsbugsbugcard).hide(200);
			$("#mycommentsbugsbugcard" + nextcommentsbugsbugcard).show(200);
			if (nextcommentsbugsbugcard == ("${lsCommentsBugsRanked}")){
				$("#commentsbugsrightbutton").animate({opacity:0}, "fast")
			}
			nowcommentsbugsbugcard++;
			nextcommentsbugsbugcard++;
			$("#commentsbugsleftbutton").animate({opacity:0.9}, "fast")
		});
		$("#commentsbugsleftbutton").click(function(){
			if (nowcommentsbugsbugcard == 0){
				return;
			}
			nowcommentsbugsbugcard--;
			nextcommentsbugsbugcard--;
			$("#mycommentsbugsbugcard" + nowcommentsbugsbugcard).show(200);
			$("#mycommentsbugsbugcard" + nextcommentsbugsbugcard).hide(200);
			if (nowcommentsbugsbugcard == 0){
				$("#commentsbugsleftbutton").animate({opacity:0}, "fast")
			}
			$("#commentsbugsrightbutton").animate({opacity:0.9}, "fast")
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
 		<jsp:include page="/WEB-INF/header.jsp" flush="true">
 			<jsp:param name="type" value="<%=str%>"/>
 		</jsp:include>
	<div id="content">
			<div id="menu" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>
                    <li><a href="/bugsRanking?timeType=5">Today</a></li>
                    <li><a href="/bugsRanking?timeType=7">This Week</a></li>
                    <li><a href="/bugsRanking?timeType=6">This Month</a></li>
                    <li><a href="/bugsRanking?timeType=8">This Year</a></li>
                </ul>
            </div>
            <hr/>
            <div class="scoresbugs">
		    	<div class="bugpagesubtitle">Bugs Ranked By Score  (<%out.print(lsScoreBugsRanked.size()); %>)</div>
					<div class="anyrowbox">
				    	<div class="scoresbugsrow">
					    	<%
					    	for (int i=0; i<lsScoreBugsRanked.size(); i++){
					    		bd = lsScoreBugsRanked.get(i);
					    		out.print("<div class=\"bugcard\" id=\"scoresbugsbugcard" + i + "\"");
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
						<div id="scoresbugsleftbutton" class="leftbuttonhomepage" style="opacity:0">
						</div>
						<br>
						
						<div id="scoresbugsrightbutton" class="rightbuttonhomepage"
						<%
						if (lsScoreBugsRanked.size() <= 2)
							out.print("style='opacity:0'");
						%>
						>
						</div>
				    </div>
					</div>
     		</div>
    <div class="votingbugs">
    	<div class="bugpagesubtitle">Bugs Ranked By Votes (<%out.print(lsVotingBugsRanked.size()); %>)</div>
			<div class="anyrowbox">
		    		<div class="votingbugsrow">
		    						<%
							    	for (int i=0; i<lsVotingBugsRanked.size(); i++){
							    		bd = lsVotingBugsRanked.get(i);
							    		out.print("<div class=\"bugcard\" id=\"votingbugsbugcard" + i + "\"");
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
							<div id="votingbugsleftbutton" class="leftbuttonhomepage" style="opacity:0">
							</div>
							<br>
							<div id="votingbugsrightbutton" class="rightbuttonhomepage"
						<%
						if (lsVotingBugsRanked.size() <= 2)
							out.print("style='opacity:0'");
						%>
						>
						</div>
		   			</div>
				    </div>
				    </div>
    <div class="solutionsbugs">
    	<div class="bugpagesubtitle">Bugs Ranked By Amount of Solutions (<%out.print(lsSolutionsBugsRanked.size()); %>)</div>
			<div class="anyrowbox"> 
    				<div class="solutionsbugsrow">
		    						<%
							    	for (int i=0; i<lsSolutionsBugsRanked.size(); i++){
							    		bd = lsSolutionsBugsRanked.get(i);
							    		out.print("<div class=\"bugcard\" id=\"solutionsbugsbugcard" + i + "\"");
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
						<div id="solutionsbugsleftbutton" class="leftbuttonhomepage" style="opacity:0">
						</div>
						<br>
						<div id="solutionsbugsrightbutton" class="rightbuttonhomepage"
						<%
						if (lsSolutionsBugsRanked.size() <= 2)
							out.print("style='opacity:0'");
						%>
						>
					</div>
		    </div>
     </div>
</div>


     <div class="commentsbugs">
    	<div class="bugpagesubtitle">Bugs Ranked By Amount of Solutions (<%out.print(lsCommentsBugsRanked.size()); %>)</div>
			<div class="anyrowbox"> 
    				<div class="commentsbugsrow" >
		    						<%
							    	for (int i=0; i<lsCommentsBugsRanked.size(); i++){
							    		bd = lsCommentsBugsRanked.get(i);
							    		out.print("<div class=\"bugcard\" id=\"commentsbugsbugcard" + i + "\"");
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
						<div id="commentsbugsleftbutton" class="leftbuttonhomepage" style="opacity:0">
						</div>
						<br>
						<div id="commentsbugsrightbutton" class="rightbuttonhomepage"
						<%
						if (lsCommentsBugsRanked.size() <= 2)
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
