package ano2_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component //객체를 생성(갖다가 쓸꺼는 component)
@Service//이것도 됨(가져오는 거는 service) 둘다 완전히 똑같음 가독성 때문에 쓴다
public class senderProcess {
	@Autowired(required=true)//setter가 필요없다.true가 기본값,
	//TYPE를 통한 맵핑 : 현재등록된값중에서 sender class type 객체를 알아서찾아 맵핑 
	@Qualifier("sender") //동일한 객체에대한 두개이상의 객체명을 구분할때 쓴다
	private sendInter sendInter;
	
	/*
	 * 이렇게 쓸수도 있지만 위에걸로 써라
	@Autowired//메소드이름은 중요하지않다
	public void setSender(sender sender) {
		this.sender = sender;
	}
	*/
	
	public sendInter getSender() {
		return sendInter;
	}
	
	public void dispData(){
		sendInter.show();
	}
	
}
