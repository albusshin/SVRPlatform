package com.SVRPlatform.data;


public class UserData {
	private int userId;
	private String email;
	private String realName;
	private int credit;
	private String website;
	private int age;
	private String location;
	private String seen;
	private String memberFor;
	private int profileViews;
	private String registerDate;
	private String lastSeenDate;
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getLastSeenDate() {
		return lastSeenDate;
	}
	public void setLastSeenDate(String lastseenDate) {
		this.lastSeenDate = lastseenDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSeen() {
		return seen;
	}
	public void setSeen(String seen) {
		this.seen = seen;
	}
	public String getMemberFor() {
		return memberFor;
	}
	public void setMemberFor(String memberFor) {
		this.memberFor = memberFor;
	}
	public int getProfileViews() {
		return profileViews;
	}
	public void setProfileViews(int profileViews) {
		this.profileViews = profileViews;
	}
}
