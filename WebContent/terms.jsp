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
  <h2>SVRPlatform Terms of Service</h2>


  <div class="article-body content-body wikistyle markdown-format">
      <p>By using the SVRPlatform.com web site (&quot;Service&quot;), or any services of SVRPlatform Inc (&quot;SVRPlatform&quot;), you are agreeing to be bound by the following terms and conditions (&quot;Terms of Service&quot;).  IF YOU ARE ENTERING INTO THIS AGREEMENT ON BEHALF OF A COMPANY OR OTHER LEGAL ENTITY, YOU REPRESENT THAT YOU HAVE THE AUTHORITY TO BIND SUCH ENTITY, ITS AFFILIATES AND ALL USERS WHO ACCESS OUR  SERVICES THROUGH YOUR ACCOUNT TO THESE TERMS AND CONDITIONS, IN WHICH CASE THE TERMS &quot;YOU&quot; OR &quot;YOUR&quot; SHALL REFER TO SUCH ENTITY, ITS AFFILIATES AND USERS ASSOCIATED WITH IT. IF YOU DO NOT HAVE SUCH AUTHORITY, OR IF YOU DO NOT AGREE WITH THESE TERMS AND CONDITIONS, YOU MUST NOT ACCEPT THIS AGREEMENT AND MAY NOT USE THE SERVICES.</p>

<p>SVRPlatform reserves the right to update and change the Terms of Service from time to time without notice. Any new features that augment or enhance the current Service, including the release of new tools and resources, shall be subject to the Terms of Service. Continued use of the Service after any such changes shall constitute your consent to such changes. You can review the most current version of the Terms of Service at any time at: <a href="http://SVRPlatform.com/site/terms">http://SVRPlatform.com/site/terms</a></p>

<p>Violation of any of the terms below will result in the termination of your Account. While SVRPlatform prohibits such conduct and Content on the Service, you understand and agree that SVRPlatform cannot be responsible for the Content posted on the Service and you nonetheless may be exposed to such materials. You agree to use the Service at your own risk.</p>

<h3>A. Account Terms</h3>

<ol>
<li><p>You must be 13 years or older to use this Service.</p></li>
<li><p>You must be a human. Accounts registered by &quot;bots&quot; or other automated methods are not permitted.</p></li>
<li><p>You must provide your legal full name, a valid email address, and any other information requested in order to complete the signup process.</p></li>
<li><p>Your login may only be used by one person - a single login shared by multiple people is not permitted. You may create separate logins for as many people as your plan allows.</p></li>
<li><p>You are responsible for maintaining the security of your account and password. SVRPlatform cannot and will not be liable for any loss or damage from your failure to comply with this security obligation.</p></li>
<li><p>You are responsible for all Content posted and activity that occurs under your account (even when Content is posted by others who have accounts under your account).</p></li>
<li><p>One person or legal entity may not maintain more than one free account.</p></li>
<li><p>You may not use the Service for any illegal or unauthorized purpose. You must not, in the use of the Service, violate any laws in your jurisdiction (including but not limited to copyright or trademark laws).</p></li>
</ol>

<h3>B. API Terms</h3>

<p>Customers may access their SVRPlatform account data via an API (Application Program Interface). Any use of the API, including use of the API through a third-party product that accesses SVRPlatform, is bound by these Terms of Service plus the following specific terms:</p>

<ol>
<li><p>You expressly understand and agree that SVRPlatform shall not be liable for any direct, indirect, incidental, special, consequential or exemplary damages, including but not limited to, damages for loss of profits, goodwill, use, data or other intangible losses (even if SVRPlatform has been advised of the possibility of such damages), resulting from your use of the API or third-party products that access data via the API.</p></li>
<li><p>Abuse or excessively frequent requests to SVRPlatform via the API may result in the temporary or permanent suspension of your account&#39;s access to the API. SVRPlatform, in its sole discretion, will determine abuse or excessive usage of the API. SVRPlatform will make a reasonable attempt via email to warn the account owner prior to suspension.</p></li>
<li><p>SVRPlatform reserves the right at any time to modify or discontinue, temporarily or permanently, your access to the API (or any part thereof) with or without notice.</p></li>
</ol>

