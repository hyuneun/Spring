package pack.aspect;

import org.springframework.stereotype.Component;

@Component
public class AopClass {
	public void mysecurity(){
		System.out.println("로직수행전 보안작업함");
	}
}
