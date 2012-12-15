package com.SVRPlatform.service;

import com.SVRPlatform.data.BugCommentsData;

public interface CommentsDisplayService {

	public BugCommentsData commentsDispalyService(String bugNumber, int pageNumber, int commentsPerPage);
}