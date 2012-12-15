<%@ page language="java" contentType="text/html;  charset=utf-8"
	import="org.apache.commons.codec.digest.DigestUtils,java.util.List"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BUG Comments</title>
<link rel="stylesheet" href="style.css" />
<script type="text/javascript" src="jquery.min.js">
	
</script>
<style type="text/css">
div.commentsfooter {
	width: 180px;
	margin: auto;
	padding: inherit;
	padding-top: 50px;
	height: 50px;
	clear: both;
	padding-bottom: 100px;
}
</style>
</head>

<body>
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
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li><a href="bugpage?strBugNumber=${strBugNumber }"><image src="images/logo.png"
							width="54px" margin="10px"></image>BUG PAGE</a></li>
				<li><a href="javascript:;">COMMENTS</a></li>
				<li><a href="javascript:;">SOLUTIONS</a></li>
			</ul>
		</div>
		<hr />
		<div class="comments">
			<div class="commentstitle">${strCommentsAmount } Comments about
				bug ${strBugNumber }</div>
			<%
			List<String> contents, datetimes, emails, realnames, titles, creditss;
			contents = (List) request.getAttribute("contents");
			datetimes = (List)request.getAttribute("datetimes");
			emails = (List)request.getAttribute("emails");
			realnames = (List)request.getAttribute("realnames");
			titles = (List)request.getAttribute("titles");
			creditss = (List)request.getAttribute("creditss");
				for (int i=0; i<contents.size(); i++){
					String hash = emails.get(i);
					if (hash!=null){
						hash = DigestUtils.md5Hex(hash.trim().toLowerCase());
					}
					out.println("<div class='comment'>" + 
					"<div class='commenttitle'>"+titles.get(i)+"</div>" +
				"<div class='commenttext'>"+contents.get(i)+"</div>"+
				"<div class='commentfooter'>"+
				"	<div class='commentfooterdate'>Published:"+ datetimes.get(i) +
				"	</div>"+
				"	<img class='commentfooteravatar'"+
			"			src='http://www.gravatar.com/avatar/"+	 hash + "'>"+
			"		<div class='commentfooterauthor'>"+
			"			<div class='commentfooterauthorname'>"+
			"				<a href='#' class='msblack20'>"+realnames.get(i)+"</a>"+
			"			</div>"+
			"			<div class='commentfooterauthorcredit'>Credits: "+ creditss.get(i) +"</div>"+
			"		</div>"+
				"</div>"+
				"</div>");
					
				}
			%>
			<div class="commentsfooter">
				<img class="commentsfooterleft"
					onmouseover="this.src='images/leftpressed.png'"
					onmouseout="this.src='images/left.png'" src="images/left.png">
				<a class="commentsfooternow">1</a> <a href="#"
					class="commentsfooterlink">2</a> <a href="#"
					class="commentsfooterlink">3</a> <a href="#"
					class="commentsfooterlink">...</a> <img class="commentsfooterright"
					onmouseover="this.src='images/rightpressed.png'"
					onmouseout="this.src='images/right.png'" src="images/right.png">
			</div>
			<div class="commentstitle">Make your comment about bug
				${strBugNumber}</div>
			<div class="commentssubmit">
				<form id="commentssubmitform" action="makeComment" method="post">
					<table class="commentssubmittable">
						<tr>
							<td class="commentssubmitkey">Title</td>
							<td class="commentssubmitvalue"><textarea
									id="commentssubmittitle" name="commentssubmittitle" type="text"
									placeholder="Digest of your comment"></textarea></td>
						</tr>
						<tr>
							<td class="commentssubmitkey">Comment</td>
							<td class="commentssubmitvalue"><textarea
									id="commentssubmittext" name="commentssubmittext"
									placeholder="Say whatever you want except offensive words"></textarea>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="right"><input type="image" alt="submit"
								id="submitbutton" src="images/submitbutton.png"
								onMouseOver="this.src='images/submitbuttonpressed.png'"
								onMouseOut="this.src='images/submitbutton.png'"></td>
						</tr>
					</table>

				</form>
			</div>
		</div>


	</div>

	<jsp:include page="/footer.jsp" flush="true" />
</body>
</html>
