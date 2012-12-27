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

public class MyHomeAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 761493739458851799L;
	HttpServletRequest request;
	HttpServletResponse response;
	MyHomeService myHomeService;
	List<BugData> lsMyBugs;
	List<BugData> lsWatchingBugs1;
	List<BugData> lsWatchingBugs2;
	List<SolutionData> lsMySolutions;
	public List<BugData> getLsMyBugs() {
		return lsMyBugs;
	}
	public List<BugData> getLsWatchingBugs1() {
		return lsWatchingBugs1;
	}
	public List<BugData> getLsWatchingBugs2() {
		return lsWatchingBugs2;
	}
	public List<SolutionData> getLsMySolutions() {
		return lsMySolutions;
	}
	public void setMyHomeService(MyHomeService myHomeService) {
		this.myHomeService = myHomeService;
	}
	public String execute(){
		if (VerifyUser.getNowUser(request) == null){
			return Constants.FAIL;
		}
		int userID = VerifyUser.getNowUserID(request);
		lsMyBugs = myHomeService.getMyBugs(userID);
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
