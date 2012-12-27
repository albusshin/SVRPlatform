package com.SVRPlatform.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.BugWatchDAO;
import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.data.BugData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.MyHomeService;

public class MyHomeServiceImpl implements MyHomeService {
	private UserDAO userDAO;
	private BugDAO bugDAO;
	private BugWatchDAO bugWatchDAO;
	private CommentDAO commentDAO;
	private SolutionDAO solutionDAO;
	

	public List<BugData> getMyBugs(int userID) {
		if (userID == -1 ) return null;
		User user = (User) userDAO.getByID(userID);
		List<Bug> bugs = bugDAO.getByUser(user);
		List<BugData> bugsData = new LinkedList<BugData>();
		
		ListIterator<Bug> it = bugs.listIterator();
		Bug bug;
		BugData bugData;
		while (it.hasNext()) {
			bug = it.next();
			bugData = new BugData();
			
			bugData.setHasOfficial(bug.getOfficialSolutionId() != null && bug.getOfficialSolutionId() != -1);
			bugData.setHasBest(bug.getBestSolutionId() != null && bug.getBestSolutionId() != -1);
			bugData.setBugNumber(bug.getBugNumber());
			bugData.setCommentsCount((int)commentDAO.getCountFromOneBug(bug));
			bugData.setDigest(bug.getBugDigest());
			bugData.setPublishDate(bug.getDatetime().toString());
			bugData.setSolutionsCount((int)solutionDAO.getCountFromOneBug(bug));
			bugsData.add(bugData);
		}
		
		return bugsData;
	}

	public Map<Integer, List<BugData>> getWatchingBugs(int userID) {
		if (userID == -1 ) return null;
		User user = (User) userDAO.getByID(userID);
		List<Bug> bugs = bugWatchDAO.getByUser(user);
		List<BugData> bugsData = new LinkedList<BugData>();
		
		return null;
	}

	public List<SolutionData> getMySolutions(int userID) {
		// TODO Auto-generated method stub
		return null;
	}
}
