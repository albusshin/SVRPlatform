<%@ page language="java" contentType="text/html;  charset=utf-8"
    pageEncoding="utf-8"%>
   
   <!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>BUG Details</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js">
    </script>
    <script type="text/javascript">
		function vote(type, caller) {
			var url = 'bugvote_vote'+type+'?bugNumber='+$('#bugNumber').text();
			$.ajax({
			    url:url,
			    type:'GET',
			    cache: false,
			    contentType: false,    //must declare
			    processData: false,    //must declare
			    success:function(data){
			        if (data == "success") {
						voting = false;
			        }			        	
			        else if (data == "creditsnotenough" || data == "alreadyvoted" ||
			        			data == "owner" || data == "DBerror") {
			        	if  (type == 'Up')	{
							setTimeout(function() {
				        		$(caller).attr('src','images/watch.png');
								$(caller).attr('onmouseover','this.src=\'images/watchpressed.png\'');
								$(caller).attr('onmouseout','this.src=\'images/watch.png\'');
				        		$(caller).next().text(parseInt($(caller).next().text())-1);
								voting = false;
							}, 400);
			        	}
			        	else {
							setTimeout(function() {
				        		$(caller).attr('src','images/trash.png');
								$(caller).attr('onmouseover','this.src=\'images/trashpressed.png\'');
								$(caller).attr('onmouseout','this.src=\'images/trash.png\'');
				        		$(caller).next().text(parseInt($(caller).next().text())-1);
								voting = false;
							}, 400);
			        	}
			        	if  (data == "creditsnotenough") {
			        		if (type == 'Up') $('div.message-text').html("Watch requires 15 credits");
			        		else $('div.message-text').html("Vote Down requires 125 credits");
			        	}
			        	if (data == "alreadyvoted") 
			        		$('div.message-text').html("Already selected!");
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

		var voting = false;
		$(document).ready(function(){
			$("img.bugvulleftbarwatch").click(function() {
				if (voting) return;
				voting = true;
				if ($(this).attr('src') == "images/watchpressed.png" || $(this).attr('src') == "images/watch.png") {
					$(this).attr('src','images/nowwatch.png');
					$(this).attr('onmouseover','');
					$(this).attr('onmouseout','');
					$(this).next().text(parseInt($(this).next().text())+1);
				}
				else {
					$(this).attr('src','images/watch.png');
					$(this).attr('onmouseover','this.src=\'images/watchpressed.png\'');
					$(this).attr('onmouseout','this.src=\'images/watch.png\'');
					$(this).next().text(parseInt($(this).next().text())-1);
				}
				
				vote('Up', this);
			});
			$("img.bugvulleftbartrash").click(function() {
				if (voting) return;
				voting = true;
				if ($(this).attr('src') == "images/trashpressed.png" || $(this).attr('src') == "images/trash.png") {
					$(this).attr('src','images/nowtrash.png');
					$(this).attr('onmouseover','');
					$(this).attr('onmouseout','');
					$(this).next().text(parseInt($(this).next().text())+1);
				}
				else {
					$(this).attr('src','images/trash.png');
					$(this).attr('onmouseover','this.src=\'images/trashpressed.png\'');
					$(this).attr('onmouseout','this.src=\'images/trash.png\'');
					$(this).next().text(parseInt($(this).next().text())-1);
				}
				
				vote('Down', this);
			});
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
    	function dismiss() {
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
 			<jsp:param name="type" value="<%=str%>"/>
 		</jsp:include>
    <div id="content">
    <div id="menu" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>
                    <li><a href="javascript:;"><image src="images/logo.png" width="54px" margin="10px"></image>BUG PAGE</a></li>
                    <li><a href="displaycomments?strBugNumber=${strBugNumber }&strNowPage=1">COMMENTS</a></li>
                    <li><a href="displaysolutions?strBugNumber=${strBugNumber }&strNowPage=1#official">SOLUTIONS</a></li>
                </ul>
            </div>
        <p class="bugvulid">
        Bug Details:&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="bugNumber">${strBugNumber }</a>
        </p>
        <br>
        <div class="bugvuldigest">
        ${strBugDigest }
         <div class="date">Publish Date: ${strDate }</div>
        </div>
        <br>
        <p class="bugvulsubtitle">
        Bug Rating
        </p>
        <br>
        <br>
        <div class="bugvulrating">
        	<div class="bugvulleftbar">
        		<%
        		if (((String)request.getAttribute("strVotedUp")).equals("true")) {
        			out.println("<img class=\"bugvulleftbarwatch\" src=\"images/nowwatch.png\" onmouseover=\"\" onmouseout=\"\" title=\"Watch this bug\" >");
					out.println("<p class=\"bugvulleftbarwatch\" align=\"center\">"+(String)request.getAttribute("strUp")+"</p>");

        		}
        		else {
        			out.println("<img class=\"bugvulleftbarwatch\" src=\"images/watch.png\" onmouseover=\"this.src='images/watchpressed.png'\" onmouseout=\"this.src='images/watch.png'\" title=\"Watch this bug\" >");
					out.println("<p class=\"bugvulleftbarwatch\" align=\"center\">"+(String)request.getAttribute("strUp")+"</p>");
        		}
        		if (((String)request.getAttribute("strVotedDown")).equals("true")) {
					out.println("<img class=\"bugvulleftbartrash\" src=\"images/nowtrash.png\" onmouseover=\"\" onmouseout=\"\" title=\"Vote down for this bug\" >");
					out.println("<p class=\"bugvulleftbartrash\" align=\"center\">"+(String)request.getAttribute("strDown")+"</p>");
        		}
        		else {
					out.println("<img class=\"bugvulleftbartrash\" src=\"images/trash.png\" onmouseover=\"this.src='images/trashpressed.png'\" onmouseout=\"this.src='images/trash.png'\" title=\"Vote down for this bug\" >");
					out.println("<p class=\"bugvulleftbartrash\" align=\"center\">"+(String)request.getAttribute("strDown")+"</p>");
        		}
        		%>
			</div>
			<div class="bugvultablediv">
		        <table class="bugvultable" align="center">
		        	<tr>
		            <td class="tableleft"> SVRB Score: </td>
		            <td class="score" align="center"> ${strScore } </td>
		            </tr>
		            <tr>
		            <td class="tableleft"> Usability Impact: </td>
		            <td class="tablemiddlegreen" align="center"> ${strUsabilityImpact } </td>
		            <td class="tableright"> There is none impact on functionality and usability of the software itself.</td>
		            </tr>
		            <tr>
		            <td class="tableleft"> Data Impact: </td>
		            <td class="tablemiddleorange" align="center"> ${strDataImpact } </td>
		            <td class="tableright"> Some saved data might be lost when the bug is triggered.</td>
		            </tr>
		            <tr>
		            <td class="tableleft"> Privacy Impact: </td>
		            <td class="tablemiddlered" align="center"> ${strPrivacyImpact}</td>
		            <td class="tableright">User privacy is completely exposed when the bug is triggered.</td>
		            </tr>
		            <tr>
		            <td class="tableleft"> Availability Impact: </td>
		            <td class="tablemiddlegreen" align="center"> ${strAvailabilityImpact } </td>
		            <td class="tableright"> There is none impact on the host's avaliability.</td>
		            <tr>
		            <td class="tableleft"> Frequency: </td>
		            <td class="tablemiddlered" align="center"> ${strFrequency } </td>
		            <td class="tableright"> There is very high probability to trigger the bug. </td>
		            </tr>
				</table>
			</div>
		</div>
        <br>
    <br>
    	<p class="bugvulsubtitle">
        Bug Screenshots
        </p>
        <p class="bugvultext">
        <img src=${strScreenshotPath } class="bugvulscreenshot">
        </p>
        <p class="bugvulsubtitle">
        Bug Description
        </p>
        <p class="bugvultext">
        ${strBugDescription }
        </p>
        <p class="bugvultext">
        
        <br>
        <p class="bugvulsubtitle">
        Products Affected By ${strBugNumber } 
        </p>
        <br>
        <br>
        <table class="productstable" align="center" border="2">
        <th>&nbsp;&nbsp;#&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Product Type&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Vendor&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Product&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Version&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Update&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Edition&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Language&nbsp;&nbsp;</th>
        	<tr>
            	<td align="center"> 1 </td>
                <td align="center"> Application </td>
                <td align="center"> ${strCompany } </td>
                <td align="center"> ${strSoftware } </td>
                <td align="center"> ${strVersion } </td>
                <td align="center">&nbsp; </td>
                <td align="center">&nbsp; </td>
                <td align="center"> ${strLanguage}</td>
            </tr>
        </table>	
        <br>
        <br>
        <p class="bugvulsubtitle">
        Best Solution 
        </p>
        <p class="bugvultext">
        ${strBestSolution }
		</p>
		<p class="bugvulsubtitle">
		Official Solution
		</p>
		<p class="bugvultext">
		${strOfficialSolution }
		</p>
    </div>
    	<jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
