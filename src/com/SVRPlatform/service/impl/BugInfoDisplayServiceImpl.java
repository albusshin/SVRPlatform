package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.service.BugInfoDisplayService;

public class BugInfoDisplayServiceImpl implements BugInfoDisplayService {
	private BugDAO bugDAO;
	
	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}
	
	@Override
	public Map<String, String> bugInfoDisplay(String bugNumber) {
		Map<String, String> map = new HashMap<String, String>();
		
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);		
		Bug bug = (Bug) bugDAO.getByID(bugID);
		
		map.put("strBugNumber", bug.getBugNumber());
		map.put("strBugDigest", bug.getBugDigest());
		map.put("strScore", Float.toString(bug.getScore())); //test
		map.put("strUsabilityImpact", Float.toString(bug.getUsabilityImpact()));
		map.put("strDataImpact", Float.toString(bug.getDataImpact()));
		map.put("strDataImpact", Float.toString(bug.getDataImpact()));
			
		
		

		return null;
	}

}
