package pack.comtroller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
//dto처럼 생각해라
@XmlAccessorType(XmlAccessType.FIELD)
public class Xmlmessage {
	private String name;
	private String age;
	
	public Xmlmessage(String name,String age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAge() {
		return age;
	}

}
