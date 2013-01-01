package com.SVRPlatform.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.dao.ExploitDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.VulnerabilityCommentDAO;
import com.SVRPlatform.dao.VulnerabilityDAO;
import com.SVRPlatform.data.BugData;
import com.SVRPlatform.data.VulnerabilityData;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Vulnerability;
import com.SVRPlatform.service.RankingService;

public class RankingServiceImpl implements RankingService {
	private BugDAO bugDAO;
	private CommentDAO commentDAO;
	private SolutionDAO solutionDAO;
	private VulnerabilityDAO vulnerabilityDAO;
	private VulnerabilityCommentDAO vulnerabilityCommentDAO;
	private ExploitDAO exploitDAO;
	
	public BugDAO getBugDAO() {
		return bugDAO;
	}

	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
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


	public List<BugData> bugRanking(int time, int orderType) {
		Calendar calendar = Calendar.getInstance();
		Date end = calendar.getTime();
		
		//calculate start time
		if (time == Constants.WEEK)
		    calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek()-calendar.get(Calendar.DAY_OF_WEEK));
		else if (time == Constants.MONTH)
			calendar.set(Calendar.DAY_OF_MONTH, 1);
		else if (time == Constants.YEAR)
			calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime();
		
		List<Bug> bugs = bugDAO.getOrderedBug(start, end, orderType);
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

	public List<VulnerabilityData> vulnerabilityRanking(int time, int orderType) {
		Calendar calendar = Calendar.getInstance();
		Date end = calendar.getTime();
		
		//calculate start time
		if (time == Constants.WEEK)
		    calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek()-calendar.get(Calendar.DAY_OF_WEEK));
		else if (time == Constants.MONTH)
			calendar.set(Calendar.DAY_OF_MONTH, 1);
		else if (time == Constants.YEAR)
			calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime();
		
		List<Vulnerability> vulnerabilitys = vulnerabilityDAO.getOrderedVulnerability(start, end, orderType);
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

	public ExploitDAO getExploitDAO() {
		return exploitDAO;
	}

	public void setExploitDAO(ExploitDAO exploitDAO) {
		this.exploitDAO = exploitDAO;
	}
}
