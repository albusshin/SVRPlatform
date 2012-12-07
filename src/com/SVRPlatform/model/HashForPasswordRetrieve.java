package com.SVRPlatform.model;

public class HashForPasswordRetrieve {
	private int userId;
	private String  hashValue;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userid) {
		this.userId = userid;
	}
	public String getHashValue() {
		return hashValue;
	}
	public void setHashValue(String hashValue) {
		this.hashValue = hashValue;
	}
}
