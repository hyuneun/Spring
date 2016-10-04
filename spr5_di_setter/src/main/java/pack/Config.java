package pack;

import org.springframework.context.annotation.Bean;

public class Config {//meta xml file 대신 class 로 환경설정
	@Bean
	public MyProcess my(){
		MyProcess process = new MyProcess();
		process.setGugudan(gugu());
		process.setDan(7);
		process.setName("신기하지");
		return process;
		
	}
	
	@Bean
	public Gugudan gugu(){
		return new Gugudan();
	}
}
