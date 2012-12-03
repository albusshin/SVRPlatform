package com.SVRPlatform.action;

import org.apache.catalina.connector.Request;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport{
	
	public String execute()
	{
		ActionContext actctx = ActionContext.getContext();
		actctx.getSession().put("email", "tourist");
		actctx.getSession().put("password", "tourist");
		return SUCCESS;
	}
}
