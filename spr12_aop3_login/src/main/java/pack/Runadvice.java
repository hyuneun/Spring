package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Runadvice {
	@Around("execution(public void startProcess())")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("aop 시작 :  핵심메소드 수행전에 id 검사");
		
		System.out.println("id 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		scanner.close();
		if(!id.equals("aa")){
			System.out.println("넌 아직 준비가 안됬다!");
			return null;
		}

		Object object = joinPoint.proceed();
		
		System.out.println("aop종료");
		return object;
	}
}
