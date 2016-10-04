package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app_init.xml");
		Myprocess myprocess = (Myprocess)context.getBean("myprocess");
		myprocess.inputMoney();
		myprocess.showResult();

	}

}
