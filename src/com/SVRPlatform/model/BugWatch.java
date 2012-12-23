package com.SVRPlatform.model;

public class BugWatch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer voteFlag;
	private User user;
	private Bug bug;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVoteFlag() {
		return voteFlag;
	}
	public void setVoteFlag(Integer voteFlag) {
		this.voteFlag = voteFlag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bug getBug() {
		return bug;
	}
	public void setBug(Bug bug) {
		this.bug = bug;
	}
	
}
