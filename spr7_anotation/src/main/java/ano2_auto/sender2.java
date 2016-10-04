package ano2_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("sender")
@Component//xml에서 <bean 어쩌구> 하지않고 여기서 객체를 만든다

public class sender2 implements sendInter{
	@Override
	public void show(){
		System.out.println("show하고있네2");
	}
}
