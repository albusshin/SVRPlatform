package com.SVRPlatform.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute()
	{
		ActionContext actctx = ActionContext.getContext();
		actctx.getSession().put("email", "tourist");
		actctx.getSession().put("password", "tourist");
		return SUCCESS;
	}
}
