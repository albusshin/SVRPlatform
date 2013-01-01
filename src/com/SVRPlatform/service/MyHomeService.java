package com.SVRPlatform.service;

import java.util.List;
import java.util.Map;

import com.SVRPlatform.data.BugData;
import com.SVRPlatform.data.ExploitData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.data.VulnerabilityData;

public interface MyHomeService {
	
	public List<BugData> getMyBugs(int userID);
	public Map<Integer, List<BugData>> getWatchingBugs(int userID);
	public List<SolutionData> getMySolutions(int userID);
	
	public List<VulnerabilityData> getMyVulnerabilitys(int userID);
	public Map<Integer, List<VulnerabilityData>> getWatchingVulnerabilitys(int userID);
	public List<ExploitData> getMyExploits(int userID);
}
