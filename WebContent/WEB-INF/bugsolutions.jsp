<%@ page language="java" contentType="text/html;  charset=utf-8"
	import="org.apache.commons.codec.digest.DigestUtils,java.util.List, com.SVRPlatform.data.*"
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
int solutionsPerPage = 5;
String strBugNumber = (String)request.getAttribute("strBugNumber");
String strSolutionsAmount = (String)request.getAttribute("strSolutionsAmount");
int solutionsAmount = Integer.parseInt(strSolutionsAmount);
int pagesAmount;


String strNowPage = (String)request.getAttribute("strNowPage");
int nowPage = Integer.parseInt(strNowPage);
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
			if (strNowPage.equals("1")){
				SolutionData officialSolution = (SolutionData) request.getAttribute("officialSolution");
				String hashofficial = officialSolution.getEmail();
				if (hashofficial!=null){
					hashofficial = DigestUtils.md5Hex(hashofficial.trim().toLowerCase());
				}
				out.println("<table class=\"solution\">"+
						"<tr>"+
						"<td class=\"leftbar\">"+
						"<img class=\"leftbarup\" src=\"images/up.png\" onmouseover=\"this.src='images/uppressed.png'\" onmouseout=\"this.src='images/up.png'\" title=\"This solution works well for me\" >"+
						"<div class=\"leftbarsum\" align=\"center\" title=\"Solution Score\">"+(officialSolution.getUp()-officialSolution.getDown())+"</div>"+
						//这里有一个问题，就是用户只能点一次顶和踩，怎么实现，初期计划填俩表，一个up表一个down表。
						"<img class=\"leftbardown\" src=\"images/down.png\" onmouseover=\"this.src='images/downpressed.png'\" onmouseout=\"this.src='images/down.png'\" title=\"This solution seems not working\" >"+
						"<img class=\"leftbarbestofficial\" src=\"images/official.png\" title=\"This solution is provided by official\">"+"</td>"+
						"<td class=\"rightcontent\">"+
						"<div class=\"commenttext\">"+officialSolution.getContent()+"</div>"+
						"<div class=\"commentfooter\">"+
						" <div class=\"commentfooterdate\">"+
						"Published: "+officialSolution.getDatetime()+
						"</div>"+
						"<img class=\"commentfooteravatar\" src=\"http://www.gravatar.com/avatar/"+	 hashofficial + "\">"+
						" <div class=\"commentfooterauthor\">"+
						"<div class=\"commentfooterauthorname\">"+
						"<a href=\"#\" class=\"msblack20\">"+officialSolution.getRealname()+"</a>"+
						" </div>"+
						" <div class=\"commentfooterauthorcredit\">"+
						" Credits:  "+officialSolution.getCredits()+
						"</div>"+
						"</div>"+
						"</div>"+
						"</td>"+
						"</tr>"+
						"</table>");
				}
			for (int i=0; i<solutionData.size(); i++){
				String hash = solutionData.get(i).getEmail();
				if (hash!=null){
					hash = DigestUtils.md5Hex(hash.trim().toLowerCase());
				}
				
				out.println("<table class=\"solution\">"+
						"<tr>"+
						"<td class=\"leftbar\">"+
						"<img id=\"upButton\" class=\"leftbarup\" src=\"images/up.png\" onmouseover=\"this.src='images/uppressed.png'\" onmouseout=\"this.src='images/up.png'\" title=\"This solution works well for me\" >"+
						"<div class=\"leftbarsum\" align=\"center\" title=\"Solution Score\">"+(solutionData.get(i).getUp()-solutionData.get(i).getDown())+"</div>"+
						//这里有一个问题，就是用户只能点一次顶和踩，怎么实现，初期计划填俩表，一个up表一个down表。
						"<img id=\"downButton\" class=\"leftbardown\" src=\"images/down.png\" onmouseover=\"this.src='images/downpressed.png'\" onmouseout=\"this.src='images/down.png'\" title=\"This solution seems not working\" >");
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
						"<a href=\"#\" class=\"msblack20\">"+solutionData.get(i).getRealname()+"</a>"+
						" </div>"+
						" <div class=\"commentfooterauthorcredit\">"+
						" Credits:  "+solutionData.get(i).getCredits()+
						"</div>"+
						"</div>"+
						"</div>"+
						"</td>"+
						"</tr>"+
						"</table>");
			}
            %>
      </div><!-- 
	<script type="text/javascript">					
		$(document).ready(function(){
			$("#upButton").click(function(){
				if ()
				//create FormData
				var data = new FormData();
				
				//add data for FormData
				data.append('graph',$("#inputfile")[0].files[0]);
				$.ajax({
				    url:'uploadgraph',
				    type:'POST',
				    data:data,
				    cache: false,
				    enctype: 'multipart/form-data',
				    contentType: false,    //must declare
				    processData: false,    //must declare
				    success:function(data){
				        $("#uploadscreenshot").attr("src",data);
				        $("#uploadscreenshot").attr('style','display:block');
				        $("#hiddenpath").attr('value', data);
				    },
				    error:function(){
				   	 $("#wrongmessage1").attr('style','display:block');
					}					             
				});
			});
		});
	</script> -->
      


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
					%>
            <div class="commentstitle">
            	Give your solution on bug ${strBugNumber}
            </div>
            <div class="commentssubmit">
                <form id="commentssubmitform" action="submitSolution" method="post">
                	<input type="text" value="${strBugNumber}" style="display:none" name="strBugNumber">
                    <table class="commentssubmittable">
                        <tr>
                            <td class="commentssubmitkey">
                            	Solution
                            </td>
                            <td class="commentssubmitvalue">
                            	<textarea id="commentssubmittext" name="solutionssubmittext" placeholder="Be aware of following tips:
                                
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
