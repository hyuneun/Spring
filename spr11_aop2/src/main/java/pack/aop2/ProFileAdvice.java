package pack.aop2;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProFileAdvice {
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		//핵심메소드의 메소드명 얻기
		String methodName = joinPoint.getSignature().toString();
		
		System.out.println(methodName + " 시작전 작업....");
		Object object = joinPoint.proceed();
		System.out.println(methodName + " 처리후 작업....");
		
		return object;
	}
}
