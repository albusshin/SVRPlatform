package Junit.test.Jingxuan;

import com.SVRPlatform.service.SolutionVoteService;

public class ServiceImpl implements SolutionVoteService {

	@Override
	public String voteUp(int solutionId, String email) {
		// TODO Auto-generated method stub
		System.out.println("up");
		return "";
	}

	@Override
	public String voteDown(int solutionId, String email) {
		// TODO Auto-generated method stub
		System.out.println("down");
		return "";
	}
	
}
