package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.Bank.Bank;
import pack.Bank.HanaBank;
import pack.Bank.ShinhanBank;

@Service
@ComponentScan("pack.Bank")//xml에서 component-scan 쓰는 대신 여기서 써줄수있다
@Scope("prototype")
public class Gogek {
	private Bank bank;
	
	@Autowired(required=true)//타입에의한맵핑
	private ShinhanBank shinhanBank;
	
	@Resource(name="hana")//이름에 의한 맵핑(정확하게 이름을 써줘야함)
	private HanaBank hanaBank;
	
	public void selBank(String sel){
		if(sel.equalsIgnoreCase("sinhan")){
			bank = shinhanBank;
		}else if(sel.equalsIgnoreCase("hana")){
			bank = hanaBank;
		}
	}
	
	public void playInputMoney(int money){
		bank.inputMoney(money);
	}
	
	public void playOutputMoney(int money){
		bank.outputMoney(money);
	}
	
	public void showMoney(){
		System.out.println(msg + bank.getMoney());
	}
	
	private String msg;
	@PostConstruct
	public void init(){
		msg = "계좌잔고";
	}
}


