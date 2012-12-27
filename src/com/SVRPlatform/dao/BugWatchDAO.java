package com.SVRPlatform.dao;

import java.util.List;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.BugWatch;
import com.SVRPlatform.model.User;

public interface BugWatchDAO extends basicDAO {
	public BugWatch getByUserAndBug(User user, Bug bug);
	public List<BugWatch> getSolutionIdFromSolutionList(List<Bug> bug, User user);
	public List<Bug> getByUser(User user);
}
