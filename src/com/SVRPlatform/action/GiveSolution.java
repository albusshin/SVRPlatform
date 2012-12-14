package com.SVRPlatform.action;

import com.SVRPlatform.constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class GiveSolution extends ActionSupport
{
	/*
	 * Get solution text from page,check it is null or not.
	 */   
	
	public String solutiontext;
	public String message;
	
	public String execute()
	{
		System.out.println( "solution:" + solutiontext);
	/*
	 *   wait for the function supplied by Qingwei to check whether title and text are valid or not.
	 *	 
	 *   message=this.GiveSolutionService.giveSolution(solutiontext); 
	 *   if(message.equal("SolutionValid")) return Constants.SUCCESS;
	 *   else return Constants.FAIL;
	 *
	 */				
		
		return Constants.SUCCESS;
	}	
}
