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
import com.SVRPlatform.service.RankingService;
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
	int timeType;
	public int getTimeType() {
		return timeType;
	}
	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}

	RankingService rankingService;
	public void setRankingService(RankingService rankingService) {
		this.rankingService = rankingService;
	}
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
		if (timeType > Constants.YEAR || timeType < Constants.DAY){
			return Constants.FAIL;
		}
		lsScoreBugsRanked = rankingService.bugRanking(timeType, Constants.ORDERBYSCORE);
		lsVotingBugsRanked = rankingService.bugRanking(timeType, Constants.ORDERBYUP_DOWN);
		lsSolutionsBugsRanked = rankingService.bugRanking(timeType, Constants.ORDERBYSOLUTIONCOUNT);
		lsCommentsBugsRanked = rankingService.bugRanking(timeType, Constants.ORDERBYCOMMENTCOUNT);
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
