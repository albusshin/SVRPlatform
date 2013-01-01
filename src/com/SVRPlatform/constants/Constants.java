package com.SVRPlatform.constants;

public class Constants {
	public static final String FAIL = "fail";
	public static final String SUCCESS = "success";
	public static final String NOTSIGNEDIN = "notsignedin";
	
	/**
	 *按时间段筛选 
	 */
	public static final int DAY = 5;
	public static final int MONTH = 6;
	public static final int WEEK = 7;
	public static final int YEAR = 8;
	
	/**
	 * 按comment count排序
	 */
	public static final int ORDERBYCOMMENTCOUNT = 3;
	
	/**
	 * 按solution count排序
	 */
	public static final int ORDERBYSOLUTIONCOUNT = 4;
	
	/**
	 * 按score排序
	 */
	public static final int ORDERBYSCORE = 1;
	
	/**
	 * 按up-down排序
	 */
	public static final int ORDERBYUP_DOWN = 2;  
	
	
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
	/**
	 * 顶踩exploit所加减的奖励
	 */
	public static final int BONUSONEXPLOITUPORDOWN = 20;
	/**
	 * 顶exploit所允许的最小credits
	 */
	public static final int MINCREDITSONEXPLOITUP = 100;
	/**
	 * 踩exploit所允许的最小credits
	 */
	public static final int MINCREDITSONEXPLOITDOWN = 500;
	/**
	 * 顶踩vulnerability所加减的分数
	 */
	public static final int BONUSONVULNERABILITYUPORDOWN = 5;
	/**
	 * 关注Vulnerability所需最少分数
	 */
	public static final int MINCREDITSONVULNERABILITYWATCH = 50;
	
	public static final String BUG = "bug";
	public static final String VULNERABILITY = "vulnerability";

}
