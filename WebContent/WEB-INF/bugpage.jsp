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
</head>

<body>
<%--
<% 	String email=(String)request.getSession().getAttribute("email"); %>
<% 	if (email.equals("tourist")){ %>
	<jsp:include page="/Tourist.jsp" flush="true"/>
<%	}else{  %>
	<jsp:include page="/headerSignedIn.jsp" flush="true"/>
<% 		}%>
--%>
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
                    <li><a href="javascript:;">COMMENTS</a></li>
                    <li><a href="javascript:;">SOLUTIONS</a></li>
                </ul>
            </div>
        <p class="bugvulid">
        Bug Details:&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">SVRB-2012-0001</a>
        </p>
        <br>
        <div class="bugvuldigest">
         The QQ Program is a mother-fucking copy of MSN!!! This is the biggest bug in the world.
         <br>
         A.K.A. å°äºç¤¾ä¼ä¸ä¹è½æã
         <br>
         <div class="date">Publish Date: 2012-11-16</div>
        </div>
        <br>
        <p class="bugvulsubtitle">
        Bug Rating
        </p>
        <br>
        <br>
        <table class="bugvultable" align="center">
        	<tr>
            <td class="tableleft"> SVRB Score: </td>
            <td class="score" align="center"> 10.0 </td>
            </tr>
            <tr>
            <td class="tableleft"> Usability Impact: </td>
            <td class="tablemiddlegreen" align="center"> None </td>
            <td class="tableright"> There is none impact on functionality and usability of the software itself.</td>
            </tr>
            <tr>
            <td class="tableleft"> Data Impact: </td>
            <td class="tablemiddleorange" align="center"> Partial </td>
            <td class="tableright"> Some saved data might be lost when the bug is triggered.</td>
            </tr>
            <tr>
            <td class="tableleft"> Privacy Impact: </td>
            <td class="tablemiddlered" align="center"> Complete </td>
            <td class="tableright">User privacy is completely exposed when the bug is triggered.</td>
            </tr>
            <tr>
            <td class="tableleft"> Availability Impact: </td>
            <td class="tablemiddlegreen" align="center"> None </td>
            <td class="tableright"> There is none impact on the host's avaliability.</td>
            <tr>
            <td class="tableleft"> Frequency: </td>
            <td class="tablemiddlered" align="center"> Always </td>
            <td class="tableright"> There is very high probability to trigger the bug. </td>
            </tr>
		</table>
        <br>
    <br>
    	<p class="bugvulsubtitle">
        Bug Screenshots
        </p>
        <p class="bugvultext">
        <img src="images/screenshot.png" class="bugvulscreenshot">
        </p>
        <p class="bugvulsubtitle">
        Bug Description
        </p>
        <p class="bugvultext">
        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam cursus. Morbi ut mi. Nullam enim leo, egestas id, condimentum at, laoreet mattis, massa. Sed eleifend nonummy diam. Praesent mauris ante, elementum et, bibendum at, posuere sit amet, nibh. Duis tincidunt lectus quis dui viverra vestibulum. Suspendisse vulputate aliquam dui. Nulla elementum dui ut augue. Aliquam vehicula mi at mauris. Maecenas placerat, nisl at consequat rhoncus, sem nunc gravida justo, quis eleifend arcu velit quis lacus. Morbi magna magna, tincidunt a, mattis non, imperdiet vitae, tellus. Sed odio est, auctor ac, sollicitudin in, consequat vitae, orci. Fusce id felis. Vivamus sollicitudin metus eget eros.
Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In posuere felis nec tortor. Pellentesque faucibus. Ut accumsan ultricies elit. Maecenas at justo id velit placerat molestie. Donec dictum lectus non odio. Cras a ante vitae enim iaculis aliquam. Mauris nunc quam, venenatis nec, euismod sit amet, egestas placerat, est. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras id elit. Integer quis urna. Ut ante enim, dapibus malesuada, fringilla eu, condimentum quis, tellus. Aenean porttitor eros vel dolor. Donec convallis pede venenatis nibh. Duis quam. Nam eget lacus. Aliquam erat volutpat. Quisque dignissim congue leo.
		</p>
        
        <br>
        <p class="bugvulsubtitle">
        Products Affected By SVRB-2012-0001
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
                <td align="center"> Tencent </td>
                <td align="center"> QQ </td>
                <td align="center"> 2012 Beta 2.0 </td>
                <td align="center">&nbsp; </td>
                <td align="center">&nbsp; </td>
                <td align="center"> Chinese</td>
            </tr>
        </table>	
        <br>
        <br>
        <p class="bugvulsubtitle">
        Best Solution / Official Solution
        </p>
        <p class="bugvultext">
        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam cursus. Morbi ut mi. Nullam enim leo, egestas id, condimentum at, laoreet mattis, massa. Sed eleifend nonummy diam. Praesent mauris ante, elementum et, bibendum at, posuere sit amet, nibh. Duis tincidunt lectus quis dui viverra vestibulum. Suspendisse vulputate aliquam dui. Nulla elementum dui ut augue. Aliquam vehicula mi at mauris. Maecenas placerat, nisl at consequat rhoncus, sem nunc gravida justo, quis eleifend arcu velit quis lacus. Morbi magna magna, tincidunt a, mattis non, imperdiet vitae, tellus. Sed odio est, auctor ac, sollicitudin in, consequat vitae, orci. Fusce id felis. Vivamus sollicitudin metus eget eros.
Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In posuere felis nec tortor. Pellentesque faucibus. Ut accumsan ultricies elit. Maecenas at justo id velit placerat molestie. Donec dictum lectus non odio. Cras a ante vitae enim iaculis aliquam. Mauris nunc quam, venenatis nec, euismod sit amet, egestas placerat, est. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras id elit. Integer quis urna. Ut ante enim, dapibus malesuada, fringilla eu, condimentum quis, tellus. Aenean porttitor eros vel dolor. Donec convallis pede venenatis nibh. Duis quam. Nam eget lacus. Aliquam erat volutpat. Quisque dignissim congue leo.
		</p>
    </div>
    	<jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
