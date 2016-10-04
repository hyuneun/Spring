package pack.Bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("hana")//객체변수만들기
@Scope("prototype")
public class HanaBank implements Bank{
	private int money = 1000;
	
	@Override
	public void inputMoney(int money) {
		this.money += this.money + money;
		
	}
	
	@Override
	public void outputMoney(int money) {
		this.money -= this.money + money;
		
	}
	
	@Override
	public int getMoney() {
		int imsi = money;
		return imsi;
	}
}
