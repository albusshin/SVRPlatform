<%@ page language="java" contentType="text/html;  charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Submit New BUG Information - SVRPlatform</title>
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery.min.js"></script>
</head>

<body>

 		<jsp:include page="headerSignedIn.jsp" flush="true"/>
    <div id="content">
	<div class="commentstitle" style="padding-top:30px;">
		Submit New Bug Information
	</div>
	<style type="text/css">
	label#Score{
		margin-left:100px;
		padding-left:150px;
		padding-right:150px;
		background:#ff6600;
		font-size:40px;
	}
	</style>
	<script type="text/javascript">
		function selectionChanged(){
			var scores= new Array(5);
			var str;
			for(var i=0; i<5; i++){
				str = "sel" + i;
				var selection = document.getElementById(str).selectedIndex;
				var nowscore = 0;
				switch (selection){
					case 0:
						nowscore = 10.0;
						break;
					case 1:
						nowscore = 7.5;
						break;
					case 2:
						nowscore = 5.0;
						break;
					case 3:
						nowscore = 1.0;
						break;
				}
				scores[i] = nowscore;
			}
			var score = 0.0;
			/**
			 *	The algorithm of Scoring. Weighting is the most important thing.
			 */
			score = scores[0] + scores[1]*3 + scores[2]*5 + scores[3]*4 + scores[4]*2;
			score /= 15;
			document.getElementById("Score").innerHTML = score.toFixed(1) +"";
			if (score >= 9){
				document.getElementById("Score").style.background="#ff0000";
			}
			else if (score >= 8){
				document.getElementById("Score").style.background="#ff3300";
			}
			else if (score >= 7){
				document.getElementById("Score").style.background="#ff6600";
			}
			else if (score >= 6){
				document.getElementById("Score").style.background="#ff9900";
			}
			else if (score >= 5){
				document.getElementById("Score").style.background="#ffCC00";
			}
			else if (score >= 4){
				document.getElementById("Score").style.background="#99ff00";
			}
			else if (score >= 3){
				document.getElementById("Score").style.background="#66dd00";
			}
			else if (score >= 2){
				document.getElementById("Score").style.background="#11dd00";
			}
			else{
				document.getElementById("Score").style.background="green";
			}	
		}
	</script>
    	<form id="submitbug" action="submitbug" method="post">
        	<div class="submitbugdigest">
            	<table class="submitbugtable">
                <tr>
                	<td class="submitbugkey">
                    	<label for="digest" > Digest </label>
                    </td>
                    <td class="submitbugvalue">
                    	<textarea id="digest" name="digest" maxlength="300" tabindex="100" class="inputdigestvalue" placeholder="Bug digest should include software name, version and the symptom when it's triggered."></textarea>
                    </td>
	    </tr>
	    <tr>
		    <td class="submitbugkey">
			    <label for="Score"> Score </label>
		    </td>
		    <td class="submitbugvalue">
			    <label id="Score"> 7.5 </label>
		    </td>
	    </tr>
	    <tr>
		    <td class="submitbugkey">
			    <label for="Usability"> Usability Impact </label>
		    </td>
		    <td class="submitbugvalue">
			<select id="sel0" name="usabilityimpact" onChange="selectionChanged()">
 				 <option value ="Complete">Complete</option>
				 <option value ="Partial" selected="selected">Partial</option>
				 <option value="Little">Little</option>
 				 <option value="None">None</option>
			</select>   
		    </td>
	    </tr>
	    <tr>
		    <td class="submitbugkey">
			    <label for="Data"> Data Impact </label>
		    </td>
		    <td class="submitbugvalue">
			<select id="sel1" name="dataimpact" onChange="selectionChanged()">
 				 <option value ="Complete">Complete</option>
				 <option value ="Partial" selected="selected">Partial</option>
				 <option value="Little">Little</option>
 				 <option value="None">None</option>
			</select>  
		    </td>
	    </tr>
	    <tr>
		    <td class="submitbugkey">
			    <label for="Privacy"> Privacy Impact </label>
		    </td>
		    <td class="submitbugvalue">
			<select id="sel2" name="privacyimpact" onChange="selectionChanged()">
 				 <option value ="Complete">Complete</option>
				 <option value ="Partial" selected="selected">Partial</option>
				 <option value="Little">Little</option>
 				 <option value="None">None</option>
			</select>  
		    </td>
	    </tr>
	    <tr>
		    <td class="submitbugkey">
			    <label for="Availability"> Availability Impact </label>
		    </td>
		    <td class="submitbugvalue">
			<select id="sel3" name="availabilityimpact" onChange="selectionChanged()"> 
 				 <option value ="Complete">Complete</option>
				 <option value ="Partial" selected="selected">Partial</option>
				 <option value="Little">Little</option>
 				 <option value="None">None</option>
			</select>  
		    </td>
	    </tr>
	    <tr>
		    <td class="submitbugkey">
			    <label for="Frequency"> Frequency </label>
		    </td>
		    <td class="submitbugvalue">
			<select id="sel4" name="frequency" onChange="selectionChanged()">
 				 <option value ="Always">Always</option>
				 <option value ="Often" selected="selected">Often</option>
				 <option value="Sometimes">Sometimes</option>
 				 <option value="Merely">Merely</option>
			</select>  
		    </td>
	    </tr>
                <tr>
                	<td class="submitbugkey">
                    	<label for="description"> Description </label>
                    </td>
                    <td class="submitbugvalue">
                    	<textarea id="description" name="description" maxlength="300" tabindex="100" class="inputdigestvalue" placeholder="Bug description should be very specific about the bug itself, including software versions, software company, platform of running the software, and so on."></textarea>
                    </td>
                </tr>

		
		<tr>
			<td class="submitbugkey">
				<label for="Software"> Software </label>
			</td>
			<td class="submitbugvalue">
				<textarea id="software" name="software" maxlength="100" tabindex="100" class="inputdigestvalue" placeholder="Input the name of the buggy software"></textarea>
			</td>
		</tr>	
		<tr>
			<td class="submitbugkey">
				<label for="Version"> Version </label>
			</td>
			<td class="submitbugvalue">
				<textarea id="version" name="version" maxlength="100" tabindex="100" class="inputdigestvalue" placeholder="Input the version of the buggy software"></textarea>
			</td>
		</tr>
		<tr>
			<td class="submitbugkey">
				<label for="Language"> Language </label>
			</td>
			<td class="submitbugvalue">
				<textarea id="language" name="language" maxlength="100" tabindex="100" class="inputdigestvalue" placeholder="Input the language of the software"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
			<td>
				<input type="image" alt="submit" id="submitbutton" src="images/submitbutton.png" style="padding-left:400px; padding-top:50px; width:300px" onMouseOver="this.src='images/submitbuttonpressed.png'" onMouseOut="this.src='images/submitbutton.png'">
			</td>
		</tr>
                </table>
                
            </div>
	    
        </form>
        <form id="uploadScreenshotForm" action="upload.jsp" method="post" enctype="multipart/form-data" target="hiddenFrame">
	        <table class="submitbugtable">
	        <tr>
				<td class="submitbugkey">
					<label for="Screenshot"> Screenshot </label>
				</td>
				<td class="submitbugvalue">
					<script type="text/javascript">
						function uploadPressed() {
							document.getElementById("uploadfilebutton").click();
						}
						function changeScreenshot() {
							document.getElementById("uploadscreenshotbutton").style.display="none";
							document.getElementById("uploadScreenshotForm").submit();
						}
						function callback(msg) {
							document.getElementById("uploadscreenshot").value=msg;
							document.getElementById("uploadscreenshot").src=msg;
							document.getElementById("uploadscreenshot").style.display="block";
						}
					</script>
					<img id="uploadscreenshotbutton" src="images/uploadbutton.png" width="300px" onmouseover="this.src='images/uploadbuttonpressed.png'" onmouseout="this.src='images/uploadbutton.png'" onclick="uploadPressed()"/>
					<input id="uploadfilebutton" name="file" type="file" style="visibility:hidden" onchange="changeScreenshot()">
					<img id="uploadscreenshot" name="graphaddress" src="/"/>
				</td>
			</tr>
			</table>
		</form>
		<iframe id="hiddenFrame" name="hiddenFrame" style="display:none"></iframe>
    </div>
    
    ${message	}
    

 		<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>
