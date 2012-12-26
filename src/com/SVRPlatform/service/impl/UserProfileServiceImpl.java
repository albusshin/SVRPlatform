package com.SVRPlatform.service.impl;

import java.util.Calendar;
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
		System.out.println("email == " + email);
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
			System.out.println("user == " + user);
			UserData userData = new UserData();
			userData.setAge(user.getAge());
			userData.setCredit(user.getCredit());
			userData.setEmail(user.getEmail());
			System.out.println(user.getSeen().toString());
			userData.setLastSeenDate(user.getSeen().toString().substring(0, 16));
			userData.setLocation(user.getLocation());
			
			userData.setMemberFor(this.formatDate(user.getDate()));
			
			userData.setProfileViews(user.getProfileViews());
			userData.setRegisterDate(user.getDate().toString().substring(0, 16));
			userData.setRealName(user.getRealName());
			
			userData.setSeen(this.formatDate(user.getSeen()));
			
			userData.setUserId(user.getUserId());
			userData.setWebsite(user.getWebsite());
			return userData;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	protected String formatDate(Date date){
		Calendar pastDate = Calendar.getInstance();
		pastDate.setTime(date);
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(new Date());
		int years = nowDate.get(Calendar.YEAR) - pastDate.get(Calendar.YEAR);
		if(years !=0 )
			return "years:"+years;
		int months = nowDate.get(Calendar.MONTH) - pastDate.get(Calendar.MONTH);
		if(months != 0)
			return "months:"+months;
		int weeks = nowDate.get(Calendar.WEEK_OF_YEAR) - pastDate.get(Calendar.WEEK_OF_YEAR);
		if(weeks != 0)
			return "weeks:"+weeks;
		int days = nowDate.get(Calendar.DAY_OF_YEAR) - pastDate.get(Calendar.DAY_OF_YEAR);
		if(days !=0 )
			return "days:"+days;
		int hours = nowDate.get(Calendar.HOUR_OF_DAY)- pastDate.get(Calendar.HOUR_OF_DAY);
		if(hours != 0)
			return "hours:"+hours;
		int minutes = nowDate.get(Calendar.MINUTE) - pastDate.get(Calendar.MINUTE);
		if(minutes !=0)
			return "minutes:"+minutes;
		int seconds = nowDate.get(Calendar.SECOND) - pastDate.get(Calendar.SECOND);
			return "seconds:"+seconds;
	}

}
