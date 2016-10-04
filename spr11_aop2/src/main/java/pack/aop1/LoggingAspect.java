package pack.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
	private MyAspect myaspect;
	
	public void setMyaspect(MyAspect myaspect) {
		this.myaspect = myaspect;
	}
	
	public Object logging(ProceedingJoinPoint joinpoint) throws Throwable{
		Object object= null;
		myaspect.myLogon();
		object = joinpoint.proceed();
		myaspect.myLogout();
		
		return object;
	}
	
	public Object logging2(ProceedingJoinPoint joinpoint) throws Throwable{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object object= null;
		myaspect.myLogon();
		myaspect.mySecurity();
		try {
			object = joinpoint.proceed();
			
		} catch (Exception e) {
			System.out.println("핵심메소드 호출 에러" + e);
		}
		myaspect.myLogout();
		
		stopWatch.stop();
		System.out.println("logging2 처리시간" + stopWatch.getTotalTimeMillis());
		return object;
	}
}
