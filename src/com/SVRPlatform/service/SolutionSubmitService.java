package com.SVRPlatform.service;

import java.util.Map;

public interface SolutionSubmitService {
	public Map<String, String> solutionSubmit(String bugNumber, String email, String content);
	public Map<String, String> solutionEdit(String bugNumber, String email, String content);
}
