package pack.model;

import org.springframework.stereotype.Component;

@Component
public class Mymodel {
	
	private String name;	
	String[] skills;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
	

}
