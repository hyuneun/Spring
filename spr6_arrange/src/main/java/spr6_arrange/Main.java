package spr6_arrange;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class Main {

	public static void main(String[] args) {
//		/*ApplicationContext context = new ClassPathXmlApplicationContext("arraengy.xml");*/
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spr6_arrange.xml");
		//패스루트에 없을경우에는 정확한경로를 적어줘야함
		//최신버전┐
/*		GenericApplicationContext context = new GenericXmlApplicationContext("arraengy.xml");
		MessageImle impl1 = (MessageImle)context.getBean("mbean");
		MessageImle impl2 = (MessageImle)context.getBean("mbean");
		System.out.println(impl1 + " --- " + impl2);
		
		impl1.sayHi();
		System.out.println();*/
		//다형성
		
//		MessageInter inter = (MessageInter)context.getBean("mbean");
//		MessageInter inter = (MessageImle)context.getBean("mbean");
//		MessageInter inter = context.getBean("mbean",MessageInter.class);
		
		
//		inter.sayHi();
		
//		context.close();
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MessageImle my = (MessageImle)context.getBean("message");
		my.sayHi();

	}

}
