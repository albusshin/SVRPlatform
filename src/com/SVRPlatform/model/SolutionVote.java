package com.SVRPlatform.model;

public class SolutionVote implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer voteFlag;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	private Integer id;
	private User user;
	private Solution solution;
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
	

}
