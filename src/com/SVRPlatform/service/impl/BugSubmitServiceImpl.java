package com.SVRPlatform.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Software;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.BugSubmitService;

public class BugSubmitServiceImpl implements BugSubmitService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public Map<String, String> bugSubmit(String graphAddress,String description,
										String version, String softwareName,String bugDigest,
										String email, String usabilityImpact, String dataImpact,
										String privacyImpact, String availabilityImpact, 
										String frequency, String language) {
		//score
		Map<String, String> map = new HashMap<String, String>();
		
		//check if bug information is complete
		
		if (description.compareTo("") == 0) 
			map.put("description", "empty");
		else if (description.length() > 5000) 
			map.put("description", "tooLong");
		else map.put("description", "OK");
		
		if (version.compareTo("") == 0) 
			map.put("version", "empty");
		else if (version.length() > 256)
			map.put("version", "tooLong");
		else map.put("version", "OK");
		
		if (softwareName.compareTo("") == 0) 
			map.put("software", "empty");
		else if (softwareName.length() > 256)
			map.put("software", "tooLong");
		else map.put("software", "OK");
		
		if (bugDigest.compareTo("") == 0) 
			map.put("bugDigest", "empty");
		else if (bugDigest.length() > 256)
			map.put("bugDigest", "tooLong");
		else map.put("bugDigest", "OK");
		
		if (language.compareTo("") == 0) 
			map.put("language", "empty");
		else if (language.length() > 50)
			map.put("language", "tooLong");
		else map.put("language", "OK");
		
		if (map.get("description") == "OK" && map.get("version") == "OK" && 
			map.get("software") == "OK" && map.get("bugDigest") == "OK" && 
			map.get("language") == "OK") {
			Bug bug = new Bug();
			Software software = (Software) userDAO.getSoftwareByName(softwareName);
			User user = (User) userDAO.getUserByEmail(email);
			
			bug.setGraphAddress(graphAddress);
			bug.setDatetime(new Date());
			bug.setDescription(description);
			bug.setVersion(version);
			bug.setSoftware(software);
			bug.setBugDigest(bugDigest);
			bug.setUser(user);
//			bug.setUsabilityImpact(Byte.valueOf((byte)usabilityImpact));
//			bug.setDataImpact(Byte.valueOf((byte)dataImpact));
//			bug.setPrivacyImpact(Byte.valueOf((byte)privacyImpact));
//			bug.setAvailabilityImpact(Byte.valueOf((byte)availabilityImpact));
//			bug.setFrequency(Byte.valueOf((byte)frequency));
//			bug.setScore(Byte.valueOf((byte)score));
			bug.setLanguage(language);
			
			Bug bugAdded = (Bug) userDAO.addBug(bug);
			int year = Calendar.getInstance().get(Calendar.YEAR);
			String bugNumber = Integer.toString(year) + bugAdded.getBugId();
			bug.setBugNumber(bugNumber);
		}

		return map;
	}
}
