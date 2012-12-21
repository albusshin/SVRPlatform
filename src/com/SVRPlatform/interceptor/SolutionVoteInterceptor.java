package com.SVRPlatform.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect @Component
public class SolutionVoteInterceptor {

	public class MyInterceptor {
		@Pointcut("execution(* com.SpringAOP.service.impl.PersonServiceBean.*(..))")
		private void anyMethod(){}
		
		@Before("anyMethod() && args(name)")
		public void doAccessCheck(String name) {
			System.out.println("before:"+name);
		}
		@AfterReturning(pointcut="anyMethod() && args(id)",returning="result")
		public void doAfterReturning(Integer id, String result) {
			System.out.println("after:"+id +","+result);
		}
		@After("anyMethod()")
		public void doAfter() {
			System.out.println("ultimate");
		}
		@AfterThrowing("anyMethod()")
		public void doAfterThrowing() {
			System.out.println("exception");
		}
		@Around("anyMethod() && args(name)")
		public Object doBasicProfiling(ProceedingJoinPoint pjp, String name) throws Throwable {
//			if(){判断用户是否有权限
			System.out.println("start function");
			System.out.println("start function"+name);
				Object result = pjp.proceed();
				System.out.println("close function");
//			}
			return result;
		}
	}
}
