package pack.bissuness;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dbinit.xml");
		
		ProcessInter inter = (ProcessInter)context.getBean("processInterImpl");
		inter.dataShow();

	}

}
