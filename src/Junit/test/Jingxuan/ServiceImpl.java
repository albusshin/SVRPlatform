package Junit.test.Jingxuan;

import com.SVRPlatform.service.SolutionVoteService;

public class ServiceImpl implements SolutionVoteService {

	@Override
	public boolean voteUp(int solutionId, String email) {
		// TODO Auto-generated method stub
		System.out.println("up");
		return false;
	}

	@Override
	public boolean voteDown(int solutionId, String email) {
		// TODO Auto-generated method stub
		System.out.println("down");
		return false;
	}
	
}
