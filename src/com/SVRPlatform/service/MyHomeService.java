package com.SVRPlatform.service;

import java.util.List;
import java.util.Map;

import com.SVRPlatform.data.BugData;
import com.SVRPlatform.data.SolutionData;

public interface MyHomeService {
	
	public List<BugData> getMyBugs(int userID);
	public Map<Integer, List<BugData>> getWatchingBugs(int userID);
	public List<SolutionData> getMySolutions(int userID);
}
//BugDAO getByUser(User user )
//BugWatchDAO getByUser(User user )