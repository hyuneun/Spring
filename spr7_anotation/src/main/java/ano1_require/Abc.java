package ano1_require;

import org.springframework.beans.factory.annotation.Required;

public class Abc {
	private int number;
	
	@Required//setter를 강요함
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
	
		return "number : " + number;
	}
}
