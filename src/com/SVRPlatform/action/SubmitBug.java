package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.BugSubmitService;
import com.opensymphony.xwork2.ActionSupport;
import com.SVRPlatform.constants.*;

public class SubmitBug extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	private String email;
	private String digest;
	private String usabilityimpact;
	private String dataimpact;
	private String privacyimpact;
	private String availabilityimpact;
	private String frequency;
	private String description;
//	private String graphaddress;
	private String version;
	private String software;
	private String language;
	private BugSubmitService bugSubmitService;
	private Map<String, String> map;
	private String message;
	private String graphPath;
	private String strBugNumber;

	public String getStrBugNumber() {
		return strBugNumber;
	}

	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
	}

	public String getGraphPath() {
		return graphPath;
	}

	public void setGraphPath(String graphPath) {
		this.graphPath = graphPath;
	}

	public void setBugSubmitService(BugSubmitService bugSubmitService) {
		this.bugSubmitService = bugSubmitService;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getUsabilityimpact() {
		return usabilityimpact;
	}

	public void setUsabilityimpact(String usabilityimpact) {
		this.usabilityimpact = usabilityimpact;
	}

	public String getDataimpact() {
		return dataimpact;
	}

	public void setDataimpact(String dataimpact) {
		this.dataimpact = dataimpact;
	}

	public String getPrivacyimpact() {
		return privacyimpact;
	}

	public void setPrivacyimpact(String privacyimpact) {
		this.privacyimpact = privacyimpact;
	}

	public String getAvailabilityimpact() {
		return availabilityimpact;
	}

	public void setAvailabilityimpact(String availabilityimpact) {
		this.availabilityimpact = availabilityimpact;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public String getGraphaddress() {
//		return graphaddress;
//	}
//
//	public void setGraphaddress(String graphaddress) {
//		this.graphaddress = graphaddress;
//	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public String execute() {
		email = (String) request.getSession().getAttribute("email");

		System.out.println(digest);
		System.out.println(usabilityimpact);
		System.out.println(dataimpact);
		System.out.println(privacyimpact);
		System.out.println(availabilityimpact);
		System.out.println(frequency);
		System.out.println(description);
//		System.out.println(graphaddress);
		System.out.println(version);
		System.out.println(software);
		System.out.println(language);
		System.out.println("graphPath=" + graphPath);
		map = bugSubmitService.bugSubmit(graphPath, description, version,
				software, digest, email, usabilityimpact, dataimpact,
				privacyimpact, availabilityimpact, frequency, language);
		message = "There's something wrong with your inputs, please check:\n";
		//message = map.get("description") + map.get("version")
		//		+ map.get("software") + map.get("bugDigest")
		//		+ map.get("language");
		if ((!map.get("bugDigest").equals("OK"))){
			message += "Please input the digest of the bug information";
		}
		if (!(map.get("description").equals("OK"))){
			message += "Please input your description about the bug";
		}
		if (!(map.get("software").equals("OK"))){
			message += "Please input the buggy software name";
		}
		if (!(map.get("version").equals("OK"))){
			message += "Please input the version of the software";
		}
		if (!(map.get("language").equals("OK"))){
			message += "Please input the language of the software";
		}
		System.out.println(message);

		if (map.get("description").equals("OK")
				&& map.get("version").equals("OK")
				&& map.get("software").equals("OK")
				&& map.get("bugDigest").equals("OK")
				&& map.get("language").equals("OK")) {
			strBugNumber = map.get("BugNumber");
			return Constants.SUCCESS;
		} else
			return Constants.FAIL;
	}

}
