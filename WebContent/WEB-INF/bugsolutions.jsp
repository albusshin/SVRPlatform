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
	<script type="text/javascript">
		function vote(type, id, caller) {
			var url = 'solutionvote_vote'+type+'?solutionId='+id;
			
			$.ajax({
			    url:url,
			    type:'GET',
			    cache: false,
			    contentType: false,    //must declare
			    processData: false,    //must declare
			    success:function(data){
			    	
			        if (data == "success") {
			        }			        	
			        else if (data == "creditsnotenough" || data == "alreadyvoted" ||
			        			data == "owner" || data == "DBerror") {
			        	if  (type == 'Up')	{
							setTimeout(function() {
				        		$(caller).attr('src','images/up.png');
								$(caller).attr('onmouseover','this.src=\'images/uppressed.png\'');
								$(caller).attr('onmouseout','this.src=\'images/up.png\'');
				        		$(caller).next().text(parseInt($(caller).next().text())-1);
							}, 400);
			        	}
			        	else {
							setTimeout(function() {
				        		$(caller).attr('src','images/down.png');
								$(caller).attr('onmouseover','this.src=\'images/downpressed.png\'');
								$(caller).attr('onmouseout','this.src=\'images/down.png\'');
				        		$(caller).prev().text(parseInt($(caller).prev().text())+1);
							}, 400);
			        	}
			        	if  (data == "creditsnotenough") {
			        		if (type == 'Up') $('div.message-text').html("Vote Up requires 15 credits");
			        		else $('div.message-text').html("Vote Down requires 125 credits");
			        	}
			        	if (data == "alreadyvoted") 
			        		$('div.message-text').html("Already voted!");
			        	if (data == "owner")
			        		$('div.message-text').html("Cannot vote for yourself");
			        	$('#wrongmessage').attr('style','display:block');
			        }
			        else window.location.replace("notSignedIn");
			    },
			    error:function(){
			   		$("#wrongmessage1").attr('style','display:block');
				}					             
			});
		}
		
		$(document).ready(function(){
			$(".leftbarup").click(function() {
				if ($(this).attr('src') == "images/uppressed.png" || $(this).attr('src') == "images/up.png") {
					$(this).attr('src','images/upvoted.png');
					$(this).attr('onmouseover','');
					$(this).attr('onmouseout','');
					$(this).next().text(parseInt($(this).next().text())+1);
				}
				else {
					$(this).attr('src','images/up.png');
					$(this).attr('onmouseover','this.src=\'images/uppressed.png\'');
					$(this).attr('onmouseout','this.src=\'images/up.png\'');
					$(this).next().text(parseInt($(this).next().text())-1);
				}
				
				vote('Up', $(this).attr('id'), this);
			});
			$(".leftbardown").click(function() {
				if ($(this).attr('src') == "images/downpressed.png" || $(this).attr('src') == "images/down.png") {
					$(this).attr('src','images/downvoted.png');
					$(this).attr('onmouseover','');
					$(this).attr('onmouseout','');
					$(this).prev().text(parseInt($(this).prev().text())-1);
				}
				else {
					$(this).attr('src','images/down.png');
					$(this).attr('onmouseover','this.src=\'images/downpressed.png\'');
					$(this).attr('onmouseout','this.src=\'images/down.png\'');
					$(this).prev().text(parseInt($(this).prev().text())+1);
				}
				
				vote('Down', $(this).attr('id'), this);
			});
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
				<a class="dismiss" href="javascript:dismiss();">×</a>
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
			if (strNowPage.equals("1")){
				out.println("<a name='official'></a>");
				SolutionData officialSolution = (SolutionData) request.getAttribute("officialSolution");
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
							"<tr>"+
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
						"<tr>"+
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
    </div>
    
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
