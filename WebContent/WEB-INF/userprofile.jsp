<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="org.apache.commons.codec.digest.DigestUtils"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>${strRealName} - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
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
    	<div class="userprofile">
        	<div class="userprofiletitle">
            User Profile
            </div>
        	<div class="userprofiledigest">
        	<%
        	String strEmail = (String) request.getAttribute("strEmail");
			String hash = strEmail;
			if (hash!=null){
				hash = DigestUtils.md5Hex(hash.trim().toLowerCase());
			}
			out.println("<img class=\"userprofiledigestavatar\" src=\"http://www.gravatar.com/avatar/\">"+hash);
        	%>
                <table class="userprofiledigesttable">
                <tr>
                <td class="userprofiledigestleft">
                	Bio</td>
                <td class="userprofiledigestmiddle"><p>Website</p>
                  <p>Location</p>
                  <p>Email</p>
                  <p>Real Name</p>
                  <p>Age</p></td>
                <td class="userprofiledigestright">
                	<p id="website"> ${strWebsite}</p>
                    <p id="location"> ${strLocation}</p>
                    <p id="email"> ${strEmail}</p>
                    <p id="realname">${strRealname}</p>
                    <p id="age">19</p>
                    
                </td>
                </tr>
                <tr>
                <td class="userprofiledigestleft">
                	Visits</td>
                <td class="userprofiledigestmiddle"><p>Member for</p>
                  <p>Seen</p></td>
                <td class="userprofiledigestright">
                	<p id="memberfor" title="Joint: ${strDate }">2 days</p>
                	<p id="seen" title="${strSeen } ">${strRoughlySeen }</p>
                </td>
                </tr>
                <tr>
                <td class="userprofiledigestleft">
                	Stats
                </td>
                <td class="userprofiledigestmiddle">Profile Views
                </td>
                <td class="userprofiledigestright">
                	<p id="profileviews">${strProfileViews }</p>
                </td>
                </tr>
                </table>
        </div>
      	<table id="userprofiledetails">
        	<tr class="userprofiledetailstitle">
            	<td>
                	Credits
                </td>
                <td>
                	Bug Uploads
                </td>
            </tr>
            <tr class="userprofiledetailscontent">
            	<td id="credits">
                	<p id="creditsamount">Credits: ${strCredits }</p>
                </td>
                <td id="buguploads">
                	${strBugUploads }
                </td>
            </tr>
        	<tr class="userprofiledetailstitle">
            	<td>
                	Solutions
                </td>
                <td>
                	Comments
                </td>
            </tr>
            <tr class="userprofiledetailscontent">
            	<td id="solutions">
                	${strSolutions}
                </td>
                <td id="comments">
                	${strComments }
                </td>
            </tr>
        </table>
    </div>
    </div>
    
	<jsp:include page="/footer.jsp" flush="true" />
</body>
</html>
