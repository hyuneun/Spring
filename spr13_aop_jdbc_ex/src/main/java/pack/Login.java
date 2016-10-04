package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Login {
	@Around("execution(public void dataList())")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("id 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		System.out.println("비밀번호 입력");
		String password = scanner.nextLine();
		scanner.close();
		if(!id.equals("kor") || !password.equals("111")){
			System.out.println("비번과 아이디가 맞지않습니다");
			return null;
		}

		Object object = joinPoint.proceed();
		
		System.out.println("aop종료");
		return object;
	}
}
