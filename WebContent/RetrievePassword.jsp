<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Retrieve Password - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>
 		<jsp:include page="WEB-INF/headerSignedIn.jsp" flush="true"/>
	<div id="content">
		<div class="commentstitle" style="padding-top:30px;">
			Submit New Bug Information
		</div>
		<form id="retrieve" action="RetrievePassword" method="post">
			<table class="submitbugtable">
                <tr>
                	<td class="submitbugkey">
                    	<label for="email" > Email </label>
                    </td>
                    <td class="submitbugvalue">
                    	<textarea id="email" name="email" maxlength="300" tabindex="100" class="inputdigestvalue" placeholder="Input your email address"></textarea>
                    </td>
	   			</tr>
	   		 </table>
		</form>
		
	</div>
    <jsp:include page="/footer.html" flush="true"/>
</body>
</html>
