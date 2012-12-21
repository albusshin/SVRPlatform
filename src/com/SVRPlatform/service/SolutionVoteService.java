package com.SVRPlatform.service;

public interface SolutionVoteService {
	public boolean voteUp(int solutionId, String email);
	public boolean voteDown(int solutionId, String email);
}
