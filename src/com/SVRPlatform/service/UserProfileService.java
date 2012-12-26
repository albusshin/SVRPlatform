package com.SVRPlatform.service;

import java.util.Map;

import com.SVRPlatform.data.UserData;

public interface UserProfileService {
	/**
	 * 通过user的email来显示信息
	 * @param email
	 * @return userData
	 */
	public UserData displayUserProfile(String email);
	/**
	 * 通过user的id来显示信息
	 * @param userId
	 * @return userData
	 */
	public UserData displayUserProfile(int userId);
	/**
	 * 传入一个完整信息的userData，保存
	 * @param userData
	 * @return Map<错误值, 错误信息>
	 */
	public Map<String, String> submitUserProfile(UserData userData);
	/**
	 * 另一个简洁的方法
	 * @param website
	 * @param location
	 * @param realname
	 * @param age
	 * @return Map<错误值, 错误信息>
	 */
	public Map<String, String> submitUserProfile(String website, String location, String realname, int age);
}
