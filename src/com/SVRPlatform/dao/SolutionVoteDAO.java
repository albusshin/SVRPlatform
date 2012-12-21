package com.SVRPlatform.dao;

import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionVote;
import com.SVRPlatform.model.User;

public interface SolutionVoteDAO extends basicDAO{
	public SolutionVote getByUserAndSolution(User user, Solution solution);
}
