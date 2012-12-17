<%@ page language="java" contentType="text/html;  charset=utf-8"
	import="org.apache.commons.codec.digest.DigestUtils,java.util.List"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>BUG Solutions</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js">
    </script>
    <style type="text/css">
    <%
int commentsPerPage = 5;
String strBugNumber = (String)request.getAttribute("strBugNumber");
String strCommentsAmount = (String)request.getAttribute("strCommentsAmount");
int commentsAmount = Integer.parseInt(strCommentsAmount);
int pagesAmount;


String strNowPage = (String)request.getAttribute("strNowPage");
int nowPage = Integer.parseInt(strNowPage);
if (commentsAmount % commentsPerPage == 0){
	pagesAmount = commentsAmount / commentsPerPage;
}
else
	pagesAmount = commentsAmount / commentsPerPage + 1;
	out.println("div.commentsfooter {"+
	"width:"+(pagesAmount*33+100) + "px;"+
	"margin: auto;"+
	"padding: inherit;"+
	"padding-top: 50px;"+
	"padding-left: 30px"+
	"height: 50px;"+
	"padding-bottom: 100px;"+
	"clear: both;"+
	"}");
%>
	</style>
</head>

<body>
<%
 		String stat = (String) request.getAttribute("strStat");
 		System.out.println("strStat == " + request.getAttribute("strStat"));
 		if (stat != null)
	 		if (stat.equals("wrong")){
	 			out.println("<div id=\"wrongmessage\" class=\"alert-messages\" style=\"display:block\">");
	 			out.println("<div class=\"message\">");
	 			out.println("<div class=\"message-inside\">");
	 			out.println("<div class=\"message-text\">");
	%>
		<div>
	 			${message }
	 	</div>
	<%
	 			out.println("</div>");
	 			out.println("<a class=\"dismiss\" href=\"javascript:dismiss();\">×</a>");
	 			out.println("</div>");
	 			out.println("</div>");
	 			out.println("</div>");
	 		}
 	%>
             	<script type="text/javascript">
             		function dismiss(){
             			document.getElementById("wrongmessage").setAttribute("style", "display:none");
             		}
             	</script>

	<%
		String str = (String) session.getAttribute("email");
		if (str != null){
			str = "signedin";
		}
	%>
	<jsp:include page="header.jsp" flush="true">
		<jsp:param name="type" value="<%=str%>" />
	</jsp:include>
	
    <div id="content">
    <div id="menu" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </li>
                    <li><a href="javascript:;"><image src="images/logo.png" width="54px" margin="10px"></image>BUG PAGE</a></li>
                    <li><a href="javascript:;">COMMENTS</a></li>
                    <li><a href="javascript:;">SOLUTIONS</a></li>
                </ul>
            </div>
        <hr/>
<div class="comments">
        	<div class="commentstitle">
            	{strSolutionsAmount} Solutions on Bug {strBugNumber}
            </div>
            <%
            List<String> contents, datetimes, emails, realnames, solutionScores, creditss;
			contents = (List) request.getAttribute("contents");
			datetimes = (List)request.getAttribute("datetimes");
			emails = (List)request.getAttribute("emails");
			realnames = (List)request.getAttribute("realnames");
			solutionScores = (List)request.getAttribute("solutionScores");
			creditss = (List)request.getAttribute("creditss"); 
			for (int i=0; i<contents.size(); i++){
				String hash = emails.get(i);
				if (hash!=null){
					hash = DigestUtils.md5Hex(hash.trim().toLowerCase());
				}
				out.println("<table class=\"solution\">"+
						"<tr>"+
						"<td class=\"leftbar\">"+
						"<img class=\"leftbarup\" src=\"images/up.png\" onmouseover=\"this.src='images/uppressed.png'\" onmouseout=\"this.src='images/up.png'\" title=\"This solution works well for me\" >"+
						"<div class=\"leftbarsum\" align=\"center\" title=\"Solution Score\">"+solutionScores.get(i)+"</div>"+
						//这里有一个问题，就是用户只能点一次顶和踩，怎么实现，初期计划填俩表，一个up表一个down表。
						"<img class=\"leftbardown\" src=\"images/down.png\" onmouseover=\"this.src='images/downpressed.png'\" onmouseout=\"this.src='images/down.png'\" title=\"This solution seems not working\" >"+
						"<img class=\"leftbarbestofficial\" src=\"images/official.png\" title=\"This solution is provided by official\">"+
						"</td>"+
						"<td class=\"rightcontent\">"+
						"<div class=\"commenttext\">"+contents.get(i)+"</div>"+
						"<div class=\"commentfooter\">"+
						" <div class=\"commentfooterdate\">"+
						"Published: "+datetimes.get(i)+
						"</div>"+
						"<img class=\"commentfooteravatar\" src=\"http://www.gravatar.com/avatar/"+	 hash + "\">"+
						" <div class=\"commentfooterauthor\">"+
						"<div class=\"commentfooterauthorname\">"+
						"<a href=\"#\" class=\"msblack20\">"+realnames.get(i)+"</a>"+
						" </div>"+
						" <div class=\"commentfooterauthorcredit\">"+
						" Credits:  "+creditss.get(i)+
						"</div>"+
						"</div>"+
						"</div>"+
						"</td>"+
						"</tr>"+
						"</table>");
			}
            %>
      </div>
            <div class="commentsfooter">
            	<img class="commentsfooterleft" onmouseover="this.src='images/leftpressed.png'" onmouseout="this.src='images/left.png'" src="images/left.png">
                <a class="commentsfooternow">1</a>
                <a href="#" class="commentsfooterlink">2</a>
                <a href="#" class="commentsfooterlink">3</a>
                <a href="#" class="commentsfooterlink">...</a>
            	<img class="commentsfooterright" onmouseover="this.src='images/rightpressed.png'" onmouseout="this.src='images/right.png'" src="images/right.png">
            </div>
            <div class="commentstitle">
            	Give your solution on bug {strBugNumber}
            </div>
            <div class="commentssubmit">
                <form id="commentssubmitform" action="giveSolution" method="post">
                    <table class="commentssubmittable">
                        <tr>
                            <td class="commentssubmitkey">
                            	Solution
                            </td>
                            <td class="commentssubmitvalue">
                            	<textarea id="commentssubmittext" name="solutiontext" placeholder="Be aware of following tips:
                                
                                1. Give useful solutions;
                                
                                2. Provide details and share your research;
                                
                                3. Do not make casual comments on this page,
                                
                                   Go to COMMENTS page to do so."></textarea>
                            </td>
                        </tr>
                        <tr>
                        	<td>&nbsp;
                            	
                            </td>
                    	    <td align="right">
                  			 	<input type="image" alt="submit" id="submitbutton" src="images/submitbutton.png" onMouseOver="this.src='images/submitbuttonpressed.png'" onMouseOut="this.src='images/submitbutton.png'">
                            </td>
                        </tr>
                    </table>
                    
                </form>   
            </div>
      </div>
        
        
    </div>
	<jsp:include page="/footer.jsp" flush="true" />
</body>
</html>
