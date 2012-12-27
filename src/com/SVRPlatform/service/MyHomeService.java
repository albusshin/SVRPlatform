package com.SVRPlatform.service;

import java.util.List;
import java.util.Map;

import com.SVRPlatform.data.SolutionData;

public interface MyHomeService {
	public List<BugData> getMyBugs();
	public Map<Integer, List<BugData>> getWatchingBugs();
	public List<SolutionData> getMySolutions(); 
	/*bugdata里面要
	 * 1. 有没有官方和bestsolution
	 * 2. comments数目多少
	 * 3. solutions数目多少
	 * 4. digest
	 * 5. bugnumber
	 * 6. publishDate
	 */
}
