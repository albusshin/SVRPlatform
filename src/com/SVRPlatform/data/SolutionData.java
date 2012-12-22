package com.SVRPlatform.data;

public class SolutionData {

	private int solutionID;
	private String content;
	private String datetime;
	private String realname;
	private String email;
	private int credits;
	private int up;
	private int down;
	private boolean isBest;
	private boolean votedUp;
	private boolean votedDown;
	
	public boolean isBest() {
		return isBest;
	}
	public void setBest(boolean isBest) {
		this.isBest = isBest;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDatetime() {
		return datetime.substring(0,16);
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public int getSolutionID() {
		return solutionID;
	}
	public void setSolutionID(int solutionID) {
		this.solutionID = solutionID;
	}
	public boolean isVotedUp() {
		return votedUp;
	}
	public void setVotedUp(boolean votedUp) {
		this.votedUp = votedUp;
	}
	public boolean isVotedDown() {
		return votedDown;
	}
	public void setVotedDown(boolean votedDown) {
		this.votedDown = votedDown;
	}
}
