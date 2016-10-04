package pack;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageInterImpl implements MessageInter, BeanFactoryAware, DisposableBean,BeanNameAware,InitializingBean{
	private String msg;
	private String beanName;
	private BeanFactory beanFactory;
	
	public MessageInterImpl() {
		System.out.println("1)빈 생성자");
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		System.out.println("2) setter");
	}
	
	@Override
	public void sayHello() {
		System.out.println(msg + beanName + "!!!");
		
	}
	
	@Override
	public void setBeanName(String beanName) {
		System.out.println("3)빈이름설정");
		this.beanName = beanName;
		System.out.println("-->" + beanName);
		
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("4) 빈팩토리설정");
		this.beanFactory = beanFactory;
		System.out.println("-->" + beanFactory);
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6) 프로퍼티 설정");
		
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("프로그램 종료");
		
	}
	
	private void init() {
		System.out.println("7)초기화");

	}
	
	
}
