package spr6_arrange;

import orther.Myinfo;
import orther.OutFileInter;

public class MessageImle implements MessageInter{
	private String name1,name2;
	private int year;
	private Myinfo myinfo;
	
	private String spec;
	private OutFileInter inter;
	
	public MessageImle(String name1,String name2,int year,Myinfo myinfo) {//construcsion injection
		this.name1 = name1;
		this.name2 = name2;
		this.year = year;
		this.myinfo = myinfo;
		
	}
	
	public void setSpec(String spec) {//setter injection
		this.spec = spec;
	}
	
	public void setInter(OutFileInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void sayHi() {
		// 출력담당
		String msg = name1 + name2 + year + "년" + myinfo.myData() + spec;
		
		System.out.println(msg);
		
		//메시지를 파일로 출력
		inter.outFile(msg);
	}
}
