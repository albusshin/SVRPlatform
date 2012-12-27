<%@page import="com.SVRPlatform.Utils.VerifyUser,java.util.List,com.SVRPlatform.data.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
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
	$(document).ready(function(){
		loadbackgroundname();
		$("#mybugsrowrightbutton").click(function(){
			$("#mybugsbugcard1").hide(1000);
			$("#mybugsbugcard3").show(1000);
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
	<%
	List<BugData> lsMyBugs = (List<BugData>) request.getAttribute("lsMyBugs");
	List<BugData> lsWatchingBugs1 = (List<BugData>) request.getAttribute("lsWatchingBugs1");
	List<BugData> lsWatchingBugs2 = (List<BugData>) request.getAttribute("lsWatchingBugs2");
	List<SolutionData> lsMySolutions = (List<SolutionData>) request.getAttribute("lsMySolutions");
	BugData bd;
	SolutionData sd;
	%>
	<div id="menu" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </li>
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
					                	"<a href=\"#\">"+bd.getBugNumber()+"</a>"+
					                    "<div class=\"digest\">"+
					                    bd.getDigest()+
					                        "<div class=\"date\">"+
					                      	"Published: "+ bd.getPublishDate() +
					                        "</div>"+
					                    "</div>"+
					                    "<a class=\"comments\" href=\"displaycomments?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Comments ("+ bd.getCommentsCount() +")</a>"+
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
				<div id="watchingbugsleftbutton1" class="leftbuttonhomepage">
				</div>
		    		<div class="watchingbugsrow" id="watchingbugsrow1">
		    						<%
							    	for (int i=0; i<lsWatchingBugs1.size(); i++){
							    		bd = lsWatchingBugs1.get(i);
							    		out.print("<div class=\"bugcard\" id=\"watchingbugsbugcard" + i + "\"");
							    		if (i > 1){
							    			out.print("style='display:none'");
							    		}
							    		out.println(">"+
							                	"<a href=\"#\">"+bd.getBugNumber()+"</a>"+
							                    "<div class=\"digest\">"+
							                    bd.getDigest()+
							                        "<div class=\"date\">"+
							                      	"Published: "+ bd.getPublishDate() +
							                        "</div>"+
							                    "</div>"+
							                    "<a class=\"comments\" href=\"displaycomments?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Comments ("+ bd.getCommentsCount() +")</a>"+
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
				<div id="watchingbugsleftbutton2" class="leftbuttonhomepage">
				</div>
    				<div class="watchingbugsrow" id="watchingbugsrow2">
		    						<%
							    	for (int i=0; i<lsWatchingBugs2.size(); i++){
							    		bd = lsWatchingBugs2.get(i);
							    		out.print("<div class=\"bugcard\" id=\"watchingbugsbugcard" + i + "\"");
							    		if (i > 1){
							    			out.print("style='display:none'");
							    		}
							    		out.println(">"+
							                	"<a href=\"#\">"+bd.getBugNumber()+"</a>"+
							                    "<div class=\"digest\">"+
							                    bd.getDigest()+
							                        "<div class=\"date\">"+
							                      	"Published: "+ bd.getPublishDate() +
							                        "</div>"+
							                    "</div>"+
							                    "<a class=\"comments\" href=\"displaycomments?strBugNumber="+ bd.getBugNumber() +"&strNowPage=1\">Comments ("+ bd.getCommentsCount() +")</a>"+
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
				<div id="mysolutionsleftbutton" class="leftbuttonhomepage">
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
				                	"<a href=\"#\">"+sd.getBugNumber()+"</a>"+
				                    "<div class=\"digest\">"+
				                    sd.getContent()+
				                        "<div class=\"date\">"+
				                      	"Published: "+ sd.getDatetime() +
				                        "</div>"+
				                    "</div>"+
				                    "<div class=\"imgbar\">"+
				                    "<a class=\"solutionsimg\" href=\"#\"><img src=\"images/uppressed.png\"/>"+sd.getUp()+"</a>"+
						            "<br><br>"+
						            "<a class=\"solutionsimg\" href=\"#\"><img src=\"images/downpressed.png\"/>"+sd.getDown()+"</a>"+
						            "</div>"+
						            "</div>");
			    		}
			    	%>
			        </div>
				<div id="mysolutionsrightbutton" class="rightbuttonhomepage">
				</div>
	     	</div>
     </div>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
