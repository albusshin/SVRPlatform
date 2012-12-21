package com.SVRPlatform.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.SVRPlatform.model.User;
import com.SVRPlatform.service.impl.SolutionVoteServiceImpl;

@Aspect @Component
public class SolutionVoteInterceptor {
	@Pointcut("execution(* com.SVRPlatform.service.impl.SolutionVoteServiceImpl.vote*(..))")
	private void voteMethod(){}
	
	
	@Around("voteMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aop processing");
		String methodName = pjp.getSignature().getName();
		SolutionVoteServiceImpl svsi = (SolutionVoteServiceImpl) pjp.getTarget();
		User user = svsi.getUserDAO().getUserByEmail((String)pjp.getArgs()[1]);

//		User user = (User) pjp.getArgs()[1];
//		boolean isUp = (boolean)pjp.getArgs()[2];
		if((methodName == "voteUp" && user.getCredit() >= 15)
				||(methodName == "voteDown" && user.getCredit() >= 125))
				return pjp.proceed();
		return false;
	}
}
