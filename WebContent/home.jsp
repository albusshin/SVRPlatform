<%@page import="com.SVRPlatform.Utils.VerifyUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Home - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript">
	function loadbackgroundname(){
			var strallbg = "url(images/sgbg";
			var ran = parseInt(Math.random()*9 + 1);
			strallbg += ran;
			strallbg += ".jpg) left top no-repeat";
			document.getElementById("content").setAttribute("style","background:"+strallbg+";");
		}
	$(document).ready(function(){
		loadbackgroundname();
		$("#mybugsrowrightbutton").click(function(){
			$("#mybugsbugcard1").hide(1000);
			$("#mybugsbugcard3").show(1000);
	});

});
	</script>
</head>
<body>
	<%
	
	String str = (String) session.getAttribute("email");
	if (str != null){
		str = "signedin";
	}
	
	%>
 		<jsp:include page="WEB-INF/header.jsp" flush="true">
 			<jsp:param name="type" value="<%=str%>"/>
 		</jsp:include>
	<div id="content">
	<div id="menu" class="menu">
                <ul>
                	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </li>
                    <li><a href="javascript:;"><image src="images/logo.png" width="54px" margin="10px"></image>MY HOME</a></li>
                    <li><a href="ranking.jsp">RANKING</a></li>
                    <li><a href="activities.jsp">ACTIVITIES</a></li>
                </ul>
            </div>
        <hr/>
            <div class="mybugs">
    	<div class="homepagesubtitle">My Bugs</div>
	<div class="anyrowbox">
		<div id="mybugsleftbutton" class="leftbuttonhomepage">
		</div>
    	<div class="mybugsrow" id="mybugsrow1">
        	<div class="bugcard" id="mybugsbugcard1">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                This bug is used to do a lot of things
                    <div class="date">
                  	Published: 2012-1-1
                    </div>
                </div>
                <a class="comments" href="#">Comments (47)</a>
                <a class="solutions" href="#">Solutions (3)</a>
                <a href="#" class="solutionsimg"><img src="images/official.png"/></a>
                <a href="#" class="solutionsimg"><img src="images/best.png"/></a>
            </div>
        	<div class="bugcard" id="mybugsbugcard2">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                This bug is used to do a lot of things
                    <div class="date">
                    	Published: 2012-1-1
                    </div>
                </div>
                <a class="comments" href="#">Comments (47)</a>
                <a class="solutions" href="#">Solutions (3)</a>
                <a href="#" class="solutionsimg"><img src="images/official.png"/></a>
                <a href="#" class="solutionsimg"><img src="images/best.png"/></a>
            </div>
        	<div class="bugcard" id="mybugsbugcard3" style="display:none">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                This bug is used to do a lot of things
                    <div class="date">
                  	Published: 2012-1-1
                    </div>
                </div>
                <a class="comments" href="#">Comments (47)</a>
                <a class="solutions" href="#">Solutions (3)</a>
                <a href="#" class="solutionsimg"><img src="images/official.png"/></a>
                <a href="#" class="solutionsimg"><img src="images/best.png"/></a>
     	</div>
                </div>
	</div>
		<div id="mybugsrightbutton" class="rightbuttonhomepage">
		</div>
     </div>
     
    <div class="watchingbugs">
    	<div class="homepagesubtitle">Watching Bugs</div>
	<div class="anyrowbox">
		<div id="watchingbugsleftbutton1" class="leftbuttonhomepage">
		</div>
    	<div class="watchingbugsrow">
        	<div class="bugcard">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                This bug is used to do a lot of things
                    <div class="date">
                    	Published: 2012-1-1
                    </div>
                </div>
                <a class="comments" href="#">Comments (47)</a>
                <a class="solutions" href="#">Solutions (3)</a>
                <a href="#" class="solutionsimg"><img src="images/official.png"/></a>
                <a href="#" class="solutionsimg"><img src="images/best.png"/></a>
            </div>
        	<div class="bugcard">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                This bug is used to do a lot of things
                    <div class="date">
                    	Published: 2012-1-1
                    </div>
                </div>
                <a class="comments" href="#">Comments (47)</a>
                <a class="solutions" href="#">Solutions (3)</a>
                <a href="#" class="solutionsimg"><img src="images/official.png"/></a>
                <a href="#" class="solutionsimg"><img src="images/best.png"/></a>
            </div>
     	</div>
       	</div>
       	
		<div id="watchingbugsrightbutton1" class="rightbuttonhomepage">
		</div>
	<div class="anyrowbox"> 
		<div id="watchingbugsleftbutton2" class="leftbuttonhomepage">
		</div>
    	<div class="watchingbugsrow">
        	<div class="bugcard">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                This bug is used to do a lot of things
                    <div class="date">
                    	Published: 2012-1-1
                    </div>
                </div>
                <a class="comments" href="#">Comments (47)</a>
                <a class="solutions" href="#">Solutions (3)</a>
                <a href="#" class="solutionsimg"><img src="images/official.png"/></a>
                <a href="#" class="solutionsimg"><img src="images/best.png"/></a>
            </div>
        	<div class="bugcard">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                This bug is used to do a lot of things
                    <div class="date">
                    	Published: 2012-1-1
                    </div>
                </div>
                <a class="comments" href="#">Comments (47)</a>
                <a class="solutions" href="#">Solutions (3)</a>
                <a href="#" class="solutionsimg"><img src="images/official.png"/></a>
                <a href="#" class="solutionsimg"><img src="images/best.png"/></a>
            </div>
     	</div>
	</div>
		<div id="watchingbugsrightbutton2" class="rightbuttonhomepage">
		</div>
     </div>
     <div class="mysolutions">
    	<div class="homepagesubtitle">My Solutions</div>
    	<div class="anyrowbox">
		<div id="watchingbugsleftbutton2" class="leftbuttonhomepage">
		</div>
        <div class="mysolutionsrow">
        	<div class="solutioncard">
            	<a href="#">SVRB-2012-00000023</a>
                <div class="digest">
                这个简直就是太简单了
                    <div class="date">
                    	Published: 2012-1-1
                    </div>
                </div>
                <div class="imgbar">
                    <a class="solutionsimg" href="#"><img src="images/uppressed.png"/>47</a>
                    <br>
                    <br>
                    <a class="solutionsimg" href="#"><img src="images/downpressed.png"/>3</a>
                </div>
            </div>
        </div>
		<div id="mysolutionsrightbutton" class="rightbuttonhomepage">
		</div>
     </div>
     </div>
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
