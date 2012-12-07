package com.SVRPlatform.dao;

import com.SVRPlatform.model.HashForPasswordRetrieve;

public interface HashForPasswordRetrieveDAO extends basicDAO {
	/**
	 * get the HashForPasswordRetrieve by the hashValue
	 * @param hashValue
	 * @return the HashForPasswordRetrieve object whose 
	 * 		hashValue equals to the parameter.
	 */
	public HashForPasswordRetrieve getByHashValue(String hashValue);
}
