package com.SVRPlatform.service;

public interface BugWatchService {
	public String voteUp(int bugId, String email);
	public String voteDown(int bugId, String email);
}
