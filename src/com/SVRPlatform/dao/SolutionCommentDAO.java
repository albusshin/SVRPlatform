package com.SVRPlatform.dao;

import java.util.List;

import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionComment;
import com.SVRPlatform.model.User;

public interface SolutionCommentDAO extends basicDAO {
	public List<SolutionComment> getByUserAndSolution(User user, Solution solution, int fetchSize,
			int firstResult);

	public List<SolutionComment> getBySolution(Solution solution, int fetchSize,
			int firstResult);

	public List<SolutionComment> getByUser(User user, int fetchSize,
			int firstResult);
	
	public long getCountFromOneSolution(Solution solution);
	
	public long getCountFromOneUser(User user);
}
