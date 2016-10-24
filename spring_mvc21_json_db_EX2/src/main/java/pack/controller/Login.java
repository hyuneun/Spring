package pack.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Component
@Aspect
public class Login{
	
	@Around("execution(public * listProcess(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("이름");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		System.out.println("번호");
		String password = scanner.nextLine();
		//scanner.close();
		DataDao dao = new DataDao();
		for (SangpumDto s : dao.getDataAll3(id,password)) {
	         
	         if(password.equals(s.getSawon_no())){
	            Object object = joinPoint.proceed();
	            return object;
	            
	        }else{
	        	return null;
	        }
	     }
		
		System.out.println("사원 인증실패!. 작업을 종료합니다.");
		
		return null;
	}
	

	
	
}
