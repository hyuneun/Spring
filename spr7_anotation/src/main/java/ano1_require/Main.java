package ano1_require;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		//GenericXmlApplicationContext context = new GenericXmlApplicationContext("ano.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("ano.xml");
		Abc abc = context.getBean("abc",Abc.class);
		System.out.println(abc);
		
		context.registerShutdownHook();//서블릿 destroy()를 명시적으로 호출
		context.refresh();
		context.close();
	}
}
