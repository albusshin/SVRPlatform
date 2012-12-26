package com.SVRPlatform.service;

import java.util.Map;

import com.SVRPlatform.data.UserData;

public interface UserProfileService {
	/**
	 * ͨ��user��email����ʾ��Ϣ
	 * @param email
	 * @return userData
	 */
	public UserData displayUserProfile(String email);
	/**
	 * ͨ��user��id����ʾ��Ϣ
	 * @param userId
	 * @return userData
	 */
	public UserData displayUserProfile(int userId);
	/**
	 * ����һ��������Ϣ��userData������
	 * @param userData
	 * @return Map<����ֵ, ������Ϣ>
	 */
	public Map<String, String> submitUserProfile(UserData userData);

}
