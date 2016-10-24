package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAopProcess {
	@Autowired
	private AopClass class1;
	
	@Around("execution(public String processMsg()) or execution(* bu*(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		
			class1.mysecurity();//핵심메소드 수행전에 aop 수행
			 Object object = joinPoint.proceed();

			return object;
		
	}
}
