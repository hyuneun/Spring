package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyModel implements MyModelInter{
	
	
	public String businessMsg() {
		System.out.println("비스니스 메소드수행");
		return "spring 안조음";
	}
	
	public String processMsg() {
		System.out.println("프로세스 메소드수행");
		return "spring 안조음";
	}
}
