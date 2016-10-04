package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("BankInit.xml");
		
		Gogek daniel = (Gogek)context.getBean("gogek");
		daniel.selBank("sinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(1000);
		System.out.print("듸에니얼");
		daniel.showMoney();
		
		Gogek John = (Gogek)context.getBean("gogek");
		John.selBank("sinhan");
		John.playInputMoney(500);
		John.playOutputMoney(1000);
		System.out.print("존 ");
		John.showMoney();
		
		//다니엘과 존은 주소가같다(싱글톤) 싱글톤을 안쓰려면 @Scope("prototype") 써라
		System.out.println(John + "\n" + daniel);
		
		Gogek oscar = (Gogek)context.getBean("gogek");
		oscar.selBank("hana");
		oscar.playInputMoney(500);
		oscar.playOutputMoney(1000);
		System.out.print("오스까 ");
		oscar.showMoney();

	}

}