<h3>C. Payment, Refunds, Upgrading and Downgrading Terms</h3>

<ol>
<li><p>All paid plans must enter a valid credit card. Free accounts are not required to provide a credit card number.</p></li>
<li><p><strong>An upgrade from the free plan to any paying plan will immediately bill you.</strong></p></li>
<li><p><strong>The Service is billed in advance on a monthly basis and is non-refundable. There will be no refunds or credits for partial months of service, upgrade/downgrade refunds, or refunds for months unused with an open account. In order to treat everyone equally, no exceptions will be made.</strong></p></li>
<li><p>All fees are exclusive of all taxes, levies, or duties imposed by taxing authorities, and you shall be responsible for payment of all such taxes, levies, or duties, excluding only United States (federal or state) taxes.</p></li>
<li><p>For any upgrade or downgrade in plan level, your credit card that you provided will automatically be charged the new rate on your next billing cycle.</p></li>
<li><p>Downgrading your Service may cause the loss of Content, features, or capacity of your Account. SVRPlatform does not accept any liability for such loss.</p></li>
</ol>

<h3>D. Cancellation and Termination</h3>

<ol>
<li><p><strong>You are solely responsible for properly canceling your account. An email or phone request to cancel your account is not considered cancellation. You can cancel your account at any time by clicking on the Account link in the global navigation bar at the top of the screen. The Account screen provides a simple no questions asked cancellation link.</strong></p></li>
<li><p>All of your Content will be immediately deleted from the Service upon cancellation. This information can not be recovered once your account is cancelled.</p></li>
<li><p>If you cancel the Service before the end of your current paid up month, your cancellation will take effect immediately and you will not be charged again.</p></li>
<li><p>SVRPlatform, in its sole discretion, has the right to suspend or terminate your account and refuse any and all current or future use of the Service, or any other SVRPlatform service, for any reason at any time. Such termination of the Service will result in the deactivation or deletion of your Account or your access to your Account, and the forfeiture and relinquishment of all Content in your Account. SVRPlatform reserves the right to refuse service to anyone for any reason at any time.</p></li>
</ol>

<h3>E. Modifications to the Service and Prices</h3>

<ol>
<li><p>SVRPlatform reserves the right at any time and from time to time to modify or discontinue, temporarily or permanently, the Service (or any part thereof) with or without notice.</p></li>
<li><p>Prices of all Services, including but not limited to monthly subscription plan fees to the Service, are subject to change upon 30 days notice from us. Such notice may be provided at any time by posting the changes to the SVRPlatform Site (<a href="http://SVRPlatform.com">SVRPlatform.com</a>) or the Service itself.</p></li>
<li><p>SVRPlatform shall not be liable to you or to any third party for any modification, price change, suspension or discontinuance of the Service.</p></li>
</ol>

<h3>F. Copyright and Content Ownership</h3>

<ol>
<li><p>We claim no intellectual property rights over the material you provide to the Service. Your profile and materials uploaded remain yours. However, by setting your pages to be viewed publicly, you agree to allow others to view your Content. By setting your repositories to be viewed publicly, you agree to allow others to view and fork your repositories.</p></li>
<li><p>SVRPlatform does not pre-screen Content, but SVRPlatform and its designee have the right (but not the obligation) in their sole discretion to refuse or remove any Content that is available via the Service.</p></li>
<li><p>You shall defend SVRPlatform against any claim, demand, suit or proceeding made or brought against SVRPlatform by a third party alleging that Your Content, or Your use of the Service in violation of this Agreement, infringes or misappropriates the intellectual property rights of a third party or violates applicable law, and shall indemnify SVRPlatform for any damages finally awarded against, and for reasonable attorney’s fees incurred by, SVRPlatform in connection with any such claim, demand, suit or proceeding; provided, that SVRPlatform (a) promptly gives You written notice of the claim, demand, suit or proceeding; (b) gives You sole control of the defense and settlement of the claim, demand, suit or proceeding (provided that You may not settle any claim, demand, suit or proceeding unless the settlement unconditionally releases SVRPlatform of all liability); and (c) provides to You all reasonable assistance, at Your expense.</p></li>
<li><p>The look and feel of the Service is copyright &copy;2010 SVRPlatform Inc. All rights reserved. You may not duplicate, copy, or reuse any portion of the HTML/CSS, Javascript, or visual design elements or concepts without express written permission from SVRPlatform.</p></li>
</ol>

