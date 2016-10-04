package pack.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		String []configs = new String[]{"InitBean.xml","InitAop.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		
		WriteInter writeInter = (WriteInter)context.getBean("writeInterImpl");
		writeInter.write();
		
		System.out.println();
		
		HelloInter helloInter = (HelloInter)context.getBean("helloInterImpl");
		helloInter.hello();
		helloInter.hi();

	}

}
