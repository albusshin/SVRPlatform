package com.SVRPlatform.dao;

import java.util.List;

import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionVote;
import com.SVRPlatform.model.User;

public interface SolutionVoteDAO extends basicDAO{
	public SolutionVote getByUserAndSolution(User user, Solution solution);
	public List<SolutionVote> getSolutionIdFromSolutionList(List<Solution> solutions, User user);
}