<h3>G. General Conditions</h3>

<ol>
<li><p>Your use of the Service is at your sole risk. The service is provided on an &quot;as is&quot; and &quot;as available&quot; basis.</p></li>
<li><p>Technical support is only provided to paying account holders and is only available via email.  Support is only available in English.</p></li>
<li><p>You understand that SVRPlatform uses third party vendors and hosting partners to provide the necessary hardware, software, networking, storage, and related technology required to run the Service.</p></li>
<li><p>You must not modify, adapt or hack the Service or modify another website so as to falsely imply that it is associated with the Service, SVRPlatform, or any other SVRPlatform service.</p></li>
<li><p>You may use SVRPlatform subdomains (e.g., yourname.SVRPlatform.com) solely as permitted and intended by the SVRPlatform Pages tool to host your company pages, personal pages, or open source project pages, and for no other purpose.  You may not use SVRPlatform subdomains in violation of SVRPlatform&#39;s trademark or other rights or in violation of applicable law.  SVRPlatform reserves the right at all times to reclaim any SVRPlatform subdomain without liability to you.</p></li>
<li><p>You agree not to reproduce, duplicate, copy, sell, resell or exploit any portion of the Service, use of the Service, or access to the Service without the express written permission by SVRPlatform.</p></li>
<li><p>We may, but have no obligation to, remove Content and Accounts containing Content that we determine in our sole discretion are unlawful, offensive, threatening, libelous, defamatory, pornographic, obscene or otherwise objectionable or violates
any party&#39;s intellectual property or these Terms of Service.</p></li>
<li><p>Verbal, physical, written or other abuse (including threats of abuse or retribution) of any SVRPlatform customer, employee, member, or officer will result in immediate account termination.</p></li>
<li><p>You understand that the technical processing and transmission of the Service, including your Content, may be transfered unencrypted and involve (a) transmissions over various networks; and (b) changes to conform and adapt to technical requirements of connecting networks or devices.</p></li>
<li><p>You must not upload, post, host, or transmit unsolicited email, SMSs, or &quot;spam&quot; messages.</p></li>
<li><p>You must not transmit any worms or viruses or any code of a destructive nature.</p></li>
<li><p>If your bandwidth usage significantly exceeds the average bandwidth usage (as determined solely by SVRPlatform) of other SVRPlatform customers, we reserve the right to immediately disable your account or throttle your file hosting until you can reduce your bandwidth consumption.</p></li>
<li><p>SVRPlatform does not warrant that (i) the service will meet your specific requirements, (ii) the service will be uninterrupted, timely, secure, or error-free, (iii) the results that may be obtained from the use of the service will be accurate or reliable, (iv) the quality of any products, services, information, or other material purchased or obtained by you through the service will meet your expectations, and (v) any errors in the Service will be corrected.</p></li>
<li><p>You expressly understand and agree that SVRPlatform shall not be liable for any direct, indirect, incidental, special, consequential or exemplary damages, including but not limited to, damages for loss of profits, goodwill, use, data or other intangible losses (even if SVRPlatform has been advised of the possibility of such damages), resulting from: (i) the use or the inability to use the service; (ii) the cost of procurement of substitute goods and services resulting from any goods, data, information or services purchased or obtained or messages received or transactions entered into through or from the service; (iii) unauthorized access to or alteration of your transmissions or data; (iv) statements or conduct of any third party on the service; (v) or any other matter relating to the service.</p></li>
<li><p>The failure of SVRPlatform to exercise or enforce any right or provision of the Terms of Service shall not constitute a waiver of such right or provision. The Terms of Service constitutes the entire agreement between you and SVRPlatform and govern your use of the Service, superseding any prior agreements between you and SVRPlatform (including, but not limited to, any prior versions of the Terms of Service). You agree that these Terms of Service and Your use of the Service are governed under California law.</p></li>
<li><p>Questions about the Terms of Service should be sent to <a href="mailto:svrplatform@gmail.com">svrplatform@gmail.com</a>.</p></li>
</ol>
</div></div>
    <jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>
