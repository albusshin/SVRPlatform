package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.BugSubmitService;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitBug extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	
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
	private String graphaddress;
	private String version;
	private String software;
	private String language;
	private BugSubmitService bugsubmitService;
	private Map<String, String> map;
	private String message;
	
	public void setBugsubmitService(BugSubmitService bugsubmitService) {
		this.bugsubmitService = bugsubmitService;
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


	public String getGraphaddress() {
		return graphaddress;
	}

	public void setGraphaddress(String graphaddress) {
		this.graphaddress = graphaddress;
	}

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
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	


	public String execute()
	{ 
		email=(String)request.getSession().getAttribute("email");
		
		System.out.println(digest);
		System.out.println(usabilityimpact);
		System.out.println(dataimpact);
		System.out.println(privacyimpact);
		System.out.println(availabilityimpact);
		System.out.println(frequency);
		System.out.println(description);
		System.out.println(graphaddress);
		System.out.println(version);
		System.out.println(software);
		System.out.println(language);
		
		map=bugsubmitService.bugSubmit(graphaddress, description,version, software,
				digest, email, usabilityimpact, dataimpact,
				 privacyimpact, availabilityimpact, frequency, language);

		message=map.get("description")+ map.get("version") + map.get("software")
					+map.get("bugDigest") + map.get("language");
		
		System.out.println(message);
		
		if (map.get("description").equals("OK") && map.get("version").equals("OK") && 
				map.get("software").equals("OK") && map.get("bugDigest").equals("OK") && 
				map.get("language").equals("OK")) {
		return "BugSubmitSuccess";}
		else  return "BugSubmitFailed";
	}


	

}
