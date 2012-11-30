package com.SVRPlatform.dao;

import java.io.Serializable;

public interface basicDAO {
	public Serializable add(Object obj);
	public Serializable update(Object obj);
	public Serializable delete(Object obj);
	public Serializable getByID(Serializable ID);
}
