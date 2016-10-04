package pack;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	private String part;//┌사실은 getname를 읽어옴(맴버필드는 private라서 x)
	@Value("#{dataInfo.name}") //spring EL 동적으로 표현식을 해석
	private String name;
	
	//public MyProcess(String part) {
//	public MyProcess(@Value("판매부")String part) {
	@Autowired						//	  ┌ 사실은 getpart를 읽어옴(맴버필드는 private라서 x) 
	public MyProcess(@Value("#{dataInfo.part}")String part) {
		System.out.println("시벌나는 생성자여");
		this.part = part;
	}
				//얘는 그냥 dataInfo의 job을 읽어옴(public이니까 가능)
	@Value("#{dataInfo.job}")
	private String job;
	
	@Value("30")//기본이 문자타입(알아서 변환해줌)
	private int age;
	
	@Value("1,2,3,4")
	private int arr[];
	
	@PostConstruct	//생성자가 실행되고난다음 자동실행(jdk가 지원 초기화작업담당)
	public void hi(){
		System.out.println("생성자수행후 처리");
	}
	
	@PreDestroy		//jdk가 지원 - 마무리작업을 담당(눈에는 보이지않음)
	public void bye(){
		System.out.println("마무리+");
	}
	
	
	public void showResult(){
		System.out.println(part);
		System.out.println(name);
		System.out.println(job);
		System.out.println(age);
		System.out.println(arr[3]);
	}
}
