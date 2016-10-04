package spr4_di_constructerEx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app_init.xml");
		
		Product2Dao product2Dao = (Product2Dao)context.getBean("product2Daoimpl");
		product2Dao.showData();

	}

}
