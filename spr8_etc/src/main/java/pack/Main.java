package pack;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("ano_etc.xml");
		
		MyProcess myProcess = (MyProcess)context.getBean("my");
		myProcess.showResult();

	}

}
