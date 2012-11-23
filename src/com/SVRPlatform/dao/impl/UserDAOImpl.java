package com.SVRPlatform.dao.impl;

import com.SVRPlatform.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	public String getPasswordByUsername(String username) {
		// TODO Auto-generated method stub
		/*
		 * do something here;
		 */
		System.out.println("DAO:"+username);
		System.out.println("DAO:"+ (username.compareTo("povergo")));
		if (username.compareTo("povergo")==0)
			return "1234";
		else
			return null;
	}

}
