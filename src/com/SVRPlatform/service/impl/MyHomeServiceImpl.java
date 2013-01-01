package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.BugWatchDAO;
import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.dao.ExploitDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.dao.VulnerabilityCommentDAO;
import com.SVRPlatform.dao.VulnerabilityDAO;
import com.SVRPlatform.dao.VulnerabilityWatchDAO;
import com.SVRPlatform.data.BugData;
import com.SVRPlatform.data.ExploitData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.data.VulnerabilityData;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Exploit;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;
import com.SVRPlatform.model.Vulnerability;
import com.SVRPlatform.service.MyHomeService;

public class MyHomeServiceImpl implements MyHomeService {
	private UserDAO userDAO;
	private BugDAO bugDAO;
	private BugWatchDAO bugWatchDAO;
	private CommentDAO commentDAO;
	private SolutionDAO solutionDAO;
	
	private VulnerabilityDAO vulnerabilityDAO;
	private VulnerabilityCommentDAO vulnerabilityCommentDAO;
	private VulnerabilityWatchDAO vulnerabilityWatchDAO;
	private ExploitDAO exploitDAO;
	
	public VulnerabilityDAO getVulnerabilityDAO() {
		return vulnerabilityDAO;
	}

	public void setVulnerabilityDAO(VulnerabilityDAO vulnerabilityDAO) {
		this.vulnerabilityDAO = vulnerabilityDAO;
	}

	public VulnerabilityCommentDAO getVulnerabilityCommentDAO() {
		return vulnerabilityCommentDAO;
	}

	public void setVulnerabilityCommentDAO(
			VulnerabilityCommentDAO vulnerabilityCommentDAO) {
		this.vulnerabilityCommentDAO = vulnerabilityCommentDAO;
	}

	public VulnerabilityWatchDAO getVulnerabilityWatchDAO() {
		return vulnerabilityWatchDAO;
	}

	public void setVulnerabilityWatchDAO(VulnerabilityWatchDAO vulnerabilityWatchDAO) {
		this.vulnerabilityWatchDAO = vulnerabilityWatchDAO;
	}

	public ExploitDAO getExploitDAO() {
		return exploitDAO;
	}

	public void setExploitDAO(ExploitDAO exploitDAO) {
		this.exploitDAO = exploitDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public BugDAO getBugDAO() {
		return bugDAO;
	}

	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}

	public BugWatchDAO getBugWatchDAO() {
		return bugWatchDAO;
	}

