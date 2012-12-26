<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="org.apache.commons.codec.digest.DigestUtils,com.SVRPlatform.Utils.*"
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
			out.println("<img class=\"userprofiledigestavatar\" src=\"http://www.gravatar.com/avatar/"+hash+"?s=200\">");
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
                	<%
                	String strWebsite = (String) request.getAttribute("strWebsite");
					System.out.println("strWebsite == " + strWebsite);
					System.out.println("strEmail == " + strEmail);
					String nowUser = VerifyUser.getNowUser(request);
					System.out.println("nowUser == " + nowUser);
                	if (nowUser!=null && nowUser.equals(strEmail)){
                		out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<a align='center' onclick=\"document.getElementById('modifyuserprofile').setAttribute('style', 'display:block')\" class=\"edit-button\" href=\"javascript:;\" >Edit Profile</a>");
                	}
                	%>
                    <p id="location"> ${strLocation}</p>
                    <p id="email"> ${strEmail}</p>
                    <p id="realname">${strRealName}</p>
                    <p id="age">${strAge }</p>
                    
                </td>
                </tr>
                <tr>
                <td class="userprofiledigestleft">
                	Visits</td>
                <td class="userprofiledigestmiddle"><p>Member for</p>
                  <p>Seen</p></td>
                <td class="userprofiledigestright">
                	<p id="memberfor" title="Joint: ${strRegisterDate }">${strMemberFor }</p>
                	<p id="seen" title="Last Login: ${strLastSeenDate } ">${strSeen }</p>
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
    <div id="modifyuserprofile" style="display:none">
            	<form id="userprofilemodifyform" action="userprofile_submit?strEmail=${strEmail }" method="post">
                    <table class="modifyuserprofiletable">
                        <tr>
                            <td class="modifyprofiletkey">
                            	Website
                            </td>
                            <td class="modifyprofilevalue">
                            	<input class="modifyuserprofileinput" type="text" name="strWebsite" value="${strWebsite }"/>  
                            </td>
                        </tr>
                        <tr>
                            <td class="modifyprofiletkey">
                            	Location
                            </td>
                            <td class="modifyprofilevalue">
                            	<input class="modifyuserprofileinput" type="text" name="strLocation" value="${strLocation }"/>  
                            </td>
                        </tr>
                        <tr>
                            <td class="modifyprofiletkey">
                            	Real Name
                            </td>
                            <td class="modifyprofilevalue">
                            	<input class="modifyuserprofileinput" type="text" name="strRealName" value="${strRealName }"/>  
                            </td>
                        </tr>
                        <tr>
                            <td class="modifyprofiletkey">
                            	Age
                            </td>
                            <td class="modifyprofilevalue">
                            	<input class="modifyuserprofileinput" type="text" name="strAge" value="${strAge }"/>  
                            </td>
                        </tr>
                        <tr>
                        	<td>&nbsp;
                            	
                            </td>
                    	    <td align="right">
                  			 	<input type="image" alt="submit" id="submitbutton" src="images/submitbutton.png" onMouseOver="this.src='images/submitbuttonpressed.png'" onMouseOut="this.src='images/submitbutton.png'" onClick="document.getElementById('modifysolution').style='display:block'">
                            </td>
                        </tr>
                    </table>
                    
                </form>   
            </div>
    </div>
    
	<jsp:include page="/footer.jsp" flush="true" />
</body>
</html>
