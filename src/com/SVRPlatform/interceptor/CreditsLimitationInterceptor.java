package com.SVRPlatform.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.dao.BugWatchDAO;
import com.SVRPlatform.dao.ExploitVoteDAO;
import com.SVRPlatform.dao.SolutionVoteDAO;
import com.SVRPlatform.dao.VulnerabilityWatchDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.BugWatch;
import com.SVRPlatform.model.Exploit;
import com.SVRPlatform.model.ExploitVote;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionVote;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.impl.BugWatchServiceImpl;
import com.SVRPlatform.service.impl.ExploitVoteServiceImpl;
import com.SVRPlatform.service.impl.SolutionVoteServiceImpl;

@Aspect @Component
public class CreditsLimitationInterceptor {
	private SolutionVoteDAO solutionVoteDAO;
	private BugWatchDAO bugWatchDAO;
	
	private VulnerabilityWatchDAO vulnerabilityWatchDAO;
	private ExploitVoteDAO exploitVoteDAO;
	
	
	public BugWatchDAO getBugWatchDAO() {
		return bugWatchDAO;
	}


	public void setBugWatchDAO(BugWatchDAO bugWatchDAO) {
		this.bugWatchDAO = bugWatchDAO;
	}


	public SolutionVoteDAO getSolutionVoteDAO() {
		return solutionVoteDAO;
	}


	public void setSolutionVoteDAO(SolutionVoteDAO solutionVoteDAO) {
		this.solutionVoteDAO = solutionVoteDAO;
	}


	public VulnerabilityWatchDAO getVulnerabilityWatchDAO() {
		return vulnerabilityWatchDAO;
	}


	public void setVulnerabilityWatchDAO(VulnerabilityWatchDAO vulnerabilityWatchDAO) {
		this.vulnerabilityWatchDAO = vulnerabilityWatchDAO;
	}


	public ExploitVoteDAO getExploitVoteDAO() {
		return exploitVoteDAO;
	}


	public void setExploitVoteDAO(ExploitVoteDAO exploitVoteDAO) {
		this.exploitVoteDAO = exploitVoteDAO;
	}


	@Pointcut("execution(* com.SVRPlatform.service.impl.SolutionVoteServiceImpl.vote*(..))")
	private void voteMethod(){}	
	
	@Around("voteMethod()")
	public Object doBasicProfilingForVote(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		SolutionVoteServiceImpl svsi = (SolutionVoteServiceImpl) pjp.getTarget();
		User user = svsi.getUserDAO().getUserByEmail((String)pjp.getArgs()[1]);
		Solution solution = (Solution) svsi.getSolutionDAO().getByID(new Integer((int)pjp.getArgs()[0]));
		if(solution.getUser().getUserId() == user.getUserId()){
			////System.out.println("owner");
			//message = "You are the owner";
			return Constants.OWNER;
		}
		SolutionVote solutionVote = this.solutionVoteDAO.getByUserAndSolution(user, solution);
		if(solutionVote != null){
			if(solutionVote.getVoteFlag() == 1 && methodName.equals("voteUp")){
				////System.out.println("rowback for up");
				//solutionVote.setVoteFlag(0);
				solutionVoteDAO.delete(solutionVote);
				if(svsi.turnBackUp(solution, true))
					return Constants.SUCCESS;
				else
					return Constants.DBERROR;
			}
			else if(solutionVote.getVoteFlag() == -1 && methodName.equals("voteDown")){
//				System.out.println("rollback for down");
				//solutionVote.setVoteFlag(0);
				solutionVoteDAO.delete(solutionVote);
				if(svsi.turnBackUp(solution, false))
					return Constants.SUCCESS;
				else
					return Constants.DBERROR;
			}
			else{
				
//				System.out.println("getVoteFlat == " + solutionVote.getVoteFlag() + "methodname==" + methodName);
//				System.out.println("have voted");
				//message = "Have voted";
				return Constants.ALREADYVOTED;
			}
		}

		if(methodName == "voteUp" && user.getCredit() >= Constants.MINCREDITSONUP){
			////System.out.println("vote up");
			solutionVote = new SolutionVote();
			solutionVote.setVoteFlag(new Integer(1));
			solutionVote.setUser(user);
			solutionVote.setSolution(solution);
			solutionVoteDAO.add(solutionVote);
			return pjp.proceed();
		}
		else if(methodName == "voteDown" && user.getCredit() >= Constants.MINCREDITSONDOWN){
			////System.out.println("vote down");
			solutionVote = new SolutionVote();
			solutionVote.setVoteFlag(new Integer(-1));
			solutionVote.setUser(user);
			solutionVote.setSolution(solution);
			solutionVoteDAO.add(solutionVote);
			return pjp.proceed();
		}
		////System.out.println("credit is not enough");	
		//message = "Credit is not enough";
		return Constants.CREDITSNOTENOUGH;
	}
	