	public void setBugWatchDAO(BugWatchDAO bugWatchDAO) {
		this.bugWatchDAO = bugWatchDAO;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public SolutionDAO getSolutionDAO() {
		return solutionDAO;
	}

	public void setSolutionDAO(SolutionDAO solutionDAO) {
		this.solutionDAO = solutionDAO;
	}

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
		Map<Integer, List<BugData>> bugsDataLists = new HashMap<Integer, List<BugData>>();
		
		List<BugData> bugsData = new LinkedList<BugData>();	
		ListIterator<Bug> it = bugs.listIterator();
		Bug bug;
		BugData bugData;
		int length = bugs.size()/2 + bugs.size()%2;
		while (it.hasNext() && it.nextIndex() < length) {
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
		bugsDataLists.put(1, bugsData);
		
		bugsData = new LinkedList<BugData>();
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
		bugsDataLists.put(2, bugsData);
		
		return bugsDataLists;
	}

	public List<SolutionData> getMySolutions(int userID) {
		if (userID == -1 ) return null;
		User user = (User) userDAO.getByID(userID);
		List<Solution> solutions = solutionDAO.getByUserId(user, -1, -1);
		List<SolutionData> solutionsData = new LinkedList<SolutionData>();
		
		ListIterator<Solution> it = solutions.listIterator();
		Solution solution;
		SolutionData solutionData;
		while (it.hasNext()) {
			solution = it.next();
			solutionData = new SolutionData();
			
			solutionData.setBugNumber(solution.getBug().getBugNumber());
			solutionData.setDatetime(solution.getDatetime().toString());
			solutionData.setUp(solution.getUp());
			solutionData.setDown(solution.getDown());
			solutionData.setContent(solution.getContent());
			solutionsData.add(solutionData);
		}
		
		return solutionsData;
	}

	public List<VulnerabilityData> getMyVulnerabilitys(int userID) {
		if (userID == -1 ) return null;
		User user = (User) userDAO.getByID(userID);
		List<Vulnerability> vulnerabilitys = vulnerabilityDAO.getByUser(user);
		List<VulnerabilityData> vulnerabilitysData = new LinkedList<VulnerabilityData>();
		
		ListIterator<Vulnerability> it = vulnerabilitys.listIterator();
		Vulnerability vulnerability;
		VulnerabilityData vulnerabilityData;
		while (it.hasNext()) {
			vulnerability = it.next();
			vulnerabilityData = new VulnerabilityData();
			
			vulnerabilityData.setHasBest(exploitDAO.getByVulnerability(vulnerability, 1, 0).size() > 0);
			vulnerabilityData.setVulnerabilityNumber(vulnerability.getVulnerabilityNumber());
			vulnerabilityData.setCommentsCount((int)vulnerabilityCommentDAO.getCountFromOneVulnerability(vulnerability));
			vulnerabilityData.setDigest(vulnerability.getVulnerabilityDigest());
			vulnerabilityData.setPublishDate(vulnerability.getDatetime().toString());
			vulnerabilityData.setExploitsCount((int)exploitDAO.getCountFromOneVulnerability(vulnerability));
			vulnerabilitysData.add(vulnerabilityData);
		}
		
		return vulnerabilitysData;
	}

	public Map<Integer, List<VulnerabilityData>> getWatchingVulnerabilitys(
			int userID) {
		if (userID == -1 ) return null;
		User user = (User) userDAO.getByID(userID);
		List<Vulnerability> vulnerabilitys = vulnerabilityWatchDAO.getByUser(user);
		Map<Integer, List<VulnerabilityData>> vulnerabilitysDataLists = new HashMap<Integer, List<VulnerabilityData>>();
		
		List<VulnerabilityData> vulnerabilitysData = new LinkedList<VulnerabilityData>();	
		ListIterator<Vulnerability> it = vulnerabilitys.listIterator();
		Vulnerability vulnerability;
		VulnerabilityData vulnerabilityData;
		int length = vulnerabilitys.size()/2 + vulnerabilitys.size()%2;
		while (it.hasNext() && it.nextIndex() < length) {
			vulnerability = it.next();
			vulnerabilityData = new VulnerabilityData();
			
			vulnerabilityData.setHasBest(exploitDAO.getByVulnerability(vulnerability, 1, 0).size() > 0);
			vulnerabilityData.setVulnerabilityNumber(vulnerability.getVulnerabilityNumber());
			vulnerabilityData.setCommentsCount((int)vulnerabilityCommentDAO.getCountFromOneVulnerability(vulnerability));
			vulnerabilityData.setDigest(vulnerability.getVulnerabilityDigest());
			vulnerabilityData.setPublishDate(vulnerability.getDatetime().toString());
			vulnerabilityData.setExploitsCount((int)exploitDAO.getCountFromOneVulnerability(vulnerability));
			vulnerabilitysData.add(vulnerabilityData);
		}
		vulnerabilitysDataLists.put(1, vulnerabilitysData);
		
		vulnerabilitysData = new LinkedList<VulnerabilityData>();
		while (it.hasNext()) {
			vulnerability = it.next();
			vulnerabilityData = new VulnerabilityData();
			
			vulnerabilityData.setHasBest(exploitDAO.getByVulnerability(vulnerability, 1, 0).size() > 0);
			vulnerabilityData.setVulnerabilityNumber(vulnerability.getVulnerabilityNumber());
			vulnerabilityData.setCommentsCount((int)vulnerabilityCommentDAO.getCountFromOneVulnerability(vulnerability));
			vulnerabilityData.setDigest(vulnerability.getVulnerabilityDigest());
			vulnerabilityData.setPublishDate(vulnerability.getDatetime().toString());
			vulnerabilityData.setExploitsCount((int)exploitDAO.getCountFromOneVulnerability(vulnerability));
			vulnerabilitysData.add(vulnerabilityData);
		}
		vulnerabilitysDataLists.put(2, vulnerabilitysData);
		
		return vulnerabilitysDataLists;
	}

	public List<ExploitData> getMyExploits(int userID) {
		if (userID == -1 ) return null;
		User user = (User) userDAO.getByID(userID);
		List<Exploit> exploits = exploitDAO.getByUser(user, -1, -1);
		List<ExploitData> exploitsData = new LinkedList<ExploitData>();
		
		ListIterator<Exploit> it = exploits.listIterator();
		Exploit exploit;
		ExploitData exploitData;
		while (it.hasNext()) {
			exploit = it.next();
			exploitData = new ExploitData();
			
			exploitData.setVulnerabilityNumber(exploit.getVulnerability().getVulnerabilityNumber());
			exploitData.setDatetime(exploit.getDatetime().toString());
			exploitData.setUp(exploit.getUp());
			exploitData.setDown(exploit.getDown());
			exploitData.setContent(exploit.getContent());
			exploitsData.add(exploitData);
		}
		
		return exploitsData;
	}
}
