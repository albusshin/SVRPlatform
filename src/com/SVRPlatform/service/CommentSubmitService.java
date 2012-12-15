package com.SVRPlatform.service;

import java.util.Map;

public interface CommentSubmitService {

	public Map<String, String> commentSubmit(String bugNumber, String email, String title, String content);
}