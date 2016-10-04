package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("app_init.xml");*/
		//MyProcess my = (MyProcess)context.getBean("myProcess");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MyProcess my = (MyProcess)context.getBean("my");

		System.out.println(my);
	}
}
