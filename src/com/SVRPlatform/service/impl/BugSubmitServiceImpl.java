package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.service.BugSubmitService;

public class BugSubmitServiceImpl implements BugSubmitService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public Map<String, String> bugSubmit(int level, String graphAddress,
						String description, String version, String software,
						String bugDigest, String user, int usabilityImpact, int dataImpact,
						int privacyImpact, int availability, int frequency, int score,
						String language, String bugNumber) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("level", "OK");
		map.get("level");
		
		if ()

		return map;
	}

}
