<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="org.apache.commons.codec.digest.DigestUtils,java.util.List, com.SVRPlatform.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%	
List<SolutionCommentData> solutionCommentsData = 
	((SolutionCommentsData)request.getAttribute("solutionCommentsData")).getSolutionCommentsData();


for(SolutionCommentData solutionCommentData : solutionCommentsData){
	//get the hash for mail address
			String mailAddressHash = DigestUtils.md5Hex(solutionCommentData.getEmail());
			out.println("<tr class='solutioncomment'>"+
							"<td class='solutioncommentuseravatartd'>"+
								"<img width='60px' class='solutioncommentuseravatar' src='http://www.gravatar.com/avatar/" + 
									mailAddressHash + //for the avatar
								"'/></td>"+
							"<td class='solutioncommentauthor'>" +
								solutionCommentData.getRealname() +
							"</td>" +
							"<td class='solutioncommentcontent'>"+
									solutionCommentData.getContent()+
							"</td>"+
						"</tr>");
}			
%>
</body>
</html>