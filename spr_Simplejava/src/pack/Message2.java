package pack;

public class Message2 implements Message_inter{
	@Override
	public void sayHello(String name) {
		System.out.println(name + "다시는 돌아오지마라");
		
	}
}
