package ano3_resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
		String[] metas = new String[]{"ano3.xml","ano3_1.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(metas);
		
		AbcProcess abcProcess = (AbcProcess)context.getBean("abcProcess");
		abcProcess.showData();

	}

}
