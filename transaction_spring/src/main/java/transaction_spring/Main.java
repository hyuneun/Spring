package transaction_spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		
		FooInter fooInter = (FooInter)context.getBean("fooInter");
		
		try {
			
		List<FooDto> list = fooInter.getFoo();
		FooDto dto = fooInter.getFoo("이타치");
		
		fooInter.insertFoo(new FooDto());
		fooInter.updateFoo(new FooDto());
		} catch (Exception e) {
			System.out.println("TMLQkf");
		}
		System.out.println("프로그램 종료");

	}

}
