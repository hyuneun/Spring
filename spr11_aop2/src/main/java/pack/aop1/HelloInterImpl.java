package pack.aop1;

public class HelloInterImpl implements HelloInter{
	public HelloInterImpl() {
		System.out.println("hellointerImpl 생성");
	}
	
	@Override
	public void hello() {
		try {
			System.out.println("헬로() 수행");
			Thread.sleep(3000);
			System.out.println("3초 지연");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	public void hi() {
		System.out.println("하이() 수행");
		
		
	}
}
