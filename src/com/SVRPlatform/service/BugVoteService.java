package com.SVRPlatform.service;

public interface BugVoteService {

	public String voteUp(String bugNumber, String email);
	public String voteDown(String bugNumber, String email);
}
