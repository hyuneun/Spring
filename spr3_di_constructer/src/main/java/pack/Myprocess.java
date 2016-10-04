package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Myprocess {
	private MoneyCalc moneyCalc;
	private int re[];
	
	public Myprocess(MoneyCalc moneyCalc) {
		this.moneyCalc = moneyCalc;
	}
	
	public void inputMoney(){
		try {
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader bReader = new BufferedReader(reader);
			int mymoney = 0;
			System.out.println("돈내놔");
			String data = bReader.readLine();
			mymoney = Integer.parseInt(data);
			re = moneyCalc.calcMoney(mymoney);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void showResult(){
		StringBuffer sb = new StringBuffer();
		sb.append("만원" + re[0]);
		sb.append("천원" + re[1]);
		sb.append("백원" + re[2]);
		sb.append("십원" + re[3]);
		sb.append("일원" + re[4]);
		System.out.println(sb.toString());
	}
}
