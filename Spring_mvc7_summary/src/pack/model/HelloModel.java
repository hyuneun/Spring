package pack.model;

import java.util.Calendar;

public class HelloModel {
	public String getGreeting(){
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour >= 6 && hour <= 10){
			return "조은아침";
		}else if(hour >= 12 && hour <= 15){
			return "맛점";
		}else if(hour >= 18 && hour <= 22 ){
			return "굿저";
		}else{
			return "ㅎㅇ" + hour;
		}
	}
	
}
