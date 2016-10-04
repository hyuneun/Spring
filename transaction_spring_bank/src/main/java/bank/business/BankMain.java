package bank.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankInit.xml");
		
		try {
			BankUiInter inter = (BankUiInter)context.getBean("shinhanBank");
			inter.startWork();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
