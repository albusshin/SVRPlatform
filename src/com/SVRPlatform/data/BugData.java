package com.SVRPlatform.data;

public class BugData {
	private boolean hasOfficial;
	private boolean hasBest;
	private int commentsCount;
	private int solutionsCount;
	private String digest;
	private String bugNumber;
	private String publishDate;
	
	public boolean isHasOfficial() {
		return hasOfficial;
	}
	public void setHasOfficial(boolean hasOfficial) {
		this.hasOfficial = hasOfficial;
	}
	public boolean isHasBest() {
		return hasBest;
	}
	public void setHasBest(boolean hasBest) {
		this.hasBest = hasBest;
	}
	public int getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}
	public int getSolutionsCount() {
		return solutionsCount;
	}
	public void setSolutionsCount(int solutionsCount) {
		this.solutionsCount = solutionsCount;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getBugNumber() {
		return bugNumber;
	}
	public void setBugNumber(String bugNumber) {
		this.bugNumber = bugNumber;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
}
