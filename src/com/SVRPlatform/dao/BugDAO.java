package com.SVRPlatform.dao;

import java.io.Serializable;

import com.SVRPlatform.model.Bug;

public interface BugDAO extends basicDAO{

	public Serializable addBug(Bug bug);

	public Serializable update(Bug bug);
}