package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		// 순수 자바를 이용한 작업(내가 뉴를 한당)
		Message1 message1 = new Message1();
		message1.sayHello("s");
		Message2 message2 = new Message2();
		message2.sayHello("d");
		System.out.println();
		
		Message_inter inter = null;
		inter = message1;
		inter.sayHello("e");
		inter = message2;
		inter.sayHello("d");
		
		//spring 방식(컨테이너)
		System.out.println();
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		Message_inter inter2 = (Message_inter)context.getBean("mb1");
		inter.sayHello("qd");
		inter2 = (Message_inter)context.getBean("mb2");
		inter2.sayHello("공기밥");
		
	}
}
