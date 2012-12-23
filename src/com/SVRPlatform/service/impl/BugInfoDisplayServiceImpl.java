package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.BugWatchDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.BugWatch;
import com.SVRPlatform.model.Software;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.service.BugInfoDisplayService;

public class BugInfoDisplayServiceImpl implements BugInfoDisplayService {
	private BugDAO bugDAO;
	private UserDAO userDAO;
	private SolutionDAO solutionDAO;
	private BugWatchDAO bugWatchDAO;
	
	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}
	
	public void setSolutionDAO(SolutionDAO solutionDAO) {
		this.solutionDAO = solutionDAO;
	}

	public BugWatchDAO getBugWatchDAO() {
		return bugWatchDAO;
	}

	public void setBugWatchDAO(BugWatchDAO bugWatchDAO) {
		this.bugWatchDAO = bugWatchDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public Map<String, String> bugInfoDisplay(String email, String bugNumber) {
		Map<String, String> map = new HashMap<String, String>();
		
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);		
		Bug bug = (Bug) bugDAO.getByID(bugID);
		if (bug == null) { 
			map.put("status", "fail");
			return map;
		}
		
		Software software = bug.getSoftware();

		Solution bestSolution;
		if (bug.getBestSolutionId() != null )
			bestSolution = (Solution) solutionDAO.getByID(bug.getBestSolutionId());
		else bestSolution = null;

		Solution officialSolution;
		if (bug.getOfficialSolutionId() != null )
			officialSolution = (Solution) solutionDAO.getByID(bug.getOfficialSolutionId());
		else officialSolution = null;
		
		map.put("strBugNumber", bug.getBugNumber());
		map.put("strBugDigest", bug.getBugDigest());
		map.put("strDate", bug.getDatetime().toString().substring(0, 16));
		map.put("strScore", Float.toString(bug.getScore()));
		map.put("strUsabilityImpact", Float.toString(bug.getUsabilityImpact()));
		map.put("strDataImpact", Float.toString(bug.getDataImpact()));
		map.put("strPrivacyImpact", Float.toString(bug.getPrivacyImpact()));
		map.put("strAvailabilityImpact", Float.toString(bug.getAvailabilityImpact()));
		map.put("strFrequency",  Float.toString(bug.getFrequency()));
		map.put("strScreenshotPath", bug.getGraphAddress());
		map.put("strBugDescription", bug.getDescription());
		map.put("strCompany", software.getCompany());
		map.put("strSoftware", software.getName());
		map.put("strVersion", bug.getVersion());
		map.put("strLanguage", bug.getLanguage());
		map.put("strUp", bug.getUp().toString());
		map.put("strDown", bug.getDown().toString());
		
		BugWatch bugWatch = bugWatchDAO.getByUserAndBug(userDAO.getUserByEmail(email), bug);
		if (bugWatch != null) {
			if (bugWatch.getVoteFlag() == 1) map.put("isVotedUp", "true");
			else map.put("isVotedDown", "true");
		}
		if (bestSolution != null)
			map.put("strBestSolution", bestSolution.getContent());
		if (officialSolution != null)
			map.put("strOfficialSolution", officialSolution.getContent());
		map.put("status", "success");

		return map;
	}
}
