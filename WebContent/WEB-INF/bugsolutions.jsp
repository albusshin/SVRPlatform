<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java" contentType="text/html;  charset=utf-8"
	import="org.apache.commons.codec.digest.DigestUtils,java.util.List, com.SVRPlatform.data.*"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>BUG Solutions</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript" src="bug.solutions.js"></script>
	<script type="text/javascript" src="showdown.js"></script>
	<script type="text/javascript" src="wmd.js"></script>
    <style type="text/css">
    <%
int solutionsPerPage = 5;
String strBugNumber = (String)request.getAttribute("strBugNumber");
String strSolutionsAmount = (String)request.getAttribute("strSolutionsAmount");
int solutionsAmount = Integer.parseInt(strSolutionsAmount);
int pagesAmount;
String strIsAlreadyGiven = (String)request.getAttribute("strIsAlreadyGiven");
boolean isAlreadyGiven;
if (strIsAlreadyGiven.equals("true")){
	isAlreadyGiven = true;
}
else{
	isAlreadyGiven = false;
}

String strNowPage = (String)request.getAttribute("strNowPage");
int nowPage = Integer.parseInt(strNowPage);
if (request.getAttribute("officialSolution") != null) solutionsAmount--;
if (solutionsAmount % solutionsPerPage == 0){
	pagesAmount = solutionsAmount / solutionsPerPage;
}
else
	pagesAmount = solutionsAmount / solutionsPerPage + 1;
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
	<script type="text/javascript">

		$(document).ready(function(){
				$('#closeButton').click(function(){
					$('#wrongmessage').hide(1000);
					});
			//if('/${strStat}' === 'wrong')
				if('${strStat}' === 'wrong'){
					$('div.message-text').html("${message}");
					$('#wrongmessage').show(1000);
				}
			});
	
		$(document).ready(function(){ 

			$('#official').animate({
				backgroundColor:"#0000cc",
			}, 50
			);
			$('#official').animate({
				backgroundColor:"#ffffff",
				}, 1000
			);
			$('#best').animate({
				backgroundColor:"#ff8800",
			}, 50
			);
			$('#best').animate({
				backgroundColor:"#ffffff",
				}, 1000
			);
		});
	</script>
</head>

