package spr6_arrange;

import org.springframework.context.annotation.Bean;

import orther.Myinfo;
import orther.OutFileInter;
import orther.OutFileInterImle;


public class Config {
	@Bean
	public MessageImle message(){
		MessageImle messageImle = new MessageImle("ㅁㄴㅇ", "ㅇㅇㅇ", 5,info());
		messageImle.setSpec("삐ㅃ읶삒ㅃ끼");
		messageImle.setInter(info2());
		return messageImle;
	}
	
	@Bean
	public Myinfo info(){
		return new Myinfo();
	}
	
	@Bean
	public OutFileInterImle info2(){
		OutFileInterImle fileInterImle = new OutFileInterImle();
		fileInterImle.setFilePath("c://work//good.txt");
		return fileInterImle;
	}
	
	
}
