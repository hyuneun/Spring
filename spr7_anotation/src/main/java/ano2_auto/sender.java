package ano2_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("sender")
@Component//xml에서 <bean 어쩌구> 하지않고 여기서 객체를 만든다
@Scope("singleton") //싱글톤이 기본값 @scope("prototype")
public class sender implements sendInter{
	@Override
	public void show(){
		System.out.println("show하고있네");
	}
}
