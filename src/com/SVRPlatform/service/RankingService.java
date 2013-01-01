package com.SVRPlatform.service;

import java.util.List;

import com.SVRPlatform.data.BugData;

public interface RankingService {
	
	/**
	 * @param time 			use Constants.DAY/WEEK/MONTH/YEAR
	 * @param orderType 	use Constants.ORDERBYCOMMENTCOUNT/
	 * 														  ORDERBYSOLUTIONCOUNT/
	 *                                                        ORDERBYSCORE/ORDERBYUP_DOWN 
	 * @return
	 */
	public List<BugData> bugRanking(int time, int orderType);
}
