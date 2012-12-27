package com.SVRPlatform.service;

import java.util.List;
import java.util.Map;

import com.SVRPlatform.data.BugData;
import com.SVRPlatform.data.SolutionData;

public interface MyHomeService {
	public List<BugData> getMyBugs();
	public Map<Integer, List<BugData>> getWatchingBugs();
	public List<SolutionData> getMySolutions(); 
}