	@Pointcut("execution(* com.SVRPlatform.service.impl.BugWatchServiceImpl.vote*(..))")
	private void watchMethod(){}
	
	@Around("watchMethod()")
	public Object doBasicProfilingForWatch(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		BugWatchServiceImpl bwsi = (BugWatchServiceImpl) pjp.getTarget();
		User user = bwsi.getUserDAO().getUserByEmail((String)pjp.getArgs()[1]);
		Bug bug = (Bug) bwsi.getBugDAO().getByID(new Integer((int)pjp.getArgs()[0]));
		System.out.println(bug.getUser());
		System.out.println(user);
		if(bug.getUser().getUserId() == user.getUserId()){
			////System.out.println("owner");
			//message = "You are the owner";
			return Constants.OWNER;
		}
		BugWatch bugWatch = this.bugWatchDAO.getByUserAndBug(user, bug);
		if(bugWatch != null){
			if(bugWatch.getVoteFlag() == 1 && methodName.equals("voteUp")){
				////System.out.println("rowback for up");
				//solutionVote.setVoteFlag(0);
				bugWatchDAO.delete(bugWatch);
				if(bwsi.turnBackUp(bug, true))
					return Constants.SUCCESS;
				else
					return Constants.DBERROR;
			}
			else if(bugWatch.getVoteFlag() == -1 && methodName.equals("voteDown")){
//				System.out.println("rollback for down");
				//solutionVote.setVoteFlag(0);
				bugWatchDAO.delete(bugWatch);
				if(bwsi.turnBackUp(bug, false))
					return Constants.SUCCESS;
				else
					return Constants.DBERROR;
			}
			else{
				
//				System.out.println("getVoteFlat == " + solutionVote.getVoteFlag() + "methodname==" + methodName);
//				System.out.println("have voted");
				//message = "Have voted";
				return Constants.ALREADYVOTED;
			}
		}

		if(methodName == "voteUp" && user.getCredit() >= Constants.MINCREDITSONUP){
			////System.out.println("vote up");
			bugWatch = new BugWatch();
			bugWatch.setVoteFlag(new Integer(1));
			bugWatch.setUser(user);
			bugWatch.setBug(bug);
			bugWatchDAO.add(bugWatch);
			return pjp.proceed();
		}
		else if(methodName == "voteDown" && user.getCredit() >= Constants.MINCREDITSONDOWN){
			////System.out.println("vote down");
			bugWatch = new BugWatch();
			bugWatch.setVoteFlag(new Integer(-1));
			bugWatch.setUser(user);
			bugWatch.setBug(bug);
			bugWatchDAO.add(bugWatch);
			return pjp.proceed();
		}
		////System.out.println("credit is not enough");	
		//message = "Credit is not enough";
		return Constants.CREDITSNOTENOUGH;
	}
	
	
	@Pointcut("execution(* com.SVRPlatform.service.impl.ExploitVoteServiceImpl.vote*(..))")
	private void exploitVoteMethod(){}	
	
