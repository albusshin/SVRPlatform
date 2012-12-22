package com.SVRPlatform.service;

public interface SolutionVoteService {
	public String voteUp(int solutionId, String email);
	public String voteDown(int solutionId, String email);
}
