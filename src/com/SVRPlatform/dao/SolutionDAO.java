package com.SVRPlatform.dao;

import java.util.List;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;

public interface SolutionDAO extends basicDAO {
	public List<Solution> getByUserIdAndBugId(User user, Bug bug);

	public List<Solution> getByBugId(Bug bug, int fetchSize,
			int firstResult);

	public List<Solution> getByUserId(User user, int fetchSize,
			int firstResult);
}
