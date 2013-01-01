<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Privacy - SVRPlatform</title>
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
 		<jsp:include page="WEB-INF/header.jsp" flush="true">
 			<jsp:param name="type" value="<%=str%>"/>
 		</jsp:include>
	<div id="content">
	
		<div class="article">
  <h2>SVRPlatform Privacy Policy</h2>


  <div class="article-body content-body wikistyle markdown-format">
      <h3>General Information</h3>

<p>We collect the e-mail addresses of those who communicate with us via e-mail, aggregate information on what pages consumers access or visit, and information volunteered by the consumer (such as survey information and/or site registrations). The information we collect is used to improve the content of our Web pages and the quality of our service, and is not shared with or sold to other organizations for commercial purposes, except to provide products or services you&#39;ve requested, when we have your permission, or under the following circumstances:</p>

<ul>
<li>It is necessary to share information in order to investigate, prevent, or take action regarding illegal activities, suspected fraud, situations involving potential threats to the physical safety of any person, violations of <a href="/terms">Terms of Service</a>, or as otherwise required by law.</li>
<li>We transfer information about you if SVRPlatform is acquired by or merged with another company. In this event, SVRPlatform will notify you before information about you is transferred and becomes subject to a different privacy policy.</li>
</ul>

<h3>Information Gathering and Usage</h3>

<ul>
<li>When you register for SVRPlatform we ask for information such as your name, email address, billing address, credit card information. Members who sign up for the free account are not required to enter a credit card.</li>
<li>SVRPlatform uses collected information for the following general purposes: products and services provision, billing, identification and authentication, services improvement, contact, and research.</li>
</ul>

<h3>Cookies</h3>

<ul>
<li>A cookie is a small amount of data, which often includes an anonymous unique identifier, that is sent to your browser from a web site&#39;s computers and stored on your computer&#39;s hard drive.</li>
<li>Cookies are required to use the SVRPlatform service.</li>
<li>We use cookies to record current session information, but do not use permanent cookies. You are required to re-login to your SVRPlatform account after a certain period of time has elapsed to protect you against others accidentally accessing your account contents.</li>
</ul>

<h3>Data Storage</h3>

<p>SVRPlatform uses third party vendors and hosting partners to provide the necessary hardware, software, networking, storage, and related technology required to run SVRPlatform. Although SVRPlatform owns the code, databases, and all rights to the SVRPlatform application, you retain all rights to your data.</p>

<h3>Disclosure</h3>

<p>SVRPlatform may disclose personally identifiable information under special circumstances, such as to comply with subpoenas or when your actions violate the <a href="/terms">Terms of Service</a>.</p>

<h3>Changes</h3>

<p>SVRPlatform may periodically update this policy. We will notify you about significant changes in the way we treat personal information by sending a notice to the primary email address specified in your SVRPlatform primary account holder account or by placing a prominent notice on our site.</p>

<h3>Questions</h3>

<p>Any questions about this Privacy Policy should be addressed to <a href="mailto:svrplatform@gmail.com">svrplatform@gmail.com</a>.</p>

  </div>
  </div>
	
	</div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
