package com.SVRPlatform.model;

// Generated 2012-11-30 16:34:58 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bug generated by hbm2java
 */
public class Bug implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bugId;
	private String version;
	private Software software;
	private User user;
	private String graphAddress;
	private Date datetime;
	private String description;
	private Integer bestSolutionId;
	private Integer officialSolutionId;
	private String bugDigest;
	private Float usabilityImpact;
	private Float dataImpact;
	private Float privacyImpact;
	private Float availabilityImpact;
	private Float frequency;
	private Float score;
	private String language;
	private String bugNumber;
	private Ranking ranking;
	private Set solutions = new HashSet(0);
	private Set users = new HashSet(0);
	private Set comments = new HashSet(0);

	public Bug() {
	}

	public Bug(Software software, User user, String graphAddress,
			Date datetime, String description, Integer bestSolutionId,
			Integer officialSolutionId, String bugDigest,
			Float usabilityImpact, Float dataImpact, Float privacyImpact,
			Float availabilityImpact, Float frequency, Float score,
			String language, String bugNumber, Ranking ranking, Set solutions,
			Set users, Set comments) {
		this.software = software;
		this.user = user;
		this.graphAddress = graphAddress;
		this.datetime = datetime;
		this.description = description;
		this.bestSolutionId = bestSolutionId;
		this.officialSolutionId = officialSolutionId;
		this.bugDigest = bugDigest;
		this.usabilityImpact = usabilityImpact;
		this.dataImpact = dataImpact;
		this.privacyImpact = privacyImpact;
		this.availabilityImpact = availabilityImpact;
		this.frequency = frequency;
		this.score = score;
		this.language = language;
		this.bugNumber = bugNumber;
		this.ranking = ranking;
		this.solutions = solutions;
		this.users = users;
		this.comments = comments;
	}

	public Integer getBugId() {
		return this.bugId;
	}

	public void setBugId(Integer bugId) {
		this.bugId = bugId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Software getSoftware() {
		return this.software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGraphAddress() {
		return this.graphAddress;
	}

	public void setGraphAddress(String graphAddress) {
		this.graphAddress = graphAddress;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBestSolutionId() {
		return this.bestSolutionId;
	}

	public void setBestSolutionId(Integer bestSolutionId) {
		this.bestSolutionId = bestSolutionId;
	}

	public Integer getOfficialSolutionId() {
		return this.officialSolutionId;
	}

	public void setOfficialSolutionId(Integer officialSolutionId) {
		this.officialSolutionId = officialSolutionId;
	}

	public String getBugDigest() {
		return this.bugDigest;
	}

	public void setBugDigest(String bugDigest) {
		this.bugDigest = bugDigest;
	}

	public Float getUsabilityImpact() {
		return this.usabilityImpact;
	}

	public void setUsabilityImpact(Float usabilityImpact) {
		this.usabilityImpact = usabilityImpact;
	}

	public Float getDataImpact() {
		return this.dataImpact;
	}

	public void setDataImpact(Float dataImpact) {
		this.dataImpact = dataImpact;
	}

	public Float getPrivacyImpact() {
		return this.privacyImpact;
	}

	public void setPrivacyImpact(Float privacyImpact) {
		this.privacyImpact = privacyImpact;
	}

	public Float getAvailabilityImpact() {
		return this.availabilityImpact;
	}

	public void setAvailabilityImpact(Float availabilityImpact) {
		this.availabilityImpact = availabilityImpact;
	}

	public Float getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Float frequency) {
		this.frequency = frequency;
	}

	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBugNumber() {
		return this.bugNumber;
	}

	public void setBugNumber(String bugNumber) {
		this.bugNumber = bugNumber;
	}

	public Ranking getRanking() {
		return this.ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public Set getSolutions() {
		return this.solutions;
	}

	public void setSolutions(Set solutions) {
		this.solutions = solutions;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}
