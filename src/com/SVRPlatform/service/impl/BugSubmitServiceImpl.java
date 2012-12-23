package com.SVRPlatform.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.SoftwareDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Software;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.BugSubmitService;

public class BugSubmitServiceImpl implements BugSubmitService{
	private UserDAO userDAO;
	private BugDAO bugDAO;
	private SoftwareDAO softwareDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}
	
	public void setSoftwareDAO(SoftwareDAO softwareDAO) {
		this.softwareDAO = softwareDAO;
	}
	
	@Override
	public Map<String, String> bugSubmit(String graphAddress,String description,
										String version, String softwareName,String bugDigest,
										String email, String usabilityImpact, String dataImpact,
										String privacyImpact, String availabilityImpact, 
										String frequency, String language) {
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
		
		if (map.get("description").equals("OK") && map.get("version").equals("OK") && 
			map.get("software").equals("OK") && map.get("bugDigest").equals("OK") && 
			map.get("language").equals("OK")) {
			Bug bug = new Bug();			
			User user = (User) userDAO.getUserByEmail(email);
			float ui = 0, di = 0, pi = 0, ai = 0, fr = 0, sc = 0;
			
			//check if software exists
			Software software;
			if (softwareDAO.getSoftwareByName(softwareName) == null) {
				software = new Software();
				software.setName(softwareName);
				softwareDAO.add(software);
			}
			software = (Software)softwareDAO.getSoftwareByName(softwareName);
			
			switch (usabilityImpact) {
			case "Complete": ui = 10;  break;
			case "Partial":  ui = 7.5f; break;
			case "Little":	 ui = 5;   break;
			case "None":     ui = 1;   break;
			}
			
			switch (dataImpact) {
			case "Complete": di = 10;  break;
			case "Partial":  di = 7.5f; break;
			case "Little":	 di = 5;   break;
			case "None":     di = 1;   break;
			}
			
			switch (privacyImpact) {
			case "Complete": pi = 10;  break;
			case "Partial":  pi = 7.5f; break;
			case "Little":	 pi = 5;   break;
			case "None":     pi = 1;   break;
			}
			
			switch (availabilityImpact) {
			case "Complete": ai = 10;  break;
			case "Partial":  ai = 7.5f; break;
			case "Little":	 ai = 5;   break;
			case "None":     ai = 1;   break;
			}
			
			switch (frequency) {
			case "Always":		fr = 10;	break;
			case "Often":		fr = 7.5f;	break;
			case "Sometimes":	fr = 5;		break;
			case "Merely":		fr = 1;		break;
			}
			
			sc = ui + di*3 + pi*5 + ai*4 + fr*2;
			sc /= 15;
			
			bug.setDatetime(new Date());
			bug.setDescription(description);
			bug.setVersion(version);
			bug.setSoftware(software);
			bug.setBugDigest(bugDigest);
			bug.setUser(user);
			bug.setUsabilityImpact(ui);
			bug.setDataImpact(di);
			bug.setPrivacyImpact(pi);
			bug.setAvailabilityImpact(ai);
			bug.setFrequency(fr);
			bug.setScore(sc);
			bug.setLanguage(language);
			bug.setOfficialSolutionId(-1);
			bug.setUp(0);
			bug.setDown(0);
			
			//set the bugNumber to year for now, hibernate layer will fix it later.
			bugDAO.add(bug);
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			String bugNumber = "SVRB-"+Integer.toString(year)+"-"+String.format("%1$08d", bug.getBugId());
			bug.setBugNumber(bugNumber);
			bug.setGraphAddress("upload/b"+bug.getBugId()+graphAddress.substring(graphAddress.indexOf(".")));
			bugDAO.update(bug);
			
			//struts end needs bug number
			map.put("BugNumber", bugNumber);			

			String uploadPath = ServletActionContext.getServletContext().getRealPath("/");
			File fromFile = new File(new File(uploadPath), graphAddress);
			File toFile = new File(new File(uploadPath), bug.getGraphAddress());
			try {
				FileUtils.copyFile(fromFile, toFile);
				fromFile.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return map;
	}
}
