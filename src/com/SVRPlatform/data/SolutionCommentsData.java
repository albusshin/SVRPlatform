package com.SVRPlatform.data;

import java.util.List;

public class SolutionCommentsData {
	private int solutionCommetCount;
	private List<SolutionCommentData> solutionCommentsData;
	
	public int getSolutionCommetCount() {
		return solutionCommetCount;
	}
	public void setSolutionCommetCount(int solutionCommetCount) {
		this.solutionCommetCount = solutionCommetCount;
	}
	public List<SolutionCommentData> getSolutionCommentsData() {
		return solutionCommentsData;
	}
	public void setSolutionCommentsData(
			List<SolutionCommentData> solutionCommentsData) {
		this.solutionCommentsData = solutionCommentsData;
	}
}
