package pack.aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProFileAdvice {
	@Around("execution(public * pack.aop3..*(..))")
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		//핵심메소드의 메소드명 얻기
		String methodName = joinPoint.getSignature().toString();
		
		System.out.println(methodName + " 시작전 작업....");
		Object object = joinPoint.proceed();
		System.out.println(methodName + " 처리후 작업....");
		
		return object;
	}
	
	@Before("execution(public * pack.aop3..*(..))")
	public void sbs() throws Throwable{
		System.out.println("전");
	}
	
	@After("execution(public * pack.aop3..*(..))")
	public void mbc() throws Throwable{
		System.out.println("후");
	}
}
