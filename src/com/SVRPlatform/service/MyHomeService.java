package com.SVRPlatform.service;

import java.util.List;
import java.util.Map;

import com.SVRPlatform.data.SolutionData;

public interface MyHomeService {
	public List<BugData> getMyBugs();
	public Map<Integer, List<BugData>> getWatchingBugs();
	public List<SolutionData> getMySolutions(); 
	/*bugdata����Ҫ
	 * 1. ��û�йٷ���bestsolution
	 * 2. comments��Ŀ����
	 * 3. solutions��Ŀ����
	 * 4. digest
	 * 5. bugnumber
	 * 6. publishDate
	 */
}
