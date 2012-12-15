package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Software;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.service.BugInfoDisplayService;

public class BugInfoDisplayServiceImpl implements BugInfoDisplayService {
	private BugDAO bugDAO;
	private SolutionDAO solutionDAO;
	
	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}
	
	public void setSolutionDAO(SolutionDAO solutionDAO) {
		this.solutionDAO = solutionDAO;
	}
	
	@Override
	public Map<String, String> bugInfoDisplay(String bugNumber) {
		Map<String, String> map = new HashMap<String, String>();
		
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);		
		Bug bug = (Bug) bugDAO.getByID(bugID);
		if (bug == null) { 
			map.put("status", "fail");
			return map;
		}
		
		Software software = bug.getSoftware();
		Solution bestSolution = (Solution) solutionDAO.getByID(bug.getBestSolutionId());
		Solution officialSolution = (Solution) solutionDAO.getByID(bug.getOfficialSolutionId());
		
		map.put("strBugNumber", bug.getBugNumber());
		map.put("strBugDigest", bug.getBugDigest());
		map.put("strScore", Float.toString(bug.getScore())); //test
		map.put("strUsabilityImpact", Float.toString(bug.getUsabilityImpact()));
		map.put("strDataImpact", Float.toString(bug.getDataImpact()));
		map.put("strPrivacyImpact", Float.toString(bug.getPrivacyImpact()));
		map.put("strAvailabilityImpact", Float.toString(bug.getAvailabilityImpact()));
		map.put("strScreenshotPath", bug.getGraphAddress());
		map.put("strBugDescription", bug.getDescription());
		map.put("strCompany", software.getCompany());
		map.put("strSoftware", software.getName());
		map.put("strVersion", bug.getVersion());
		map.put("strLanguage", bug.getLanguage());
		map.put("strBestSolution", bestSolution.getContent());
		map.put("strOfficialSolution", officialSolution.getContent());
		map.put("status", "success");

		return map;
	}
}
