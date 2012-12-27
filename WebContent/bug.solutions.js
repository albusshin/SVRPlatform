
function vote(type, id, caller) {
	var url = 'solutionvote_vote'+type+'?solutionId='+id;
	
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
		        		$(caller).attr('src','images/up.png');
						$(caller).attr('onmouseover','this.src=\'images/uppressed.png\'');
						$(caller).attr('onmouseout','this.src=\'images/up.png\'');
		        		$(caller).next().text(parseInt($(caller).next().text())-1);
						voting = false;
					}, 400);
	        	}
	        	else {
					setTimeout(function() {
		        		$(caller).attr('src','images/down.png');
						$(caller).attr('onmouseover','this.src=\'images/downpressed.png\'');
						$(caller).attr('onmouseout','this.src=\'images/down.png\'');
		        		$(caller).prev().text(parseInt($(caller).prev().text())+1);
						voting = false;
					}, 400);
	        	}
	        	if  (data == "creditsnotenough") {
	        		if (type == 'Up') $('div.message-text').html("Vote Up requires 15 credits");
	        		else $('div.message-text').html("Vote Down requires 125 credits");
	        	}
	        	if (data == "alreadyvoted") 
	        		$('div.message-text').html("Already voted!");
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
	$(".leftbarup").click(function() {
		if (voting) return;
		voting = true;
		if ($(this).attr('src') == "images/uppressed.png" || $(this).attr('src') == "images/up.png") {
			$(this).attr('src','images/upvoted.png');
			$(this).attr('onmouseover','');
			$(this).attr('onmouseout','');
			$(this).next().text(parseInt($(this).next().text())+1);
		}
		else {
			$(this).attr('src','images/up.png');
			$(this).attr('onmouseover','this.src=\'images/uppressed.png\'');
			$(this).attr('onmouseout','this.src=\'images/up.png\'');
			$(this).next().text(parseInt($(this).next().text())-1);
		}
		
		vote('Up', $(this).attr('id'), this);
	});
	$(".leftbardown").click(function() {
		if (voting) return;
		voting = true;
		if ($(this).attr('src') == "images/downpressed.png" || $(this).attr('src') == "images/down.png") {
			$(this).attr('src','images/downvoted.png');
			$(this).attr('onmouseover','');
			$(this).attr('onmouseout','');
			$(this).prev().text(parseInt($(this).prev().text())-1);
		}
		else {
			$(this).attr('src','images/down.png');
			$(this).attr('onmouseover','this.src=\'images/downpressed.png\'');
			$(this).attr('onmouseout','this.src=\'images/down.png\'');
			$(this).prev().text(parseInt($(this).prev().text())+1);
		}
		
		vote('Down', $(this).attr('id'), this);
	});
});
/*********************************vote end******************************************/

function showSolutionComment(solutionId) {
	var slidedown = '#solutioncommentstable' + solutionId;
	var length = $(slidedown).children(':first').children().length;
	for (var i = length-2; i >= 0; i--)	$(slidedown).children(':first').children().eq(i).remove();
	
	$.ajax({
	    url:'solutioncomments_displaySolutionComments?solutionId='+solutionId,
	    type:'GET',
	    cache: false,
	    contentType: false,    //must declare
	    processData: false,    //must declare
	    success:function(data){
	    	var bodyHtml = /<body.*?>([\s\S]*)<\/body>/.exec(data)[1];
	    	$(slidedown).children(':first').prepend(bodyHtml);
	    },
	    error:function(){
	   		$("#wrongmessage1").attr('style','display:block');
		}					             
	});
}

$(document).ready(function(){
	$(".commentsbutton").click(function(){
		if ($(this).attr('commentButtonClicked') != 'true') {
			$(this).attr('commentButtonClicked','true');
			showSolutionComment($(this).attr('id'));
		}
		else $(this).attr('commentButtonClicked','false');

		var slidedown = $(this).attr("slidedown");
		slidedown="#" + slidedown;
		$(slidedown).slideToggle("slow");
	});
	
	$('.submitcomment').click(function() {
		var data = new FormData();
		var solutionId = $(this).attr('id');
		
		data.append('solutionId', solutionId);
		data.append('content', $('#content'+$(this).attr('id')).val());
		$.ajax({
		    url:'solutioncomments_submitSolutionComment',
		    type:'POST',
		    cache: false,
		    data: data,
		    contentType: false,    //must declare
		    processData: false,    //must declare
		    success:function(data){
		    	if (data != 'fail') {
		    		showSolutionComment(solutionId);
		    		$('#content'+solutionId).val('');
		    	}
		    	else {
		    		$('div.message-text').html("submit comment failed.");
		    		$('#wrongmessage').attr('style','display:block');
		    	}
	        	
		    },
		    error:function(){
		   		$("#wrongmessage1").attr('style','display:block');
			}					             
		});
	});
	
	$('textarea[name=\"solutioneditbutton\"]').click(function() {
		var data = new FormData();
		data.append('solutionId',$('textarea[name=\"solutionsmodifytext\"]').attr('solutionId'));
		data.append('content',$('textarea[name=\"solutionsmodifytext\"]').val());
		$.ajax({
		    url:'solutionedit',
		    type:'POST',
		    cache: false,
		    data: data,
		    contentType: false,    //must declare
		    processData: false,    //must declare
		    success:function(data){
	        	alert();
		    },
		    error:function(){
		   		$("#wrongmessage1").attr('style','display:block');
			}					             
		});
	});
});
/*
"<tr class='solutioncomment'>"+
"<td class='solutioncommentuseravatartd'><img width='60px' class='solutioncommentuseravatar' src='http://www.gravatar.com/avatar/a6dc91974119e1d3ab253c7311e072fe'/></td>"+
"<td class='solutioncommentauthor'>Albus Shin</td>"+
"<td class='solutioncommentcontent'>"+
"asfdsadf"+
"</td>"+
"</tr>"*/