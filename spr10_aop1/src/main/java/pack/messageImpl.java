package pack;

public class messageImpl implements MessageInter{
	//핵심로직 클래스 - target
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHello() {
		System.out.println("안녕?" + name + "님 비스니즈 로직 처리중???");
		//시간끌기
		int t = 0;
		while (t < 5) {
			try {
				Thread.sleep(1000);
				System.out.println(".");
				t++;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		System.out.println("완료~");
		System.out.println("______________________");
		
	}
	
}
