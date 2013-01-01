package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.SVRPlatform.Utils.StringEncoder;
import com.SVRPlatform.service.PasswordRetrieveService;
import com.opensymphony.xwork2.ActionSupport;

public class CheckingHash extends ActionSupport implements
ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1387036496288380704L;
	public static final String FAIL = "fail";
	private HttpServletRequest request;
	private PasswordRetrieveService passwordRetrieveService;
	


	public void setPasswordRetrieveService(
			PasswordRetrieveService passwordRetrieveService) {
		this.passwordRetrieveService = passwordRetrieveService;
	}

	private String email = null;
	public String execute() {
//		//System.out.println("Inside CheckingHash.java execute");
		HttpSession session = request.getSession();
		String hash = request.getParameter("hash");
		String ehash = request.getParameter("ehash");
		//System.out.println("hash == " + hash);
		email = passwordRetrieveService.checkHashValue(hash);
		String ehash1 = StringEncoder.EncoderByMd5(email);
		if(ehash.compareTo(ehash1) == 0){
			System.out.println("Checked email = " + email);
			session.setAttribute("email", email);
			return SUCCESS;
		}
		return FAIL;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

}
