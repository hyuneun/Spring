package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		//spring 방식(컨테이너)
		System.out.println();
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		Message_inter inter2 = (Message_inter)context.getBean("mb1");
		inter2.sayHello("qd");
		inter2 = (Message_inter)context.getBean("mb2");
		inter2.sayHello("공기밥");
		
	}
}
