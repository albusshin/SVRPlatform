package Junit.test.Jingxuan;

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
public class MyInterceptor {
	@Pointcut("execution(* Junit.test.Jingxuan.ServiceImpl.*(..))")
	private void anyMethod(){}
	
	public MyInterceptor() {
		super();
		System.out.println("interceptor");
	}
	
	@Before("anyMethod()")
	public void doAccessCheck() {
		System.out.println("before:");
	}
	@AfterReturning(pointcut="anyMethod() && args(email)",returning="result")
	public void doAfterReturning(Integer email, boolean result) {
		System.out.println("after:"+email +","+result);
	}
	@After("anyMethod()")
	public void doAfter() {
		System.out.println("ultimate");
	}
	@AfterThrowing("anyMethod()")
	public void doAfterThrowing() {
		System.out.println("exception");
	}
	@Around("anyMethod() && args(email)")
	public Object doBasicProfiling(ProceedingJoinPoint pjp, String email) throws Throwable {
//		if(){判断用户是否有权限
		System.out.println("start function");
		System.out.println("start function"+email);
			Object result = pjp.proceed();
			System.out.println("close function");
//		}
		return result;
	}
}
