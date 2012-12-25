package com.SVRPlatform.service;

import com.SVRPlatform.data.SolutionCommentsData;

public interface SolutionCommentDisplayService {
	public SolutionCommentsData commentsDispalyService(int solutionId, int pageNumber, int commentsPerPage);
}
