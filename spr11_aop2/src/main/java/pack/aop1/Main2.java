package pack.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.aop2.LogicInter;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("InitAop2.xml");
		
		LogicInter inter = (LogicInter)context.getBean("logicImpl");
		inter.selectData_process();

	}

}
