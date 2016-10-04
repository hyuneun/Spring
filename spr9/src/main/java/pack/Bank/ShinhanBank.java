package pack.Bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component//객체변수만들기
@Scope("prototype")
public class ShinhanBank implements Bank{
	private int money = 5000;
	
	@Override
	public void inputMoney(int money) {
		this.money += money;
		
	}
	
	@Override
	public void outputMoney(int money) {
		this.money -= money;
		
	}
	
	@Override
	public int getMoney() {
		
		return money;
	}
}
