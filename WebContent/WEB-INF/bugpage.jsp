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
        Bug Details:&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">${strBugNumber }</a>
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
