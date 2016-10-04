package ano2_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		String[] metas = new  String[]{"ano2.xml"};
		
		//ApplicationContext context = new ClassPathXmlApplicationContext(metas[0]);
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(metas[0]);
		
		senderProcess process = context.getBean("senderProcess", senderProcess.class);
		process.dispData();
		process.getSender().show();
		
	}

}