	@Around("exploitVoteMethod()")
	public Object doBasicProfilingForExploitVote(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		ExploitVoteServiceImpl evsi = (ExploitVoteServiceImpl) pjp.getTarget();
		User user = evsi.getUserDAO().getUserByEmail((String)pjp.getArgs()[1]);
		Exploit exploit = (Exploit) evsi.getExploitDAO().getByID(new Integer((int)pjp.getArgs()[0]));
		if(exploit.getUser().getUserId() == user.getUserId()){
			////System.out.println("owner");
			//message = "You are the owner";
			return Constants.OWNER;
		}
		ExploitVote exploitVote = this.getExploitVoteDAO().getByUserAndExploit(user, exploit);
		if(exploitVote != null){
			if(exploitVote.getVoteFlag() == 1 && methodName.equals("voteUp")){
				////System.out.println("rowback for up");
				//solutionVote.setVoteFlag(0);
				solutionVoteDAO.delete(exploitVote);
				if(evsi.turnBackUp(exploit, true))
					return Constants.SUCCESS;
				else
					return Constants.DBERROR;
			}
			else if(exploitVote.getVoteFlag() == -1 && methodName.equals("voteDown")){
//				System.out.println("rollback for down");
				//solutionVote.setVoteFlag(0);
				exploitVoteDAO.delete(exploitVote);
				if(evsi.turnBackUp(exploit, false))
					return Constants.SUCCESS;
				else
					return Constants.DBERROR;
			}
			else{
				
//				System.out.println("getVoteFlat == " + solutionVote.getVoteFlag() + "methodname==" + methodName);
//				System.out.println("have voted");
				//message = "Have voted";
				return Constants.ALREADYVOTED;
			}
		}

		if(methodName == "voteUp" && user.getCredit() >= Constants.MINCREDITSONEXPLOITUP){
			////System.out.println("vote up");
			exploitVote = new ExploitVote();
			exploitVote.setVoteFlag(new Integer(1));
			exploitVote.setUser(user);
			exploitVote.setExploit(exploit);
			solutionVoteDAO.add(exploitVote);
			return pjp.proceed();
		}
		else if(methodName == "voteDown" && user.getCredit() >= Constants.MINCREDITSONEXPLOITDOWN){
			////System.out.println("vote down");
			exploitVote = new ExploitVote();
			exploitVote.setVoteFlag(new Integer(-1));
			exploitVote.setUser(user);
			exploitVote.setExploit(exploit);
			exploitVoteDAO.add(exploitVote);
			return pjp.proceed();
		}
		////System.out.println("credit is not enough");	
		//message = "Credit is not enough";
		return Constants.CREDITSNOTENOUGH;
	}
	
//	@Pointcut("execution(* com.SVRPlatform.service.impl.VulnerabilityWatchServiceImpl.vote*(..))")
//	private void vulnerabilityWatchMethod(){}
//	
//	@Around("vulnerabilityWatchMethod()")
//	public Object doBasicProfilingForVulnerabilityWatch(ProceedingJoinPoint pjp) throws Throwable {
//		String methodName = pjp.getSignature().getName();
//		VulnerabilityWatchServiceImpl vwsi = (VulnerabilityWatchServiceImpl) pjp.getTarget();
//		User user = bwsi.getUserDAO().getUserByEmail((String)pjp.getArgs()[1]);
//		Bug bug = (Bug) bwsi.getBugDAO().getByID(new Integer((int)pjp.getArgs()[0]));
//		System.out.println(bug.getUser());
//		System.out.println(user);
//		if(bug.getUser().getUserId() == user.getUserId()){
//			////System.out.println("owner");
//			//message = "You are the owner";
//			return Constants.OWNER;
//		}
//		BugWatch bugWatch = this.bugWatchDAO.getByUserAndBug(user, bug);
//		if(bugWatch != null){
//			if(bugWatch.getVoteFlag() == 1 && methodName.equals("voteUp")){
//				////System.out.println("rowback for up");
//				//solutionVote.setVoteFlag(0);
//				bugWatchDAO.delete(bugWatch);
//				if(bwsi.turnBackUp(bug, true))
//					return Constants.SUCCESS;
//				else
//					return Constants.DBERROR;
//			}
//			else if(bugWatch.getVoteFlag() == -1 && methodName.equals("voteDown")){
////				System.out.println("rollback for down");
//				//solutionVote.setVoteFlag(0);
//				bugWatchDAO.delete(bugWatch);
//				if(bwsi.turnBackUp(bug, false))
//					return Constants.SUCCESS;
//				else
//					return Constants.DBERROR;
//			}
//			else{
//				
////				System.out.println("getVoteFlat == " + solutionVote.getVoteFlag() + "methodname==" + methodName);
////				System.out.println("have voted");
//				//message = "Have voted";
//				return Constants.ALREADYVOTED;
//			}
//		}
//
//		if(methodName == "voteUp" && user.getCredit() >= Constants.MINCREDITSONUP){
//			////System.out.println("vote up");
//			bugWatch = new BugWatch();
//			bugWatch.setVoteFlag(new Integer(1));
//			bugWatch.setUser(user);
//			bugWatch.setBug(bug);
//			bugWatchDAO.add(bugWatch);
//			return pjp.proceed();
//		}
//		else if(methodName == "voteDown" && user.getCredit() >= Constants.MINCREDITSONDOWN){
//			////System.out.println("vote down");
//			bugWatch = new BugWatch();
//			bugWatch.setVoteFlag(new Integer(-1));
//			bugWatch.setUser(user);
//			bugWatch.setBug(bug);
//			bugWatchDAO.add(bugWatch);
//			return pjp.proceed();
//		}
//		////System.out.println("credit is not enough");	
//		//message = "Credit is not enough";
//		return Constants.CREDITSNOTENOUGH;
//	}
}
