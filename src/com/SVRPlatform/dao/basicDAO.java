package com.SVRPlatform.dao;

import java.io.Serializable;

public interface basicDAO {
	public Serializable add(Object obj);
	public void update(Object obj);
	public void delete(Object obj);
	public Object getByID(Serializable ID);
}
