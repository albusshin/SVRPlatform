package com.SVRPlatform.service;

import java.util.Map;

public interface SolutionCommentSubmitService {
	public Map<String, String> commentSubmit(int solutionId, String email, String content);
}
