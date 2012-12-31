package com.SVRPlatform.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.data.UserData;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService {
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserData displayUserProfile(String email) {
		// TODO Auto-generated method stub
		User user = (User) this.userDAO.getUserByEmail(email);
		return displayUserProfile(user);
	}

	@Override
	public UserData displayUserProfile(int userId) {
		// TODO Auto-generated method stub
		User user = (User) this.userDAO.getByID(new Integer(userId));
		return displayUserProfile(user);
	}

	@Override
	public Map<String, String> submitUserProfile(UserData userData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> submitUserProfile(int userID, String website,
			String location, String realname, int age) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		User user = (User) this.userDAO.getByID(new Integer(userID));
		try{
			user.setAge(age);
			user.setLocation(location);
			user.setWebsite(website);
			user.setRealName(realname);
			userDAO.update(user);
			map.put("stats", "OK");
		}catch(Exception e){
			map.put("message", e.getMessage());
			map.put("stats", "failed");
		}
		return map;
	}
	
	protected UserData displayUserProfile(User user){
		try{
			UserData userData = new UserData();
			userData.setAge(user.getAge());
			userData.setCredit(user.getCredit());
			userData.setEmail(user.getEmail());
			//System.out.println(user.getSeen().toString());
			userData.setLastSeenDate(user.getSeen().toString().substring(0, 16));
			userData.setLocation(user.getLocation());
			
			userData.setMemberFor(this.formatDate(user.getDate()));
			
			userData.setProfileViews(user.getProfileViews());
			userData.setRegisterDate(user.getDate().toString().substring(0, 16));
			userData.setRealName(user.getRealName());
			
			userData.setSeen(this.formatDate(user.getSeen())+ " ago");
			
			userData.setUserId(user.getUserId());
			userData.setWebsite(user.getWebsite());
			return userData;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	protected String formatDate(Date date){
		long between = (new Date().getTime() - date.getTime()) / 1000;
		long minute = 60;
		long hour = 60 * minute;
		long day  = 24 * hour;
		long year = 365 * day;
		long month = 30 * day;
		long week = 7 * day;
		
		
		long years = between / year;
		if(years > 0)
			return years + " years";
		
		long months = between / month;
		if(months > 0)
			return months + " months";
		
		long weeks = between / week;
		if(weeks > 0)
			return weeks + " weeks";
		
		long days = between / day;
		if(days > 0)
			return days + " days";
		
		long hours = between / hour;
		if(hours > 0)
			return hours + " hours";
		
		long minutes = between / minute;
		if(minutes > 0)
			return minutes + " minutes";
		
		return between + " seconds";
	}

}
