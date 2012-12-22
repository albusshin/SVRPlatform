package com.SVRPlatform.service;

import com.SVRPlatform.data.BugSolutionsData;
import com.SVRPlatform.data.SolutionData;

public interface SolutionsDisplayService {

	public BugSolutionsData solutionsDisplayService(int userID, String bugNumber, int pageNumber, int solutionsPerPage);
	public SolutionData officialSolutionDisplayService(String bugNumber);
}