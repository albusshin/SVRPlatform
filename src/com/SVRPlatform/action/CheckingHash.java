package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.PasswordRetrieveService;
import com.opensymphony.xwork2.ActionSupport;

public class CheckingHash extends ActionSupport implements
ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1387036496288380704L;
	public static final String FAIL = "fail";
	private HttpServletResponse response;
	private HttpServletRequest request;
	private PasswordRetrieveService passwordretrieveservice;
	

	public void setPasswordretrieveservice(
			PasswordRetrieveService passwordretrieveservice) {
		this.passwordretrieveservice = passwordretrieveservice;
	}
	String email = null;
	public String execute() {
		System.out.println("Inside CheckingHash.java execute");
		HttpSession session = request.getSession();
		String hash = request.getParameter("hash");
		System.out.println("hash == " + hash);
		email = passwordretrieveservice.checkHashValue(hash);
		System.out.println("Checked email = " + email);
		
		session.setAttribute("email", email);
		if (email != null)
			return SUCCESS;
		return FAIL;
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
