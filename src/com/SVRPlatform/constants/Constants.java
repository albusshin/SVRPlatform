package com.SVRPlatform.constants;

public class Constants {
	public static final String FAIL = "fail";
	public static final String SUCCESS = "success";
	public static final String NOTSIGNEDIN = "notsignedin";
	/**
	 * 错误：
	 * 你是这个solution的Owner
	 */
	public static final String OWNER = "owner";
	/**
	 * 错误：
	 * 可能是database连接不上
	 */
	public static final String DBERROR = "DBerror";
	/**
	 * 错误
	 * 你已经投票过了
	 */
	public static final String ALREADYVOTED = "alreadyvoted";
	/**
	 * 错误
	 * Credits 不够
	 * 
	 */
	public static final String CREDITSNOTENOUGH = "creditsnotenough";
	/**
	 * 顶踩bug加减的分数
	 */
	public static final int BONUSONBUGUPORDOWN = 5;
	/**
	 * solution被顶或踩一下加或减的分数
	 */
	public static final int BONUSONSOLUTIONUPORDOWN = 5;
	/**
	 * 顶solution所允许的最小credits
	 */
	public static final int MINCREDITSONUP = 15;
	/**
	 * 踩solution所允许的最小credits
	 */
	public static final int MINCREDITSONDOWN = 125;
	
	
	public static final String BUG = "bug";
	public static final String VULNERABILITY = "vulnerability";
}
