package com.SVRPlatform.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.VulnerabilityData;
import com.SVRPlatform.service.RankingService;
import com.opensymphony.xwork2.ActionSupport;

public class VulnerabilitiesRankingAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 761493739458851799L;
	HttpServletRequest request;
	HttpServletResponse response;
	List<VulnerabilityData> lsScoreBugsRanked;
	List<VulnerabilityData> lsVotingBugsRanked;
	List<VulnerabilityData> lsSolutionsBugsRanked;
	List<VulnerabilityData> lsCommentsBugsRanked;
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
	public List<VulnerabilityData> getLsScoreBugsRanked() {
		return lsScoreBugsRanked;
	}
	public List<VulnerabilityData> getLsVotingBugsRanked() {
		return lsVotingBugsRanked;
	}
	public List<VulnerabilityData> getLsSolutionsBugsRanked() {
		return lsSolutionsBugsRanked;
	}
	public List<VulnerabilityData> getLsCommentsBugsRanked() {
		return lsCommentsBugsRanked;
	}
	public String execute(){
		if (timeType > Constants.YEAR || timeType < Constants.DAY){
			return Constants.FAIL;
		}
		lsScoreBugsRanked = rankingService.vulnerabilityRanking(timeType, Constants.ORDERBYSCORE);
		lsVotingBugsRanked = rankingService.vulnerabilityRanking(timeType, Constants.ORDERBYUP_DOWN);
		lsSolutionsBugsRanked = rankingService.vulnerabilityRanking(timeType, Constants.ORDERBYSOLUTIONCOUNT);
		lsCommentsBugsRanked = rankingService.vulnerabilityRanking(timeType, Constants.ORDERBYCOMMENTCOUNT);
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
