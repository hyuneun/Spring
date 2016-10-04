package pack;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dbInit.xml");
		BussinessInter inter = (BussinessInter)context.getBean("bussnessImpl");
		
		inter.dataList();
		

	}

}
