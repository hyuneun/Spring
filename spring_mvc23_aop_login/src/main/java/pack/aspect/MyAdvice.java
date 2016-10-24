package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
	
	@Autowired
	private LoginAspect loggingClass;
	
	@Around("execution(* getlist(..))")
	public Object aopprocess(ProceedingJoinPoint joinPoint) throws Throwable{
		HttpServletResponse response = null;
		HttpServletRequest request = null;
		
		//Response와 Request를 구분하기위해
		for(Object o:joinPoint.getArgs()){
			if(o instanceof HttpServletResponse){
				response = (HttpServletResponse) o;
			}
			if(o instanceof HttpServletRequest){
				request = (HttpServletRequest) o;
			}
		}
		
		//sessoin 체크후 로그인하지않은 경우 로그인창으로이동
		if(!loggingClass.logincheck(request, response)){
			return null;
		}
		
		Object object = joinPoint.proceed();
		return object;
	}
}
