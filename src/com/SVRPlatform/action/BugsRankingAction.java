package com.SVRPlatform.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.BugData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.service.MyHomeService;
import com.opensymphony.xwork2.ActionSupport;

public class BugsRankingAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 761493739458851799L;
	HttpServletRequest request;
	HttpServletResponse response;
	List<BugData> lsScoreBugsRanked;
	List<BugData> lsVotingBugsRanked;
	List<BugData> lsSolutionsBugsRanked;
	List<BugData> lsCommentsBugsRanked;
	
	public List<BugData> getLsScoreBugsRanked() {
		return lsScoreBugsRanked;
	}
	public List<BugData> getLsVotingBugsRanked() {
		return lsVotingBugsRanked;
	}
	public List<BugData> getLsSolutionsBugsRanked() {
		return lsSolutionsBugsRanked;
	}
	public List<BugData> getLsCommentsBugsRanked() {
		return lsCommentsBugsRanked;
	}
	public String execute(){
		if (VerifyUser.getNowUser(request) == null){
			return Constants.FAIL;
		}
		int userID = VerifyUser.getNowUserID(request);
		lsScoreBugsRanked = myHomeService.getMyBugs(userID);
		lsWatchingBugs1 = myHomeService.getWatchingBugs(userID).get(1);
		lsWatchingBugs2 = myHomeService.getWatchingBugs(userID).get(2);
		lsMySolutions = myHomeService.getMySolutions(userID);
		return Constants.SUCCESS;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

}
