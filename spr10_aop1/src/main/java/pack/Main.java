package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Init.xml");
		
		//aop 적용전
		/*MessageInter inter = (MessageInter)context.getBean("targetBean");
		inter.sayHello();*/
		
		MessageInter inter = (MessageInter)context.getBean("proxy");
		inter.sayHello();
		

	}

}