<body>
	<div id="wrongmessage" class="alert-messages" style="display:none">
		<div class="message">
			<div class="message-inside">
				<div class="message-text">
				</div>
				<label id="closeButton" class="dismiss">×</label> <!--href="javascript:dismiss();" >×</a>-->
			</div>
		</div>
	</div>
             	<script type="text/javascript">
             		function dismiss(){
             			document.getElementById("wrongmessage").setAttribute("style", "display:none");
             		}
             		function dismiss1(){
             			document.getElementById("officialsolutionnotgiven").setAttribute("style", "display:none");
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
                    <li><a href="bugpage?strBugNumber=${strBugNumber }"><image src="images/logo.png" width="54px" margin="10px"></image>BUG PAGE</a></li>
                    <li><a href="displaycomments?strBugNumber=${strBugNumber }&strNowPage=1">COMMENTS</a></li>
                    <li><a href="javascript:;">SOLUTIONS</a></li>
                </ul>
            </div>
        <hr/>
<div class="comments">
        	<div class="commentstitle">
            	${strSolutionsAmount} Solutions on Bug ${strBugNumber}
            </div>
            <%
            List<SolutionData> solutionData = (List) request.getAttribute("solutionData");
            SolutionData officialSolution = null;
			out.println("<a name='official'></a>");
			if (strNowPage.equals("1")){
				officialSolution = (SolutionData) request.getAttribute("officialSolution");
				if (officialSolution == null){
			 			out.println("<div id=\"officialsolutionnotgiven\" class=\"alert-messages\" style=\"display:block\">");
			 			out.println("<div class=\"message\">");
			 			out.println("<div class=\"message-inside\">");
			 			out.println("<div class=\"message-text\">");
			 			out.println("Official solution not given yet.");
			 			out.println("</div>");
			 			out.println("<a class=\"dismiss\" href=\"javascript:dismiss1();\">×</a>");
			 			out.println("</div>");
			 			out.println("</div>");
			 			out.println("</div>");
				}
				else{
					String hashofficial = officialSolution.getEmail();
					if (hashofficial!=null){
						hashofficial = DigestUtils.md5Hex(hashofficial.trim().toLowerCase());
					}
					out.println("<table class=\"solution\" id='official'>"+
							"<tr class='solutionitself'>"+
							"<td class=\"leftbar\">");
							if (!officialSolution.isVotedUp())
								out.println("<img class=\"leftbarup\" src=\"images/up.png\" onmouseover=\"this.src='images/uppressed.png'\" onmouseout=\"this.src='images/up.png'\" title=\"This solution works well for me\" id=\""+ officialSolution.getSolutionID() + "\" >");
							else
								out.println("<img class=\"leftbarup\" src=\"images/upvoted.png\" title=\"Click again to undo\" id=\""+ officialSolution.getSolutionID() + "\" >");
							out.print("<div class=\"leftbarsum\" align=\"center\" title=\"Solution Score\">"+(officialSolution.getUp()-officialSolution.getDown())+"</div>");
							if (!officialSolution.isVotedDown())
								out.println("<img class=\"leftbardown\" src=\"images/down.png\" onmouseover=\"this.src='images/downpressed.png'\" onmouseout=\"this.src='images/down.png'\" title=\"This solution seems not working\" id=\""+ officialSolution.getSolutionID() + "\" >");
							else
								out.println("<img class=\"leftbardown\" src=\"images/downvoted.png\" title=\"Click again to undo\" id=\""+ officialSolution.getSolutionID() + "\" >");
									
									
									
									
							/*"<img class=\"leftbarup\" src=\"images/up.png\" onmouseover=\"this.src='images/uppressed.png'\" onmouseout=\"this.src='images/up.png'\" title=\"This solution works well for me\" id=\""+ officialSolution.getSolutionID() + "\" >"+
							"<div class=\"leftbarsum\" align=\"center\" title=\"Solution Score\">"+(officialSolution.getUp()-officialSolution.getDown())+"</div>"+
							"<img class=\"leftbardown\" src=\"images/down.png\" onmouseover=\"this.src='images/downpressed.png'\" onmouseout=\"this.src='images/down.png'\" title=\"This solution seems not working\" id=\""+ officialSolution.getSolutionID() + "\" >"+
							*/
							out.println("<img class=\"leftbarbestofficial\" src=\"images/official.png\" title=\"This solution is provided by official\">"+"</td>"+
							"<td class=\"rightcontent\">"+
							"<div class=\"commenttext\">"+officialSolution.getContent()+"</div>"+
							"<div class=\"commentfooter\">"+
							" <div class=\"commentfooterdate\">"+
							"Published: "+officialSolution.getDatetime()+
							"</div>"+
							"<img class=\"commentfooteravatar\" src=\"http://www.gravatar.com/avatar/"+	 hashofficial + "\">"+
							" <div class=\"commentfooterauthor\">"+
							"<div class=\"commentfooterauthorname\">"+
							"<a href=\"userprofile_display?strEmail="+officialSolution.getEmail()+"\" class=\"msblack20\">"+officialSolution.getRealname()+"</a>"+
							" </div>"+
							" <div class=\"commentfooterauthorcredit\">"+
							" Credits:  "+officialSolution.getCredits()+
							"</div>"+
							"</div>");
							if (officialSolution.getEmail().equals(VerifyUser.getNowUser(request)))
							{
									out.println("<div class='solutionbuttons'>");
									out.println("<a align='center' onclick=\"document.getElementById('modifysolution').setAttribute('style', 'display:block')\" class=\"edit-button\" href=\"#modify\" >edit</a>");
									out.println("<a align='center' class=\"edit-button  commentsbutton\" slidedown='solutioncommentstable"+officialSolution.getSolutionID()+"' href='javascript:;' id='"+officialSolution.getSolutionID()+"'>comments</a>");
									out.println("</div>");
							}
							else{
								out.println("<div class='solutionbuttons'>");
								out.println("<a align='center' class=\"edit-button  commentsbutton\" slidedown='solutioncommentstable"+officialSolution.getSolutionID()+"' href='javascript:;' id='"+officialSolution.getSolutionID()+"'>comments</a>");
								out.println("</div>");
							}
					out.println("</div>"+
					"</td>"+
					"</tr>"+
					"</table>"+
					"<div id='solutioncommentstable"+officialSolution.getSolutionID()+"' style='display:none'>"+
					"<table class='solutioncommentstable'>"+
							"<tr class='solutioncomment'>");

					String makecommentsolutionhash = VerifyUser.getNowUser(request);
					if (makecommentsolutionhash!=null){
						makecommentsolutionhash = DigestUtils.md5Hex(makecommentsolutionhash.trim().toLowerCase());
					}
		
			out.println("<td class='solutioncommentuseravatartd'><img width='60px' class='solutioncommentuseravatar' src='http://www.gravatar.com/avatar/"+makecommentsolutionhash+"'/></td>"+
			"<td class='solutioncommentauthor'>"+VerifyUser.getNowUserRealname(request)+"</td>"+
			"<td class='solutioncommentcontent'>"+
			"<textarea class='makesolutioncomment' id='content"+officialSolution.getSolutionID()+"'></textarea>"+
      		"<input class='submitcomment' type=\"image\" style='padding-left:20px;' width='50px' id=\""+officialSolution.getSolutionID()+"\" src=\"images/submiticon.png\" onMouseOver=\"this.src='images/submiticonpressed.png'\" onMouseOut=\"this.src='images/submiticon.png'\"\">"+
			"</td>"+
			"</tr>"+
					"</table>"+
					"</div>");
				}
			}
			for (int i=0; i<solutionData.size(); i++){
				String hash = solutionData.get(i).getEmail();
				if (hash!=null){
					hash = DigestUtils.md5Hex(hash.trim().toLowerCase());
				}
				
				out.println("<table class=\"solution\"");
				if (solutionData.get(i).isBest()){
					out.print("id='best'");
				}
						out.print(">"+
						"<tr class='solutionitself'>"+
						"<td class=\"leftbar\">");
						if (!solutionData.get(i).isVotedUp())
							out.println("<img class=\"leftbarup\" src=\"images/up.png\" onmouseover=\"this.src='images/uppressed.png'\" onmouseout=\"this.src='images/up.png'\" title=\"This solution works well for me\" id=\""+ solutionData.get(i).getSolutionID() + "\" >");
						else
							out.println("<img class=\"leftbarup\" src=\"images/upvoted.png\" title=\"Click again to undo\" id=\""+ solutionData.get(i).getSolutionID() + "\" >");
						out.print("<div class=\"leftbarsum\" align=\"center\" title=\"Solution Score\">"+(solutionData.get(i).getUp()-solutionData.get(i).getDown())+"</div>");
						if (!solutionData.get(i).isVotedDown())
							out.println("<img class=\"leftbardown\" src=\"images/down.png\" onmouseover=\"this.src='images/downpressed.png'\" onmouseout=\"this.src='images/down.png'\" title=\"This solution seems not working\" id=\""+ solutionData.get(i).getSolutionID() + "\" >");
						else
							out.println("<img class=\"leftbardown\" src=\"images/downvoted.png\" title=\"Click again to undo\" id=\""+ solutionData.get(i).getSolutionID() + "\" >");
				if (solutionData.get(i).isBest()){
					out.println("<img class=\"leftbarbestofficial\" src=\"images/best.png\" title=\"This solution is selected as the best answer\">");
				}
						out.println("</td>"+
						"<td class=\"rightcontent\">"+
						"<div class=\"commenttext\">"+solutionData.get(i).getContent()+"</div>"+
						"<div class=\"commentfooter\">"+
						" <div class=\"commentfooterdate\">"+
						"Published: "+solutionData.get(i).getDatetime()+
						"</div>"+
						"<img class=\"commentfooteravatar\" src=\"http://www.gravatar.com/avatar/"+	 hash + "\">"+
						
						" <div class=\"commentfooterauthor\">"+
						"<div class=\"commentfooterauthorname\">"+
						"<a href=\"userprofile_display?strEmail="+solutionData.get(i).getEmail()+"\" class=\"msblack20\">"+solutionData.get(i).getRealname()+"</a>"+
						" </div>"+
						" <div class=\"commentfooterauthorcredit\">"+
						" Credits:  "+solutionData.get(i).getCredits()+
						"</div>"+
						"</div>");
								if (solutionData.get(i).getEmail().equals(VerifyUser.getNowUser(request)))
								{
										out.println("<div class='solutionbuttons'>");
										out.println("<a align='center' onclick=\"document.getElementById('modifysolution').setAttribute('style', 'display:block')\" class=\"edit-button\" href=\"#modify\" >edit</a>");
										out.println("<a align='center' class=\"edit-button  commentsbutton\" slidedown='solutioncommentstable"+solutionData.get(i).getSolutionID()+"' href='javascript:;'id='"+solutionData.get(i).getSolutionID()+"'>comments</a>");
										out.println("</div>");
								}
								else{
									out.println("<div class='solutionbuttons'>");
									out.println("<a align='center' class=\"edit-button  commentsbutton\" slidedown='solutioncommentstable"+solutionData.get(i).getSolutionID()+"' href='javascript:;' id='"+solutionData.get(i).getSolutionID()+"'>comments</a>");
									out.println("</div>");
								}
						out.println("</div>"+
						"</td>"+
						"</tr>"+
						"</table>"+
						"<div id='solutioncommentstable"+solutionData.get(i).getSolutionID()+"' style='display:none'>"+
						"<table class='solutioncommentstable'>"+
				"<tr class='solutioncomment'>");

						String makecommentsolutionhash = VerifyUser.getNowUser(request);
						if (makecommentsolutionhash!=null){
							makecommentsolutionhash = DigestUtils.md5Hex(makecommentsolutionhash.trim().toLowerCase());
						}
			
				out.println("<td class='solutioncommentuseravatartd'><img width='60px' class='solutioncommentuseravatar' src='http://www.gravatar.com/avatar/"+makecommentsolutionhash+"'/></td>"+
				"<td class='solutioncommentauthor'>"+VerifyUser.getNowUserRealname(request)+"</td>"+
				"<td class='solutioncommentcontent'>"+
				"<textarea class='makesolutioncomment' id='content"+solutionData.get(i).getSolutionID()+"'></textarea>"+
          		"<input class='submitcomment' type=\"image\" style='padding-left:20px;' width='50px' id=\""+solutionData.get(i).getSolutionID()+"\" src=\"images/submiticon.png\" onMouseOver=\"this.src='images/submiticonpressed.png'\" onMouseOut=\"this.src='images/submiticon.png'\"\">"+
				"</td>"+
				"</tr>"+
				"</table>"+
				"</div>");
			}
            %>
            <%
            
            
            
					
/**
* Firstly, we need to output the previous page image link
*/
					out.println("	<div class=\"commentsfooter\">"+
	"					<img class=\"commentsfooterleft\""+
	"						onmouseover=\"this.src='images/leftpressed.png'\""+
	"						onmouseout=\"this.src='images/left.png'\" src=\"images/left.png\"");
						if (nowPage > 1)
							out.print("onclick=\"window.location.href='displaysolutions?strNowPage="+(nowPage-1)+"&strBugNumber="+(strBugNumber )+"'\">");
						else
							out.print(">");
						
					/**
					* Next, we need to output the links of numbers;
					*/
					
					
					for (int i=1; i<pagesAmount+1; i++){
						if (i == nowPage){
							out.print("<a class=\"commentsfooternow\">"+ i + "</a>");
						}
						else{
							out.print("<a href=\"displaysolutions?strNowPage="+ i +"&strBugNumber="+(strBugNumber )+"\" class=\"commentsfooterlink\">"+i+"</a>");
						}
					}
					
					/**
					* Finally, we output the next page link image.
					*/
					out.println("					<img class=\"commentsfooterright\""+
							"						onmouseover=\"this.src='images/rightpressed.png'\""+
							"						onmouseout=\"this.src='images/right.png'\" src=\"images/right.png\"");
												
												if (nowPage < pagesAmount)
													out.print("onclick=\"window.location.href='displaysolutions?strNowPage="+(nowPage+1)+"&strBugNumber="+(strBugNumber )+"'\">");
												else
													out.print(">");	
					out.println("</div>");
					
					
					
					if (isAlreadyGiven){
						out.println("<div class=\"commentstitle\">"+
				            	"Modify your solution on bug "+strBugNumber+
				            	"<a name='modify'/>"+
			         "   </div>"+
			          "  <div class=\"commentssubmit\">"+
			            	"<form id=\"solutionmodifyform\" action=\"submitSolution_edit?strNowPage="+ strNowPage +"\" method=\"post\">"+
			                	"<input type=\"text\" value=\""+ strBugNumber +"\" style=\"display:none\" name=\"strBugNumber\">"+
			                    "<table class=\"commentssubmittable\">"+
			                       " <tr>"+
			                         "<td class=\"commentssubmitkey\">"+
			                     	" &nbsp;"+
			                        "    </td>"+
			                       "     <td class=\"commentssubmitvalue\">");
			             out.println("<div id=\"wmd-editor\" class=\"wmd-panel\">"
			                     +"<div id=\"wmd-button-bar\"></div>");
			                     out.print("<textarea id=\"wmd-input\" class=\"commentssubmittext\" name=\"solutionssubmittext\">");
			                     for (SolutionData s:solutionData){
			                     	if (s.getEmail().equals(VerifyUser.getNowUser(request))){
			                     		out.print(s.getContent());
			                     		break;
			                     		/*这里需要转义。*/
			                     	}
			                     }
			                     if (officialSolution != null)
			                         if (officialSolution.getEmail().equals(VerifyUser.getNowUser(request)))
			                     		out.print(officialSolution.getContent());
			                     out.print("</textarea>");
			                     out.println("</div>");
			                     out.println("<div id=\"wmd-preview\" class=\"wmd-panel\"></div>");
			                     out.println("</td>"+
			                            " </tr>"+
			                           "  <tr>"+
			                             	"<td>&nbsp;"+
			                               "  </td>"+
			                         	    "<td align=\"right\">"+
			                       			 	"<input type=\"image\" alt=\"submit\" id=\"submitbutton\" src=\"images/submitbutton.png\" onMouseOver=\"this.src='images/submitbuttonpressed.png'\" onMouseOut=\"this.src='images/submitbutton.png'\">"+
			                            "     </td>"+
			                       "     </tr>"+
			                      "   </table>"+
			                   "  </form></div>   ");
			            }
					if (!isAlreadyGiven){
						out.println("<div class=\"commentstitle\">"+
				            	"Give your solution on bug "+strBugNumber+
			         "   </div>"+
			          "  <div class=\"commentssubmit\">"+
			               " <form id=\"commentssubmitform\" action=\"submitSolution_execute\" method=\"post\">"+
			                	"<input type=\"text\" value=\""+strBugNumber+"\" style=\"display:none\" name=\"strBugNumber\">"+
			                   " <table class=\"commentssubmittable\">"+
			                    "    <tr>"+
			                     "       <td class=\"commentssubmitkey\">"+
			                      "      	&nbsp;"+
			                       "     </td>"+
			                        "    <td class=\"commentssubmitvalue\">"+
									"		<div id=\"wmd-editor\" class=\"wmd-panel\">"+
									"			<div id=\"wmd-button-bar\"></div>"+
				                     "       	<textarea id=\"wmd-input\" class=\"commentssubmittext\" name=\"solutionssubmittext\" placeholder=\"Please give useful solutions; provide details and share your research;and do not make casual comments on this page,go to COMMENTS page to do so.\" ></textarea>"+
				                      "      </div>"+
				                       "     <div id=\"wmd-preview\" class=\"wmd-panel\"></div>"+
			                            "</td>"+
			          "              </tr>"+
			          "              <tr>"+
			           "             	<td>&nbsp;"+
			             "               </td>"+
			              "      	    <td align=\"right\">"+
			               "   			 	<input type=\"image\" alt=\"submit\" id=\"submitbutton\" src=\"images/submitbutton.png\" onMouseOver=\"this.src='images/submitbuttonpressed.png'\" onMouseOut=\"this.src='images/submitbutton.png'\">"+
			                "            </td>"+
			                 "       </tr>"+
			                  "  </table>"+
			       "         </form>   "+
			        "    </div>");
					}
					%>
      </div>
    </div>
	<jsp:include page="/footer.jsp" flush="true" />
</body>
</html>
