package pack.aop3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.aop3.LogicInter;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("InitAop3.xml");
		
		LogicInter inter = (LogicInter)context.getBean("logicImpl");
		inter.selectData_process();

	}

}
